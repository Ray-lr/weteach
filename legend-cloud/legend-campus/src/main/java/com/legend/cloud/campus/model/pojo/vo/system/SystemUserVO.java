package com.legend.cloud.campus.model.pojo.vo.system;

import com.alibaba.fastjson.annotation.JSONField;
import com.legend.cloud.campus.model.pojo.entity.system.SystemUser;
import com.legend.module.core.model.pojo.vo.user.UserVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 系统用户
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class SystemUserVO extends UserVO<SystemUser> {
    @JSONField(serialize = false)
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 用户类型
     */
    private String typeUser;
    /**
     * 记住我
     */
    @JSONField(serialize = false)
    private Boolean rememberMe;
    /**
     * 最后登录时间
     */
    @JSONField(serialize = false)
    private Date lastLoginTime;

    /**
     * 状态（0、离线 1、在线）
     */
    @JSONField(serialize = false)
    private Integer status;
    /**
     * 是否启用
     */
    @JSONField(serialize = false)
    private Boolean isEnabled;
    /**
     * 创建时间
     */
    @JSONField(serialize = false)
    private Date createTime;
    /**
     * 更新时间
     */
    @JSONField(serialize = false)
    private Date updateTime;
    /**
     * 是否删除
     */
    @JSONField(serialize = false)
    private Boolean isDeleted;

    @Override
    public SystemUserVO parseFrom(SystemUser systemUser, String... ignoreProperties) {
        return (SystemUserVO) super.parseFrom(systemUser, ignoreProperties);
    }
}
