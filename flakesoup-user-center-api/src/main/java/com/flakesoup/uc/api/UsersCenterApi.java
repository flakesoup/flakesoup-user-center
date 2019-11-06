package com.flakesoup.uc.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(contextId = "usersCenterApi", value = "flakesoup-user-center")
public interface UsersCenterApi {

	/**
	 * 分页查询用户
	 *
	 * @param page    参数集
	 * @param userDto 查询参数列表
	 * @return 用户集合
	 */
	@GetMapping("/users/list")
	R<IPage<UserDto>> getPageUsers(Page page, UserDto userDto);

}
