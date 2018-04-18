package com.legend.cloud.campus.web.controller.system;


import com.legend.cloud.campus.model.pojo.entity.system.SystemRoleRelPermission;
import com.legend.cloud.campus.model.pojo.vo.system.SystemRoleRelPermissionVO;
import com.legend.cloud.campus.service.system.SystemRoleRelPermissionService;
import com.legend.cloud.campus.web.controller.CampusController;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.group.option.AddGroup;
import com.legend.module.core.model.group.option.UpdateGroup;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import com.legend.module.core.model.utils.PageUtils;
import com.legend.module.core.model.utils.QueryUtils;
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
@RequestMapping("/system/roleRelPermission")
public class SystemRoleRelPermissionController extends CampusController {

    @Resource
    private SystemRoleRelPermissionService systemRoleRelPermissionService;

    @GetMapping("/list")
    // @RequiresPermissions("roleRelPermission:roleRelPermission:list")
    public Ajax list(SystemRoleRelPermissionVO systemRoleRelPermissionVO, QueryUtils query) {
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

    @GetMapping("/details/{id}")
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


    @PostMapping("/add")
    // @RequiresPermissions("roleRelPermission:roleRelPermission:add")
    public Ajax add(@Validated(AddGroup.class) SystemRoleRelPermissionVO systemRoleRelPermissionVO, BindingResult
            bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = systemRoleRelPermissionService.save(systemRoleRelPermissionVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("roleRelPermission:roleRelPermission:update")
    public Ajax update(@Validated(UpdateGroup.class) SystemRoleRelPermissionVO systemRoleRelPermissionVO, BindingResult
            bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = systemRoleRelPermissionService.updateById(systemRoleRelPermissionVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
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
