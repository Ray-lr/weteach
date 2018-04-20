<#include "common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">课时设置</h1>
            <hr class="line">
            <div class="col col-md-2" id="personal">
            </div>
            <div class="col-12 col-md-8" id="principal">
                <div class="progress">
                    <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar"
                         aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div>
                </div>
                <form @submit.prevent="publish($event)">
                    <!--标题-->
                    <div class="form-group">
                        <label for="courseTitle">课程标题</label>
                        <input type="email" class="form-control" id="courseTitle"
                               data-toggle="tooltip"
                               data-placement="left" title="必填">
                    </div>
                    <!--系别/专业/课程-->
                    <div class="form-group">
                        <label for="course">系别/专业/课程</label>
                        <div class="input-group">
                            <select class="form-control" id="dept"
                                    v-model="dept" name="course.dept"
                                    data-toggle="tooltip"
                                    data-placement="left" title="请选择系别">
                                <option v-for="item in depts" :value="item.id"
                                        v-text="item.name"></option>
                            </select>
                            <select class="form-control" id="major" v-model="major"
                                    data-toggle="tooltip" name="course.major"
                                    data-placement="left" title="请选择专业">
                                <option v-for="item in majors" :value="item.id"
                                        v-text="item.name"></option>
                            </select>
                            <select class="form-control" id="course"
                                    v-model="course" name="course.course"
                                    data-toggle="tooltip"
                                    data-placement="left" title="请选择课程">
                                <option v-for="item in courses" :value="item.id"
                                        v-text="item.name"></option>
                            </select>
                        </div>
                    </div>
                    <!--课程描述-->
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">课程描述</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"
                                  data-toggle="tooltip"
                                  data-placement="left" title="课程描述"></textarea>
                    </div>
                    <!--相关备注-->
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">相关备注</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="4"
                                  data-toggle="tooltip"
                                  data-placement="left" title="选填"></textarea>
                    </div>
                    <!--课时节数-->
                    <div class="form-group">
                        <label for="courseTime">预计课时节数</label>
                        <input type="number" class="form-control" id="courseTime"
                               data-toggle="tooltip"
                               data-placement="left" title="请输入课时节数">
                    </div>
                    <!--参与所需积分-->
                    <div class="form-group">
                        <label for="payCredits">参与所需积分</label>
                        <input type="number" class="form-control" id="payCredits"
                               data-toggle="tooltip"
                               data-placement="left" title="请输入参与课程所需积分">
                    </div>
                    <!--开课时间-->
                    <div class="form-group">
                        <label for="dateTime">开课时间</label>
                        <div class="input-group date form_datetime">
                            <input type="text" class="form-control" id="dateTime"
                                   name="publishTime"
                                   data-toggle="tooltip"
                                   data-placement="left" title="请输入开课时间"
                                   aria-describedby="expectedPublishTimeHelp"
                                   placeholder="Date Time"
                                   readonly>
                            <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <small id="expectedPublishTimeHelp" class="form-text text-muted">

                        </small>
                    </div>
                    <!--结课时间-->
                    <div class="form-group">
                        <label for="dateTime">结课时间</label>
                        <div class="input-group date form_datetime">
                            <input type="text" class="form-control" id="dateTime"
                                   name="course.finishTime"
                                   data-toggle="tooltip"
                                   data-placement="left" title="请输入结课时间"
                                   aria-describedby="finishTimeHelp" placeholder="Date Time"
                                   readonly>
                            <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <small id="finishTimeHelp" class="form-text text-muted">

                        </small>
                    </div>
                    <!--模态框限制-->
                    <button type="button" class="btn btn-danger" data-toggle="modal"
                            data-target="#exampleModal2" style="width: 100%">
                        增加限制条件
                    </button>
                    <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog"
                         aria-labelledby="exampleModalLabel2" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="exampleModalLabel2">报名人员限制</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <!--相关限制条件-->
                                    <div id="courseLimit">
                                        <div class="alert alert-primary" role="alert">

                                            <!--专业限制-->
                                            <h5>
                                                <label for="teach_major_limit">专业限制</label>
                                                <input type="checkbox" class=".all_check"
                                                       aria-label="Checkbox for following text input"
                                                       id="teach_major_limit" name="a"
                                                       data-toggle="tooltip"
                                                       data-placement="left" title="专业限制">
                                            </h5>
                                            <div class="input-group cancel_all" id="teach_major"
                                                 style="display: none">
                                                <select class="form-control" id="dept"
                                                        v-model="dept" name="course.dept"
                                                        data-toggle="tooltip"
                                                        data-placement="left" title="请选择系别">
                                                    <option v-for="item in depts" :value="item.id"
                                                            v-text="item.name"></option>
                                                </select>
                                                <select class="form-control" id="major" v-model="major"
                                                        data-toggle="tooltip" name="course.major"
                                                        data-placement="left" title="请选择专业">
                                                    <option v-for="item in majors" :value="item.id"
                                                            v-text="item.name"></option>
                                                </select>
                                            </div>
                                            <div class="dropdown-divider"></div>
                                            <!--性别限制-->
                                            <h5>
                                                <label for="teach_sex_limit">性别限制</label>
                                                <input type="checkbox" class=".all_check"
                                                       aria-label="Checkbox for following text input"
                                                       id="teach_sex_limit" name="a"
                                                       data-toggle="tooltip"
                                                       data-placement="left" title="性别限制">
                                            </h5>
                                            <div class="form-group cancel_all" align="center" id="teach_sex"
                                                 style="display: none;">
                                                <label for="male">男</label>
                                                <input type="radio" name="sex" id="male" checked/>

                                                <label for="female">女</label>
                                                <input type="radio" name="sex" id="female"/>
                                            </div>
                                            <div class="dropdown-divider"></div>
                                            <!--年级限制-->
                                            <h5>
                                                <label for="teach_grade_limit">年级限制</label>
                                                <input type="checkbox" class=".all_check"
                                                       aria-label="Checkbox for following text input"
                                                       id="teach_grade_limit" name="a"
                                                       data-toggle="tooltip"
                                                       data-placement="left" title="年级限制">
                                            </h5>
                                            <div class="form-group cancel_all" id="teach_grade"
                                                 style="display: none;">
                                                <div class="row" align="center">
                                                    <p class="col col-3">大一
                                                        <input type="checkbox" value="1"
                                                               name="limit.grade"
                                                               id="gradeOne"
                                                               data-toggle="tooltip"
                                                               data-placement="left" title="大一">
                                                    </p>
                                                    <p class="col col-3">大二
                                                        <input type="checkbox" value="2"
                                                               name="limit.grade"
                                                               id="gradeTwo"
                                                               data-toggle="tooltip"
                                                               data-placement="left" title="大二">
                                                    </p>
                                                    <p class="col col-3">大三
                                                        <input type="checkbox" value="3"
                                                               name="limit.grade"
                                                               id="gradeThree"
                                                               data-toggle="tooltip"
                                                               data-placement="left" title="大三">
                                                    </p>
                                                    <p class="col col-3">大四
                                                        <input type="checkbox" value="4"
                                                               name="limit.grade"
                                                               id="gradeFour"
                                                               data-toggle="tooltip"
                                                               data-placement="left" title="大四">
                                                    </p>
                                                </div>
                                            </div>
                                            <div class="dropdown-divider"></div>
                                            <!--人数限制-->
                                            <h5>
                                                <label for="person_num_limit">人数限制</label>
                                                <input type="checkbox" class=".all_check"
                                                       aria-label="Checkbox for following text input"
                                                       id="person_num_limit"
                                                       data-toggle="tooltip"
                                                       data-placement="left" title="人数限制">
                                            </h5>
                                            <div id="person_num" class="form-group cancel_all"
                                                 style="display: none;">
                                                <div class="form-group row" align="center">
                                                    <label for="courseTime"></label>
                                                    <input type="number" min="0" class="form-control col col-5"
                                                           data-toggle="tooltip" name="limit.upper"
                                                           data-placement="left" title="请输入人数上限">
                                                    <label for="courseTime"></label>~
                                                    <input type="number" min="0" class="form-control col col-5"
                                                           data-toggle="tooltip" name="limit.lower"
                                                           data-placement="left" title="请输入人数下限">
                                                </div>
                                            </div>
                                            <div class="dropdown-divider"></div>
                                            <h4>
                                                <label for="bigBox">全选/取消</label>
                                                <input type="checkbox" class="bigBox"
                                                       aria-label="Checkbox for following text input"
                                                       data-toggle="tooltip"
                                                       data-placement="left" title="全选/取消">
                                            </h4>

                                        <#--<button type="button" class="btn btn-danger hide"
                                                style="width: 100%;height:35px;font-size:15px;">全部取消
                                        </button>-->
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>

                                </div>
                            </div>
                        </div>
                    </div>

                    <!--分割线-->
                    <div class="dropdown-divider"></div>
                    <input type="submit" class="btn btn-primary btn-lg btn-block"
                           v-model="submitText">

                </form>
            </div>
            <div class="col col-md-2" id="external">
            </div>
        </div>
    </div>
</div>
<#include "common/js.ftl">

<#include "common/foot.ftl">