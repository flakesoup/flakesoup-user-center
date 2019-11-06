package com.flakesoup.uc.api.feign;

import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(contextId = "userCenterApi", value = "flakesoup-user-center")
public interface UserCenterApi {
	/**
	 * 通过id查询用户
	 *
	 * @param id 用户id
	 * @return R
	 */
	@GetMapping("/user/{id}")
	R<UserDto> getUserById(@PathVariable("id") Long id);

	/**
	 * 创建用户
	 *
	 * @param userDto
	 * @return 用户信息
	 */
	@PostMapping("/user")
	R<UserDto> createUser(@RequestBody UserDto userDto);

	/**
	 * 用户登录
	 *
	 * @param userDto
	 * @return 用户信息
	 */
	@PostMapping("/user/check/pwd")
	R<UserDto> checkUserPassword(@RequestBody UserDto userDto);
}
