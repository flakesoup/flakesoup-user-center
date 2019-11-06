package com.flakesoup.uc.api.feign;

import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(contextId = "userCenterApi", value = "flakesoup-user-center")
public interface UserCenterApi {
	/**
	 * 通过用户名查询用户
	 *
	 * @param username 用户名
	 * @return R
	 */
	@GetMapping("/user/{username}")
	R<UserDto> info(@PathVariable("username") String username);
}
