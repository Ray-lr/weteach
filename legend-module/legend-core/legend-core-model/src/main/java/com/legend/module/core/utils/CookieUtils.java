package com.legend.module.core.utils;

import javax.servlet.http.Cookie;

/**
 * @author Administrator
 * @date 2018/1/9
 */
public class CookieUtils {

    public static void setCookie(String s,String o){
        Cookie cookie = new Cookie(s,o);
    }

    public static Cookie getCookie(String s){

        return null;
    }
}
