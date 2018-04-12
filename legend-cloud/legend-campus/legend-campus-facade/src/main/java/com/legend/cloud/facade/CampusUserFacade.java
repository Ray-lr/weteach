package com.legend.cloud.facade;

import com.legend.cloud.entity.base.BaseUser;
import com.legend.cloud.entity.campus.CampusUserInfo;

/**
 * @author Administrator
 * @date 2018/4/11
 */
public interface CampusUserFacade {

    /**
     * 同时更新BaseUser和CampusUserInfo的信息
     *
     * @param baseUser       baseuser
     * @param campusUserInfo campusUserInfo
     * @return 更新结果
     */
    int updateUser(BaseUser baseUser, CampusUserInfo campusUserInfo);
}
