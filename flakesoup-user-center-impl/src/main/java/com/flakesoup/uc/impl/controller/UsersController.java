package com.flakesoup.uc.impl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.feign.UsersCenterApi;
import com.flakesoup.uc.impl.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController implements UsersCenterApi {
	private final UserService userService;

	/**
	 * 分页查询用户
	 *
	 * @param page    参数集
	 * @param userDto 查询参数列表
	 * @return 用户集合
	 */
	@GetMapping("/list")
	public R<IPage<UserDto>> getPageUsers(Page page, com.flakesoup.uc.api.dto.UserDto userDto) {
		return R.ok(userService.getPageUsers(page, userDto));
	}

}
