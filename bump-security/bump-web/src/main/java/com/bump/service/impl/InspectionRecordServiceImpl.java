package com.bump.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bump.dao.InspectionRecordDao;
import com.bump.entity.InspectionRecordEntity;
import com.bump.service.InspectionRecordService;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;



@Service("inspectionRecordService")
public class InspectionRecordServiceImpl implements InspectionRecordService {
	@Autowired
	private InspectionRecordDao inspectionRecordDao;
	
	
	public PageList<InspectionRecordEntity> findPageList(Map<String, Object> param,PageBounds bounds){
	 PageList<InspectionRecordEntity> pageList = inspectionRecordDao.findPageList(param, bounds);
	 return pageList;
	}
	
	@Override
	public InspectionRecordEntity queryObject(Long recordId){
		return inspectionRecordDao.queryObject(recordId);
	}
	
	@Override
	public List<InspectionRecordEntity> queryList(Map<String, Object> map){
		return inspectionRecordDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return inspectionRecordDao.queryTotal(map);
	}
	
	@Override
	public void save(InspectionRecordEntity inspectionRecord){
		inspectionRecordDao.save(inspectionRecord);
	}
	
	@Override
	public void update(InspectionRecordEntity inspectionRecord){
		inspectionRecordDao.update(inspectionRecord);
	}
	
	@Override
	public void delete(Long recordId){
		inspectionRecordDao.delete(recordId);
	}
	
	@Override
	public void deleteBatch(Long[] recordIds){
		inspectionRecordDao.deleteBatch(recordIds);
	}
	
}
