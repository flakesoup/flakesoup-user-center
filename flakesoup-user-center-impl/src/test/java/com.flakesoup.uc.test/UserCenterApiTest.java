package com.flakesoup.uc.test;


import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.feign.UserCenterApi;
import com.flakesoup.uc.impl.FlakeSoupUserCenterApplication;
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

    @Test
    public void testGetUserById(){
        R<UserDto> r = userCenterApi.getUserById(10L);
        System.out.println(r);
    }

    @Test
    public void testCreateUser(){
        com.flakesoup.uc.api.dto.UserDto userDto = new com.flakesoup.uc.api.dto.UserDto();
        userDto.setName("manson");
        userDto.setMobile("13466730687");
        userDto.setPassword("123456");
        R<UserDto> r = userCenterApi.createUser(userDto);
        System.out.println(r);
    }

    @Test
    public void testCheckUserPwd(){
        com.flakesoup.uc.api.dto.UserDto userDto = new com.flakesoup.uc.api.dto.UserDto();
        userDto.setId(28L);
        userDto.setPassword("123456");
        R<UserDto> r = userCenterApi.checkUserPassword(userDto);
        System.out.println(r);
    }
}
