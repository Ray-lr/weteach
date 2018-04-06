package com.legend.cloud.controller.campus;


import com.alibaba.fastjson.JSON;
import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.base.BaseUser;
import com.legend.cloud.entity.campus.CampusUserInfo;
import com.legend.cloud.service.base.BaseAreasService;
import com.legend.cloud.service.base.BaseUserService;
import com.legend.cloud.service.campus.CampusUserInfoService;
import com.legend.cloud.vo.base.BaseUserVO;
import com.legend.cloud.vo.campus.CampusUserInfoVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.group.option.AddGroup;
import com.legend.module.core.model.group.option.UpdateGroup;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.utils.HttpSessionUtils;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/campus/userInfo")
public class CampusUserInfoController extends CampusController {

    @Resource
    private CampusUserInfoService campusUserInfoService;
    @Resource
    private BaseUserService baseUserService;
    @Resource
    private BaseAreasService baseAreasService;
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
            BaseUserVO b = JSON.parseObject((String) HttpSessionUtils.getAttribute("currentUser"), BaseUserVO.class);
            b.setNickName(campusUserInfoVO.getNickname());
            b.setPhone(campusUserInfoVO.getPhone());
            BaseUser baseUser = b.parseTo();
            int updateResult = baseUserService.updateById(baseUser);
            updateResult += campusUserInfoService.updateById(campusUserInfoVO.parseTo());
            return updateResult == 2 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{id}")
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
            CampusUserInfo cui = campusUserInfoService.get(campusUserInfo);
            return Ajax.success(cui);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }
}
