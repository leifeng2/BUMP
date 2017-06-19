package com.bump.entity;

import java.io.Serializable;



/**
 * 数据字典表
 * @author leifeng
 * @email ${email}
 * @date 2017-05-14 14:28:45
 */
public class SysDomainEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long id;
	//表名
	private String tableName;
	//字段名
	private String columnName;
	//字段对应值
	private String columnValue;
	//描述
	private String description;
	//排序
	private Integer sort;
	//状态：0-无效；1-有效
	private String status;

	/**
	 * 设置：主键ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取：主键ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置：表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * 获取：表名
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * 设置：字段名
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * 获取：字段名
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * 设置：字段对应值
	 */
	public void setColumnValue(String columnValue) {
		this.columnValue = columnValue;
	}
	/**
	 * 获取：字段对应值
	 */
	public String getColumnValue() {
		return columnValue;
	}
	/**
	 * 设置：描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置：状态：0-无效；1-有效
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取：状态：0-无效；1-有效
	 */
	public String getStatus() {
		return status;
	}
}
