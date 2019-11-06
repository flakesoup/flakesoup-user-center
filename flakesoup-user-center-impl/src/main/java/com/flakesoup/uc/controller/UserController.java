package com.flakesoup.uc.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.feign.UserCenterApi;
import com.flakesoup.uc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController implements UserCenterApi {
	private final UserService userService;

	/**
	 * 通过ID查询用户信息
	 *
	 * @param id ID
	 * @return 用户信息
	 */
	@GetMapping("/{id}")
	public R getUserById(@PathVariable Long id) {
		return R.ok(userService.getUserById(id));
	}

	/**
	 * 创建用户
	 *
	 * @param userDto
	 * @return 用户信息
	 */
	@PostMapping("/")
	public R createUser(@RequestBody UserDto userDto) {
		return R.ok(userService.createUser(userDto));
	}

	/**
	 * 分页查询用户
	 *
	 * @param page    参数集
	 * @param userDto 查询参数列表
	 * @return 用户集合
	 */
	@GetMapping("/page")
	public R getUserPage(Page page, UserDto userDto) {
		return R.ok(userService.getPageUsers(page, userDto));
	}

}
