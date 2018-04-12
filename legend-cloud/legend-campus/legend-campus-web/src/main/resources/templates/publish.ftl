<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "./common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">教师资格认证</h1>
            <hr width=100% size=1 color=#bbbcbc style="border:1dppx dashed #bbbcbc">
            <div class="col col-md-12" id="course">
                <!-- 课程列表 -->
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link <#if !type?? || type=="seek">active</#if>" id="study-tab"
                           data-toggle="tab" href="#study" role="tab"
                           aria-controls="study" aria-selected="true">求学贴</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link <#if type?? && type=="teach">active</#if>" id="teaching-tab"
                           data-toggle="tab" href="#teaching" role="tab"
                           aria-controls="teaching" aria-selected="false">教学贴</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <!-- 求学贴 -->
                    <div class="tab-pane fade <#if !type?? || type=="seek">show active</#if> form-group" id="study"
                         role="tabpanel"
                         aria-labelledby="study-tab">
                        <form @submit.prevent="publish($event)">
                            <div class="col col-md-10">
                            <#--隐藏的课程类型-->
                                <input type="hidden" name="course.typeCourse" value="求学">
                                <!--标题-->
                                <div class="form-group">
                                    <label for="courseTitle">课程标题</label>
                                    <input type="text" class="form-control" id="courseTitle"
                                           name="course.title"
                                           placeholder="标题">
                                </div>
                                <!--系别专业-->
                                <div class="form-group">
                                    <label for="course">课程</label>
                                    <div class="row text-truncate">
                                        <div class="col col-md-4">
                                            <select class="form-control" id="dept"
                                                    v-model="dept" name="course.dept"
                                                    data-toggle="tooltip"
                                                    data-placement="left" title="请选择系别">
                                                <option v-for="item in depts" :value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>
                                        <div class=" col col-md-4">
                                            <select class="form-control" id="major" v-model="major"
                                                    data-toggle="tooltip" name="course.major"
                                                    data-placement="left" title="请选择专业">
                                                <option v-for="item in majors" :value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>
                                        <div class=" col col-md-4">
                                            <select class="form-control" id="course"
                                                    v-model="course" name="course.course"
                                                    data-toggle="tooltip"
                                                    data-placement="left" title="请选择课程">
                                                <option v-for="item in courses" :value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <!--课程描述-->
                                <div class="form-group">
                                    <label for="description">课程描述</label>
                                    <textarea class="form-control" id="description" rows="3"
                                              name="course.description" placeholder="不超过100个字"></textarea>
                                </div>
                                <!--相关备注-->
                                <div class="form-group">
                                    <label for="remark">相关备注</label>
                                    <textarea class="form-control" id="remark" rows="4"
                                              name="course.remark" placeholder="选填"></textarea>
                                </div>
                                <!--悬赏积分-->
                                <div class="form-group">
                                    <label for="payCredits">悬赏积分</label>
                                    <input type="number" class="form-control" id="payCredits"
                                           name="course.payCredits"
                                           :value="1"
                                           min="1"
                                           placeholder="最低悬赏1积分">
                                </div>
                                <!--报名截止时间-->
                                <div class="form-group">
                                    <label for="applyEndTime">截止时间</label>
                                    <div class="input-group date form_datetime"
                                         data-picker-position="top-right">
                                        <input type="text" class="form-control cursor-pointer"
                                               id="applyEndTime"
                                               name="course.applyEndTime"
                                               aria-describedby="expectedApplyEndTimeHelp"
                                               placeholder="报名截止日期"
                                               readonly>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-th"></span></span>
                                    </div>
                                    <small id="expectedApplyEndTimeHelp" class="form-text text-muted">

                                    </small>
                                </div>
                                <!--报名截止时间-->
                                <div class="form-group">
                                    <label for="beginTime">开课时间</label>
                                    <div class="input-group date form_datetime"
                                         data-picker-position="top-right">
                                        <input type="text" class="form-control cursor-pointer"
                                               id="beginTime"
                                               name="course.beginTime"
                                               aria-describedby="expectedBeginTimeHelp"
                                               placeholder="开课时间"
                                               readonly>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-th"></span></span>
                                    </div>
                                    <small id="expectedBeginTimeHelp" class="form-text text-muted">

                                    </small>
                                </div>
                                <!--分割线-->
                                <div class="dropdown-divider"></div>
                                <div align="center" class="col-md-10" style="height:150px;">
                                    <input type="submit" class="btn btn-primary btn-lg btn-block"
                                           v-model="submitText">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- 教学贴 -->
            <div class="tab-pane fade <#if type?? && type=="teach">show active</#if> form-group"
                 id="teaching" role="tabpanel"
                 aria-labelledby="teaching-tab">
            </div>
        </div>
    </div>

</div>
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
        },
        methods: {
            publish: function (e) {
                $(e.currentTarget).find("input[type='submit']").attr("disabled", "disabled");
                vm.submitText = "请耐心等待";
                let _this = this;
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
            }
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

    /*点击展开限制条件*/
    $(document).ready(function () {
        $("#seek_major_limit").click(function () {
            $("#seek_major").toggle();
        });
        $("#seek_sex_limit").click(function () {
            $("#seek_sex").toggle();
        });
        $("#seek_grade_limit").click(function () {
            $("#seek_grade").toggle();
        });
        $("#teach_major_limit").click(function () {
            $("#teach_major").toggle();
        });
        $("#teach_sex_limit").click(function () {
            $("#teach_sex").toggle();
        });
        $("#teach_grade_limit").click(function () {
            $("#teach_grade").toggle();
        });
        $("#person_num_limit").click(function () {
            $("#person_num").toggle();
        });
        $(".hide").click(function () {
            $(".cancel_all").hide();
            $("input").prop("checked", false);
        });

    });
    /*$().ready(function(){
        $('input').iCheck({
            checkboxClass: 'icheckbox_minimal-red',
            radioClass: 'iradio_minimal-red',
            increaseArea: '20%' // optional
        });
    });
    $(".sex_limit").on('ifChanged', function(event){
        $(".sex").toggle();
    });
    $(".grade_limit").on('ifChanged', function(event){
        $(".grade").toggle();
    });
    $(".person_num_limit").on('ifChanged', function(event){
        $(".person_num").toggle();
    });
    $(".hide").on('ifChecked', function(event){ //ifCreated 事件应该在插件初始化之前绑定
        $(".cancel_all").hide();
        $('input').iCheck("checked", false);
    });*/
    /*submit点击后文字改变*/
    function textChange() {
        document.getElementById("dd").innerHTML = "请耐心等待";
    }

</script>
<#include "./common/foot.ftl">