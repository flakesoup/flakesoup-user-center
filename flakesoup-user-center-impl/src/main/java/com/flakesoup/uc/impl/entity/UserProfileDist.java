package com.flakesoup.uc.impl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户信息表
 * </p>
 */
@Data
@TableName("t_user_profile")
public class UserProfileDist implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 用户id
	 */
	private Long userId;

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

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;
}
