package com.flakesoup.uc.impl.controller;

import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.feign.UserCenterApi;
import com.flakesoup.uc.impl.service.UserService;
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
	public R<UserDto> getUserById(@PathVariable Long id) {
		UserDto userVo = userService.getUserById(id);
		return R.ok(userVo);
	}

	/**
	 * 创建用户
	 *
	 * @param userDto
	 * @return 用户信息
	 */
	@PostMapping({"", "/"})
	public R<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto userVo = userService.createUser(userDto);
		return R.ok(userVo);
	}

	/**
	 * 用户登录
	 *
	 * @param userDto
	 * @return 用户信息
	 */
	@GetMapping("/check/pwd")
	public R<UserDto> checkUserPassword(@RequestBody UserDto userDto) {
		UserDto userVo = userService.checkUserPassword(userDto);
		return R.ok(userVo);
	}
}
