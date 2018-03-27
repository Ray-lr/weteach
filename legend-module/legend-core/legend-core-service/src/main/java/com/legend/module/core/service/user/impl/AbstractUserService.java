package com.legend.module.core.service.user.impl;

import com.legend.module.core.entity.user.User;
import com.legend.module.core.service.core.impl.AbstractLegendService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @date 2018/3/8
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public abstract class AbstractUserService<T extends User> extends AbstractLegendService<T> {

}