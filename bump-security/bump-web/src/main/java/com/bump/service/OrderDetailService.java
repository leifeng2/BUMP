package com.bump.service;

import com.bump.entity.OrderDetailEntity;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;

import java.util.List;
import java.util.Map;

/**
 * 订单明细
 * 
 * @author leifeng
 * @date 2017-05-14 16:49:12
 */
public interface OrderDetailService {
	
	public PageList<OrderDetailEntity> findPageList(Map<String, Object> param,PageBounds bounds);
	
	OrderDetailEntity queryObject(Long detailId);
	
	List<OrderDetailEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderDetailEntity orderDetail);
	
	void update(OrderDetailEntity orderDetail);
	
	void delete(Long detailId);
	
	void deleteBatch(Long[] detailIds);
}
