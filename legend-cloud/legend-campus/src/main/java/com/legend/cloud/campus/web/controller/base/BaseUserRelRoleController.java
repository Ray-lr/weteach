package com.legend.cloud.campus.web.controller.base;


import com.legend.cloud.campus.model.pojo.entity.base.BaseUserRelRole;
import com.legend.cloud.campus.model.pojo.vo.base.BaseUserRelRoleVO;
import com.legend.cloud.campus.service.base.BaseUserRelRoleService;
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
@RequestMapping("/base/userRelRole")
public class BaseUserRelRoleController extends CampusController {

    @Resource
    private BaseUserRelRoleService baseUserRelRoleService;

    @GetMapping("/list")
    // @RequiresPermissions("base:userRelRole:list")
    public Ajax list(BaseUserRelRoleVO baseUserRelRoleVO, QueryUtils query) {
        try {
            List<BaseUserRelRole> baseUserRelRoleList = baseUserRelRoleService.getList(baseUserRelRoleVO.parseTo(),
                    query);
            List<BaseUserRelRoleVO> baseUserRelRoleVOList = new BaseUserRelRoleVO().parseFrom(baseUserRelRoleList);
            PageUtils pageUtils = new PageUtils(baseUserRelRoleVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(baseUserRelRoleVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("base:userRelRole:details")
    public Ajax details(@PathVariable int id) {
        try {
            BaseUserRelRole baseUserRelRole = baseUserRelRoleService.getById(id);
            BaseUserRelRoleVO baseUserRelRoleVO = new BaseUserRelRoleVO().parseFrom(baseUserRelRole);
            return Ajax.success(baseUserRelRoleVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("base:userRelRole:add")
    public Ajax add(@Validated(AddGroup.class) BaseUserRelRoleVO baseUserRelRoleVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = baseUserRelRoleService.save(baseUserRelRoleVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("base:userRelRole:update")
    public Ajax update(@Validated(UpdateGroup.class) BaseUserRelRoleVO baseUserRelRoleVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = baseUserRelRoleService.updateById(baseUserRelRoleVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("base:userRelRole:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = baseUserRelRoleService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
