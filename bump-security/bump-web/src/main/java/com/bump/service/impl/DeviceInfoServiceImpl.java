package com.bump.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bump.dao.DeviceInfoDao;
import com.bump.entity.DeviceInfoEntity;
import com.bump.service.DeviceInfoService;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;



@Service("deviceInfoService")
public class DeviceInfoServiceImpl implements DeviceInfoService {
	@Autowired
	private DeviceInfoDao deviceInfoDao;
	
	
	public PageList<DeviceInfoEntity> findPageList(Map<String, Object> param,PageBounds bounds){
	 PageList<DeviceInfoEntity> pageList = deviceInfoDao.findPageList(param, bounds);
	 return pageList;
	}
	
	@Override
	public DeviceInfoEntity queryObject(Long deviceId){
		return deviceInfoDao.queryObject(deviceId);
	}
	
	@Override
	public List<DeviceInfoEntity> queryList(Map<String, Object> map){
		return deviceInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return deviceInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(DeviceInfoEntity deviceInfo){
		deviceInfoDao.save(deviceInfo);
	}
	
	@Override
	public void update(DeviceInfoEntity deviceInfo){
		deviceInfoDao.update(deviceInfo);
	}
	
	@Override
	public void delete(Long deviceId){
		deviceInfoDao.delete(deviceId);
	}
	
	@Override
	public void deleteBatch(Long[] deviceIds){
		deviceInfoDao.deleteBatch(deviceIds);
	}
	
}
