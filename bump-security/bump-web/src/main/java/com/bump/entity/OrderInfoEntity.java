package com.bump.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单信息
 * 
 * @author leifeng
 * @email ${email}
 * @date 2017-05-14 16:48:16
 */
public class OrderInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键Id
	private Long orderId;
	//交易模式
	private String exchangeModel;
	//送检机构
	private Long sysOrgId;
	//检测机构ID
	private Long detectOrgId;
	//订单名称
	private String orderName;
	//订单类型(参见数据字典)
	private String orderType;
	//联系人1
	private String contactPerson1;
	//联系电话1
	private String contactPhone1;
	//联系人2
	private String contactPerson2;
	//联系电话2
	private String contactPhone2;
	//发票类型（参见数据字典）
	private String invoiceType;
	//发票抬头
	private String invoiceTitle;
	//发票明细
	private String invoiceDetail;
	//要求完成时限
	private Integer timeLimit;
	//订单应收
	private Double shouldAmount;
	//订单实收
	private Double realAmount;
	//订单状态（参见数据字典）
	private String status;
	//备注
	private String remark;
	//收货地址
	private String receiveAddress;
	//配送方式(参见数据字典)
	private String shippingMethods;
	//快递单号
	private String expressNumber;
	//回寄地址
	private String returnAddress;
	//用户ID
	private Long userId;
	//账户交易类型
	private String exchangeType;
	
	//订单编号
	private String orderNum;
	//创建时间
	private Date createTime;

	/**
	 * 设置：主键Id
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：主键Id
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：交易模式
	 */
	public void setExchangeModel(String exchangeModel) {
		this.exchangeModel = exchangeModel;
	}
	/**
	 * 获取：交易模式
	 */
	public String getExchangeModel() {
		return exchangeModel;
	}
	/**
	 * 设置：送检机构
	 */
	public void setSysOrgId(Long sysOrgId) {
		this.sysOrgId = sysOrgId;
	}
	/**
	 * 获取：送检机构
	 */
	public Long getSysOrgId() {
		return sysOrgId;
	}
	/**
	 * 设置：检测机构ID
	 */
	public void setDetectOrgId(Long detectOrgId) {
		this.detectOrgId = detectOrgId;
	}
	/**
	 * 获取：检测机构ID
	 */
	public Long getDetectOrgId() {
		return detectOrgId;
	}
	/**
	 * 设置：订单名称
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	/**
	 * 获取：订单名称
	 */
	public String getOrderName() {
		return orderName;
	}
	/**
	 * 设置：订单类型(参见数据字典)
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：订单类型(参见数据字典)
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * 设置：联系人1
	 */
	public void setContactPerson1(String contactPerson1) {
		this.contactPerson1 = contactPerson1;
	}
	/**
	 * 获取：联系人1
	 */
	public String getContactPerson1() {
		return contactPerson1;
	}
	/**
	 * 设置：联系电话1
	 */
	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}
	/**
	 * 获取：联系电话1
	 */
	public String getContactPhone1() {
		return contactPhone1;
	}
	/**
	 * 设置：联系人2
	 */
	public void setContactPerson2(String contactPerson2) {
		this.contactPerson2 = contactPerson2;
	}
	/**
	 * 获取：联系人2
	 */
	public String getContactPerson2() {
		return contactPerson2;
	}
	/**
	 * 设置：联系电话2
	 */
	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}
	/**
	 * 获取：联系电话2
	 */
	public String getContactPhone2() {
		return contactPhone2;
	}
	/**
	 * 设置：发票类型（参见数据字典）
	 */
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	/**
	 * 获取：发票类型（参见数据字典）
	 */
	public String getInvoiceType() {
		return invoiceType;
	}
	/**
	 * 设置：发票抬头
	 */
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	/**
	 * 获取：发票抬头
	 */
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	/**
	 * 设置：发票明细
	 */
	public void setInvoiceDetail(String invoiceDetail) {
		this.invoiceDetail = invoiceDetail;
	}
	/**
	 * 获取：发票明细
	 */
	public String getInvoiceDetail() {
		return invoiceDetail;
	}
	/**
	 * 设置：要求完成时限
	 */
	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}
	/**
	 * 获取：要求完成时限
	 */
	public Integer getTimeLimit() {
		return timeLimit;
	}
	/**
	 * 设置：订单应收
	 */
	public void setShouldAmount(Double shouldAmount) {
		this.shouldAmount = shouldAmount;
	}
	/**
	 * 获取：订单应收
	 */
	public Double getShouldAmount() {
		return shouldAmount;
	}
	/**
	 * 设置：订单实收
	 */
	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}
	/**
	 * 获取：订单实收
	 */
	public Double getRealAmount() {
		return realAmount;
	}
	/**
	 * 设置：订单状态（参见数据字典）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态（参见数据字典）
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
	 * 设置：收货地址
	 */
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	/**
	 * 获取：收货地址
	 */
	public String getReceiveAddress() {
		return receiveAddress;
	}
	/**
	 * 设置：配送方式(参见数据字典)
	 */
	public void setShippingMethods(String shippingMethods) {
		this.shippingMethods = shippingMethods;
	}
	/**
	 * 获取：配送方式(参见数据字典)
	 */
	public String getShippingMethods() {
		return shippingMethods;
	}
	/**
	 * 设置：快递单号
	 */
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
	/**
	 * 获取：快递单号
	 */
	public String getExpressNumber() {
		return expressNumber;
	}
	/**
	 * 设置：回寄地址
	 */
	public void setReturnAddress(String returnAddress) {
		this.returnAddress = returnAddress;
	}
	/**
	 * 获取：回寄地址
	 */
	public String getReturnAddress() {
		return returnAddress;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：账户交易类型
	 */
	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}
	/**
	 * 获取：账户交易类型
	 */
	public String getExchangeType() {
		return exchangeType;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
