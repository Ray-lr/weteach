package com.legend.cloud.vo.base;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.legend.cloud.entity.base.BaseUser;
import com.legend.module.core.vo.core.UserVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * 用户
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@JsonAutoDetect
public class BaseUserVO extends UserVO<BaseUser> {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @Override
    public BaseUser parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public BaseUserVO parseFrom(BaseUser baseUser, String... ignoreProperties) {
        return (BaseUserVO) super.parseFrom(baseUser, ignoreProperties);
    }
}
