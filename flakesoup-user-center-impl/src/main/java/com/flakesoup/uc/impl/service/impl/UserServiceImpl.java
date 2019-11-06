package com.flakesoup.uc.impl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.entity.User;
import com.flakesoup.uc.api.vo.UserVo;
import com.flakesoup.uc.impl.mapper.UserMapper;
import com.flakesoup.uc.impl.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

	@Override
	public UserVo getUserById(Long id) {
		User user = baseMapper.getUserById(id);
		return convertUserToVo(user);
	}

	@Override
	public UserVo createUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		user.setPassword(ENCODER.encode(userDto.getPassword()));
		baseMapper.insert(user);
		return convertUserToVo(user);
	}

	@Override
	public IPage<UserVo> getPageUsers(Page page, UserDto userDto) {
		IPage<User> users = baseMapper.getPageUsers(page, userDto);
		return convertListUserToVo(users);
	}

	@Override
	public UserVo checkUserPassword(UserDto userDto) {
		User user = baseMapper.getUserById(userDto.getId());
		if (user != null) {
			boolean res = ENCODER.matches(userDto.getPassword(), user.getPassword());
			if (res) {
				return convertUserToVo(user);
			}
		}
		return null;
	}

	private UserVo convertUserToVo(User user) {
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(user, userVo);
		return userVo;
	}

	private IPage<UserVo> convertListUserToVo(IPage<User> users) {
		IPage<UserVo> userVos = new Page<>();
		BeanUtils.copyProperties(users, userVos);
		return userVos;
	}
}
