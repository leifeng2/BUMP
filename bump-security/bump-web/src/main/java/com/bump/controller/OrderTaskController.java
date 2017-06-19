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

import com.bump.entity.OrderTaskEntity;
import com.bump.service.OrderTaskService;
import com.bump.paginator.domain.Order;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;
import com.bump.utils.PageUtils;
import com.bump.utils.Query;
import com.bump.utils.R;


/**
 * 任务管理
 * 
 * @author leifeng
 * @date 2017-05-14 16:49:27
 */
@RestController
@RequestMapping("/ordertask")
public class OrderTaskController {
	@Autowired
	private OrderTaskService orderTaskService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("ordertask:list")
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
        PageList<OrderTaskEntity> list = orderTaskService.findPageList(null, bounds);
        PageUtils pageUtil = new PageUtils(list, list.getPaginator().getTotalCount(), query.getLimit(), list.getPaginator().getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{taskId}")
	@RequiresPermissions("ordertask:info")
	public R info(@PathVariable("taskId") Long taskId){
		OrderTaskEntity orderTask = orderTaskService.queryObject(taskId);
		
		return R.ok().put("orderTask", orderTask);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("ordertask:save")
	public R save(@RequestBody OrderTaskEntity orderTask){
		orderTaskService.save(orderTask);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("ordertask:update")
	public R update(@RequestBody OrderTaskEntity orderTask){
		orderTaskService.update(orderTask);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("ordertask:delete")
	public R delete(@RequestBody Long[] taskIds){
		orderTaskService.deleteBatch(taskIds);
		
		return R.ok();
	}
	
}
