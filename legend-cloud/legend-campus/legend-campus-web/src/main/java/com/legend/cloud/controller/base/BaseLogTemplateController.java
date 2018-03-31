package com.legend.cloud.controller.base;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.base.BaseLogTemplate;
import com.legend.cloud.service.base.BaseLogTemplateService;
import com.legend.cloud.vo.base.BaseLogTemplateVO;
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
@RequestMapping("/base/logTemplate")
public class BaseLogTemplateController extends CampusController {

    @Resource
    private BaseLogTemplateService baseLogTemplateService;

    @GetMapping("/list")
    // @RequiresPermissions("base:logTemplate:list")
    public Ajax list(BaseLogTemplateVO baseLogTemplateVO, Query query) {
        try {
            List<BaseLogTemplate> baseLogTemplateList = baseLogTemplateService.getList(baseLogTemplateVO.parseTo(),
                    query);
            List<BaseLogTemplateVO> baseLogTemplateVOList = baseLogTemplateList.stream().map((entity) ->
                    new BaseLogTemplateVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(baseLogTemplateVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(baseLogTemplateVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("base:logTemplate:details")
    public Ajax details(@PathVariable int id) {
        try {
            BaseLogTemplate baseLogTemplate = baseLogTemplateService.getById(id);
            BaseLogTemplateVO baseLogTemplateVO = new BaseLogTemplateVO().parseFrom(baseLogTemplate);
            return Ajax.success(baseLogTemplateVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("base:logTemplate:add")
    public Ajax add(@Validated BaseLogTemplateVO baseLogTemplateVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = baseLogTemplateService.save(baseLogTemplateVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("base:logTemplate:update")
    public Ajax update(@Validated BaseLogTemplateVO baseLogTemplateVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = baseLogTemplateService.updateById(baseLogTemplateVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("base:logTemplate:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = baseLogTemplateService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
