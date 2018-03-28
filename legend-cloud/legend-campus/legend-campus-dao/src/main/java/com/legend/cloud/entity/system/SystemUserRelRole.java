package com.legend.cloud.entity.system;

import com.legend.module.core.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 系统用户关联系统角色
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "system_user_rel_role")
public class SystemUserRelRole extends AbstractEntity<SystemUserRelRole> {
    private static final long serialVersionUID = 1L;

    /**
     * 关联id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 系统用户id
     */
    private Integer userId;
    /**
     * 系统角色id
     */
    private Integer roleId;
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
