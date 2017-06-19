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

// 页面加载完执行函数
$(function() {
	$("#save_give_org_btn").unbind().bind("click", function() {
		saveFormData();
	});
	// 【弹窗】送检机构信息补充
	 show_addGiveOrg();

	$("#save_deviceInfo_btn").unbind().bind("click", function() {
		saveDeviceInfoFormData();
	});
	// 【弹窗】计量器具添加
	//show_addDeviceInfo();
});