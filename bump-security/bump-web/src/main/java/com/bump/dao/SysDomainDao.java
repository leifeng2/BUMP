package com.bump.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.bump.entity.SysDomainEntity;

/**
 * 数据字典表
 * @author leifeng
 * @date 2017-05-14 14:28:45
 */
public interface SysDomainDao extends BaseDao<SysDomainEntity> {
	
	/**
	 * 根据tableName 和 tableName 查询字典
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	List<SysDomainEntity> findByTableNameAndColumnName(@Param("tableName") String tableName, @Param("columnName") String columnName);

}
