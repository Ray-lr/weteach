package com.legend.cloud.controller.base;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.base.BaseType;
import com.legend.cloud.service.base.BaseTypeService;
import com.legend.cloud.vo.base.BaseTypeVO;
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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/base/type")
public class BaseTypeController extends CampusController {

    @Resource
    private BaseTypeService baseTypeService;

    @GetMapping("/list")
    // @RequiresPermissions("base:type:list")
    public Ajax list(BaseTypeVO baseTypeVO, Query query) {
        try {
            List<BaseType> baseTypeList = baseTypeService.getList(baseTypeVO.parseTo(),
                    query);
            List<BaseTypeVO> baseTypeVOList = baseTypeList.stream().map((entity) ->
                    new BaseTypeVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(baseTypeVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(baseTypeVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("base:type:details")
    public Ajax details(@PathVariable int id) {
        try {
            BaseType baseType = baseTypeService.getById(id);
            BaseTypeVO baseTypeVO = new BaseTypeVO().parseFrom(baseType);
            return Ajax.success(baseTypeVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("base:type:add")
    public Ajax add(@Validated BaseTypeVO baseTypeVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = baseTypeService.save(baseTypeVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("base:type:update")
    public Ajax update(@Validated BaseTypeVO baseTypeVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = baseTypeService.updateById(baseTypeVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("base:type:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = baseTypeService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
