package com.legend.cloud.campus.model.pojo.entity.base;

import com.legend.module.core.model.pojo.entity.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * 用户
 *
 * @author hupeiD
 * @date 2018-04-12 10:38:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
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
    @Column(name = "nick_name")
    private String nickName;
    /**
     * 是否启用
     */
    @Column(name = "is_enabled")
    private Boolean isEnabled;
    /**
     * 状态（0、离线 1、在线）
     */
    private Integer status;
    /**
     * 最后登录时间
     */
    @Column(name = "last_login_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

}
