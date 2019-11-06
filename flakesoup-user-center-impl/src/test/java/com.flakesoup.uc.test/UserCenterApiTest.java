package com.flakesoup.uc.test;


import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.feign.UserCenterApi;
import com.flakesoup.uc.api.vo.UserVo;
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
        R<UserVo> r = userCenterApi.getUserById(10L);
        System.out.println(r);
    }

    @Test
    public void testCreateUser(){
        UserDto userDto = new UserDto();
        userDto.setName("manson2");
        userDto.setMobile("13466730687");
        userDto.setPassword("333333");
        R<UserVo> r = userCenterApi.createUser(userDto);
        System.out.println(r);
    }

}
