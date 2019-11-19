package com.flakesoup.uc.impl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.impl.entity.UserDist;
import com.flakesoup.uc.impl.entity.UserProfileDist;
import com.flakesoup.uc.impl.mapper.UserDistMapper;
import com.flakesoup.uc.impl.mapper.UserProfileDistMapper;
import com.flakesoup.uc.impl.service.UserDistService;
import com.flakesoup.uc.impl.service.UserProfileDistService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class UserProfileDistServiceImpl extends ServiceImpl<UserProfileDistMapper, UserProfileDist> implements UserProfileDistService {

	@Override
	public UserDto createDistUserProfile(Long userId) {
		UserProfileDist user = new UserProfileDist();
		user.setUserId(userId);
		baseMapper.insert(user);
		return null;
	}
}
