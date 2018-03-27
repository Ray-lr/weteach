package com.legend.cloud.controller.campus;


        import com.legend.module.core.model.contant.arribute.Column;
        import com.legend.module.core.model.contant.arribute.Key;
        import com.legend.module.core.model.contant.code.result.AjaxCode;
        import com.legend.module.core.model.contant.message.result.AjaxMessage;
        import com.legend.module.core.model.json.result.Ajax;
        import com.legend.module.core.model.json.result.AjaxValidate;
        import com.legend.module.core.utils.PageUtils;
        import com.legend.module.core.utils.Query;
        import com.legend.module.core.web.controller.LegendController;
        import com.legend.cloud.entity.campus.CampusCourse;
        import com.legend.cloud.service.campus.CampusCourseService;
        import com.legend.cloud.vo.campus.CampusCourseVO;
        import org.springframework.validation.BindingResult;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

        import javax.annotation.Resource;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/3/17
 */
@RestController
@RequestMapping("/campus/course")
public class CampusCourseController extends LegendController {

    @Resource
    private CampusCourseService campusCourseService;

    @RequestMapping(value = "/studyList", method = RequestMethod.GET)
    // @RequiresPermissions("campus:course:list")
    public Ajax list(CampusCourseVO campusCourseVO, Query query) {
        try {
            campusCourseVO.setTypeCourse("求学");
            List<CampusCourse> campusCourseList = campusCourseService.getList(campusCourseVO.parseTo(),
                    query);
            List<CampusCourseVO> campusCourseVOList = campusCourseList.stream().map((entity) ->
                    new CampusCourseVO().parseFrom(entity)).collect(Collectors.toList());
            PageUtils pageUtils = new PageUtils(campusCourseVOList, campusCourseVOList.size(), query.getCurrentPage(), query.getPageSize());
            return Ajax.success(AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    // @RequiresPermissions("campus:course:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusCourse campusCourse =campusCourseService.getById(id);
                CampusCourseVO campusCourseVO = new CampusCourseVO().parseFrom(campusCourse);
            return Ajax.success(campusCourseVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    // @RequiresPermissions("campus:course:add")
    public Ajax add(@Validated CampusCourseVO campusCourseVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int saveResult = campusCourseService.save(campusCourseVO.parseTo(Column.ID));
            return saveResult == 1 ? Ajax.success(AjaxMessage.SAVE_SUCCESS) : Ajax.error(AjaxMessage.SAVE_FAILURE, AjaxCode
                    .SAVE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    // @RequiresPermissions("campus:course:update")
    public Ajax update(@Validated CampusCourseVO campusCourseVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return Ajax.error(AjaxMessage.PARAMETER_ERROR, AjaxCode.PARAMETER_ERROR).put(AjaxValidate.parseFieldError(bindingResult
                        .getFieldErrors()));
            }
            int updateResult = campusCourseService.updateById(campusCourseVO.parseTo());
            return updateResult == 1 ? Ajax.success(AjaxMessage.UPDATE_SUCCESS) : Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode
                    .UPDATE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // @RequiresPermissions("campus:course:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusCourseService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
