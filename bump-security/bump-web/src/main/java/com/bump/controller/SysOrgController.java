package com.bump.controller;

import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bump.entity.SysOrgEntity;
import com.bump.paginator.domain.Order;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;
import com.bump.service.SysOrgService;
import com.bump.utils.PageUtils;
import com.bump.utils.Query;
import com.bump.utils.R;


/**
 * 组织机构
 * 
 * @author leifeng
 * @date 2017-05-08 23:54:24
 */
@RestController
@RequestMapping("/sysorg")
public class SysOrgController extends AbstractController {
	@Autowired
	private SysOrgService sysOrgService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysorg:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        String order = (String) params.get("order");
        if(order.equals("asc")||order.equals("desc")){
			order = null;
		}
        PageBounds bounds = new PageBounds(query.getPage(), query.getLimit(), Order.formString(order));
        PageList<SysOrgEntity> list = sysOrgService.findPageList(null, bounds);
        PageUtils pageUtil = new PageUtils(list, list.getPaginator().getTotalCount(), query.getLimit(), list.getPaginator().getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{sysOrgId}")
	@RequiresPermissions("sysorg:info")
	public R info(@PathVariable("sysOrgId") Long sysOrgId){
		SysOrgEntity sysOrg = sysOrgService.queryObject(sysOrgId);
		
		return R.ok().put("sysOrg", sysOrg);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysorg:save")
	public R save(@RequestBody SysOrgEntity sysOrg){
		sysOrgService.save(sysOrg);
		
		return R.ok();
	}
	
	@RequestMapping("/saveGiveOrg")
	@RequiresPermissions("sysorg:save")
	public R saveGiveOrg(@RequestBody SysOrgEntity sysOrg) {
		Long userId = getUserId();
		sysOrg.setUserId(userId);
		sysOrg.setOrgType(1);
		sysOrg.setIsCheck(0);
		sysOrgService.save(sysOrg);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysorg:update")
	public R update(@RequestBody SysOrgEntity sysOrg){
		sysOrgService.update(sysOrg);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sysorg:delete")
	public R delete(@RequestBody Long[] sysOrgIds){
		sysOrgService.deleteBatch(sysOrgIds);
		
		return R.ok();
	}
	
}
