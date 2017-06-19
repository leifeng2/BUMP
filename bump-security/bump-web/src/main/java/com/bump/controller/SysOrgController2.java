package com.bump.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.util.EncodingUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.validator.constraints.Range;
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
 * 检测机构
 * 
 * @author leifeng
 * @date 2017-05-08 23:54:24
 */
@RestController
@RequestMapping("/sysorg2")
public class SysOrgController2 extends AbstractController {
	@Autowired
	private SysOrgService sysOrgService;

	/**
	 * 列表
	 * 
	 * @throws UnsupportedEncodingException
	 */

	@RequestMapping("/list")
	@RequiresPermissions("sys:org2:list")
	public R list(@RequestParam Map<String, Object> params)
			throws UnsupportedEncodingException {
		// 查询列表数据
		Query query = new Query(params);
		String order = (String) params.get("order");
		if (order.equals("asc") || order.equals("desc")) {
			order = null;
		}
		PageBounds bounds = new PageBounds(query.getPage(), query.getLimit(),
				Order.formString(order));
		Map<String, Object> map = new HashMap<>();
		map.put("org_type", "2");
		if (query.containsKey("key")) {
			map.put("key",  java.net.URLDecoder.decode((String) query.get("key"),"UTF-8"));
		}
		PageList<SysOrgEntity> list = sysOrgService.findPageList(map, bounds);
		PageUtils pageUtil = new PageUtils(list, list.getPaginator()
				.getTotalCount(), query.getLimit(), list.getPaginator()
				.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{sysOrgId}")
	@RequiresPermissions("sys:org2:info")
	public R info(@PathVariable("sysOrgId") Long sysOrgId) {
		SysOrgEntity sysOrg = sysOrgService.queryObject(sysOrgId);

		return R.ok().put("sysOrg", sysOrg);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:org2:save")
	public R save(@RequestBody SysOrgEntity sysOrg) {
		Long userId = getUserId();
		sysOrg.setUserId(userId);
		sysOrg.setOrgType(2);
		sysOrg.setIsCheck(0);
		sysOrgService.save(sysOrg);

		return R.ok();
	}

	@RequestMapping("/saveGiveOrg")
	@RequiresPermissions("sys:org2:save")
	public R saveGiveOrg(@RequestBody SysOrgEntity sysOrg) {
		Long userId = getUserId();
		sysOrg.setUserId(userId);
		sysOrg.setOrgType(2);
		sysOrg.setIsCheck(0);
		sysOrgService.save(sysOrg);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:org2:update")
	public R update(@RequestBody SysOrgEntity sysOrg) {
		sysOrgService.update(sysOrg);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:org2:delete")
	public R delete(@RequestBody Long[] sysOrgIds) {
		sysOrgService.deleteBatch(sysOrgIds);

		return R.ok();
	}

}
