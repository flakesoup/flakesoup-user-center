package com.flakesoup.uc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.entity.User;
import com.flakesoup.uc.mapper.UserMapper;
import com.flakesoup.uc.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

	@Override
	public User getUserById(Long id) {
		return baseMapper.getUserById(id);
	}

	@Override
	public Boolean createUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setPassword(ENCODER.encode(userDto.getPassword()));
		baseMapper.insert(user);
		return true;
	}

	@Override
	public IPage getPageUsers(Page page, UserDto userDto) {
		return baseMapper.getPageUsers(page, userDto);
	}
}
