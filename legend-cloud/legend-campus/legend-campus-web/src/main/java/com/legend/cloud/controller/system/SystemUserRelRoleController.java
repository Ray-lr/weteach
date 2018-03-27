package com.legend.cloud.controller.system;


import com.legend.cloud.entity.system.SystemUserRelRole;
import com.legend.cloud.service.system.SystemUserRelRoleService;
import com.legend.cloud.vo.system.SystemUserRelRoleVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
import com.legend.module.core.web.controller.LegendController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/system/userRelRole")
public class SystemUserRelRoleController extends LegendController {

    @Resource
    private SystemUserRelRoleService systemUserRelRoleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("userRelRole:userRelRole:list")
    public Ajax list(SystemUserRelRoleVO systemUserRelRoleVO, Query query) {
        try {
            List<SystemUserRelRole> systemUserRelRoleList = systemUserRelRoleService.getList(systemUserRelRoleVO.parseTo(),
                    query);
            List<SystemUserRelRoleVO> systemUserRelRoleVOList = systemUserRelRoleList.stream().map((entity) ->
                    new SystemUserRelRoleVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils( systemUserRelRoleVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(systemUserRelRoleVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("userRelRole:userRelRole:details")
    public Ajax details(@PathVariable int id) {
        try {
            SystemUserRelRole systemUserRelRole =systemUserRelRoleService.getById(id);
                SystemUserRelRoleVO systemUserRelRoleVO = new SystemUserRelRoleVO().parseFrom(systemUserRelRole);
            return Ajax.success(systemUserRelRoleVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("userRelRole:userRelRole:add")
    public Ajax add(@Validated SystemUserRelRoleVO systemUserRelRoleVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int saveResult = systemUserRelRoleService.save(systemUserRelRoleVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("userRelRole:userRelRole:update")
    public Ajax update(@Validated SystemUserRelRoleVO systemUserRelRoleVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int updateResult = systemUserRelRoleService.updateById(systemUserRelRoleVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("userRelRole:userRelRole:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = systemUserRelRoleService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
