package com.legend.cloud.controller;

import com.legend.module.core.web.controller.LegendController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Administrator
 * @date 2018/3/11
 */
@Controller
@RequestMapping("/")
public class DirectController extends LegendController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectController.class);

    @RequestMapping(value = "direct/{url}", method = RequestMethod.GET)
    public String redirect(@PathVariable String url) {
        try {
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

}
