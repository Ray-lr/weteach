package com.legend.cloud.campus.model.pojo.vo.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.legend.cloud.campus.model.pojo.entity.base.BaseUser;
import com.legend.module.core.model.pojo.vo.user.UserVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Null;
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
public class BaseUserVO extends UserVO<BaseUser, BaseUserVO> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;
    /**
     * 昵称
     */
    @JSONField(serialize = false)
    @Null
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

}
