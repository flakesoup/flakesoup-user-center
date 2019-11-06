package com.flakesoup.uc.api.feign;

import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(contextId = "usersCenterApi", value = "flakesoup-user-center")
public interface UsersCenterApi {
	/**
	 * 通过id查询用户
	 *
	 * @param id 用户id
	 * @return R
	 */
	@GetMapping("/user/{id}")
	R<UserDto> getUserById(@PathVariable("id") Long id);
}
