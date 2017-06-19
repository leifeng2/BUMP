package com.bump.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 计量器具管理
 * 
 * @author ynccsoft
 * @email ${email}
 * @date 2017-05-15 23:19:57
 */
public class DeviceInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long deviceId;
	//录入人员（参见用户表）
	private Long userId;
	//机构ID（参见机构ID）
	private Long sysOrgId;
	//编号
	private String deviceNum;
	//设备名称
	private String deviceName;
	//设备型号
	private String deviceType;
	//检测方式
	private String detectMethod;
	//生产厂家
	private String manuFacturer;
	//生产日期
	private Date productionDate;
	//规格
	private String standard;
	//测量范围
	private String measureRange;
	//最大误差
	private String maxError;
	//类别
	private String category;
	//专业（参见数据字典）
	private String major;
	//服务类型（参见数据字典）
	private String serviceType;
	//安装/使用地点
	private String useLocation;
	//检测周期
	private Integer detectCycle;
	//最近一次检测日期
	private Date lastDetectDate;
	//最近一次检测证书
	private String lastCertificateUrl;
	//图片地址
	private String imageUrl;
	//使用状态（参见数据字典）
	private String useState;
	//状态标识（参见数据字典）
	private String status;
	//备注
	private String remark;
	//管理部门（前台可搜索选择）
	private String department;
	//设备二维码
	private String deviceQrCode;

	/**
	 * 设置：主键ID
	 */
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：主键ID
	 */
	public Long getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：录入人员（参见用户表）
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：录入人员（参见用户表）
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：机构ID（参见机构ID）
	 */
	public void setSysOrgId(Long sysOrgId) {
		this.sysOrgId = sysOrgId;
	}
	/**
	 * 获取：机构ID（参见机构ID）
	 */
	public Long getSysOrgId() {
		return sysOrgId;
	}
	/**
	 * 设置：编号
	 */
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	/**
	 * 获取：编号
	 */
	public String getDeviceNum() {
		return deviceNum;
	}
	/**
	 * 设置：设备名称
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * 设置：设备型号
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	/**
	 * 获取：设备型号
	 */
	public String getDeviceType() {
		return deviceType;
	}
	/**
	 * 设置：检测方式
	 */
	public void setDetectMethod(String detectMethod) {
		this.detectMethod = detectMethod;
	}
	/**
	 * 获取：检测方式
	 */
	public String getDetectMethod() {
		return detectMethod;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setManuFacturer(String manuFacturer) {
		this.manuFacturer = manuFacturer;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getManuFacturer() {
		return manuFacturer;
	}
	/**
	 * 设置：生产日期
	 */
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	/**
	 * 获取：生产日期
	 */
	public Date getProductionDate() {
		return productionDate;
	}
	/**
	 * 设置：规格
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}
	/**
	 * 获取：规格
	 */
	public String getStandard() {
		return standard;
	}
	/**
	 * 设置：测量范围
	 */
	public void setMeasureRange(String measureRange) {
		this.measureRange = measureRange;
	}
	/**
	 * 获取：测量范围
	 */
	public String getMeasureRange() {
		return measureRange;
	}
	/**
	 * 设置：最大误差
	 */
	public void setMaxError(String maxError) {
		this.maxError = maxError;
	}
	/**
	 * 获取：最大误差
	 */
	public String getMaxError() {
		return maxError;
	}
	/**
	 * 设置：类别
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：类别
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：专业（参见数据字典）
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * 获取：专业（参见数据字典）
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * 设置：服务类型（参见数据字典）
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	/**
	 * 获取：服务类型（参见数据字典）
	 */
	public String getServiceType() {
		return serviceType;
	}
	/**
	 * 设置：安装/使用地点
	 */
	public void setUseLocation(String useLocation) {
		this.useLocation = useLocation;
	}
	/**
	 * 获取：安装/使用地点
	 */
	public String getUseLocation() {
		return useLocation;
	}
	/**
	 * 设置：检测周期
	 */
	public void setDetectCycle(Integer detectCycle) {
		this.detectCycle = detectCycle;
	}
	/**
	 * 获取：检测周期
	 */
	public Integer getDetectCycle() {
		return detectCycle;
	}
	/**
	 * 设置：最近一次检测日期
	 */
	public void setLastDetectDate(Date lastDetectDate) {
		this.lastDetectDate = lastDetectDate;
	}
	/**
	 * 获取：最近一次检测日期
	 */
	public Date getLastDetectDate() {
		return lastDetectDate;
	}
	/**
	 * 设置：最近一次检测证书
	 */
	public void setLastCertificateUrl(String lastCertificateUrl) {
		this.lastCertificateUrl = lastCertificateUrl;
	}
	/**
	 * 获取：最近一次检测证书
	 */
	public String getLastCertificateUrl() {
		return lastCertificateUrl;
	}
	/**
	 * 设置：图片地址
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：图片地址
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：使用状态（参见数据字典）
	 */
	public void setUseState(String useState) {
		this.useState = useState;
	}
	/**
	 * 获取：使用状态（参见数据字典）
	 */
	public String getUseState() {
		return useState;
	}
	/**
	 * 设置：状态标识（参见数据字典）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态标识（参见数据字典）
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：管理部门（前台可搜索选择）
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * 获取：管理部门（前台可搜索选择）
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * 设置：设备二维码
	 */
	public void setDeviceQrCode(String deviceQrCode) {
		this.deviceQrCode = deviceQrCode;
	}
	/**
	 * 获取：设备二维码
	 */
	public String getDeviceQrCode() {
		return deviceQrCode;
	}
}
