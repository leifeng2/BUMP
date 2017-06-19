package com.bump.dao;

import com.bump.entity.TokenEntity;

/**
 * 用户Token
 * 
 * @author lixi
 * 
 * @date 2017-04-23 15:22:07
 */
public interface TokenDao extends BaseDao<TokenEntity> {
    
    TokenEntity queryByUserId(Long userId);

    TokenEntity queryByToken(String token);
	
}
