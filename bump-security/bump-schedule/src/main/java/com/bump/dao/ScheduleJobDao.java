package com.bump.dao;

import com.bump.entity.ScheduleJobEntity;
import java.util.Map;

/**
 * 定时任务
 * @author lixi
 * @date 2017年05月04日 下午10:29:57
 */
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {

	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
