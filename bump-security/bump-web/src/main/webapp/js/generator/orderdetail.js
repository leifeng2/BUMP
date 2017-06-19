$(function () {
    $("#jqGrid").jqGrid({
        url: '../orderdetail/list',
        datatype: "json",
        colModel: [			
			{ label: 'detailId', name: 'detailId', index: 'detail_id', width: 50, key: true },
			{ label: '订单ID', name: 'orderId', index: 'order_id', width: 80 }, 			
			{ label: '设备ID', name: 'deviceId', index: 'device_id', width: 80 }, 			
			{ label: '检测方式（参见数据字典：检定、校准、检测、检验）', name: 'detectMethod', index: 'detect_method', width: 80 }, 			
			{ label: '送检机构', name: 'sysOrgId', index: 'sys_org_id', width: 80 }, 			
			{ label: '录入人员', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '应收', name: 'shouldAmount', index: 'should_amount', width: 80 }, 			
			{ label: '实收', name: 'realAmount', index: 'real_amount', width: 80 }, 			
			{ label: '订单类型（参见数据字典 指派、竞价）', name: 'orderType', index: 'order_type', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        sortable:true,
        sortorder: 'asc',
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		orderDetail: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.orderDetail = {};
		},
		update: function (event) {
			var detailId = getSelectedRow();
			if(detailId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(detailId)
		},
		saveOrUpdate: function (event) {
			var url = vm.orderDetail.detailId == null ? "../orderdetail/save" : "../orderdetail/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.orderDetail),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var detailIds = getSelectedRows();
			if(detailIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../orderdetail/delete",
				    data: JSON.stringify(detailIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(detailId){
			$.get("../orderdetail/info/"+detailId, function(r){
                vm.orderDetail = r.orderDetail;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});