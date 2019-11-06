package com.flakesoup.uc.impl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.entity.User;
import com.flakesoup.uc.api.vo.UserVo;

import java.util.List;


public interface UserService extends IService<User> {

	/**
	 * 分页查询用户信息（含有角色信息）
	 *
	 * @param page    分页对象
	 * @param userDto 参数列表
	 * @return
	 */
	IPage<UserVo> getPageUsers(Page page, UserDto userDto);
//
//	/**
//	 * 删除用户
//	 *
//	 * @param sysUser 用户
//	 * @return boolean
//	 */
//	Boolean removeUserById(SysUser sysUser);
//
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
	User getUserById(Long id);
//
//	/**
//	 * 查询上级部门的用户信息
//	 *
//	 * @param username 用户名
//	 * @return R
//	 */
//	List<SysUser> listAncestorUsersByUsername(String username);
//
	/**
	 * 创建用户
	 *
	 * @param userDto DTO 对象
	 * @return success/fail
	 */
	User createUser(UserDto userDto);
}
