$(function () {
    $("#jqGrid").jqGrid({
        url: '../sysorg/list',
        datatype: "json",
        colModel: [			
			{ label: 'sysOrgId', name: 'sysOrgId', index: 'SYS_ORG_ID', width: 50, key: true },
			{ label: '机构名称', name: 'sysOrgName', index: 'SYS_ORG_NAME', width: 80 }, 			
			{ label: '机构联系人', name: 'contactMan', index: 'CONTACT_MAN', width: 80 }, 			
			{ label: '联系电话', name: 'contactPhone', index: 'CONTACT_PHONE', width: 80 }, 			
			{ label: '邮箱', name: 'mail', index: 'MAIL', width: 80 }, 			
			{ label: '统一社会信用代码', name: 'sociaCreditCode', index: 'Socia_Credit_Code', width: 80 }, 			
			{ label: '紧急电话', name: 'helpPhone', index: 'HELP_PHONE', width: 80 }, 			
			{ label: '详细地址', name: 'address', index: 'ADDRESS', width: 80 }, 			
			{ label: '银行', name: 'bank', index: 'bank', width: 80 }, 			
			{ label: '银行账号', name: 'bankAccount', index: 'bank_account', width: 80 }, 			
			{ label: '机构LOGO', name: 'sysLogo', index: 'SYS_LOGO', width: 80 }, 			
			{ label: '排序ID', name: 'sort', index: 'SORT', width: 80 }, 			
			{ label: '机构类别', name: 'orgType', index: 'ORG_TYPE', width: 80 }, 			
			{ label: '传真', name: 'fax', index: 'FAX', width: 80 }, 			
			{ label: '服务承诺', name: 'servicePromise', index: 'service_Promise', width: 80 }, 			
			{ label: '经纬度', name: 'latitudeLongitude', index: 'Latitude_longitude', width: 80 }, 			
			{ label: '营业执照', name: 'license', index: 'License', width: 80 }, 			
			{ label: '资质', name: 'qualifications', index: 'Qualifications', width: 80 }, 			
			{ label: '检测周期', name: 'detectionCycle', index: 'Detection_cycle', width: 80 }, 			
			{ label: '是否托管', name: 'isTrusteeship', index: 'is_Trusteeship', width: 80 }, 			
			{ label: '管理员用户', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '是否审核', name: 'isCheck', index: 'is_check', width: 80 }, 			
			{ label: '行业', name: 'trade', index: 'trade', width: 80 }, 			
			{ label: '紧急联系人', name: 'helpMan', index: 'help_man', width: 80 }, 			
			{ label: '通讯地址_国家', name: 'postAddrCountry', index: 'post_addr_country', width: 80 }, 			
			{ label: '通讯地址_省市区', name: 'postAddrArea', index: 'post_addr_area', width: 80 }			
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
		sysOrg: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysOrg = {};
		},
		update: function (event) {
			var sysOrgId = getSelectedRow();
			if(sysOrgId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(sysOrgId)
		},
		saveOrUpdate: function (event) {
			var url = vm.sysOrg.sysOrgId == null ? "../sysorg/save" : "../sysorg/update";
			$.ajax({
				type: "POST",
			    url: url,
			    data: JSON.stringify(vm.sysOrg),
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
			var sysOrgIds = getSelectedRows();
			if(sysOrgIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../sysorg/delete",
				    data: JSON.stringify(sysOrgIds),
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
		getInfo: function(sysOrgId){
			$.get("../sysorg/info/"+sysOrgId, function(r){
                vm.sysOrg = r.sysOrg;
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