package com.flakesoup.uc.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {
	private final UserService userService;

	/**
	 * 分页查询用户
	 *
	 * @param page    参数集
	 * @param userDto 查询参数列表
	 * @return 用户集合
	 */
	@GetMapping("/")
	public R getPageUsers(Page page, UserDto userDto) {
		return R.ok(userService.getPageUsers(page, userDto));
	}

}
