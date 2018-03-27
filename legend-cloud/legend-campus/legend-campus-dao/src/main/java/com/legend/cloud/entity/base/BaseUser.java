package com.legend.cloud.entity.base;

import com.legend.module.core.entity.AbstractEntity;
import com.legend.module.core.entity.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;


/**
 * 用户
 *
 * @author hupeiD
 * @date 2018-03-26 22:19:04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "base_user")
public class BaseUser extends User<BaseUser> {
    private static final long serialVersionUID = 1L;
    /**
     * 状态（0、离线 1、在线）
     */
    private Integer status;

}
