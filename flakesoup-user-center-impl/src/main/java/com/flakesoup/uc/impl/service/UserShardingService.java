package com.flakesoup.uc.impl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.impl.entity.UserSharding;
import org.apache.ibatis.annotations.Param;


public interface UserShardingService extends IService<UserSharding> {
	/**
	 * 创建分库分表用户
	 *
	 * @param userDto DTO 对象
	 * @return 用户信息
	 */
	UserDto createUser(UserDto userDto);

	/**
	 * 通过id查询用户信息
	 *
	 * @param id 用户通过id查询用户信息
	 * @return UserDto
	 */
	UserDto getUserById(Long id);

	/**
	 * 通过id查询用户详细信息
	 *
	 * @param id 用户通过id查询用户详细信息
	 * @return UserAggregate
	 */
	UserDto getUserByIdWithProfile(Long id);

	/**
	 * 分页查询用户信息（含有角色信息）
	 *
	 * @param page    分页对象
	 * @param userDto 参数列表
	 * @return
	 */
	IPage<UserDto> getPageUsers(Page page, @Param("query") UserDto userDto);
}
