// 【弹窗】送检机构信息补充
function show_addGiveOrg() {
	layer.open({
		type : 1,
		skin : 'layui-layer-molv',
		title : "送检机构信息补充",
		area : [ '900px', '590px' ],
		shadeClose : false,
		content : jQuery("#giveOrgFormLayer")
	});
}

// 【保存】送检机构信息补充
function saveFormData() {
	var data = $('#giveOrgForm').serializeObject();
	$.ajax({
		type : "POST",
		cache : false,
		url : "../sysorg/saveGiveOrg",
		data : JSON.stringify(data),
		success : function(result) {
			if (result.code == 0) {
				layer.close(1);
				layer.alert('保存成功');
			} else {
				layer.alert(result.msg);
			}
		}
	});
}

// =======================================================================
// 【弹窗】计量器具添加
function show_addDeviceInfo() {
	layer.open({
		type : 1,
		skin : 'layui-layer-molv',
		title : "计量器具添加",
		area : [ '900px', '590px' ],
		shadeClose : false,
		content : jQuery("#deviceInfoLayer")
	});
}

// 【保存】计量器具添加
function saveDeviceInfoFormData() {
	var data = $('#deviceInfoForm').serializeObject();
	$.ajax({
		type : "POST",
		cache : false,
		url : "../deviceinfo/save",
		data : JSON.stringify(data),
		success : function(result) {
			if (result.code == 0) {
				layer.close(1);
				layer.alert('保存成功');
			} else {
				layer.alert(result.msg);
			}
		}
	});
}
// =======================================================================

// =======================================================================
// 【弹窗】生成订单
function show_addOrderInfo() {
	var devIds = jqchk();
	
	if(devIds.length==""){
		alert("请选择需要生成订单的计量器！");
		return false;
	}
	
	layer.open({
		type : 1,
		skin : 'layui-layer-molv',
		title : "订单详细信息补充",
		area : [ '900px', '660px' ],
		shadeClose : false,
		content : jQuery("#orderInfoLayer")
	});
}

function jqchk() { // jquery获取复选框值
	var chk_value = "";
	$('input[name="devId_checkBox"]:checked').each(function() {
		chk_value += $(this).val() + ",";
	});
	return chk_value;
}

// 【保存】生成订单
function saveOrderInfoFormData() {
	var devIds = jqchk();
	var data = $('#orderInfoForm').serializeObject();
// console.log(data);
//	console.log("===>" + JSON.stringify(data));
	$.ajax({
		type : "POST",
		cache : false,
		url : "../orderinfo/publish?devIds=" + devIds,
		data : JSON.stringify(data),
		success : function(result) {
			if (result.code == 0) {
				layer.close(1);
				layer.alert('保存成功');
			} else {
				layer.alert(result.msg);
			}
		}
	});
}
// =======================================================================

// 页面加载完执行函数
$(function() {
	$("#save_give_org_btn").unbind().bind("click", function() {
		saveFormData();
	});
	// 【弹窗】送检机构信息补充
	// show_addGiveOrg();

	$("#save_deviceInfo_btn").unbind().bind("click", function() {
		saveDeviceInfoFormData();
	});
	// 【弹窗】计量器具添加
	$("#bach_add_device_1,#bach_add_device_2").unbind().bind("click", function() {
		 show_addDeviceInfo();
	});	

	// 【发布订单】按钮事件
	$("#save_order_btn").unbind().bind("click", function() {
		saveOrderInfoFormData();
	});
	// 【生成订单】按钮事件
	$("#create_order_btn").unbind().bind("click", function() {
		show_addOrderInfo();
	});	
});