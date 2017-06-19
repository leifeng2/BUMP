$(function() {
	/* 初始化查询条件 */
	iniQueryCondition();
	$("#jqGrid").jqGrid({
		url : '../inspectionrecord/list',
		datatype : "json",
		colModel : [ {
			label : '仪器名称',
			name : 'recordId',
			index : 'record_id',
			width : 50,
			key : true
		}, {
			label : '设备型号',
			name : 'deviceType',
			index : 'device_type',
			width : 80
		}, {
			label : '测量范围',
			name : 'measureRange',
			index : 'measure_range',
			width : 80
		}, {
			label : '检测日期',
			name : 'inspectDate',
			index : 'inspectDate',
			width : 80
		}, {
			label : '送检单位',
			name : 'recordType',
			index : 'record_type',
			width : 80
		}, {
			label : '检定人员',
			name : 'userId',
			index : 'user_id',
			width : 80
		}, {
			label : '检定结果',
			name : 'inspectResult',
			index : 'inspect_result',
			width : 80,
			formatter : function(cellvalue, options, rowObject) {
				if (rowObject.inspectResult == "1") {
					return "合格";
				} else {
					return '不合格';
				}
			}

		} ],
		viewrecords : true,
		height : 385,
		rowNum : 10,
		rowList : [ 10, 30, 50 ],
		rownumbers : true,
		rownumWidth : 25,
		autowidth : true,
		multiselect : true,
		sortable : true,
		sortorder : 'asc',
		pager : "#jqGridPager",
		jsonReader : {
			root : "page.list",
			page : "page.currPage",
			total : "page.totalPage",
			records : "page.totalCount"
		},
		prmNames : {
			page : "page",
			rows : "limit",
			order : "order"
		},
		beforeSelectRow : function(rowid, e) {
			editWindow();
		},

		loadComplete : function() {
			var rows = $(this).getDataIDs();
			for ( var i = 0; i < rows.length; i++) {
				var row = $(this).getRowData(rows[i]);
				// if (row.IsSomething == 'true') {
				// this.rows[i + 1].className = this.rows[i +
				// 1].className + ' ui-state-highlight';
				$(this.rows[i]).bind('onmouseover', 'showSubMenu');
				// }
			}
		},
		gridComplete : function() {
			// 隐藏grid底部滚动条
			$("#jqGrid").closest(".ui-jqgrid-bdiv").css({
				"overflow-x" : "hidden"
			});
		}
	});
});
function editWindow() {
	$('#history').modal({
		keyboard : true
	});
}

function hiddenSubMenu() {
	var m = document.getElementById("subMenu");
	m.style.display = "none";
}

/**
 * 初始化查询条件
 */
function iniQueryCondition() {
	// 进度
	$("#queryJD").checkgroup({
		defaultValue : '',
		onChange : function(e) {
		},
	}, [ {
		"text" : "全部 ",
		"value" : ""
	}, {
		"text" : " 设备没到 ",
		"value" : "01"
	}, {
		"text" : " 正在检测 ",
		"value" : "02"
	}, {
		"text" : " 检测完成 ",
		"value" : "03"
	} ]);
	$("#queryJD").checkgroup("setValue", "");
	// 检测结果
	$("#queryCCJG").checkgroup({
		defaultValue : '',
		onChange : function(e) {
		},
	}, [ {
		"text" : "全部 ",
		"value" : ""
	}, {
		"text" : " 合格 ",
		"value" : "01"
	}, {
		"text" : " 不合格 ",
		"value" : "02"
	} ]);
	$("#queryCCJG").checkgroup("setValue", "");
	// 检定日期
	$("#queryCDRQ").checkgroup({
		defaultValue : '',
		onChange : function(e) {
			//query();
		},
	}, [ {
		"text" : "全部 ",
		"value" : ""
	}, {
		"text" : " 一个月内 ",
		"value" : "01"
	}, {
		"text" : " 三月内 ",
		"value" : "02"
	}, {
		"text" : " 半年内",
		"value" : "03"
	}, {
		"text" : " 一年内 ",
		"value" : "04"
	}, {
		"text" : " 三年内 ",
		"value" : "05"
	} ]);
	$("#queryCDRQ").checkgroup("setValue", "");
}
var vm = new Vue(
		{
			el : '#rrapp',
			data : {
				showList : true,
				title : null,
				inspectionRecord : {}
			},
			methods : {
				query : function() {
					vm.reload();
				},
				add : function() {
					vm.showList = false;
					vm.title = "新增";
					vm.inspectionRecord = {};
				},
				update : function(event) {
					var recordId = getSelectedRow();
					if (recordId == null) {
						return;
					}
					vm.showList = false;
					vm.title = "修改";

					vm.getInfo(recordId);
				},
				saveOrUpdate : function(event) {
					var url = vm.inspectionRecord.recordId == null ? "../inspectionrecord/save"
							: "../inspectionrecord/update";
					$.ajax({
						type : "POST",
						url : url,
						data : JSON.stringify(vm.inspectionRecord),
						success : function(r) {
							if (r.code === 0) {
								alert('操作成功', function(index) {
									vm.reload();
								});
							} else {
								alert(r.msg);
							}
						}
					});
				},
				del : function(event) {
					var recordIds = getSelectedRows();
					if (recordIds == null) {
						return;
					}

					confirm('确定要删除选中的记录？', function() {
						$.ajax({
							type : "POST",
							url : "../inspectionrecord/delete",
							data : JSON.stringify(recordIds),
							success : function(r) {
								if (r.code == 0) {
									alert('操作成功', function(index) {
										$("#jqGrid").trigger("reloadGrid");
									});
								} else {
									alert(r.msg);
								}
							}
						});
					});
				},
				getInfo : function(recordId) {
					$.get("../inspectionrecord/info/" + recordId, function(r) {
						vm.inspectionRecord = r.inspectionRecord;
					});
				},
				reload : function(event) {
					vm.showList = true;
					var page = $("#jqGrid").jqGrid('getGridParam', 'page');
					$("#jqGrid").jqGrid(
							'setGridParam',
							{
								page : page,
								postData : {
									'queryJD' : $("#queryJD").checkgroup(
											"getValue")[0],
									'queryCCJG' : $("#queryCCJG").checkgroup(
											"getValue")[0],
									'queryCDRQ' : $("#queryCDRQ").checkgroup(
											"getValue")[0],
									'queryKey' : encodeURIComponent($(
											"#queryKey").val())
								},
							}).trigger("reloadGrid");
				}
			}
		});