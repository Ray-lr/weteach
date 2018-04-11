package com.legend.cloud.controller.campus;


import com.alibaba.fastjson.JSON;
import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.base.BaseUser;
import com.legend.cloud.entity.campus.CampusUserInfo;
import com.legend.cloud.service.base.BaseUserService;
import com.legend.cloud.service.campus.CampusUserInfoService;
import com.legend.cloud.vo.campus.CampusUserInfoVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.group.option.AddGroup;
import com.legend.module.core.model.group.option.UpdateGroup;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/campus/userInfo")
public class CampusUserInfoController extends CampusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampusUserInfoController.class);

    @Resource
    private CampusUserInfoService campusUserInfoService;

    @Resource
    private BaseUserService baseUserService;

    @GetMapping("/list")
    // @RequiresPermissions("campus:userInfo:list")
    public Ajax list(CampusUserInfoVO campusUserInfoVO, Query query) {
        try {
            List<CampusUserInfo> campusUserInfoList = campusUserInfoService.getList(campusUserInfoVO.parseTo(),
                    query);
            List<CampusUserInfoVO> campusUserInfoVOList = campusUserInfoList.stream().map((entity) ->
                    new CampusUserInfoVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusUserInfoVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusUserInfoVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("campus:userInfo:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusUserInfo campusUserInfo = campusUserInfoService.getById(id);
            CampusUserInfoVO campusUserInfoVO = new CampusUserInfoVO().parseFrom(campusUserInfo);
            return Ajax.success(campusUserInfoVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("campus:userInfo:add")
    public Ajax add(@Validated(AddGroup.class) CampusUserInfoVO campusUserInfoVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = campusUserInfoService.save(campusUserInfoVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("campus:userInfo:update")
    public Ajax update(@Validated(UpdateGroup.class) CampusUserInfoVO campusUserInfoVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            CampusUserInfoVO currentUser = JSON.parseObject(String.valueOf(getCurrentUser()), CampusUserInfoVO.class);
            campusUserInfoVO.setId(currentUser.getId());
            campusUserInfoVO.setUpdateTime(new Date());
            if (campusUserInfoService.updateById(campusUserInfoVO.parseTo()) <= 0) {
                Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode.UPDATE_FAILURE);
            }
            // 重新查询并设置进session中
            BaseUser baseUser = baseUserService.getById(currentUser.getBaseUserId());
            CampusUserInfo campusUserInfo = campusUserInfoService.getById(currentUser.getId());
            currentUser.parseFrom(campusUserInfo);
            currentUser.setUsername(baseUser.getUsername());
            setCurrentUser(JSON.toJSONString(currentUser));
            LOGGER.info(String.valueOf(getCurrentUser()));
            return Ajax.success(AjaxMessage.UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("campus:userInfo:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusUserInfoService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/detail/{userId}")
    public Ajax get(@PathVariable Integer userId) {
        try {
            CampusUserInfo campusUserInfo = new CampusUserInfo();
            campusUserInfo.setBaseUserId(userId);
            campusUserInfo = campusUserInfoService.get(campusUserInfo);
            return Ajax.success(new CampusUserInfoVO().parseFrom(campusUserInfo));
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }
}
