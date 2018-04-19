package com.legend.cloud.campus.web.controller.system;


import com.legend.cloud.campus.model.pojo.entity.system.SystemUserRelRole;
import com.legend.cloud.campus.model.pojo.vo.system.SystemUserRelRoleVO;
import com.legend.cloud.campus.service.system.SystemUserRelRoleService;
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

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/system/userRelRole")
public class SystemUserRelRoleController extends CampusController {

    @Resource
    private SystemUserRelRoleService systemUserRelRoleService;

    @GetMapping("/list")
    // @RequiresPermissions("userRelRole:userRelRole:list")
    public Ajax list(SystemUserRelRoleVO systemUserRelRoleVO, QueryUtils query) {
        try {
            List<SystemUserRelRole> systemUserRelRoleList = systemUserRelRoleService.getList(systemUserRelRoleVO.parseTo(),
                    query);
            List<SystemUserRelRoleVO> systemUserRelRoleVOList = new SystemUserRelRoleVO().parseFrom(systemUserRelRoleList);
            PageUtils pageUtils = new PageUtils(systemUserRelRoleVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(systemUserRelRoleVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("userRelRole:userRelRole:details")
    public Ajax details(@PathVariable int id) {
        try {
            SystemUserRelRole systemUserRelRole = systemUserRelRoleService.getById(id);
            SystemUserRelRoleVO systemUserRelRoleVO = new SystemUserRelRoleVO().parseFrom(systemUserRelRole);
            return Ajax.success(systemUserRelRoleVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("userRelRole:userRelRole:add")
    public Ajax add(@Validated(AddGroup.class) SystemUserRelRoleVO systemUserRelRoleVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = systemUserRelRoleService.save(systemUserRelRoleVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("userRelRole:userRelRole:update")
    public Ajax update(@Validated(UpdateGroup.class) SystemUserRelRoleVO systemUserRelRoleVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = systemUserRelRoleService.updateById(systemUserRelRoleVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
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
