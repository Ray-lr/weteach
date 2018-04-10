package com.legend.cloud.vo.campus.complex;

import com.legend.cloud.vo.base.BaseUserVO;
import com.legend.cloud.vo.campus.CampusUserInfoVO;
import lombok.Data;
import lombok.ToString;

/**
 * @author Administrator
 * @date 2018/4/10
 */
@Data
@ToString
public class CampusUserVO {

    /**
     * 用户信息
     */
    private BaseUserVO user;
    /**
     * 账户信息
     */
    private CampusUserInfoVO info;
}
