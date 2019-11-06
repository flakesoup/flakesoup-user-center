package com.flakesoup.uc;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringCloudApplication
public class FlakeSoupUserCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlakeSoupUserCenterApplication.class, args);
	}

}
