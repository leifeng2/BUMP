package com.bump.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单明细
 * 
 * @author leifeng
 * @email ${email}
 * @date 2017-05-14 16:49:12
 */
public class OrderDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long detailId;
	//订单ID
	private Long orderId;
	//设备ID
	private Long deviceId;
	//检测方式（参见数据字典：检定、校准、检测、检验）
	private String detectMethod;
	//送检机构
	private Long sysOrgId;
	//录入人员
	private Long userId;
	//应收
	private Double shouldAmount;
	//实收
	private Double realAmount;
	//订单类型（参见数据字典 指派、竞价）
	private String orderType;

	/**
	 * 设置：主键ID
	 */
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
	/**
	 * 获取：主键ID
	 */
	public Long getDetailId() {
		return detailId;
	}
	/**
	 * 设置：订单ID
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：设备ID
	 */
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：设备ID
	 */
	public Long getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：检测方式（参见数据字典：检定、校准、检测、检验）
	 */
	public void setDetectMethod(String detectMethod) {
		this.detectMethod = detectMethod;
	}
	/**
	 * 获取：检测方式（参见数据字典：检定、校准、检测、检验）
	 */
	public String getDetectMethod() {
		return detectMethod;
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
	 * 设置：录入人员
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：录入人员
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：应收
	 */
	public void setShouldAmount(Double shouldAmount) {
		this.shouldAmount = shouldAmount;
	}
	/**
	 * 获取：应收
	 */
	public Double getShouldAmount() {
		return shouldAmount;
	}
	/**
	 * 设置：实收
	 */
	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}
	/**
	 * 获取：实收
	 */
	public Double getRealAmount() {
		return realAmount;
	}
	/**
	 * 设置：订单类型（参见数据字典 指派、竞价）
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：订单类型（参见数据字典 指派、竞价）
	 */
	public String getOrderType() {
		return orderType;
	}
}
