package com.legend.cloud.campus.web.controller.campus;


import com.legend.cloud.campus.model.pojo.entity.campus.CampusCourseCategory;
import com.legend.cloud.campus.model.pojo.vo.campus.CampusCourseCategoryVO;
import com.legend.cloud.campus.service.campus.CampusCourseCategoryService;
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
@RequestMapping("/campus/courseCategory")
public class CampusCourseCategoryController extends CampusController {

    @Resource
    private CampusCourseCategoryService campusCourseCategoryService;

    /**
     * 根据campusCourseCategoryVO中不为空的字段以及query中的分页条件进行条件查询
     *
     * @param campusCourseCategoryVO 查询条件
     * @return Ajax.success() or Ajax.error()
     */
    @GetMapping("/list")
    // @RequiresPermissions("campus:courseCategory:list")
    public Ajax list(CampusCourseCategoryVO campusCourseCategoryVO, QueryUtils query) {
        try {
            List<CampusCourseCategory> campusCourseCategoryList = campusCourseCategoryService.getList(campusCourseCategoryVO.parseTo(),
                    query);
            List<CampusCourseCategoryVO> campusCourseCategoryVOList = new CampusCourseCategoryVO().parseFrom(campusCourseCategoryList);
            PageUtils pageUtils = new PageUtils(campusCourseCategoryVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(campusCourseCategoryVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 根据id查询指定的campusCourseCategory
     *
     * @param id id
     * @return Ajax.success() or Ajax.error()
     */
    @GetMapping("/details/{id}")
    // @RequiresPermissions("campus:courseCategory:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusCourseCategory campusCourseCategory = campusCourseCategoryService.getById(id);
            CampusCourseCategoryVO campusCourseCategoryVO = new CampusCourseCategoryVO().parseFrom(campusCourseCategory);
            return Ajax.success(campusCourseCategoryVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 需要通过后台验证，并个根据id添加
     *
     * @param campusCourseCategoryVO 添加的campusCourseCategoryVO
     * @param bindingResult          后台验证结果
     * @return Ajax.success() or Ajax.error()
     */
    @PostMapping(value = "/add")
    // @RequiresPermissions("campus:courseCategory:add")
    public Ajax add(@Validated(AddGroup.class) CampusCourseCategoryVO campusCourseCategoryVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = campusCourseCategoryService.save(campusCourseCategoryVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 需要通过后台验证，并个根据id更新相应不为空的字段
     *
     * @param campusCourseCategoryVO 更新campusCourseCategoryVO的字段信息
     * @param bindingResult          后台验证结果
     * @return Ajax.success() or Ajax.error()
     */
    @PutMapping("/update")
    // @RequiresPermissions("campus:courseCategory:update")
    public Ajax update(@Validated(UpdateGroup.class) CampusCourseCategoryVO campusCourseCategoryVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int updateResult = campusCourseCategoryService.updateById(campusCourseCategoryVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 根据id逻辑删除
     *
     * @param id id
     * @return Ajax.success() or Ajax.error()
     */
    @DeleteMapping("/delete/{id}")
    // @RequiresPermissions("campus:courseCategory:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusCourseCategoryService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
