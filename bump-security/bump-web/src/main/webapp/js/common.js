//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

//工具集合Tools
window.T = {};

// 获取请求参数
// 使用示例
// location.href = http://localhost:8080/index.html?id=123
// T.p('id') --> 123;
var url = function(name) {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)return  unescape(r[2]); return null;
};
T.p = url;

//全局配置
$.ajaxSetup({
	dataType: "json",
	contentType: "application/json",
	cache: false
});

//重写alert
window.alert = function(msg, callback){
	parent.layer.alert(msg, function(index){
		parent.layer.close(index);
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
};

//重写confirm式样框
window.confirm = function(msg, callback){
	parent.layer.confirm(msg, {btn: ['确定','取消']},
	function(){//确定事件
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
};

//选择一条记录
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请选择一条记录");
    	return ;
    }
    
    var selectedIDs = grid.getGridParam("selarrrow");
    if(selectedIDs.length > 1){
    	alert("只能选择一条记录");
    	return ;
    }
    
    return selectedIDs[0];
}

//选择多条记录
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if(!rowKey){
    	alert("请选择一条记录");
    	return ;
    }
    
    return grid.getGridParam("selarrrow");
}

//======================= 设置下拉框内容 start ==========================================

function loadSelectOptions() {
	$("select").each(function(i) {
		var tableName = $(this).attr("tableName");
		var columnName = $(this).attr("columnName");
		var defVal = $(this).attr("defVal");
		var defTip = $(this).attr("defTip");
		if (typeof (tableName) != "undefined" && tableName.length > 0 && typeof (columnName) != "undefined" && columnName.length > 0) {
			var selectObj = $(this);
			findByTableNameAndColumnName(selectObj, tableName, columnName, defVal, defTip, setSelectOptions);
		}
	});
}

function findByTableNameAndColumnName(selectObj, tableName, columnName, defVal, defTip, callBackFunction) {
	var data = {
		"tableName" : tableName,
		"columnName" : columnName
	};
	//console.log("==>tableName=" + tableName + ",columnName=" + columnName);
	$.ajax({
		type : "POST",
		cache : false,
		url : "../sysdomain/info/" + tableName + "/" + columnName,
		data : data,
		success : function(result) {
			if (result.code == 0) {
				callBackFunction(selectObj, result.sysDomainList, defVal, defTip);
			}
		}
	});
}

function setSelectOptions(selectObj, dataList, defVal, defTip) {
	// 清空select内容
	selectObj.empty();
	// 设置默认第一个option项
	defTip = (typeof (defTip) != "undefined") ? defTip : "--请选择--";
	var option = $("<option>").val("").text(defTip);
	selectObj.append(option);
	// 添加 option
	$.each(dataList, function(index, item) {
		var option = $("<option>").val(item.columnValue).text(item.description);
		selectObj.append(option);
	});
	// 设置默认选中项
	if (typeof (defVal) != "undefined" && defVal.length > 0) {
		selectObj.find("option[value='" + defVal + "']").attr("selected", true);
	}
}

// ======================= 设置下拉框内容 end ==========================================

// 页面加载完执行函数
$(function() {
	// 设置下拉框内容
	loadSelectOptions();
});