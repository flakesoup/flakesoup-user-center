package com.flakesoup.uc.impl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 */
@Data
@TableName("t_user")
public class UserSharding implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "id", type = IdType.AUTO)
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
	 * 密码
	 */
	private String password;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date updateTime;

	/**
	 * 用户status枚举
	 */
	public enum UserStatusEnum {

		USER_STATUS_NORMAL(0, "用户正常"),
		USER_STATUS_EXPIRED(1, "用户过期"),
		USER_STATUS_BLOCK(2, "用户停用");

		private Integer code;

		private String name;

		UserStatusEnum(Integer code, String name) {
			this.code = code;
			this.name = name;
		}

		public Integer getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

	}
}
