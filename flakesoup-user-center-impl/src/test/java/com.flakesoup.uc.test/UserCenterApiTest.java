package com.flakesoup.uc.test;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.UserCenterApi;
import com.flakesoup.uc.impl.FlakeSoupUserCenterApplication;
import com.flakesoup.uc.impl.service.UserShardingService;
import com.flakesoup.uc.impl.service.UserProfileDistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FlakeSoupUserCenterApplication.class)
public class UserCenterApiTest {

    @Autowired
    private UserCenterApi userCenterApi;

    @Autowired
    private UserShardingService userShardingService;

    @Autowired
    private UserProfileDistService userProfileDistService;

    @Test
    public void testGetUserById(){
        R<UserDto> r = userCenterApi.getUserById(10L);
        System.out.println(r);
    }

    @Test
    public void testCreateUser(){
        UserDto userDto = new UserDto();
        userDto.setName("manson");
        userDto.setMobile("13466730687");
        userDto.setPassword("123456");
        R<UserDto> r = userCenterApi.createUser(userDto);
        System.out.println(r);
    }

    @Test
    public void testCheckUserPwd(){
        UserDto userDto = new UserDto();
        userDto.setId(28L);
        userDto.setPassword("123456");
        R<UserDto> r = userCenterApi.checkUserPassword(userDto);
        System.out.println(r);
    }

    /* sharding */

    @Test
    public void testgetUserShardingById(){
        UserDto r = userShardingService.getUserById(403578695215742977L);
        System.out.println(r);
    }

    @Test
    public void testgetUserShardingByIdWithProfile(){
        UserDto r = userShardingService.getUserByIdWithProfile(403578695215742977L);
        System.out.println(r);
    }

    @Test
    public void testgetPageUsersSharding(){
        Page page = new Page(0L, 10L);
        UserDto userDto = new UserDto();
        userDto.setMobile("13466730688");
        IPage<UserDto> r = userShardingService.getPageUsers(page, userDto);
        System.out.println(r.getRecords());
    }

    @Test
    public void testCreateDistUser(){
        UserDto userDto = new UserDto();
        userDto.setName("manson");
        userDto.setMobile("13466730687");
        userDto.setPassword("123456");
        UserDto r = userShardingService.createUser(userDto);
        System.out.println(r);
    }

    @Test
    public void testCreateDistUserProfile(){
        userProfileDistService.createDistUserProfile(403578695215742977L);
    }
}
