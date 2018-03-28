package com.legend.cloud.config;

import com.legend.cloud.realm.ShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/3/24
 */
@Configuration
public class ShiroConfig {
    /**
     * shiro拦截器
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如不设置默认寻找的是login.jsp而非login.ftl
        shiroFilterFactoryBean.setLoginUrl("/direct/login");
        shiroFilterFactoryBean.setSuccessUrl("/direct/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/direct/login");
        // 需要拦截的url处理
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 不用验证的url
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/system/user/login", "anon");
        filterChainDefinitionMap.put("/base/user/login", "anon");
        // 登出的url，具体方法，shiro已经实现
        filterChainDefinitionMap.put("/logout", "logout");
        // 剩下的所有url都需要经过验证才可以访问
        filterChainDefinitionMap.put("/*", "authc");
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/*.*", "authc");
        // 将配置好的拦截url赋给ShiroFilterFactoryBean
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 开启shiro的注解
     *
     * @return authorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new
                AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(getSecurityManager());
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * shiro的安全管理器
     *
     * @return securityManager
     */
    @Bean
    public SecurityManager getSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getShiroRealm());
        securityManager.setRememberMeManager(getCookieRememberMeManager());
        return securityManager;
    }

    /**
     * 自定义拦截器
     *
     * @return shiroRealm
     */
    @Bean
    public ShiroRealm getShiroRealm() {
        return new ShiroRealm();
    }

    /**
     * 记住我
     *
     * @return cookieRememberMeManager
     */
    @Bean
    public CookieRememberMeManager getCookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(getRememberMeCookie());
        return cookieRememberMeManager;
    }

    /**
     * cookie
     *
     * @return simpleCookie
     */
    @Bean
    public SimpleCookie getRememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(86400);
        return simpleCookie;
    }

    /**
     * shiro生命周期处理器
     *
     * @return lifecycleBeanPostProcessor
     */
    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


}
