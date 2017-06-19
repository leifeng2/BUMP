package com.bump.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bump.dao.SysOrgDao;
import com.bump.entity.SysOrgEntity;
import com.bump.service.SysOrgService;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;



@Service("sysOrgService")
public class SysOrgServiceImpl implements SysOrgService {
	@Autowired
	private SysOrgDao sysOrgDao;
	
	
	public PageList<SysOrgEntity> findPageList(Map<String, Object> param,PageBounds bounds){
	 PageList<SysOrgEntity> pageList = sysOrgDao.findPageList(param, bounds);
	 return pageList;
	}
	
	@Override
	public SysOrgEntity queryObject(Long sysOrgId){
		return sysOrgDao.queryObject(sysOrgId);
	}
	
	@Override
	public List<SysOrgEntity> queryList(Map<String, Object> map){
		return sysOrgDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysOrgDao.queryTotal(map);
	}
	
	@Override
	public void save(SysOrgEntity sysOrg){
		sysOrgDao.save(sysOrg);
	}
	
	@Override
	public void update(SysOrgEntity sysOrg){
		sysOrgDao.update(sysOrg);
	}
	
	@Override
	public void delete(Long sysOrgId){
		sysOrgDao.delete(sysOrgId);
	}
	
	@Override
	public void deleteBatch(Long[] sysOrgIds){
		sysOrgDao.deleteBatch(sysOrgIds);
	}
	
}
