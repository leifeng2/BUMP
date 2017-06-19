package com.bump.controller;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bump.entity.OrderDetailEntity;
import com.bump.entity.OrderInfoEntity;
import com.bump.entity.SysUserEntity;
import com.bump.paginator.domain.Order;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;
import com.bump.service.OrderDetailService;
import com.bump.service.OrderInfoService;
import com.bump.utils.PageUtils;
import com.bump.utils.Query;
import com.bump.utils.R;


/**
 * 订单信息
 * 
 * @author leifeng
 * @date 2017-05-14 16:48:16
 */
@RestController
@RequestMapping("/orderinfo")
public class OrderInfoController extends AbstractController {
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private OrderDetailService orderDetailService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("orderinfo:list")
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
        PageList<OrderInfoEntity> list = orderInfoService.findPageList(null, bounds);
        PageUtils pageUtil = new PageUtils(list, list.getPaginator().getTotalCount(), query.getLimit(), list.getPaginator().getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{orderId}")
	@RequiresPermissions("orderinfo:info")
	public R info(@PathVariable("orderId") Long orderId){
		OrderInfoEntity orderInfo = orderInfoService.queryObject(orderId);
		
		return R.ok().put("orderInfo", orderInfo);
	}
	
	/**
	 * 发布
	 */
	@RequestMapping("/publish")
	@RequiresPermissions("orderinfo:save")
	public R savePublish(@RequestBody OrderInfoEntity orderInfo, @RequestParam("devIds") String devIds) {
		SysUserEntity sysUser = getUser();
		String orderName = orderInfo.getDetectOrgId() + ""; // 机构名称+器具名称

		// 订单编号
		String orderNum = UUID.randomUUID().toString();
		// 订单主表信息
		orderInfo.setOrderNum(orderNum);
		orderInfo.setSysOrgId(sysUser.getSysOrgId()); //送检单位
		orderInfo.setOrderName(orderName);
		orderInfo.setUserId(sysUser.getUserId());
		orderInfo.setStatus("S0Q"); //订单状态：机构确认中
		orderInfo.setShouldAmount(0.0);
		orderInfo.setRealAmount(0.0);
		orderInfo.setCreateTime(new Date());
		orderInfoService.save(orderInfo);

		// 订单明细信息
//		detail_id	主键ID	bigint(20)	TRUE	TRUE	主键ID
//		order_id	订单ID	bigint(20)	FALSE	TRUE	订单ID
//		device_id	设备ID	bigint(20)	FALSE	TRUE	设备ID
//		detect_method	检测方式	varchar(3)	FALSE	TRUE	检测方式（参见数据字典：检定、校准、检测、检验）
//		sys_org_id	送检机构	bigint(20)	FALSE	TRUE	送检机构
//		user_id	录入人员	bigint(20)	FALSE	TRUE	录入人员
//		should_amount	应收	double(6,2)	FALSE	TRUE	应收
//		real_amount	实收	double(6,2)	FALSE	TRUE	实收
//		order_model	订单类型	varchar(4)	FALSE	TRUE	订单类型（参见数据字典 指派、竞价）

		String[] devIdSet = devIds.split(",");
		for (String devId : devIdSet) {
			OrderDetailEntity orderDetail = new OrderDetailEntity();
			orderDetail.setOrderId(orderInfo.getOrderId());
			orderDetail.setDeviceId(Long.parseLong(devId));
			orderDetail.setDetectMethod("1"); //检测方式（参见数据字典：1-检测 、2-检定、3-校准、4-检验） ORDER_DETAIL--> DETECT_METHOD
			orderDetail.setSysOrgId(sysUser.getSysOrgId());
			orderDetail.setUserId(sysUser.getUserId());
			orderDetail.setShouldAmount(0.0);
			orderDetail.setRealAmount(0.0);
			orderDetailService.save(orderDetail);
		}

		return R.ok();
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("orderinfo:save")
	public R save(@RequestBody OrderInfoEntity orderInfo){
		orderInfoService.save(orderInfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("orderinfo:update")
	public R update(@RequestBody OrderInfoEntity orderInfo){
		orderInfoService.update(orderInfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("orderinfo:delete")
	public R delete(@RequestBody Long[] orderIds){
		orderInfoService.deleteBatch(orderIds);
		
		return R.ok();
	}
	
}
