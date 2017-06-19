package com.bump.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bump.dao.OrderTaskDao;
import com.bump.entity.OrderTaskEntity;
import com.bump.service.OrderTaskService;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;



@Service("orderTaskService")
public class OrderTaskServiceImpl implements OrderTaskService {
	@Autowired
	private OrderTaskDao orderTaskDao;
	
	
	public PageList<OrderTaskEntity> findPageList(Map<String, Object> param,PageBounds bounds){
	 PageList<OrderTaskEntity> pageList = orderTaskDao.findPageList(param, bounds);
	 return pageList;
	}
	
	@Override
	public OrderTaskEntity queryObject(Long taskId){
		return orderTaskDao.queryObject(taskId);
	}
	
	@Override
	public List<OrderTaskEntity> queryList(Map<String, Object> map){
		return orderTaskDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderTaskDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderTaskEntity orderTask){
		orderTaskDao.save(orderTask);
	}
	
	@Override
	public void update(OrderTaskEntity orderTask){
		orderTaskDao.update(orderTask);
	}
	
	@Override
	public void delete(Long taskId){
		orderTaskDao.delete(taskId);
	}
	
	@Override
	public void deleteBatch(Long[] taskIds){
		orderTaskDao.deleteBatch(taskIds);
	}
	
}
