package com.flakesoup.uc.test;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flakesoup.common.core.util.R;
import com.flakesoup.uc.api.dto.UserDto;
import com.flakesoup.uc.api.feign.UsersCenterApi;
import com.flakesoup.uc.api.vo.UserVo;
import com.flakesoup.uc.impl.FlakeSoupUserCenterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FlakeSoupUserCenterApplication.class)
public class UsersCenterApiTest {

    @Autowired
    private UsersCenterApi usersCenterApi;

    @Test
    public void testGetUsersPage(){
        Page page = new Page();
        page.setSize(50);
        ArrayList<OrderItem> orders = new ArrayList<>();
        orders.add(OrderItem.desc("id"));
        page.setOrders(orders);
//        page.setSize(5);
        UserDto userDto = new UserDto();
//        userDto.setName("manson");
//        userDto.setMobile("13466730687");
        R<IPage<UserVo>> r = usersCenterApi.getPageUsers(page, userDto);
        IPage<UserVo> data = r.getData();
        System.out.println(data.getCurrent());
        System.out.println(data.getPages());
        System.out.println(data.getTotal());
        System.out.println(data.getRecords());
    }
}
