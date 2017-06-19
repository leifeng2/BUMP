package com.bump.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bump.dao.SysDomainDao;
import com.bump.entity.SysDomainEntity;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;
import com.bump.service.SysDomainService;



@Service("sysDomainService")
public class SysDomainServiceImpl implements SysDomainService {
	@Autowired
	private SysDomainDao sysDomainDao;
	
	
	public PageList<SysDomainEntity> findPageList(Map<String, Object> param,PageBounds bounds){
	 PageList<SysDomainEntity> pageList = sysDomainDao.findPageList(param, bounds);
	 return pageList;
	}
	
	@Override
	public SysDomainEntity queryObject(Long id) {
		return sysDomainDao.queryObject(id);
	}
	
	@Override
	public List<SysDomainEntity> queryList(Map<String, Object> map){
		return sysDomainDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysDomainDao.queryTotal(map);
	}
	
	@Override
	public void save(SysDomainEntity sysDomain){
		sysDomainDao.save(sysDomain);
	}
	
	@Override
	public void update(SysDomainEntity sysDomain){
		sysDomainDao.update(sysDomain);
	}
	
	@Override
	public void delete(Long id) {
		sysDomainDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids) {
		sysDomainDao.deleteBatch(ids);
	}

	@Override
	public List<SysDomainEntity> findByTableNameAndColumnName(String tableName, String columnName) {
		return sysDomainDao.findByTableNameAndColumnName(tableName, columnName);
	}
	
}
