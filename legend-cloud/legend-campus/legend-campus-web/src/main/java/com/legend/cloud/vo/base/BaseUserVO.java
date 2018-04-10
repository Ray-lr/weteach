package com.legend.cloud.vo.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.legend.cloud.entity.base.BaseUser;
import com.legend.module.core.vo.core.UserVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;


/**
 * 用户
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class BaseUserVO extends UserVO<BaseUser> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
    /**
     * 昵称
     */
    @JSONField(serialize = false)
    private String nickName;
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
    public BaseUser parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseUserVO parseFrom(BaseUser baseUser, String... ignoreProperties) {
        return (BaseUserVO) super.parseFrom(baseUser, ignoreProperties);
    }
}
