$(function () {
    $("#jqGrid").jqGrid({
        url: '../orderinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'orderId', name: 'orderId', index: 'order_id', width: 50, key: true },
			{ label: '交易模式', name: 'exchangeModel', index: 'exchange_model', width: 80 }, 			
			{ label: '送检机构', name: 'sysOrgId', index: 'sys_org_id', width: 80 }, 			
			{ label: '检测机构ID', name: 'detectOrgId', index: 'detect_org_id', width: 80 }, 			
			{ label: '订单名称', name: 'orderName', index: 'order_name', width: 80 }, 			
			{ label: '订单类型(参见数据字典)', name: 'orderType', index: 'order_type', width: 80 }, 			
			{ label: '联系人1', name: 'contactPerson1', index: 'contact_person1', width: 80 }, 			
			{ label: '联系电话1', name: 'contactPhone1', index: 'contact_phone1', width: 80 }, 			
			{ label: '联系人2', name: 'contactPerson2', index: 'contact_Person2', width: 80 }, 			
			{ label: '联系电话2', name: 'contactPhone2', index: 'contact_phone2', width: 80 }, 			
			{ label: '发票类型（参见数据字典）', name: 'invoiceType', index: 'invoice_type', width: 80 }, 			
			{ label: '发票抬头', name: 'invoiceTitle', index: 'invoice_title', width: 80 }, 			
			{ label: '发票明细', name: 'invoiceDetail', index: 'invoice_detail', width: 80 }, 			
			{ label: '要求完成时限', name: 'timeLimit', index: 'time_limit', width: 80 }, 			
			{ label: '订单应收', name: 'shouldAmount', index: 'should_amount', width: 80 }, 			
			{ label: '订单实收', name: 'realAmount', index: 'real_amount', width: 80 }, 			
			{ label: '订单状态（参见数据字典）', name: 'status', index: 'status', width: 80 }, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '收货地址', name: 'receiveAddress', index: 'receive_address', width: 80 }, 			
			{ label: '配送方式(参见数据字典)', name: 'shippingMethods', index: 'shipping_methods', width: 80 }, 			
			{ label: '快递单号', name: 'expressNumber', index: 'express_number', width: 80 }, 			
			{ label: '回寄地址', name: 'returnAddress', index: 'return_address', width: 80 }, 			
			{ label: '用户ID', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '账户交易类型', name: 'exchangeType', index: 'exchange_type', width: 80 }			
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
		orderInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.orderInfo = {};
		},
		update: function (event) {
			var orderId = getSelectedRow();
			if(orderId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(orderId)
		},
		saveOrUpdate: function (event) {
			var url = vm.orderInfo.orderId == null ? "../orderinfo/save" : "../orderinfo/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.orderInfo),
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
			var orderIds = getSelectedRows();
			if(orderIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../orderinfo/delete",
				    data: JSON.stringify(orderIds),
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
		getInfo: function(orderId){
			$.get("../orderinfo/info/"+orderId, function(r){
                vm.orderInfo = r.orderInfo;
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