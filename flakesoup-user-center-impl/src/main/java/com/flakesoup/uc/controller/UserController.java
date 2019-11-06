package com.flakesoup.uc.controller;

import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
	private final UserService userService;

	/**
	 * 通过ID查询用户信息
	 *
	 * @param id ID
	 * @return 用户信息
	 */
	@GetMapping("/{id}")
	public R getUser(@PathVariable Long id) {
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
}
