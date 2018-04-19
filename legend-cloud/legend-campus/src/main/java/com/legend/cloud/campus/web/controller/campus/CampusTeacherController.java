package com.legend.cloud.campus.web.controller.campus;


import com.legend.cloud.campus.model.pojo.entity.campus.CampusTeacher;
import com.legend.cloud.campus.model.pojo.vo.campus.CampusTeacherVO;
import com.legend.cloud.campus.service.campus.CampusTeacherService;
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
@RequestMapping("/campus/teacher")
public class CampusTeacherController extends CampusController {

    @Resource
    private CampusTeacherService campusTeacherService;

    @GetMapping("/list")
    // @RequiresPermissions("campus:campusteacher:list")
    public Ajax list(CampusTeacherVO campusTeacherVO, QueryUtils query) {
        try {
            List<CampusTeacher> campusTeacherList = campusTeacherService.getList(campusTeacherVO.parseTo(),
                    query);
            List<CampusTeacherVO> campusTeacherVOList = new CampusTeacherVO().parseFrom(campusTeacherList);
            PageUtils pageUtils = new PageUtils(campusTeacherVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusTeacherVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @GetMapping("/details/{id}")
    // @RequiresPermissions("campus:campusteacher:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusTeacher campusTeacher = campusTeacherService.getById(id);
            CampusTeacherVO campusTeacherVO = new CampusTeacherVO().parseFrom(campusTeacher);
            return Ajax.success(campusTeacherVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @PostMapping("/add")
    // @RequiresPermissions("campus:campusteacher:add")
    public Ajax add(@Validated(AddGroup.class) CampusTeacherVO campusTeacherVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = campusTeacherService.save(campusTeacherVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    // @RequiresPermissions("campus:campusteacher:update")
    public Ajax update(@Validated(UpdateGroup.class) CampusTeacherVO campusTeacherVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = campusTeacherService.updateById(campusTeacherVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("campus:campusteacher:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusTeacherService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
