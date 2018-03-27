package com.legend.module.core.web.controller;


import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.utils.HttpSessionUtils;
import com.legend.module.core.vo.core.UserVO;

/**
 * @author Administrator
 * @date 2018/3/8
 */
public class LegendController<TVO extends UserVO> {
    /**
     * 设置当前用户，存入session中
     *
     * @param tvo 当前用户
     */
    protected void setCurrentUser(TVO tvo) {
        HttpSessionUtils.setAttribute(Key.CURRENT_USER, tvo);
    }

    /**
     * 得到当前用户，从session中取值
     *
     * @return 当前用户
     */
    protected Object getCurrentUser() {
        return HttpSessionUtils.getAttribute(Key.CURRENT_USER);
    }

    /**
     * 从session中移除当前用户
     */
    protected void removeCurrentUser() {
        HttpSessionUtils.removeAttribute(Key.CURRENT_USER);
    }
}
