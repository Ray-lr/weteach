package com.legend.cloud.campus.web.controller.system;


import com.legend.cloud.campus.model.pojo.entity.system.SystemMenuRelPermission;
import com.legend.cloud.campus.model.pojo.vo.system.SystemMenuRelPermissionVO;
import com.legend.cloud.campus.service.system.SystemMenuRelPermissionService;
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
 * @author hupeiD
 * @date 2018-04-12 10:59:34
 */
@RestController
@RequestMapping("/system/menuRelPermission")
public class SystemMenuRelPermissionController extends CampusController {

    @Resource
    private SystemMenuRelPermissionService systemMenuRelPermissionService;

    /**
     * 根据systemMenuRelPermissionVO中不为空的字段以及query中的分页条件进行条件查询
     *
     * @param systemMenuRelPermissionVO 查询条件
     * @param query                     分页查询工具
     * @return Ajax.success() or Ajax.error()
     */
    @GetMapping("/list")
    // @RequiresPermissions("system:menuRelPermission:list")
    public Ajax list(SystemMenuRelPermissionVO systemMenuRelPermissionVO, QueryUtils query) {
        try {
            List<SystemMenuRelPermission> systemMenuRelPermissionList = systemMenuRelPermissionService.getList(systemMenuRelPermissionVO.parseTo(),
                    query);
            List<SystemMenuRelPermissionVO> systemMenuRelPermissionVOList = new SystemMenuRelPermissionVO().parseFrom(systemMenuRelPermissionList);
            PageUtils pageUtils = new PageUtils(systemMenuRelPermissionVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(systemMenuRelPermissionVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 根据id查询指定的systemMenuRelPermission
     *
     * @param id id
     * @return Ajax.success() or Ajax.error()
     */
    @GetMapping("/details/{id}")
    // @RequiresPermissions("system:menuRelPermission:details")
    public Ajax details(@PathVariable int id) {
        try {
            SystemMenuRelPermission systemMenuRelPermission = systemMenuRelPermissionService.getById(id);
            SystemMenuRelPermissionVO systemMenuRelPermissionVO = new SystemMenuRelPermissionVO().parseFrom(systemMenuRelPermission);
            return Ajax.success(systemMenuRelPermissionVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 需要通过后台验证，并个根据id添加
     *
     * @param systemMenuRelPermissionVO 添加的systemMenuRelPermissionVO
     * @param bindingResult             后台验证结果
     * @return Ajax.success() or Ajax.error()
     */
    @PostMapping("/add")
    // @RequiresPermissions("system:menuRelPermission:add")
    public Ajax add(@Validated(AddGroup.class) SystemMenuRelPermissionVO systemMenuRelPermissionVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = systemMenuRelPermissionService.save(systemMenuRelPermissionVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 需要通过后台验证，并个根据id更新相应不为空的字段
     *
     * @param systemMenuRelPermissionVO 更新systemMenuRelPermissionVO的字段信息
     * @param bindingResult             后台验证结果
     * @return Ajax.success() or Ajax.error()
     */
    @PutMapping("/update")
    // @RequiresPermissions("system:menuRelPermission:update")
    public Ajax update(@Validated(UpdateGroup.class) SystemMenuRelPermissionVO systemMenuRelPermissionVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = systemMenuRelPermissionService.updateById(systemMenuRelPermissionVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 根据id逻辑删除
     *
     * @param id id
     * @return Ajax.success() or Ajax.error()
     */
    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("system:menuRelPermission:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = systemMenuRelPermissionService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
