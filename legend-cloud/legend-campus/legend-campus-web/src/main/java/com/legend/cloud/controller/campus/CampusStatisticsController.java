package com.legend.cloud.controller.campus;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.campus.CampusStatistics;
import com.legend.cloud.service.campus.CampusStatisticsService;
import com.legend.cloud.vo.campus.CampusStatisticsVO;
import com.legend.module.core.model.contant.arribute.Column;
import com.legend.module.core.model.contant.arribute.Key;
import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import com.legend.module.core.model.group.option.AddGroup;
import com.legend.module.core.model.group.option.UpdateGroup;
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
@RequestMapping("/campus/statistics")
public class CampusStatisticsController extends CampusController {

    @Resource
    private CampusStatisticsService campusStatisticsService;

    @GetMapping("/list")
    // @RequiresPermissions("campus:campusstatistics:list")
    public Ajax list(CampusStatisticsVO campusStatisticsVO, Query query) {
        try {
            List<CampusStatistics> campusStatisticsList = campusStatisticsService.getList(campusStatisticsVO.parseTo(),
                    query);
            List<CampusStatisticsVO> campusStatisticsVOList = campusStatisticsList.stream().map((entity) ->
                    new CampusStatisticsVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusStatisticsVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusStatisticsVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("campus:campusstatistics:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusStatistics campusStatistics = campusStatisticsService.getById(id);
            CampusStatisticsVO campusStatisticsVO = new CampusStatisticsVO().parseFrom(campusStatistics);
            return Ajax.success(campusStatisticsVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("campus:campusstatistics:add")
    public Ajax add(@Validated(AddGroup.class) CampusStatisticsVO campusStatisticsVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = campusStatisticsService.save(campusStatisticsVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("campus:campusstatistics:update")
    public Ajax update(@Validated(UpdateGroup.class) CampusStatisticsVO campusStatisticsVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = campusStatisticsService.updateById(campusStatisticsVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("campus:campusstatistics:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusStatisticsService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
