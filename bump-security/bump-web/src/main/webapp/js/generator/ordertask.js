$(function () {
    $("#jqGrid").jqGrid({
        url: '../ordertask/list',
        datatype: "json",
        colModel: [			
			{ label: 'taskId', name: 'taskId', index: 'task_id', width: 50, key: true },
			{ label: '计量器具ID', name: 'deviceId', index: 'device_id', width: 80 }, 			
			{ label: '检测人员ID', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '检测方式（参见数据字典：检定、校准、检测、检验）', name: 'detectMethod', index: 'detect_method', width: 80 }, 			
			{ label: '任务时限', name: 'taskLimt', index: 'task_limt', width: 80 }, 			
			{ label: '状态', name: 'state', index: 'state', width: 80 }, 			
			{ label: '任务时间', name: 'taskTime', index: 'task_time', width: 80 }, 			
			{ label: '处理时间', name: 'dealTime', index: 'deal_time', width: 80 }, 			
			{ label: '订单ID', name: 'orderId', index: 'order_id', width: 80 }			
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
		orderTask: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.orderTask = {};
		},
		update: function (event) {
			var taskId = getSelectedRow();
			if(taskId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(taskId)
		},
		saveOrUpdate: function (event) {
			var url = vm.orderTask.taskId == null ? "../ordertask/save" : "../ordertask/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.orderTask),
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
			var taskIds = getSelectedRows();
			if(taskIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../ordertask/delete",
				    data: JSON.stringify(taskIds),
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
		getInfo: function(taskId){
			$.get("../ordertask/info/"+taskId, function(r){
                vm.orderTask = r.orderTask;
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