package com.legend.cloud.campus.web.controller;

import com.alibaba.fastjson.JSON;
import com.legend.module.core.model.contant.code.result.user.UserResultCode;
import com.legend.module.core.model.contant.message.result.user.UserResultMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.pojo.vo.user.UserVO;
import com.legend.module.core.web.controller.LegendController;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Administrator
 * @date 2018/3/30
 */
public class CampusController extends LegendController<UserVO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampusController.class);

    /**
     * 权限异常
     *
     * @param request  请求
     * @param response 应答
     * @return url
     */
    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info(UserResultMessage.PERMISSIONS_INSUFFICIENT);
        PrintWriter printWriter = null;
        try {
            String requestedWith = request.getHeader("x-requested-with");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            if (requestedWith != null && "XMLHttpRequest".equalsIgnoreCase(requestedWith)) {
                printWriter = response.getWriter();
                printWriter.write(JSON.toJSONString(Ajax.error(UserResultMessage.PERMISSIONS_INSUFFICIENT, UserResultCode.PERMISSIONS_INSUFFICIENT)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        return null;
    }

}
