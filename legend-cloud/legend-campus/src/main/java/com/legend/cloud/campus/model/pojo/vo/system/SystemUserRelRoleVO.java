package com.legend.cloud.campus.model.pojo.vo.system;

import com.legend.cloud.campus.model.pojo.entity.system.SystemUserRelRole;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 系统用户关联系统角色
 *
 * @author hupeiD
 * @date 2018-03-28 10:17:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class SystemUserRelRoleVO extends AbstractVO<SystemUserRelRole> {
    private static final long serialVersionUID = 1L;

    /**
     * 关联id
     */
    private Integer id;
    /**
     * 系统用户id
     */
    private Integer systemUserId;
    /**
     * 系统角色id
     */
    private Integer systemRoleId;
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

    @Override
    public SystemUserRelRoleVO parseFrom(SystemUserRelRole systemUserRelRole, String... ignoreProperties) {
        return (SystemUserRelRoleVO) super.parseFrom(systemUserRelRole, ignoreProperties);
    }

}
