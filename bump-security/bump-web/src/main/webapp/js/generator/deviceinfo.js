$(function () {
    $("#jqGrid").jqGrid({
        url: '../deviceinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'deviceId', name: 'deviceId', index: 'device_id', width: 50, key: true },
			{ label: '录入人员（参见用户表）', name: 'userId', index: 'user_Id', width: 80 }, 			
			{ label: '机构ID（参见机构ID）', name: 'sysOrgId', index: 'sys_org_id', width: 80 }, 			
			{ label: '编号', name: 'deviceNum', index: 'device_num', width: 80 }, 			
			{ label: '设备名称', name: 'deviceName', index: 'device_name', width: 80 }, 			
			{ label: '设备型号', name: 'deviceType', index: 'device_type', width: 80 }, 			
			{ label: '检测方式', name: 'detectMethod', index: 'detect_method', width: 80 }, 			
			{ label: '生产厂家', name: 'manuFacturer', index: 'manu_facturer', width: 80 }, 			
			{ label: '生产日期', name: 'productionDate', index: 'production_date', width: 80 }, 			
			{ label: '规格', name: 'standard', index: 'standard', width: 80 }, 			
			{ label: '测量范围', name: 'measureRange', index: 'measure_range', width: 80 }, 			
			{ label: '最大误差', name: 'maxError', index: 'max_error', width: 80 }, 			
			{ label: '类别', name: 'category', index: 'category', width: 80 }, 			
			{ label: '专业（参见数据字典）', name: 'major', index: 'major', width: 80 }, 			
			{ label: '服务类型（参见数据字典）', name: 'serviceType', index: 'service_type', width: 80 }, 			
			{ label: '安装/使用地点', name: 'useLocation', index: 'use_location', width: 80 }, 			
			{ label: '检测周期', name: 'detectCycle', index: 'detect_cycle', width: 80 }, 			
			{ label: '最近一次检测日期', name: 'lastDetectDate', index: 'last_detect_date', width: 80 }, 			
			{ label: '最近一次检测证书', name: 'lastCertificateUrl', index: 'last_certificate_url', width: 80 }, 			
			{ label: '图片地址', name: 'imageUrl', index: 'image_url', width: 80 }, 			
			{ label: '使用状态（参见数据字典）', name: 'useState', index: 'use_state', width: 80 }, 			
			{ label: '状态标识（参见数据字典）', name: 'status', index: 'status', width: 80 }, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '管理部门（前台可搜索选择）', name: 'department', index: 'department', width: 80 }, 			
			{ label: '设备二维码', name: 'deviceQrCode', index: 'device_qr_code', width: 80 }			
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
		deviceInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.deviceInfo = {};
		},
		update: function (event) {
			var deviceId = getSelectedRow();
			if(deviceId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(deviceId)
		},
		saveOrUpdate: function (event) {
			var url = vm.deviceInfo.deviceId == null ? "../deviceinfo/save" : "../deviceinfo/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.deviceInfo),
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
			var deviceIds = getSelectedRows();
			if(deviceIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../deviceinfo/delete",
				    data: JSON.stringify(deviceIds),
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
		getInfo: function(deviceId){
			$.get("../deviceinfo/info/"+deviceId, function(r){
                vm.deviceInfo = r.deviceInfo;
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