package com.flakesoup.uc.impl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.impl.entity.UserProfileSharding;
import com.flakesoup.uc.impl.mapper.UserProfileDistMapper;
import com.flakesoup.uc.impl.service.UserProfileDistService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class UserProfileDistServiceImpl extends ServiceImpl<UserProfileDistMapper, UserProfileSharding> implements UserProfileDistService {

	@Override
	public UserDto createDistUserProfile(Long userId) {
		UserProfileSharding user = new UserProfileSharding();
		user.setUserId(userId);
		baseMapper.insert(user);
		return null;
	}
}
