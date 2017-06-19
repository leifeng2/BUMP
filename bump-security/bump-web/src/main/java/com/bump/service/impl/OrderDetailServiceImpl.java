package com.bump.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bump.dao.OrderDetailDao;
import com.bump.entity.OrderDetailEntity;
import com.bump.service.OrderDetailService;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;



@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	
	public PageList<OrderDetailEntity> findPageList(Map<String, Object> param,PageBounds bounds){
	 PageList<OrderDetailEntity> pageList = orderDetailDao.findPageList(param, bounds);
	 return pageList;
	}
	
	@Override
	public OrderDetailEntity queryObject(Long detailId){
		return orderDetailDao.queryObject(detailId);
	}
	
	@Override
	public List<OrderDetailEntity> queryList(Map<String, Object> map){
		return orderDetailDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderDetailDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderDetailEntity orderDetail){
		orderDetailDao.save(orderDetail);
	}
	
	@Override
	public void update(OrderDetailEntity orderDetail){
		orderDetailDao.update(orderDetail);
	}
	
	@Override
	public void delete(Long detailId){
		orderDetailDao.delete(detailId);
	}
	
	@Override
	public void deleteBatch(Long[] detailIds){
		orderDetailDao.deleteBatch(detailIds);
	}
	
}
