package com.bump.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bump.entity.OrderDetailEntity;
import com.bump.service.OrderDetailService;
import com.bump.paginator.domain.Order;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;
import com.bump.utils.PageUtils;
import com.bump.utils.Query;
import com.bump.utils.R;


/**
 * 订单明细
 * 
 * @author leifeng
 * @date 2017-05-14 16:49:12
 */
@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("orderdetail:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        String sidx = (String) params.get("sidx");
		String order = (String) params.get("order");
		order = sidx+"."+order;
        if(order.equals("asc")||order.equals("desc")){
			order = null;
		}
        PageBounds bounds = new PageBounds(query.getPage(), query.getLimit(), Order.formString(order));
        PageList<OrderDetailEntity> list = orderDetailService.findPageList(null, bounds);
        PageUtils pageUtil = new PageUtils(list, list.getPaginator().getTotalCount(), query.getLimit(), list.getPaginator().getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{detailId}")
	@RequiresPermissions("orderdetail:info")
	public R info(@PathVariable("detailId") Long detailId){
		OrderDetailEntity orderDetail = orderDetailService.queryObject(detailId);
		
		return R.ok().put("orderDetail", orderDetail);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("orderdetail:save")
	public R save(@RequestBody OrderDetailEntity orderDetail){
		orderDetailService.save(orderDetail);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("orderdetail:update")
	public R update(@RequestBody OrderDetailEntity orderDetail){
		orderDetailService.update(orderDetail);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("orderdetail:delete")
	public R delete(@RequestBody Long[] detailIds){
		orderDetailService.deleteBatch(detailIds);
		
		return R.ok();
	}
	
}
