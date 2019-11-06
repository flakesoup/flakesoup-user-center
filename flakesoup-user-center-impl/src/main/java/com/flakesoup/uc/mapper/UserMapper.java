package com.flakesoup.uc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flakesoup.uc.api.entity.User;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 */
public interface UserMapper extends BaseMapper<User> {
	/**
	 * 通过ID查询用户信息
	 *
	 * @param id 用户ID
	 * @return userVo
	 */
	User getUserById(Long id);
}
