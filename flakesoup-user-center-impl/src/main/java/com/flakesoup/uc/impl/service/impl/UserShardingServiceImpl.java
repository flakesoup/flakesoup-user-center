package com.flakesoup.uc.impl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.impl.entity.User;
import com.flakesoup.uc.impl.entity.UserAggregate;
import com.flakesoup.uc.impl.entity.UserSharding;
import com.flakesoup.uc.impl.mapper.UserShardingMapper;
import com.flakesoup.uc.impl.service.UserShardingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class UserShardingServiceImpl extends ServiceImpl<UserShardingMapper, UserSharding> implements UserShardingService {
	private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

	@Override
	public IPage<UserDto> getPageUsers(Page page, UserDto userDto) {
//		List<UserSharding> users = super.list();
//		System.out.println(users);
//		return null;
		IPage<User> users = baseMapper.getPageUsers(page, userDto);
		return convertListUserToVo(users);
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		UserSharding user = new UserSharding();
		BeanUtils.copyProperties(userDto, user);
		user.setPassword(ENCODER.encode(userDto.getPassword()));
		baseMapper.insert(user);
		return convertUserToVo(user);
	}

	@Override
	public UserDto getUserById(Long id) {
		UserSharding user = super.getById(id);
		return convertUserToVo(user);
	}

	@Override
	public UserDto getUserByIdWithProfile(Long id) {
		UserAggregate userAggregate = baseMapper.getUserByIdWithProfile(id);
		UserDto userDto = new UserDto();
		if (userAggregate != null) {
			BeanUtils.copyProperties(userAggregate, userDto);
		}
		return userDto;
	}

	private UserDto convertUserToVo(UserSharding user) {
		UserDto userDto = new UserDto();
		if (user != null) {
			BeanUtils.copyProperties(user, userDto);
		}
		return userDto;
	}

	private IPage<UserDto> convertListUserToVo(IPage<User> users) {
		IPage<UserDto> userDtos = new Page<>();
		BeanUtils.copyProperties(users, userDtos);
		return userDtos;
	}
}
