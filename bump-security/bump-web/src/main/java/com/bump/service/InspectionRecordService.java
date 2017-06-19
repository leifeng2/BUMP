package com.bump.service;

import com.bump.entity.InspectionRecordEntity;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;

import java.util.List;
import java.util.Map;

/**
 * 检验记录
 * 
 * @author lixi
 * @date 2017-05-14 00:39:39
 */
public interface InspectionRecordService {
	
	public PageList<InspectionRecordEntity> findPageList(Map<String, Object> param,PageBounds bounds);
	
	InspectionRecordEntity queryObject(Long recordId);
	
	List<InspectionRecordEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InspectionRecordEntity inspectionRecord);
	
	void update(InspectionRecordEntity inspectionRecord);
	
	void delete(Long recordId);
	
	void deleteBatch(Long[] recordIds);
}
