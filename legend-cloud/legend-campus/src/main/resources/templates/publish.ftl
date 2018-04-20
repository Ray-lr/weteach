<#include "common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <h1 class="alert-heading">发布课程</h1>
        <hr class="line">
        <div class="row-fluid">
            <ul class="nav nav-pills justify-content-center" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link <#if !type?? || type=="seek">active</#if>" id="study-tab" data-toggle="tab"
                       href="#study" role="tab"
                       aria-controls="study" aria-selected="true">求学贴</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <#if type?? && type=="teach">active</#if>" id="teaching-tab" data-toggle="tab"
                       href="#teaching" role="tab"
                       aria-controls="teaching" aria-selected="false">教学贴</a>
                </li>
            </ul>

            <div class="tab-content row justify-content-center" id="courseContent">
                <!-- first list -->
                <div class="col col-md-10 tab-pane fade <#if !type?? || type=="seek">show active</#if>" id="study"
                     role="tabpanel"
                     aria-labelledby="study-tab">
                    <form class="publishForm">
                    <#--隐藏的课程类型-->
                        <input type="hidden" name="course.typeCourse" value="求学">
                        <!--标题-->
                        <div class="form-group">
                            <label class="control-label" for="courseTitle">课程标题</label>
                            <input type="text" class="form-control" id="courseTitle"
                                   name="course.title"
                                   placeholder="标题">
                        </div>
                        <!--系别/专业/课程-->
                        <div class="form-group">
                            <label class="control-label" for="course">系别/专业/课程</label>
                            <div class="input-group">
                                <select class="selectpicker form-control" id="dept roleidForSelect"
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
                            <label class="control-label" for="description">课程描述</label>
                            <textarea class="form-control" id="description" rows="3"
                                      name="course.description" placeholder="不超过100个字"></textarea>
                        </div>
                        <!--相关备注-->
                        <div class="form-group">
                            <label class="control-label" for="remark">相关备注</label>
                            <textarea class="form-control" id="remark" rows="4"
                                      name="course.remark" placeholder="选填"></textarea>
                        </div>
                        <!--悬赏积分-->
                        <div class="form-group">
                            <label class="control-label" for="payCredits">悬赏积分</label>
                            <input type="number" class="form-control" id="payCredits"
                                   name="course.payCredits"
                                   :value="1"
                                   min="1"
                                   placeholder="最低悬赏1积分">
                        </div>
                        <!--报名截止时间-->
                        <div class="form-group">
                            <label class="control-label" for="applyEndTime">截止时间</label>
                            <div class="input-group date form_datetime"
                                 data-picker-position="top-right">
                                <input type="text" class="form-control cursor-pointer"
                                       data-link-field="#applyEndTime"
                                       data-link-format="yyyy-mm-dd hh:ii"
                                       placeholder="报名截止日期"
                                       readonly>
                                <span class="input-group-addon"><span
                                        class="glyphicon glyphicon-th"></span></span>
                                <input type="hidden" name="course.applyEndTime" id="applyEndTime">
                            </div>
                        </div>
                        <!--开课时间-->
                        <div class="form-group">
                            <label class="control-label" for="beginTime">开课时间</label>
                            <input type="hidden" name="course.beginTime">
                            <div class="input-group date form_datetime"
                                 data-picker-position="top-right">
                                <input type="text" class="form-control cursor-pointer"
                                       data-link-field="#beginTime"
                                       data-link-format="yyyy-mm-dd hh:ii"
                                       placeholder="开课时间"
                                       readonly>
                                <span class="input-group-addon"><span
                                        class="glyphicon glyphicon-th"></span></span>
                                <input type="hidden" name="course.beginTime" id="beginTime">
                            </div>
                        </div>
                        <!--模态框限制-->
                        <button type="button" class="btn btn-danger" data-toggle="modal"
                                data-target="#exampleModal" style="width: 100%">
                            增加限制条件
                        </button>
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title" id="exampleModalLabel">报名人员限制</h4>
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
                                                    <label for="seek_major_limit">专业限制</label>
                                                    <input type="checkbox" class="all_check"
                                                           aria-label="Checkbox for following text input"
                                                           id="seek_major_limit" name="a"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="专业限制">
                                                </h5>
                                                <div class="input-group cancel_all" id="seek_major"
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
                                                    <label for="seek_sex_limit">性别限制</label>
                                                    <input type="checkbox" class="all_check"
                                                           aria-label="Checkbox for following text input"
                                                           id="seek_sex_limit" name="a"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="性别限制">
                                                </h5>
                                                <div class="form-group cancel_all" align="center" id="seek_sex"
                                                     style="display: none;">
                                                    <label for="male">男</label>
                                                    <input type="radio" name="limit.sex" value="1" id="male" checked/>

                                                    <label for="female">女</label>
                                                    <input type="radio" name="limit.sex" value="0" id="female"/>
                                                </div>
                                                <div class="dropdown-divider"></div>
                                                <!--年级限制-->
                                                <h5>
                                                    <label for="seek_grade_limit">年级限制</label>
                                                    <input type="checkbox" class="all_check"
                                                           aria-label="Checkbox for following text input"
                                                           id="seek_grade_limit" name="a"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="年级限制">
                                                </h5>
                                                <div class="form-group cancel_all" id="seek_grade"
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
                                                <h4>
                                                    <label for="bigBox">全选/取消</label>
                                                    <input type="checkbox" class="bigBox"
                                                           aria-label="Checkbox for following text input"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="全选/取消">
                                                </h4>
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
                <!-- second list -->
                <div class="col col-md-10 tab-pane fade <#if type?? && type=="teach">show active</#if>" id="teaching"
                     role="tabpanel"
                     aria-labelledby="teaching-tab">
                    <form class="publishForm">
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
                        </div>
                        <!--模态框限制-->
                        <button type="button" class="btn btn-danger" data-toggle="modal"
                                data-target="#exampleModal2" style="width: 100%">
                            增加限制条件
                        </button>
                        <div class="modal " id="exampleModal2" tabindex="-1" role="dialog"
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
            </div>
        </div>
        <div style="height: 150px">

        </div>
    </div>
</div>
<#include "common/js.ftl">
<script>
    let vm = new Vue({
        el: "#vm",
        data: {
            depts: [],
            dept: null,
            majors: [],
            major: null,
            courses: [],
            course: null,
            submitText: "发布课程"
        },
        created: function () {
            let _this = this;
            $.ajax({
                url: "/campus/courseCategory/list",
                type: "get",
                data: {
                    typeCourseCategory: 1
                },
                success: function (data) {
                    if (data.result) {
                        _this.depts = data.data;
                    } else {
                        Messenger().post({
                            id: "error",
                            message: data.msg,//提示信息
                            type: 'error',//消息类型。error、info、success
                            hideAfter: 3,//多长时间消失
                            showCloseButton: true,//是否显示关闭按钮
                            hideOnNavigate: false//是否隐藏导航
                        });
                    }
                }
            });
            //点击展开限制条件
            $(function () {
                $("#seek_major_limit").on('ifChanged', function (event) {
                    $("#seek_major").toggle();
                });
                $("#seek_sex_limit").on('ifChanged', function (event) {
                    $("#seek_sex").toggle();
                });
                $("#seek_grade_limit").on('ifChanged', function (event) {
                    $("#seek_grade").toggle();
                });
                $("#seek_person_num_limit").on('ifChanged', function (event) {
                    $("#seek_person_num").toggle();
                });
                $("#teach_major_limit").on('ifChanged', function (event) {
                    $("#teach_major").toggle();
                });
                $("#teach_sex_limit").on('ifChanged', function (event) {
                    $("#teach_sex").toggle();
                });
                $("#teach_grade_limit").on('ifChanged', function (event) {
                    $("#teach_grade").toggle();
                });
                $("#person_num_limit").on('ifChanged', function (event) {
                    $("#person_num").toggle();
                });
                let bigBox = $('.bigBox');
                bigBox.on('ifChecked', function (event) {
                    $('.all_check').iCheck('check');
                    $('.cancel_all').show();
                });
                bigBox.on('ifUnchecked', function (event) {
                    $('.all_check').iCheck('uncheck');
                    $('.cancel_all').hide();
                });
            });
            $(function () {
                $('.publishForm').bootstrapValidator({
                    message: 'This value is not valid',
                    excluded: [":disabled"],
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    live: 'enabled',
                    fields: {
                        'course.title': {
                            validators: {
                                notEmpty: {
                                    message: '课程标题不能为空',
                                },
                            }
                        },
                        'course.course': {
                            validators: {
                                notEmpty: {
                                    message: '课程不能为空'
                                },
                            }
                        },
                        'course.description': {
                            validators: {
                                notEmpty: {
                                    message: '描述不能为空'
                                }
                            }
                        },
                        'course.payCredits': {
                            validators: {
                                notEmpty: {
                                    message: '悬赏积分不能为空'
                                }
                            }
                        },
                        'course.applyEndTime': {
                            validators: {
                                notEmpty: {
                                    message: '报名截止不能为空'
                                }
                            }
                        },
                        'course.beginTime': {
                            validators: {
                                trigger: "change",
                                notEmpty: {
                                    message: '开课时间不能为空'
                                }
                            }
                        }
                    },
                    submitHandler: function (validator, form, submitButton) {
                        console.log("publish submit");
                    },

                }).on("success.form.bv", function (e) {
                    e.preventDefault();
                    $(e.currentTarget).ajaxSubmit({
                        url: "/campus/course/add",
                        type: "POST",
                        success: function (data) {
                            Messenger().post({
                                id: "messenger",
                                message: data.result ? "您的申请已提交，请耐心等待一到两个工作日。" : "申请提交失败，请检查信息并修改！",//提示信息
                                type: data.result ? 'success' : 'error',//消息类型。error、info、success
                                hideAfter: 3,//多长时间消失
                                showCloseButton: true,//是否显示关闭按钮
                                hideOnNavigate: false//是否隐藏导航
                            });
                        }
                    });
                    setTimeout(function () {
                        window.location.reload();
                    }, 3000);
                });
            })

        },
        watch: {
            dept: function () {
                let _this = this;
                $.ajax({
                    url: "/campus/courseCategory/list",
                    type: "get",
                    data: {
                        parentId: _this.dept,
                    },
                    success: function (data) {
                        if (data.result) {
                            _this.majors = data.data;
                            _this.major = _this.majors[0].id;

                        } else {
                            Messenger().post({
                                id: "error",
                                message: data.msg,//提示信息
                                type: 'error',//消息类型。error、info、success
                                hideAfter: 3,//多长时间消失
                                showCloseButton: true,//是否显示关闭按钮
                                hideOnNavigate: false//是否隐藏导航
                            });
                        }
                    }
                });
            },
            major: function () {
                let _this = this;
                $.ajax({
                    url: "/campus/courseCategory/list",
                    type: "get",
                    data: {
                        parentId: _this.major
                    },
                    success: function (data) {
                        if (data.result) {
                            _this.courses = data.data;
                            _this.course = _this.courses[0].id;
                        } else {
                            Messenger().post({
                                id: "error",
                                message: data.msg,//提示信息
                                type: 'error',//消息类型。error、info、success
                                hideAfter: 3,//多长时间消失
                                showCloseButton: true,//是否显示关闭按钮
                                hideOnNavigate: false//是否隐藏导航
                            });
                        }
                    }
                });
            }
        }
    });
</script>
<#include "common/foot.ftl">