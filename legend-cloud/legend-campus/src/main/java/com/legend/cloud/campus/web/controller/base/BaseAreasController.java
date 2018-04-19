package com.legend.cloud.campus.web.controller.base;


import com.legend.cloud.campus.model.pojo.entity.base.BaseAreas;
import com.legend.cloud.campus.model.pojo.vo.base.BaseAreasVO;
import com.legend.cloud.campus.service.base.BaseAreasService;
import com.legend.cloud.campus.web.controller.CampusController;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/base/areas")
public class BaseAreasController extends CampusController {

    @Resource
    private BaseAreasService baseAreasService;

    @GetMapping("/list")
    // @RequiresPermissions("base:areas:list")
    public Ajax list(BaseAreasVO baseAreasVO) {
        try {
            List<BaseAreas> baseAreasList = baseAreasService.getList(baseAreasVO.parseTo());
            List<BaseAreasVO> baseAreasVOList = new BaseAreasVO().parseFrom(baseAreasList);
            return Ajax.success(baseAreasVOList, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("base:areas:details")
    public Ajax details(@PathVariable int id) {
        try {
            BaseAreas baseAreas = baseAreasService.getById(id);
            BaseAreasVO baseAreasVO = new BaseAreasVO().parseFrom(baseAreas);
            return Ajax.success(baseAreasVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("base:areas:add")
    public Ajax add(@Validated BaseAreasVO baseAreasVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = baseAreasService.save(baseAreasVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("base:areas:update")
    public Ajax update(@Validated BaseAreasVO baseAreasVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = baseAreasService.updateById(baseAreasVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("base:areas:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = baseAreasService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAreaName", method = RequestMethod.GET)
    public Ajax getAreaName(Integer[] areas) {
        try {
            if (areas == null || areas.length <= 0) {
                return Ajax.error(AjaxMessage.QUERY_FAILURE);
            }
            BaseAreas baseAreas = null;
            List<String> areasName = new ArrayList<>(areas.length);
            for (Integer areaId : areas) {
                if ((baseAreas = baseAreasService.getById(areaId)) != null) {
                    areasName.add(baseAreas.getName());
                }
            }
            return Ajax.success(areasName, AjaxMessage.QUERY_SUCCESS);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }
}
