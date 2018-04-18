package com.legend.cloud.campus.model.pojo.vo.base;

import com.legend.cloud.campus.model.pojo.entity.base.BaseUserRelRole;
import com.legend.module.core.model.pojo.vo.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 用户角色关联
 *
 * @author hupeiD
 * @date 2018-03-27 21:30:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BaseUserRelRoleVO extends AbstractVO<BaseUserRelRole> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户角色关联id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer baseUserId;
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
    public BaseUserRelRoleVO parseFrom(BaseUserRelRole baseUserRelRole, String... ignoreProperties) {
        return (BaseUserRelRoleVO) super.parseFrom(baseUserRelRole, ignoreProperties);
    }

}
