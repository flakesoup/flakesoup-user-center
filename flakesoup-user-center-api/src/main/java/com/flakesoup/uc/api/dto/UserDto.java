package com.flakesoup.uc.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 手机
	 */
	private String mobile;

	/**
	 * 用户id
	 */
	private Integer status;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;

	/* ==========user profile============ */
	/**
	 * profile id
	 */
	private Long userProfileId;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 用户昵称
	 */
	private String nickname;

	/**
	 * 用户地址
	 */
	private String address;

	/**
	 * 用户邮箱
	 */
	private String email;

}
