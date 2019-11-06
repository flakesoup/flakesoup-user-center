package com.flakesoup.uc.controller;

import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.entity.User;
import com.flakesoup.uc.api.feign.UserCenterApi;
import com.flakesoup.uc.api.vo.UserVo;
import com.flakesoup.uc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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
	public R<UserVo> getUserById(@PathVariable Long id) {
		User user = userService.getUserById(id);
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(user, userVo);
		return R.ok(userVo);
	}

	/**
	 * 创建用户
	 *
	 * @param userDto
	 * @return 用户信息
	 */
	@PostMapping({"", "/"})
	public R<UserVo> createUser(@RequestBody UserDto userDto) {
		User user = userService.createUser(userDto);
		System.out.println(user);
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(user, userVo);
		return R.ok(userVo);
	}

}
