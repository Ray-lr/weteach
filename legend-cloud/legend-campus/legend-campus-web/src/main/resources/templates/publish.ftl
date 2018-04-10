<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "./common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <div class="col">
                <h1 class="alert-heading">发布课程</h1>
            </div>
            <hr width=100% size=1 color=#bbbcbc style="border:1px
             dashed #bbbcbc">
        </div>
        <div class="row">
            <div class="col-12 col-md-12" id="course">
                <!-- 课程列表 -->
                <div class="row-fluid" id="courseList">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="study-tab" data-toggle="tab" href="#study" role="tab"
                               aria-controls="study" aria-selected="true">求学贴</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="teaching-tab" data-toggle="tab" href="#teaching" role="tab"
                               aria-controls="teaching" aria-selected="false">教学贴</a>
                        </li>
                    </ul>

                    <div class="tab-content">
                        <!-- first list -->
                        <div class="tab-pane fade show active form-group" id="study" role="tabpanel"
                             aria-labelledby="study-tab">
                            <form @submit.prevent="publish($event)">
                                <div class="col col-md-10">
                                    <div class="row">
                                        <div class="col col-md-8">
                                            <!--标题-->
                                            <div class="form-group">
                                                <label for="courseTitle">课程标题</label>
                                                <input type="email" class="form-control" id="courseTitle">
                                            </div>
                                            <!--系别专业-->
                                            <div class="form-group">
                                                <label for="exampleFormControlSelect1">系/专业</label>
                                                <div class="row">
                                                    <div class="col col-md-8">
                                                        <select class="form-control" id="department"
                                                                @change="changeDepartment"
                                                                data-toggle="tooltip"
                                                                data-placement="left" title="请选择系别">
                                                            <option selected="selected" value="0"
                                                                    id="departmentOption" disabled>--
                                                                请选择系别
                                                                --
                                                            </option>
                                                            <option v-for="item in departments" :value="item.id"
                                                                    v-text="item.name"></option>
                                                        </select>
                                                    </div>
                                                    <div class=" col col-md-8" v-show="">
                                                        <select class="form-control" id="exampleFormControlSelect1"
                                                                data-toggle="tooltip"
                                                                data-placement="left" title="请选择专业">
                                                            <option selected="selected" value="0" id="majorOption"
                                                                    disabled>--
                                                                请选择专业 --
                                                            </option>
                                                            <option v-for="item in majors" :value="item.id"
                                                                    v-text="item.name"></option>
                                                        </select>
                                                    </div>
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
                                            <!--相关限制条件-->
                                            <div class="form-group">
                                                <!--预计发布时间-->
                                                <label for="dateTime">预计发布时间</label>
                                                <div class="input-group date form_datetime">
                                                    <input type="text" class="form-control" id="dateTime"
                                                           name="publishTime"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="请输入预计发布时间"
                                                           aria-describedby="expectedPublishTimeHelp"
                                                           placeholder="Date Time"
                                                           readonly>
                                                    <span class="input-group-addon"><span
                                                            class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                                <small id="expectedPublishTimeHelp" class="form-text text-muted">

                                                </small>
                                            </div>
                                            <!--预计结课时间-->
                                            <div class="form-group">
                                                <label for="dateTime">预计结课时间</label>
                                                <div class="input-group date form_datetime">
                                                    <input type="text" class="form-control" id="dateTime"
                                                           name="finishTime"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="请输入预计结课时间"
                                                           aria-describedby="finishTimeHelp" placeholder="Date Time"
                                                           readonly>
                                                    <span class="input-group-addon"><span
                                                            class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                                <small id="finishTimeHelp" class="form-text text-muted">

                                                </small>
                                            </div>
                                            <!--分割线-->
                                            <div class="dropdown-divider"></div>
                                            <div align="center" class="col-md-10" style="height:150px;">
                                                <input type="submit" class="btn btn-primary btn-lg btn-block"
                                                       v-model="submitText">
                                            </div>
                                        </div>
                                        <div class="col col-md-3" id="courseLimit">
                                            <div class="alert alert-danger" role="alert">
                                                <h4 class="alert-heading">报名人员限制</h4>
                                                <!--专业限制-->
                                                <h5>专业限制
                                                    <input type="checkbox"
                                                           aria-label="Checkbox for following text input"
                                                           id="major_limit" name="a"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="专业限制">
                                                </h5>
                                                <div class="form-group cancel_all" id="major" style="display: none">
                                                    <label for="courseTime">系别</label>
                                                    <select class="form-control" id="department"
                                                            @change="changeDepartment"
                                                            data-toggle="tooltip"
                                                            data-placement="left" title="请选择系别">
                                                        <option selected="selected" id="departmentOption">-- 请选择系别 --
                                                        </option>
                                                        <option v-for="item in departments" :value="item.id"
                                                                v-text="item.name"></option>
                                                    </select>
                                                    <label for="courseTime">专业</label>
                                                    <select class="form-control" id="exampleFormControlSelect1"
                                                            data-toggle="tooltip"
                                                            data-placement="left" title="请选择专业">
                                                        <option selected="selected" id="majorOption">-- 请选择专业 --
                                                        </option>
                                                        <option v-for="item in majors" :value="item.id"
                                                                v-text="item.name"></option>
                                                    </select>
                                                </div>
                                                <div class="dropdown-divider"></div>
                                                <!--性别限制-->
                                                <h5>性别限制
                                                    <input type="checkbox"
                                                           aria-label="Checkbox for following text input"
                                                           id="sex_limit" name="a"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="性别限制">
                                                </h5>
                                                <div class="form-group cancel_all" align="center" id="sex"
                                                     style="display: none;">
                                                    <label for="male">男</label>
                                                    <input type="radio" name="sex" id="male" checked/>

                                                    <label for="female">女</label>
                                                    <input type="radio" name="sex" id="female"/>
                                                </div>
                                                <div class="dropdown-divider"></div>
                                                <!--年级限制-->
                                                <h5>年级限制
                                                    <input type="checkbox"
                                                           aria-label="Checkbox for following text input"
                                                           id="grade_limit" name="a"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="年级限制">
                                                </h5>
                                                <div class="form-group cancel_all" id="grade" style="display: none;">
                                                    <select class="form-control" id="exampleFormControlSelect1"
                                                            name="enrollmentYear">
                                                        <option>大学一年级</option>
                                                        <option>大学二年级</option>
                                                        <option>大学三年级</option>
                                                        <option>大学四年级</option>
                                                    </select>
                                                </div>
                                                <div class="dropdown-divider"></div>
                                                <!--人数限制-->
                                                <h5>人数限制
                                                    <input type="checkbox"
                                                           aria-label="Checkbox for following text input"
                                                           id="person_num_limit" name="a"
                                                           data-toggle="tooltip"
                                                           data-placement="left" title="人数限制">
                                                </h5>
                                                <div id="person_num" class="form-group cancel_all"
                                                     style="display: none;">
                                                    <div class="form-group">
                                                        <label for="courseTime"></label>
                                                        <input type="number" min="0" class="form-control"
                                                               data-toggle="tooltip"
                                                               data-placement="left" title="请输入人数上限">
                                                        <label for="courseTime"></label>~
                                                        <input type="number" min="0" class="form-control"
                                                               data-toggle="tooltip"
                                                               data-placement="left" title="请输入人数下限">
                                                    </div>
                                                </div>
                                                <div class="dropdown-divider"></div>
                                                <button type="button" class="btn btn-danger" id="hide"
                                                        style="width: 100%;height:35px;font-size:15px;">全部取消
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- second list -->
                        <div class="tab-pane fade form-group" id="teaching" role="tabpanel"
                             aria-labelledby="teaching-tab">

                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script>
    let vm = new Vue({
        el: "#vm",
        data: {
            departments: [],
            majors: [],
            submitText: "发布课程"
        },
        beforeCreate: function () {
            $.ajax({
                url: "/campus/major/list",
                type: "get",
                data: {
                    typeMajor: 1
                },
                success: function (data) {
                    if (data.result) {
                        vm.departments = data.data;
                    }

                }
            });
        },
        methods: {
            search: function (e) {
                alert($(e.currentTarget).val());
            },
            SignOut: function () {
                $.ajax({
                    url: "/base/user/logout",
                    type: "POST",
                    data: {
                        _method: "PUT"
                    },
                    success: function (data) {
                        if (data.result) {
                            window.location.href = data.url;
                        }
                    }
                })
            },
            changeDepartment: function (e) {
                $.ajax({
                    url: "/campus/major/list",
                    type: "get",
                    data: {
                        deptId: e.target.value
                    },
                    success: function (data) {
                        if (data.result) {
                            vm.majors = data.data;
                            $("#majorOption").prop("selected", "selected");
                        }
                    }
                })
            },
            publish: function (e) {
                $(e.currentTarget).find("input[type='submit']").attr("disabled", "disabled");
                Messenger().post({
                    id: "messenger",
                    message: "您的申请已提交，请耐心等待一到两个工作日。",//提示信息
                    type: "info",//消息类型。error、info、success
                    hideAfter: 5,//多长时间消失
                    showCloseButton: true,//是否显示关闭按钮
                    hideOnNavigate: false//是否隐藏导航
                });
                vm.submitText = "请耐心等待";
            }

        }
    });


    $("").validate({
        submitHandler: function () {

        }
    });



    /*根据不同链接的传值选取课程类型*/
    var typeCourse = window.location.search;
    $(document).ready(function () {
        if (typeCourse == "?seek") {
            $("#seek").prop("checked", true);
        }
        if (typeCourse == "?teach") {
            $("#teach").prop("checked", true);
        }
    });
    /*submit点击后不可选取*/
    $().ready(function () {
        $("#qd").click(function () {
            $("#dd").addClass('diabled');
            $("#dd").prop('disabled', true);
        });
    });
    /*点击展开限制条件*/
    $(document).ready(function () {
        $("#seek").ready(function () {
            if (typeCourse == "?1") {
                $("#seek").prop("checked", true);
            }
            if (typeCourse == "?2") {
                $("#teach").prop("checked", true);
            }
        });
        $("#major_limit").click(function () {
            $("#major").toggle();
        });
        $("#sex_limit").click(function () {
            $("#sex").toggle();
        });
        $("#grade_limit").click(function () {
            $("#grade").toggle();
        });
        $("#person_num_limit").click(function () {
            $("#person_num").toggle();
        });
        $("#hide").click(function () {
            $(".cancel_all").hide();
            $("input").prop("checked", false);
        });
    });

    /*submit点击后文字改变*/
    function textChange() {
        document.getElementById("dd").innerHTML = "请耐心等待";
    }

</script>
<#include "./common/foot.ftl">