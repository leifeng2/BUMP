package com.bump.dao;

import com.bump.entity.UserEntity;

/**
 * 用户
 * 
 * @author lixi
 * 
 * @date 2017-04-23 15:22:06
 */
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);
}
