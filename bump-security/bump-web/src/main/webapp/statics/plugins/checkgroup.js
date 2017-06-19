(function($) {
	// 构造函数
	$.fn.checkgroup = function(options, args) {
		if (typeof options == 'string') {
			return $.fn.checkgroup.methods[options](this, args);
		}
		options = options || {};
		// 初始化构造每个组件
		return this.each(function() {
			var data = $.data(this, "checkgroup");
			if (data) {
				$.extend(data.options, options);
				return;
			} else {
				options = optionsParser(this, options);
				var r = init($(this), options);
				data = $.data(this, "checkgroup", {
					options : r.options,
					id : r.id,
					panel : r.panel,
					valueInput : r.valueInput
				});
			}

			if (args) {
				if (typeof args == 'string')
					data.options.url = args;
				_load(this, args);
			} else if (data.options && typeof data.options.url == 'string'
					&& data.options.url != "") {
				_load(this, data.options.url);
			}

		});
	};

	// 对外接口方法
	$.fn.checkgroup.methods = {
		// 获取值
		getValue : function(target, options) {
			return _getValue(target);
		},
		// 获取文本
		getText : function(target, options) {
			return _getText(target);
		},
		// 设置值,复选框的值以逗号分隔
		setValue : function(target, val) {
			_setValue(target, val);
			return target;
		},
		// 获取控件id
		getId : function(target, options) {
			return $(target).data('checkgroup').id;
		},
		// 加载数据,data可以是键值对json数据,也可以是url
		load : function(target, data) {
			_load(target, data);
			return target;
		},
		// 重置
		reset : function(target) {
			return target.each(function() {
				var data = $(this).data('checkgroup');
				if (data && data.options) {
					if (data.options.defaultValue)
						$(this).checkgroup("setValue",
								data.options.defaultValue);
				}
			});
		},
		// 清除
		clear : function(target, options) {
			return target.each(function() {
				$(this).checkgroup("setValue", "");
			});
		},
		// 校验
		validate : function(target) {
			return $(target).each(function() {
				_validate(this, true);
			});
		},
		// 获取组件类名
		getClassName : function(target) {
			return $(target).attr("data-class-name");
		},
		// 设置组件类名
		setClassName : function(target, val) {
			$(target).attr("data-class-name", val);
			return target;
		},
		// 刘武2017-03-03增加此属性
		// 设置只读属性
		setDisabled : function(target, options) {
			var id = $(target).attr("id");
			var data = $("input[name=" + id + "]");
			data.each(function(i) {
				var m = this;
				if (options) {
					$(m).attr("disabled", options);
				} else {
					$(m).removeAttr("disabled");
				}
			});
			return target;
		},
	};

	// Combo默认设置
	$.fn.checkgroup.defaults = {
		// 初始默认Value值
		defaultValue : '',
		// 是否禁用组件
		disabled : false,
		// ajax获取数据的url地址
		url : '',
		// 用于表单提交的name属性,默认与id一致
		name : null,
		// 是否使用内联样式布局
		inline : true,
		// 是否允许多选,默认false
		multiple : false,
		// 在请求加载数据之前触发。返回false可以停止该动作
		onBeforeLoad : function(e) {
		},
		// 在表单数据加载完成后触发
		onLoadSuccess : function(data) {
		},
		// 在表单数据加载出现错误的时候触发
		onLoadError : function(textStatus) {
		},
		// 选中值发生改变
		onChange : function(val) {
		}
	};

	// 初始化Dom结构
	function init(target, options) {
		var panel = $(target).addClass("checkgroup-f checkbox");
		var opts = $.extend({}, $.fn.checkgroup.defaults, options);

		// 设置组件类名
		$(target).attr("data-class-name", "CheckGroup");

		// 是否多选
		if (opts.multiple) {
			panel.addClass("checkbox");
			// 是否内联
			if (opts.inline)
				panel.addClass("checkbox-inline");
		} else {
			panel.addClass("radio");
			// 是否内联
			if (opts.inline)
				panel.addClass("radio-inline");
		}

		// 添加name属性
		var id = panel.attr("id");
		if (opts.name) {
			panel.data("name", opts.name);
		} else {
			panel.data("name", id);
			opts.name = id;
		}
		panel.data("oldId", id);
		panel.attr("comName", opts.name);
		return {
			options : opts,
			id : id,
			panel : panel
		};
	}
	;

	// 绑定事件
	function _bindEvent(target) {
		var state = $.data(target, "checkgroup");
		var panel = state.panel;

		// 选出panel中被选中的checkbox和radiobox
		var rr = $("input:checkbox,input:radio", panel);
		rr.unbind(".checkgroup").bind("change.checkgroup", function() {
			var vals = _getValue(target);
			$(target).data("value", vals);// 将value值存入data-value属性
			state.options.onChange.call(target, vals);
			_validate(target, true);
		});
	}
	;

	/**
	 * 加载数据,data可以是键值对json数组,也可以是url
	 * 
	 * @param target
	 * @param data
	 * @private
	 */
	function _load(target, data) {
		if (!$.data(target, "checkgroup")) {
			$.data(target, "checkgroup", {
				options : $.extend({}, $.fn.checkgroup.defaults)
			});
		}
		var options = $.data(target, "checkgroup").options;
		if (typeof data == "string") {
			var param = {};

			// onBeforeLoad返回false可以阻止加载数据
			if (options.onBeforeLoad.call(target, param) == false) {
				return;
			}

			// ajax获取数据
			$.ajax({
				url : data,
				data : param,
				dataType : "json",
				success : function(data) {
					options.onLoadSuccess.call(target, data);
					// 成功获取数据后,将数据绑定到表单中
					_bindData(target, data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					options.onLoadError.apply(target, textStatus);
				}
			});
		} else {
			_bindData(target, data);
		}

		// 将value值存入data-value属性
		$(target).data("value", _getValue(target));
		// 加载完成后进行数据校验
		_validate(target);
	}
	;

	// 绑定数据
	function _bindData(target, data) {
		var state = $.data(target, "checkgroup");
		var panel = state.panel;
		var opts = state.options;
		$(data).each(
				function(i) {
					// 创建dom元素
					var m = this;
					var item;
					if (opts.multiple) {
						item = $("<input type='checkbox' />");
					} else {
						item = $("<input type='radio' />");
					}
					item.attr("name", opts.name);
					item.attr("value", m["value"]);
					item.addClass("ace");
					// 如果需要默认选中
					if (m["check"] == true) {
						$.fn.prop ? item.prop("checked", true) : item.attr(
								"checked", true);
					}
					// 禁用
					if (opts.disabled) {
						item.attr("readonly", true);
					}
					var label = $("<label />");
					// .addClass("control-label")
					// .css({"padding-right":"8px"});
					var span = $("<span />").html(m["text"]);
					span.addClass("lbl");

					item.appendTo(label);
					span.insertAfter(item);
					label.appendTo(panel);

				});

		// 事件绑定
		_bindEvent(target);

		// 选中默认值
		if (opts && opts.defaultValue)
			_setValue(target, opts.defaultValue);

	}
	;

	// 获取选中项的Value值
	function _getValue(target) {
		var state = $(target).data("checkgroup");
		var panel = state.panel;
		var items = $("input:checkbox:checked,input:radio:checked", panel);

		var vals = [];
		items.each(function() {
			vals.push($(this).val());
		});
		return vals;
	}
	;

	// 获取选中项的Text值
	function _getText(target) {
		var state = $.data(target, "checkgroup");
		var panel = state.panel;
		var items = $("input:checkbox:checked,input:radio:checked", panel);

		var vals = [];
		items.each(function() {
			var label = $("label", $(this).parent());
			vals.push(label.html());
		});
		return vals;
	}
	;

	// 设置选中项
	function _setValue(target, val) {
		// var state = $.data(target,"checkgroup");
		var state = $(target).data("checkgroup");

		var panel = state.panel;

		// 先清除已选中的选项
		var rr = $("input:checkbox,input:radio", panel);
		$.fn.prop ? rr.prop("checked", false) : rr.attr("checked", false);

		var vals = val.split(',');
		if (vals.length) {
			$(vals).each(
					function(i) {
						var v = this;
						var item = $("input:checkbox[value='" + v
								+ "'],input:radio[value='" + v + "']", panel);
						$.fn.prop ? item.prop("checked", true) : item.attr(
								"checked", true);
					});
		}
		$(target).data("value", val);
	}
	;

	// 数据校验
	function _validate(target, doit) {
		if (!$.fn.validatebox)
			return;
		var opts = $.data(target, "checkgroup").options;
		$(target).validatebox(opts);
		if (doit) {
			$(target).validatebox("validate");
		}
	}
	;

	// options转换器
	function optionsParser(target, options) {
		var $this = $(target);
		var options = $.extend({}, $.fn.checkgroup.defaults, options || {},
				$this.data());
		return options;
	}

	// 自动渲染组件
	$(function() {
		$("input[data-toggle='checkgroup']").each(function() {
			$(this).checkgroup();
		});
	});

})(jQuery);