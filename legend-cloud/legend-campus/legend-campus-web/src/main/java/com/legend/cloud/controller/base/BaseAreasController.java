package com.legend.cloud.controller.base;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.base.BaseAreas;
import com.legend.cloud.service.base.BaseAreasService;
import com.legend.cloud.vo.base.BaseAreasVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.json.result.Ajax;
import com.legend.module.core.model.json.result.AjaxValidate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            List<BaseAreasVO> baseAreasVOList = baseAreasList.stream().map((entity) ->
                    new BaseAreasVO().parseFrom(entity)).collect(Collectors.toList());
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

    /*@RequestMapping(value = "/choose",method = RequestMethod.GET)
    public Ajax choose(String area){

        try {
            BaseAreasExample example = new BaseAreasExample();
            example.createCriteria().andNameEqualTo(area);
            BaseAreas baseAreas= baseAreasService.getByExample(example);
            BaseAreasExample example2 = new BaseAreasExample();
            example2.createCriteria().andTypeAreasEqualTo(baseAreas.getTypeAreas()).andParentIdEqualTo(baseAreas.getParentId());
            List<BaseAreas> list =baseAreasService.getListByExample(example2);
            return Ajax.success(list, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }*/
    @RequestMapping(value = "/getAreaName", method = RequestMethod.GET)
    public Ajax getAreaName(String provinceId, String cityId, String countryId) {
        try {
            Map<String, String> map = new HashMap();
            /*map.put("province",baseAreasService.getById(Integer.parseInt(provinceId)).getName());
            map.put("city",baseAreasService.getById(Integer.parseInt(cityId)).getName());
            map.put("country",baseAreasService.getById(Integer.parseInt(countryId)).getName());*/
            String[] s = new String[3];
            s[0] = baseAreasService.getById(Integer.parseInt(provinceId)).getName();
            s[1] = baseAreasService.getById(Integer.parseInt(cityId)).getName();
            s[2] = baseAreasService.getById(Integer.parseInt(countryId)).getName();
            return Ajax.success(s, AjaxMessage.QUERY_SUCCESS);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }
}
