package com.legend.cloud.controller.base;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.base.BaseUserRelRole;
import com.legend.cloud.service.base.BaseUserRelRoleService;
import com.legend.cloud.vo.base.BaseUserRelRoleVO;
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
@RequestMapping("/base/userRelRole")
public class BaseUserRelRoleController extends CampusController {

    @Resource
    private BaseUserRelRoleService baseUserRelRoleService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("base:userRelRole:list")
    public Ajax list(BaseUserRelRoleVO baseUserRelRoleVO, Query query) {
        try {
            List<BaseUserRelRole> baseUserRelRoleList = baseUserRelRoleService.getList(baseUserRelRoleVO.parseTo(),
                    query);
            List<BaseUserRelRoleVO> baseUserRelRoleVOList = baseUserRelRoleList.stream().map((entity) ->
                    new BaseUserRelRoleVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(baseUserRelRoleVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(baseUserRelRoleVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
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


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("base:userRelRole:add")
    public Ajax add(@Validated BaseUserRelRoleVO baseUserRelRoleVO, BindingResult bindingResult) {
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

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("base:userRelRole:update")
    public Ajax update(@Validated BaseUserRelRoleVO baseUserRelRoleVO, BindingResult bindingResult) {
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
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
