package com.legend.cloud.controller;

import com.legend.module.core.model.contant.arribute.Key;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 * @date 2018/3/11
 */
@Controller
@RequestMapping("/")
public class DirectController extends CampusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectController.class);

    /**
     * 所有的页面的都通过这里跳转
     *
     * @param url url
     * @return url
     */
    @RequestMapping(value = "direct/{url}", method = RequestMethod.GET)
    public ModelAndView redirect(@PathVariable String url, ModelAndView modelAndView) {
        try {
            LOGGER.info("url:" + url);
            modelAndView.setViewName(url);
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("error");
            modelAndView.addObject(Key.MSG, "404");
            return modelAndView;
        }
    }

}
