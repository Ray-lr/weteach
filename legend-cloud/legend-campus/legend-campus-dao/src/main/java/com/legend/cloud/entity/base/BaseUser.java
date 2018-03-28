package com.legend.cloud.entity.base;

import com.legend.module.core.entity.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;



/**
 * 用户
 *
 * @author hupeiD
 * @date 2018-03-28 10:33:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_user")
public class BaseUser extends User<BaseUser> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 是否启用
     */
    private Boolean isEnabled;
    /**
     * 状态（0、离线 1、在线）
     */
    private Integer status;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Boolean isDeleted;

}
