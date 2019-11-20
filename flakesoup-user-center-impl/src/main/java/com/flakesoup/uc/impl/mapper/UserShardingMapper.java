package com.flakesoup.uc.impl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.impl.entity.User;
import com.flakesoup.uc.impl.entity.UserAggregate;
import com.flakesoup.uc.impl.entity.UserSharding;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 */
public interface UserShardingMapper extends BaseMapper<UserSharding> {
    /**
     * 通过id查询用户信息
     *
     * @param id 用户通过id查询用户信息
     * @return User
     */
    User getUserById(Long id);

    /**
     * 通过id查询用户详细信息
     *
     * @param id 用户通过id查询用户详细信息
     * @return UserAggregate
     */
    UserAggregate getUserByIdWithProfile(Long id);

    /**
     * 分页查询用户
     *
     * @param page    分页
     * @param userDto 查询参数
     * @return list
     */
    IPage<User> getPageUsers(Page page, @Param("query") UserDto userDto);
}
