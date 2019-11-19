package com.flakesoup.uc.impl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.impl.entity.User;
import com.flakesoup.uc.impl.entity.UserDist;
import com.flakesoup.uc.impl.mapper.UserDistMapper;
import com.flakesoup.uc.impl.service.UserDistService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class UserDistServiceImpl extends ServiceImpl<UserDistMapper, UserDist> implements UserDistService {
	private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

	@Override
	public UserDto createDistUser(UserDto userDto) {
		UserDist user = new UserDist();
		BeanUtils.copyProperties(userDto, user);
		user.setPassword(ENCODER.encode(userDto.getPassword()));
		baseMapper.insert(user);
		return convertUserToVo(user);
	}

	private UserDto convertUserToVo(UserDist user) {
		UserDto userVo = new UserDto();
		if (user != null) {
			BeanUtils.copyProperties(user, userVo);
		}
		return userVo;
	}
}
