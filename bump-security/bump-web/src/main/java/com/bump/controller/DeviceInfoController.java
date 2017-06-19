package com.bump.controller;

import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bump.entity.DeviceInfoEntity;
import com.bump.entity.SysUserEntity;
import com.bump.paginator.domain.Order;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;
import com.bump.service.DeviceInfoService;
import com.bump.utils.PageUtils;
import com.bump.utils.Query;
import com.bump.utils.R;


/**
 * 计量器具管理
 * @author ynccsoft
 * @date 2017-05-15 23:19:57
 */
@RestController
@RequestMapping("/deviceinfo")
public class DeviceInfoController extends AbstractController {
	@Autowired
	private DeviceInfoService deviceInfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("deviceinfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		String sidx = (String) params.get("sidx");
		String order = (String) params.get("order");
		order = sidx + "." + order;
        if(order.equals("asc")||order.equals("desc")){
			order = null;
		}
        PageBounds bounds = new PageBounds(query.getPage(), query.getLimit(), Order.formString(order));
        PageList<DeviceInfoEntity> list = deviceInfoService.findPageList(null, bounds);
        PageUtils pageUtil = new PageUtils(list, list.getPaginator().getTotalCount(), query.getLimit(), list.getPaginator().getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{deviceId}")
	@RequiresPermissions("deviceinfo:info")
	public R info(@PathVariable("deviceId") Long deviceId){
		DeviceInfoEntity deviceInfo = deviceInfoService.queryObject(deviceId);
		
		return R.ok().put("deviceInfo", deviceInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("deviceinfo:save")
	public R save(@RequestBody DeviceInfoEntity deviceInfo){
		SysUserEntity sysUser = getUser();
		deviceInfo.setUserId(sysUser.getUserId());
		deviceInfo.setSysOrgId(sysUser.getSysOrgId());
		deviceInfoService.save(deviceInfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("deviceinfo:update")
	public R update(@RequestBody DeviceInfoEntity deviceInfo){
		deviceInfoService.update(deviceInfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("deviceinfo:delete")
	public R delete(@RequestBody Long[] deviceIds){
		deviceInfoService.deleteBatch(deviceIds);
		
		return R.ok();
	}
	
}
