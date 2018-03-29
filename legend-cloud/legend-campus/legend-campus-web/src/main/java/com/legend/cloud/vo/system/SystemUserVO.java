package com.legend.cloud.vo.system;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.legend.cloud.entity.system.SystemUser;
import com.legend.module.core.vo.core.UserVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * 系统用户
 *
 * @author hupeiD
 * @date 2018-03-26 22:25:07
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@JsonAutoDetect
public class SystemUserVO extends UserVO<SystemUser> {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @Override
    public SystemUser parseTo(String... ignoreProperties) {
        return super.parseTo(ignoreProperties);
    }

    @Override
    public SystemUserVO parseFrom(SystemUser systemUser, String... ignoreProperties) {
        return (SystemUserVO) super.parseFrom(systemUser, ignoreProperties);
    }
}
