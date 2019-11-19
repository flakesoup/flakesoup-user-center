package com.flakesoup.uc.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.impl.entity.User;
import com.flakesoup.uc.impl.entity.UserDist;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 */
public interface UserDistMapper extends BaseMapper<UserDist> {
}
