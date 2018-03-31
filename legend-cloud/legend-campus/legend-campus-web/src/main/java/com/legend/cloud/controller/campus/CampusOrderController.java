package com.legend.cloud.controller.campus;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.campus.CampusOrder;
import com.legend.cloud.service.campus.CampusOrderService;
import com.legend.cloud.vo.campus.CampusOrderVO;
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
@RequestMapping("/campus/order")
public class CampusOrderController extends CampusController {

    @Resource
    private CampusOrderService campusOrderService;

    @GetMapping("/list")
    // @RequiresPermissions("campus:campusorder:list")
    public Ajax list(CampusOrderVO campusOrderVO, Query query) {
        try {
            List<CampusOrder> campusOrderList = campusOrderService.getList(campusOrderVO.parseTo(),
                    query);
            List<CampusOrderVO> campusOrderVOList = campusOrderList.stream().map((entity) ->
                    new CampusOrderVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusOrderVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusOrderVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("campus:campusorder:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusOrder campusOrder = campusOrderService.getById(id);
            CampusOrderVO campusOrderVO = new CampusOrderVO().parseFrom(campusOrder);
            return Ajax.success(campusOrderVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("campus:campusorder:add")
    public Ajax add(@Validated CampusOrderVO campusOrderVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = campusOrderService.save(campusOrderVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("campus:campusorder:update")
    public Ajax update(@Validated CampusOrderVO campusOrderVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = campusOrderService.updateById(campusOrderVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("campus:campusorder:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusOrderService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
