package com.legend.cloud.campus.service.campus;


import com.legend.cloud.campus.model.pojo.entity.campus.CampusAccount;
import com.legend.module.core.service.core.LegendService;

/**
 * @author hupeiD
 * @date 2018-04-18 22:41:20
 */
public interface CampusAccountService extends LegendService<CampusAccount> {

    /**
     * 更具用户id获得用户信息
     *
     * @param id 用户id
     * @return campusUserInfo
     */
    CampusAccount getByUserId(Integer id);
}