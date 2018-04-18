package com.legend.cloud.campus.web.controller.system;


import com.legend.cloud.campus.model.pojo.entity.system.SystemRole;
import com.legend.cloud.campus.model.pojo.vo.system.SystemRoleVO;
import com.legend.cloud.campus.service.system.SystemRoleService;
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
@RequestMapping("/system/role")
public class SystemRoleController extends CampusController {

    @Resource
    private SystemRoleService systemRoleService;

    @GetMapping("/list")
    // @RequiresPermissions("role:role:list")
    public Ajax list(SystemRoleVO systemRoleVO, QueryUtils query) {
        try {
            List<SystemRole> systemRoleList = systemRoleService.getList(systemRoleVO.parseTo(),
                    query);
            List<SystemRoleVO> systemRoleVOList = systemRoleList.stream().map((entity) ->
                    new SystemRoleVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(systemRoleVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(systemRoleVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("role:role:details")
    public Ajax details(@PathVariable int id) {
        try {
            SystemRole systemRole = systemRoleService.getById(id);
            SystemRoleVO systemRoleVO = new SystemRoleVO().parseFrom(systemRole);
            return Ajax.success(systemRoleVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("role:role:add")
    public Ajax add(@Validated(AddGroup.class) SystemRoleVO systemRoleVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = systemRoleService.save(systemRoleVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("role:role:update")
    public Ajax update(@Validated(UpdateGroup.class) SystemRoleVO systemRoleVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = systemRoleService.updateById(systemRoleVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("role:role:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = systemRoleService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
