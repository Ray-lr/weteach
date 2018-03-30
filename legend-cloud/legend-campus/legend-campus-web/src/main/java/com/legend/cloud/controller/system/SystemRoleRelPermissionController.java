package com.legend.cloud.controller.system;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.system.SystemRoleRelPermission;
import com.legend.cloud.service.system.SystemRoleRelPermissionService;
import com.legend.cloud.vo.system.SystemRoleRelPermissionVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.utils.PageUtils;
import com.legend.module.core.utils.Query;
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
@RequestMapping("/system/roleRelPermission")
public class SystemRoleRelPermissionController extends CampusController {

    @Resource
    private SystemRoleRelPermissionService systemRoleRelPermissionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("roleRelPermission:roleRelPermission:list")
    public Ajax list(SystemRoleRelPermissionVO systemRoleRelPermissionVO, Query query) {
        try {
            List<SystemRoleRelPermission> systemRoleRelPermissionList = systemRoleRelPermissionService.getList(systemRoleRelPermissionVO.parseTo(),
                    query);
            List<SystemRoleRelPermissionVO> systemRoleRelPermissionVOList = systemRoleRelPermissionList.stream().map((entity) ->
                    new SystemRoleRelPermissionVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(systemRoleRelPermissionVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(systemRoleRelPermissionVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("roleRelPermission:roleRelPermission:details")
    public Ajax details(@PathVariable int id) {
        try {
            SystemRoleRelPermission systemRoleRelPermission = systemRoleRelPermissionService.getById(id);
            SystemRoleRelPermissionVO systemRoleRelPermissionVO = new SystemRoleRelPermissionVO().parseFrom(systemRoleRelPermission);
            return Ajax.success(systemRoleRelPermissionVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("roleRelPermission:roleRelPermission:add")
    public Ajax add(@Validated SystemRoleRelPermissionVO systemRoleRelPermissionVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int saveResult = systemRoleRelPermissionService.save(systemRoleRelPermissionVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("roleRelPermission:roleRelPermission:update")
    public Ajax update(@Validated SystemRoleRelPermissionVO systemRoleRelPermissionVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int updateResult = systemRoleRelPermissionService.updateById(systemRoleRelPermissionVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("roleRelPermission:roleRelPermission:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = systemRoleRelPermissionService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
