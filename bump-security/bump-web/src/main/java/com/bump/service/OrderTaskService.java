package com.bump.service;

import com.bump.entity.OrderTaskEntity;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;

import java.util.List;
import java.util.Map;

/**
 * 任务管理
 * 
 * @author leifeng
 * @date 2017-05-14 16:49:27
 */
public interface OrderTaskService {
	
	public PageList<OrderTaskEntity> findPageList(Map<String, Object> param,PageBounds bounds);
	
	OrderTaskEntity queryObject(Long taskId);
	
	List<OrderTaskEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderTaskEntity orderTask);
	
	void update(OrderTaskEntity orderTask);
	
	void delete(Long taskId);
	
	void deleteBatch(Long[] taskIds);
}
