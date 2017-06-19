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
import com.bump.entity.SysDomainEntity;
import com.bump.paginator.domain.Order;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;
import com.bump.service.SysDomainService;
import com.bump.utils.PageUtils;
import com.bump.utils.Query;
import com.bump.utils.R;


/**
 * 数据字典表
 * @author leifeng
 * @date 2017-05-14 14:28:45
 */
@RestController
@RequestMapping("/sysdomain")
public class SysDomainController {
	@Autowired
	private SysDomainService sysDomainService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysdomain:list")
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
        PageList<SysDomainEntity> list = sysDomainService.findPageList(null, bounds);
        PageUtils pageUtil = new PageUtils(list, list.getPaginator().getTotalCount(), query.getLimit(), list.getPaginator().getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 根据tableName 和 tableName 查询字典
	 */
	@RequestMapping("/info/{tableName}/{columnName}")
	@RequiresPermissions("sysdomain:info")
	public R infoByNameAndColumn(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName) {
		List<SysDomainEntity> sysDomainList = sysDomainService.findByTableNameAndColumnName(tableName, columnName);
		return R.ok().put("sysDomainList", sysDomainList);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysdomain:info")
	public R info(@PathVariable("id") Long id){
		SysDomainEntity sysDomain = sysDomainService.queryObject(id);
		
		return R.ok().put("sysDomain", sysDomain);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysdomain:save")
	public R save(@RequestBody SysDomainEntity sysDomain){
		sysDomainService.save(sysDomain);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysdomain:update")
	public R update(@RequestBody SysDomainEntity sysDomain){
		sysDomainService.update(sysDomain);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sysdomain:delete")
	public R delete(@RequestBody Long[] ids){
		sysDomainService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
