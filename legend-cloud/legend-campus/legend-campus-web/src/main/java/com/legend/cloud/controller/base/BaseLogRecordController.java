package com.legend.cloud.controller.base;


import com.legend.cloud.controller.CampusController;
import com.legend.cloud.entity.base.BaseLogRecord;
import com.legend.cloud.service.base.BaseLogRecordService;
import com.legend.cloud.vo.base.BaseLogRecordVO;
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
@RequestMapping("/base/logRecord")
public class BaseLogRecordController extends CampusController {

    @Resource
    private BaseLogRecordService baseLogRecordService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    // @RequiresPermissions("base:logRecord:list")
    public Ajax list(BaseLogRecordVO baseLogRecordVO, Query query) {
        try {
            List<BaseLogRecord> baseLogRecordList = baseLogRecordService.getList(baseLogRecordVO.parseTo(),
                    query);
            List<BaseLogRecordVO> baseLogRecordVOList = baseLogRecordList.stream().map((entity) ->
                    new BaseLogRecordVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(baseLogRecordVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(baseLogRecordVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("base:logRecord:details")
    public Ajax details(@PathVariable int id) {
        try {
            BaseLogRecord baseLogRecord = baseLogRecordService.getById(id);
            BaseLogRecordVO baseLogRecordVO = new BaseLogRecordVO().parseFrom(baseLogRecord);
            return Ajax.success(baseLogRecordVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("base:logRecord:add")
    public Ajax add(@Validated BaseLogRecordVO baseLogRecordVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = baseLogRecordService.save(baseLogRecordVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("base:logRecord:update")
    public Ajax update(@Validated BaseLogRecordVO baseLogRecordVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = baseLogRecordService.updateById(baseLogRecordVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("base:logRecord:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = baseLogRecordService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
