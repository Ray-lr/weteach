package com.legend.cloud.campus.web.config;

import com.legend.cloud.campus.web.realm.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
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
     * @param securityManager 安全管理器
     * @return shiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如不设置默认寻找的是login.jsp而非login.ftl
        shiroFilterFactoryBean.setLoginUrl("/direct/login");
        shiroFilterFactoryBean.setSuccessUrl("/direct/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/direct/login");
        // 需要拦截的url处理
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 不用验证的url
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/**/login", "anon");
        // 登出的url，具体方法，shiro已经实现
        filterChainDefinitionMap.put("/**/logout", "logout");
        // 剩下的所有url都需要经过验证才可以访问
        filterChainDefinitionMap.put("/**", "authc");
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
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(HashedCredentialsMatcher hashedCredentialsMatcher) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new
                AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager(hashedCredentialsMatcher));
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * shiro的安全管理器
     *
     * @param hashedCredentialsMatcher 密码凭证管理器
     * @return securityManager
     */
    @Bean
    public SecurityManager securityManager(HashedCredentialsMatcher hashedCredentialsMatcher) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm(hashedCredentialsMatcher));
        securityManager.setRememberMeManager(cookieRememberMeManager());
        return securityManager;
    }

    /***
     * 密码匹配凭证管理器
     * @return hashedCredentialsMatcher
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 采用MD5方式加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        // 设置加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * 自定义拦截器
     *
     * @return shiroRealm
     */
    @Bean
    public ShiroRealm shiroRealm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return shiroRealm;
    }

    /**
     * 记住我
     *
     * @return cookieRememberMeManager
     */
    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(cookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("LEGEND-CAMPUS-CIPHERKEY=="));
        return cookieRememberMeManager;
    }

    /**
     * cookie
     *
     * @return simpleCookie
     */
    @Bean
    public SimpleCookie cookie() {
        SimpleCookie simpleCookie = new SimpleCookie("RM");
        simpleCookie.setMaxAge(86400);
        return simpleCookie;
    }

    /**
     * shiro生命周期处理器
     *
     * @return lifecycleBeanPostProcessor
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


}
