package com.bump.service;

import com.bump.entity.SysOrgEntity;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;

import java.util.List;
import java.util.Map;

/**
 * 组织机构
 * 
 * @author leifeng
 * @date 2017-05-08 23:54:24
 */
public interface SysOrgService {
	
	public PageList<SysOrgEntity> findPageList(Map<String, Object> param,PageBounds bounds);
	
	SysOrgEntity queryObject(Long sysOrgId);
	
	List<SysOrgEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysOrgEntity sysOrg);
	
	void update(SysOrgEntity sysOrg);
	
	void delete(Long sysOrgId);
	
	void deleteBatch(Long[] sysOrgIds);
}
