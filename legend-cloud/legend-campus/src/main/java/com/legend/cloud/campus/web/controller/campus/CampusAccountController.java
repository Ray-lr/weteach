package com.legend.cloud.campus.web.controller.campus;


import com.alibaba.fastjson.JSON;
import com.legend.cloud.campus.model.pojo.entity.campus.CampusAccount;
import com.legend.cloud.campus.model.pojo.vo.campus.CampusAccountVO;
import com.legend.cloud.campus.service.campus.CampusAccountService;
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
import com.legend.module.core.model.pojo.vo.user.UserVO;
import com.legend.module.core.model.utils.PageUtils;
import com.legend.module.core.model.utils.QueryUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author hupeiD
 * @date 2018-04-19 17:14:25
 */
@RestController
@RequestMapping("/campus/account")
public class CampusAccountController extends CampusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CampusAccountController.class);

    @Resource
    private CampusAccountService campusAccountService;
    @Resource
    private CampusCourseCategoryService campusCourseCategoryService;
    /**
     * 根据campusAccountVO中不为空的字段以及query中的分页条件进行条件查询
     *
     * @param campusAccountVO 查询条件
     * @param queryUtils      分页查询工具
     * @return Ajax.success() or Ajax.error()
     */
    @GetMapping("/list")
    // @RequiresPermissions("campus:account:list")
    public Ajax list(CampusAccountVO campusAccountVO, QueryUtils queryUtils) {
        try {
            List<CampusAccount> campusAccountList = campusAccountService.getList(campusAccountVO.parseTo(),
                    queryUtils);
            List<CampusAccountVO> campusAccountVOList = new CampusAccountVO().parseFrom(campusAccountList);
            PageUtils pageUtils = new PageUtils(campusAccountVOList.size(), queryUtils.getCurrentPage(), queryUtils.getPageSize());
            LOGGER.info("list=>" + pageUtils);
            return Ajax.success(campusAccountVOList, AjaxMessage.QUERY_SUCCESS).put(Key.PAGINATION, pageUtils);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 根据userID获取个人详细信息并获取系和专业的文字
     *
     * @param campusAccountVO
     * @return Ajax.success() or Ajax.error()
     */
    @GetMapping("/detail")
    public Ajax detail(CampusAccountVO campusAccountVO) {
        try {
            campusAccountVO = new CampusAccountVO().parseFrom(campusAccountService.getByUserId(campusAccountVO.getUserId()));
            campusAccountVO.setDept_string(campusCourseCategoryService.getById(Integer.parseInt(campusAccountVO.getDept())).getName());
            campusAccountVO.setMajor_string(campusCourseCategoryService.getById(Integer.parseInt(campusAccountVO.getMajor())).getName());
            return Ajax.success(campusAccountVO, AjaxMessage.QUERY_SUCCESS);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }

    }

    /**
     * 根据id查询指定的campusAccount
     *
     * @param id id
     * @return Ajax.success() or Ajax.error()
     */
    @GetMapping("/details/{id}")
    // @RequiresPermissions("campus:account:details")
    public Ajax details(@PathVariable int id) {
        try {
            CampusAccount campusAccount = campusAccountService.getById(id);
            CampusAccountVO campusAccountVO = new CampusAccountVO().parseFrom(campusAccount);
            LOGGER.info("details=>" + campusAccountVO);
            return Ajax.success(campusAccountVO, AjaxMessage.QUERY_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

    /**
     * 需要通过后台验证，并个根据id添加
     *
     * @param campusAccountVO 添加的campusAccountVO
     * @param bindingResult   后台验证结果
     * @return Ajax.success() or Ajax.error()
     */
    @PostMapping("/add")
    // @RequiresPermissions("campus:account:add")
    public Ajax add(@Validated(AddGroup.class) CampusAccountVO campusAccountVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            int saveResult = campusAccountService.save(campusAccountVO.parseTo(Column.ID));
            LOGGER.info("save=>" + (saveResult == 1));
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
     * @param campusAccountVO 更新campusAccountVO的字段信息
     * @param bindingResult   后台验证结果
     * @return Ajax.success() or Ajax.error()
     */
    @PutMapping("/update")
    // @RequiresPermissions("campus:account:update")
    public Ajax update(@Validated(UpdateGroup.class) CampusAccountVO campusAccountVO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return AjaxValidate.processBindingResult(bindingResult);
            }
            Subject subject = SecurityUtils.getSubject();
            UserVO currentUser = (UserVO) subject.getPrincipal();
            CampusAccountVO account = (CampusAccountVO) currentUser.getAccount();
            campusAccountVO.setId(account.getId());
            campusAccountVO.setUpdateTime(new Date());
            if (campusAccountService.updateById(campusAccountVO.parseTo()) <= 0) {
                Ajax.error(AjaxMessage.UPDATE_FAILURE, AjaxCode.UPDATE_FAILURE);
            }
            CampusAccount campusAccount = campusAccountService.getByUserId(currentUser.getId());
            currentUser.setAccount(new CampusAccountVO().parseFrom(campusAccount));
            // 重新挂载新信息到Shiro
            String realmName = subject.getPrincipals().getRealmNames().iterator().next();
            subject.runAs(new SimplePrincipalCollection(currentUser, realmName));
            // 设置用户到session
            setCurrentUser(JSON.toJSONString(currentUser));
            LOGGER.info(String.valueOf(getCurrentUser()));
            return Ajax.success(AjaxMessage.UPDATE_SUCCESS);
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
    // @RequiresPermissions("campus:account:delete")
    public Ajax delete(@PathVariable Integer id) {
        try {
            int deletedResult = campusAccountService.updateDeleted(id);
            return deletedResult == 1 ? Ajax.success(AjaxMessage.DELETE_SUCCESS) : Ajax.error(AjaxMessage.DELETE_FAILURE,
                    AjaxCode.DELETE_FAILURE);
        } catch (Exception e) {
            e.printStackTrace();
            return Ajax.error(AjaxMessage.SERVER_ERROR, AjaxCode.SERVER_ERROR);
        }
    }

}
