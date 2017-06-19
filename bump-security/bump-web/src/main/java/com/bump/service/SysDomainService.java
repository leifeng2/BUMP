package com.bump.service;

import java.util.List;
import java.util.Map;
import com.bump.entity.SysDomainEntity;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;

/**
 * 数据字典表
 * @author leifeng
 * @date 2017-05-14 14:28:45
 */
public interface SysDomainService {
	
	public PageList<SysDomainEntity> findPageList(Map<String, Object> param,PageBounds bounds);
	
	SysDomainEntity queryObject(Long id);
	
	List<SysDomainEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysDomainEntity sysDomain);
	
	void update(SysDomainEntity sysDomain);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<SysDomainEntity> findByTableNameAndColumnName(String tableName, String columnName);
}
