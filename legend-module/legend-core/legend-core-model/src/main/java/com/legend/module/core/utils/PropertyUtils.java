package com.legend.module.core.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Administrator
 * @date 2018/1/16
 */
public class PropertyUtils extends  Properties{

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("config/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String get(String key) {
        properties.getProperty(key);
        return null;
    }

}
