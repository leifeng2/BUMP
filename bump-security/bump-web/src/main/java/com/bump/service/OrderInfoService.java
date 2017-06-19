package com.bump.service;

import com.bump.entity.OrderInfoEntity;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;

import java.util.List;
import java.util.Map;

/**
 * 订单信息
 * 
 * @author leifeng
 * @date 2017-05-14 16:48:16
 */
public interface OrderInfoService {
	
	public PageList<OrderInfoEntity> findPageList(Map<String, Object> param,PageBounds bounds);
	
	OrderInfoEntity queryObject(Long orderId);
	
	List<OrderInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderInfoEntity orderInfo);
	
	void update(OrderInfoEntity orderInfo);
	
	void delete(Long orderId);
	
	void deleteBatch(Long[] orderIds);
}
