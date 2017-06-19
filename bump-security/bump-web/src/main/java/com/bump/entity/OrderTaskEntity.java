package com.bump.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 任务管理
 * 
 * @author leifeng
 * @email ${email}
 * @date 2017-05-14 16:49:27
 */
public class OrderTaskEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//任务ID
	private Long taskId;
	//计量器具ID
	private Long deviceId;
	//检测人员ID
	private Long userId;
	//检测方式（参见数据字典：检定、校准、检测、检验）
	private String detectMethod;
	//任务时限
	private Integer taskLimt;
	//状态
	private String state;
	//任务时间
	private Date taskTime;
	//处理时间
	private Date dealTime;
	//订单ID
	private Long orderId;

	/**
	 * 设置：任务ID
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	/**
	 * 获取：任务ID
	 */
	public Long getTaskId() {
		return taskId;
	}
	/**
	 * 设置：计量器具ID
	 */
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：计量器具ID
	 */
	public Long getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：检测人员ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：检测人员ID
	 */
	public Long getUserId() {
		return userId;
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
	 * 设置：任务时限
	 */
	public void setTaskLimt(Integer taskLimt) {
		this.taskLimt = taskLimt;
	}
	/**
	 * 获取：任务时限
	 */
	public Integer getTaskLimt() {
		return taskLimt;
	}
	/**
	 * 设置：状态
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：状态
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置：任务时间
	 */
	public void setTaskTime(Date taskTime) {
		this.taskTime = taskTime;
	}
	/**
	 * 获取：任务时间
	 */
	public Date getTaskTime() {
		return taskTime;
	}
	/**
	 * 设置：处理时间
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
	/**
	 * 获取：处理时间
	 */
	public Date getDealTime() {
		return dealTime;
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
}
