package com.legend.cloud.controller.system;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.system.SystemPermission;
import com.legend.cloud.service.system.SystemPermissionService;
import com.legend.cloud.vo.system.SystemPermissionVO;
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
@RequestMapping("/system/permission")
public class SystemPermissionController extends CampusController {

    @Resource
    private SystemPermissionService systemPermissionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("permission:permission:list")
    public Ajax list(SystemPermissionVO systemPermissionVO, Query query) {
        try {
            List<SystemPermission> systemPermissionList = systemPermissionService.getList(systemPermissionVO.parseTo(),
                    query);
            List<SystemPermissionVO> systemPermissionVOList = systemPermissionList.stream().map((entity) ->
                    new SystemPermissionVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(systemPermissionVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(systemPermissionVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("permission:permission:details")
    public Ajax details(@PathVariable int id) {
        try {
            SystemPermission systemPermission = systemPermissionService.getById(id);
            SystemPermissionVO systemPermissionVO = new SystemPermissionVO().parseFrom(systemPermission);
            return Ajax.success(systemPermissionVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("permission:permission:add")
    public Ajax add(@Validated SystemPermissionVO systemPermissionVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int saveResult = systemPermissionService.save(systemPermissionVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("permission:permission:update")
    public Ajax update(@Validated SystemPermissionVO systemPermissionVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int updateResult = systemPermissionService.updateById(systemPermissionVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("permission:permission:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = systemPermissionService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
