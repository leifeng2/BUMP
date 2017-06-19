package com.bump.entity;

import java.io.Serializable;



/**
 * 组织机构
 * 
 * @author leifeng
 * @email ${email}
 * @date 2017-05-09 21:18:53
 */
public class SysOrgEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//机构标识
	private Long sysOrgId;
	//机构名称
	private String sysOrgName;
	//上级机构ID
	private Long parentOrgId;
	//机构联系人
	private String contactMan;
	//联系电话
	private String contactPhone;
	//邮箱
	private String mail;
	//统一社会信用代码
	private String sociaCreditCode;
	//紧急电话
	private String helpPhone;
	//详细地址
	private String address;
	//银行
	private String bank;
	//银行账号
	private String bankAccount;
	//机构LOGO
	private String sysLogo;
	//排序ID
	private Integer sort;
	//机构类别(参见数据字典)
	private Integer orgType;
	//传真
	private String fax;
	//服务承诺
	private String servicePromise;
	//经纬度
	private String latitudeLongitude;
	//营业执照
	private String license;
	//资质
	private String qualifications;
	//检测周期
	private Integer detectionCycle;
	//是否托管
	private Integer isTrusteeship;
	//管理员用户
	private Long userId;
	//是否审核
	private Integer isCheck;
	//行业
	private String trade;
	//紧急联系人
	private String helpMan;
	//通讯地址_国家
	private String postAddrCountry;
	//通讯地址_省市区
	private String postAddrArea;

	/**
	 * 设置：机构标识
	 */
	public void setSysOrgId(Long sysOrgId) {
		this.sysOrgId = sysOrgId;
	}
	/**
	 * 获取：机构标识
	 */
	public Long getSysOrgId() {
		return sysOrgId;
	}
	/**
	 * 设置：机构名称
	 */
	public void setSysOrgName(String sysOrgName) {
		this.sysOrgName = sysOrgName;
	}
	/**
	 * 获取：机构名称
	 */
	public String getSysOrgName() {
		return sysOrgName;
	}
	/**
	 * 设置：上级机构ID
	 */
	public void setParentOrgId(Long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	/**
	 * 获取：上级机构ID
	 */
	public Long getParentOrgId() {
		return parentOrgId;
	}
	/**
	 * 设置：机构联系人
	 */
	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}
	/**
	 * 获取：机构联系人
	 */
	public String getContactMan() {
		return contactMan;
	}
	/**
	 * 设置：联系电话
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * 设置：邮箱
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * 获取：邮箱
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setSociaCreditCode(String sociaCreditCode) {
		this.sociaCreditCode = sociaCreditCode;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getSociaCreditCode() {
		return sociaCreditCode;
	}
	/**
	 * 设置：紧急电话
	 */
	public void setHelpPhone(String helpPhone) {
		this.helpPhone = helpPhone;
	}
	/**
	 * 获取：紧急电话
	 */
	public String getHelpPhone() {
		return helpPhone;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：银行
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * 获取：银行
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 设置：银行账号
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * 获取：银行账号
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 设置：机构LOGO
	 */
	public void setSysLogo(String sysLogo) {
		this.sysLogo = sysLogo;
	}
	/**
	 * 获取：机构LOGO
	 */
	public String getSysLogo() {
		return sysLogo;
	}
	/**
	 * 设置：排序ID
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序ID
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：机构类别(参见数据字典)
	 */
	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}
	/**
	 * 获取：机构类别(参见数据字典)
	 */
	public Integer getOrgType() {
		return orgType;
	}
	/**
	 * 设置：传真
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * 获取：传真
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * 设置：服务承诺
	 */
	public void setServicePromise(String servicePromise) {
		this.servicePromise = servicePromise;
	}
	/**
	 * 获取：服务承诺
	 */
	public String getServicePromise() {
		return servicePromise;
	}
	/**
	 * 设置：经纬度
	 */
	public void setLatitudeLongitude(String latitudeLongitude) {
		this.latitudeLongitude = latitudeLongitude;
	}
	/**
	 * 获取：经纬度
	 */
	public String getLatitudeLongitude() {
		return latitudeLongitude;
	}
	/**
	 * 设置：营业执照
	 */
	public void setLicense(String license) {
		this.license = license;
	}
	/**
	 * 获取：营业执照
	 */
	public String getLicense() {
		return license;
	}
	/**
	 * 设置：资质
	 */
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	/**
	 * 获取：资质
	 */
	public String getQualifications() {
		return qualifications;
	}
	/**
	 * 设置：检测周期
	 */
	public void setDetectionCycle(Integer detectionCycle) {
		this.detectionCycle = detectionCycle;
	}
	/**
	 * 获取：检测周期
	 */
	public Integer getDetectionCycle() {
		return detectionCycle;
	}
	/**
	 * 设置：是否托管
	 */
	public void setIsTrusteeship(Integer isTrusteeship) {
		this.isTrusteeship = isTrusteeship;
	}
	/**
	 * 获取：是否托管
	 */
	public Integer getIsTrusteeship() {
		return isTrusteeship;
	}
	/**
	 * 设置：管理员用户
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：管理员用户
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：是否审核
	 */
	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}
	/**
	 * 获取：是否审核
	 */
	public Integer getIsCheck() {
		return isCheck;
	}
	/**
	 * 设置：行业
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	/**
	 * 获取：行业
	 */
	public String getTrade() {
		return trade;
	}
	/**
	 * 设置：紧急联系人
	 */
	public void setHelpMan(String helpMan) {
		this.helpMan = helpMan;
	}
	/**
	 * 获取：紧急联系人
	 */
	public String getHelpMan() {
		return helpMan;
	}
	/**
	 * 设置：通讯地址_国家
	 */
	public void setPostAddrCountry(String postAddrCountry) {
		this.postAddrCountry = postAddrCountry;
	}
	/**
	 * 获取：通讯地址_国家
	 */
	public String getPostAddrCountry() {
		return postAddrCountry;
	}
	/**
	 * 设置：通讯地址_省市区
	 */
	public void setPostAddrArea(String postAddrArea) {
		this.postAddrArea = postAddrArea;
	}
	/**
	 * 获取：通讯地址_省市区
	 */
	public String getPostAddrArea() {
		return postAddrArea;
	}
}
