package com.flakesoup.uc.impl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.impl.entity.User;


public interface UserService extends IService<User> {

	/**
	 * 分页查询用户信息（含有角色信息）
	 *
	 * @param page    分页对象
	 * @param userDto 参数列表
	 * @return
	 */
	IPage<UserDto> getPageUsers(Page page, UserDto userDto);

//	/**
//	 * 更新当前用户基本信息
//	 *
//	 * @param userDto 用户信息
//	 * @return Boolean
//	 */
//	R<Boolean> updateUserInfo(UserDTO userDto);
//
//	/**
//	 * 更新指定用户信息
//	 *
//	 * @param userDto 用户信息
//	 * @return
//	 */
//	Boolean updateUser(UserDTO userDto);
//
	/**
	 * 通过ID查询用户信息
	 *
	 * @param id 用户ID
	 * @return 用户信息
	 */
	UserDto getUserById(Long id);

	/**
	 * 创建用户
	 *
	 * @param userDto DTO 对象
	 * @return 用户信息
	 */
	UserDto createUser(UserDto userDto);

	/**
	 * 验证用户密码用户
	 *
	 * @param userDto DTO 对象
	 * @return 用户信息
	 */
	UserDto checkUserPassword(UserDto userDto);
}
