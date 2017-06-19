package com.bump.dao;

import com.bump.entity.SysRoleEntity;

import java.util.List;

/**
 * 角色管理
 * 
 * @author lixi
 * 
 * @date 2017年04月18日 上午9:33:33
 */
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
