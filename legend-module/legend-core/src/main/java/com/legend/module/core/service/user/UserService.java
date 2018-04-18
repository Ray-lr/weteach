package com.legend.module.core.service.user;


import com.legend.module.core.model.pojo.entity.user.User;
import com.legend.module.core.service.core.LegendService;

/**
 * @author Administrator
 * @date 2018/3/8
 */
public interface UserService<T extends User> extends LegendService<T> {
    /**
     * 根据手机号查询
     *
     * @param phone 手机号
     * @return t
     */
    T getByPhone(String phone);

    /**
     * 根据用户名查询
     *
     * @param username 用户名
     * @return t
     */
    T getByUserName(String username);

    /**
     * 根据用户名和密码查询
     *
     * @param username 用户名
     * @param password 密码
     * @return t
     */
    T getByUsernameAndPassword(String username, String password);
}
