package com.bump.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bump.entity.InspectionRecordEntity;
import com.bump.service.InspectionRecordService;
import com.bump.paginator.domain.Order;
import com.bump.paginator.domain.PageBounds;
import com.bump.paginator.domain.PageList;
import com.bump.utils.PageUtils;
import com.bump.utils.Query;
import com.bump.utils.R;


/**
 * 检验记录
 * 
 * @author lixi
 * @date 2017-05-14 00:39:39
 */
@RestController
@RequestMapping("inspectionrecord")
public class InspectionRecordController {
	@Autowired
	private InspectionRecordService inspectionRecordService;
	
	/**
	 * 列表
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/list")
	@RequiresPermissions("inspectionrecord:list")
	public R list(@RequestParam Map<String, Object> params) throws UnsupportedEncodingException{
		//查询列表数据
        Query query = new Query(params);
        String sidx = (String) params.get("sidx");
		String order = (String) params.get("order");
		order = sidx+"."+order;
        if(order.equals("asc")||order.equals("desc")){
			order = null;
		}
        Map<String, Object> map = new HashMap<>();
		if (query.containsKey("queryJD")) {
			map.put("queryJD",  (String) query.get("queryJD"));
		}
		if (query.containsKey("queryCCJG")) {
			map.put("queryCCJG",  (String) query.get("queryCCJG"));
		}
		if (query.containsKey("queryCDRQ")) {
			map.put("queryCDRQ",  (String) query.get("queryCDRQ"));
		}
		if (query.containsKey("queryKey")) {
			map.put("queryKey",  java.net.URLDecoder.decode((String) query.get("queryKey"),"UTF-8"));
		}
        PageBounds bounds = new PageBounds(query.getPage(), query.getLimit(), Order.formString(order));
        PageList<InspectionRecordEntity> list = inspectionRecordService.findPageList(map, bounds);
        PageUtils pageUtil = new PageUtils(list, list.getPaginator().getTotalCount(), query.getLimit(), list.getPaginator().getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{recordId}")
	@RequiresPermissions("inspectionrecord:info")
	public R info(@PathVariable("recordId") Long recordId){
		InspectionRecordEntity inspectionRecord = inspectionRecordService.queryObject(recordId);
		
		return R.ok().put("inspectionRecord", inspectionRecord);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("inspectionrecord:save")
	public R save(@RequestBody InspectionRecordEntity inspectionRecord){
		inspectionRecordService.save(inspectionRecord);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("inspectionrecord:update")
	public R update(@RequestBody InspectionRecordEntity inspectionRecord){
		inspectionRecordService.update(inspectionRecord);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("inspectionrecord:delete")
	public R delete(@RequestBody Long[] recordIds){
		inspectionRecordService.deleteBatch(recordIds);
		
		return R.ok();
	}
	
}
