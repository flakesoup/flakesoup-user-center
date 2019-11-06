package com.flakesoup.uc.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.entity.User;
import com.flakesoup.uc.api.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

	/**
	 * 分页查询用户
	 *
	 * @param page    分页
	 * @param userDto 查询参数
	 * @return list
	 */
	IPage<User> getPageUsers(Page page, @Param("query") UserDto userDto);
//	IPage<UserVo> getPageUsers(Page page, @Param("query") UserDto userDto);
}
