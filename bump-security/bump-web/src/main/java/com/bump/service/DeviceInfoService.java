package com.bump.service;

import com.bump.entity.DeviceInfoEntity;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;

import java.util.List;
import java.util.Map;

/**
 * 计量器具管理
 * 
 * @author ynccsoft
 * @date 2017-05-15 23:19:57
 */
public interface DeviceInfoService {
	
	public PageList<DeviceInfoEntity> findPageList(Map<String, Object> param,PageBounds bounds);
	
	DeviceInfoEntity queryObject(Long deviceId);
	
	List<DeviceInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DeviceInfoEntity deviceInfo);
	
	void update(DeviceInfoEntity deviceInfo);
	
	void delete(Long deviceId);
	
	void deleteBatch(Long[] deviceIds);
}
