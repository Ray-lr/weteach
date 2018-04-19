package com.legend.cloud.campus.web.controller.campus;


import com.legend.cloud.campus.model.pojo.entity.campus.CampusVerify;
import com.legend.cloud.campus.model.pojo.vo.campus.CampusVerifyVO;
import com.legend.cloud.campus.service.campus.CampusVerifyService;
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
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/campus/verify")
public class CampusVerifyController extends CampusController {

    @Resource
    private CampusVerifyService campusVerifyService;

    @GetMapping("/list")
    // @RequiresPermissions("campus:campusverify:list")
    public Ajax list(CampusVerifyVO campusVerifyVO, QueryUtils query) {
        try {
            List<CampusVerify> campusVerifyList = campusVerifyService.getList(campusVerifyVO.parseTo(),
                    query);
            List<CampusVerifyVO> campusVerifyVOList = new CampusVerifyVO().parseFrom(campusVerifyList);
            PageUtils pageUtils = new PageUtils(campusVerifyVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusVerifyVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("campus:campusverify:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusVerify campusVerify = campusVerifyService.getById(id);
            CampusVerifyVO campusVerifyVO = new CampusVerifyVO().parseFrom(campusVerify);
            return Ajax.success(campusVerifyVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("campus:campusverify:add")
    public Ajax add(@Validated(AddGroup.class) CampusVerifyVO campusVerifyVO, BindingResult bindingResult, String userId) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            campusVerifyVO.setUserId(Integer.parseInt(userId));
            campusVerifyVO.setCreateTime(new Date());
            campusVerifyVO.setUpdateTime(new Date());
            int saveResult = campusVerifyService.save(campusVerifyVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("campus:campusverify:update")
    public Ajax update(@Validated(UpdateGroup.class) CampusVerifyVO campusVerifyVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = campusVerifyService.updateById(campusVerifyVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("campus:campusverify:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusVerifyService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


}
