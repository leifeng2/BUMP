package com.bump.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 检验记录
 * 
 * @author lixi
 * @email ${email}
 * @date 2017-05-14 00:39:39
 */
public class InspectionRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 仪器名称
	private Long recordId;
	// 记录类型
	private String recordType;
	// 设备编号
	private Long deviceId;
	// 处理人员
	private Long userId;
	// 检测时间
	private Date inspectDate;
	// 检测结果
	private String inspectResult;
	// 备注
	private String remark;
	// 检测记录附件
	private String recordDetail;

	// 检测记录附件
	private String standName;

	// 检测记录附件
	private String deviceType;

	// 检测记录附件
	private String measureRange;

	public String getStandName() {
		return standName;
	}

	public void setStandName(String standName) {
		this.standName = standName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getMeasureRange() {
		return measureRange;
	}

	public void setMeasureRange(String measureRange) {
		this.measureRange = measureRange;
	}

	/**
	 * 设置：仪器名称
	 */
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	/**
	 * 获取：仪器名称
	 */
	public Long getRecordId() {
		return recordId;
	}

	/**
	 * 设置：记录类型
	 */
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	/**
	 * 获取：记录类型
	 */
	public String getRecordType() {
		return recordType;
	}

	/**
	 * 设置：设备编号
	 */
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * 获取：设备编号
	 */
	public Long getDeviceId() {
		return deviceId;
	}

	/**
	 * 设置：处理人员
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取：处理人员
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置：检测时间
	 */
	public void setInspectDate(Date inspectDate) {
		this.inspectDate = inspectDate;
	}

	/**
	 * 获取：检测时间
	 */
	public Date getInspectDate() {
		return inspectDate;
	}

	/**
	 * 设置：检测结果
	 */
	public void setInspectResult(String inspectResult) {
		this.inspectResult = inspectResult;
	}

	/**
	 * 获取：检测结果
	 */
	public String getInspectResult() {
		return inspectResult;
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
	 * 设置：检测记录附件
	 */
	public void setRecordDetail(String recordDetail) {
		this.recordDetail = recordDetail;
	}

	/**
	 * 获取：检测记录附件
	 */
	public String getRecordDetail() {
		return recordDetail;
	}
}
