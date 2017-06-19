package com.bump.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bump.dao.OrderInfoDao;
import com.bump.entity.OrderInfoEntity;
import com.bump.service.OrderInfoService;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;



@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	
	public PageList<OrderInfoEntity> findPageList(Map<String, Object> param,PageBounds bounds){
	 PageList<OrderInfoEntity> pageList = orderInfoDao.findPageList(param, bounds);
	 return pageList;
	}
	
	@Override
	public OrderInfoEntity queryObject(Long orderId){
		return orderInfoDao.queryObject(orderId);
	}
	
	@Override
	public List<OrderInfoEntity> queryList(Map<String, Object> map){
		return orderInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderInfoEntity orderInfo){
		orderInfoDao.save(orderInfo);
	}
	
	@Override
	public void update(OrderInfoEntity orderInfo){
		orderInfoDao.update(orderInfo);
	}
	
	@Override
	public void delete(Long orderId){
		orderInfoDao.delete(orderId);
	}
	
	@Override
	public void deleteBatch(Long[] orderIds){
		orderInfoDao.deleteBatch(orderIds);
	}
	
}
