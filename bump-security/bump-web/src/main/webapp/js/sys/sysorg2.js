$(function() {
	$("#jqGrid")
			.jqGrid(
					{
						url : '../sysorg2/list',
						datatype : "json",
						colModel : [
								{
									label : '机构LOGO',
									name : 'sysLogo',
									index : 'sysLogo',
									width : 80,
									formatter : function(cellvalue, options,
											rowObject) {
										if (rowObject.sysLogo != "") {
											var html = "";
											html += "<img ";
											html += "style=\"border: 1px solid #b3b3b3; text-align: center;;display:none;\"";
											html += "src=\""
													+ rowObject.sysLogo + "\\>";
											return html;
										} else {
											return '';
										}
									}

								},
								{
									label : 'sysOrgId',
									name : 'sysOrgId',
									index : 'sysOrgId',
									width : 50,
									hidden : true,
									key : true,
									visibled : false
								},
								{
									label : '机构名称',
									name : 'sysOrgName',
									index : 'sysOrgName',
									width : 80
								},
								{
									label : '统一社会信用代码',
									name : 'sociaCreditCode',
									index : 'sociaCreditCode',
									width : 80
								},
								{
									label : '机构联系人',
									name : 'contactMan',
									index : 'contactMan',
									width : 80
								},
								{
									label : '联系电话',
									name : 'contactPhone',
									index : 'contactPhone',
									width : 80
								},
								{
									label : '审核状态',
									name : 'isCheck',
									index : 'isCheck',
									width : 80,
									formatter : function(cellvalue, options,
											rowObject) {
										if (cellvalue == 1) {
											return '已审核';
										} else if (cellvalue == 0) {
											return '未审核';
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
						gridComplete : function() {
							// 隐藏grid底部滚动条
							$("#jqGrid").closest(".ui-jqgrid-bdiv").css({
								"overflow-x" : "hidden"
							});
						}
					});
});

var vm = new Vue({
	el : '#rrapp',
	data : {
		q : {
			key : null
		},
		showList : true,
		title : null,
		sysOrg : {}
	},
	methods : {
		query : function() {
			vm.reload();
		},
		add : function() {
			vm.showList = false;
			vm.title = "检测机构信息补充";
			vm.sysOrg = {};
		},
		update : function(event) {
			var id = getSelectedRow();
			if (id == null) {
				return;
			}
			vm.showList = false;
			vm.title = "检测机构信息维护";
			vm.getInfo(id);
		},
		saveOrUpdate : function(event) {
			var url = vm.sysOrg.sysOrgId == null ? "../sysorg2/save"
					: "../sysorg2/update";
			$('body').shadow();
			$.ajax({
				type : "POST",
				url : url,
				data : JSON.stringify(vm.sysOrg),
				success : function(r) {
					// 关闭遮罩
					$('body').shadow('hide');
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
			var ids = getSelectedRows();
			if (ids == null) {
				return;
			}

			confirm('确定要删除选中的记录？', function() {
				$.ajax({
					type : "POST",
					url : "../sysorg2/delete",
					data : JSON.stringify(ids),
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
		getInfo : function(id) {
			$.get("../sysorg2/info/" + id, function(r) {
				vm.sysOrg = r.sysOrg;
			});
		},
		reload : function(event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam', 'page');
			var key = "";
			if (vm.q.key) {
				key=encodeURIComponent(vm.q.key);
			}

			$("#jqGrid").jqGrid('setGridParam', {
				page : page,
				postData : {
					'key' : key
				},
			}).trigger("reloadGrid");
		}
	}
});