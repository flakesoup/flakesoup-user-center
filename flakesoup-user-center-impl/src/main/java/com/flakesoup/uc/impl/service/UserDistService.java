package com.flakesoup.uc.impl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.impl.entity.UserDist;


public interface UserDistService extends IService<UserDist> {
	/**
	 * 创建分库分表用户
	 *
	 * @param userDto DTO 对象
	 * @return 用户信息
	 */
	UserDto createDistUser(UserDto userDto);
}
