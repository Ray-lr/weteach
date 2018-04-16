package com.legend.cloud.service.campus;

import com.legend.cloud.entity.campus.CampusUserInfo;
import com.legend.module.core.service.core.LegendService;

/**
 * @author Jim
 * @date 2018/3/8
 */
public interface CampusUserInfoService extends LegendService<CampusUserInfo> {
    /**
     * 更具用户id获得用户信息
     *
     * @param id 用户id
     * @return campusUserInfo
     */
    CampusUserInfo getByUserId(Integer id);

}