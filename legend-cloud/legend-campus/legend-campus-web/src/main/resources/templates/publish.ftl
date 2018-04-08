<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
    <#include "./common/top.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">发布课程</h1>

            <hr width=100% size=1 color=#bbbcbc style="border:1 dashed #bbbcbc">

            <div class="col col-md-1" id="personal">

            </div>
            <div class="col col-md-10" id="principal">
                <form>
                    <div class="form-group" align="center">
                        <h3>课程类型</h3>
                        <label for="male">求学贴</label>
                        <input type="radio" name="sex" id="male" checked="checked"/>

                        <label for="female">教学贴</label>
                        <input type="radio" name="sex" id="female"/>
                    </div>
                    <div class="row">
                        <div class="col-md-7">
                            <!--标题-->
                            <div class="form-group">
                                <label for="courseTitle">课程标题</label>
                                <input type="email" class="form-control" id="courseTitle">
                            </div>
                            <!--系别专业-->
                            <div class="form-group">
                                <label for="exampleFormControlSelect1">系/专业</label>
                                <div class="row">
                                    <div class="col-md-6">
                                        <select class="form-control" id="department" @change="changeDepartment">
                                            <option selected="selected" id="departmentOption">-- 请选择系别 --</option>
                                            <option v-for="item in departments" :value="item.id"
                                                    v-text="item.name"></option>
                                        </select>
                                    </div>
                                    <div class="col-md-6">
                                        <select class="form-control" id="exampleFormControlSelect1">
                                            <option selected="selected" id="majorOption">-- 请选择专业 --</option>
                                            <option v-for="item in majors" :value="item.id"
                                                    v-text="item.name"></option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <!--课程描述-->
                            <div class="form-group">
                                <label for="exampleFormControlTextarea1">课程描述</label>
                                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                            </div>
                            <!--相关备注-->
                            <div class="form-group">
                                <label for="exampleFormControlTextarea1">相关备注</label>
                                <textarea class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
                            </div>
                            <!--课时节数-->
                            <div class="form-group">
                                <label for="courseTime">预计课时节数</label>
                                <input type="email" class="form-control" id="courseTime">
                            </div>
                            <!--相关限制条件-->
                            <!--预计发布时间-->
                            <label for="dateTime">预计发布时间</label>
                            <div class="input-group date form_datetime">
                                <input type="text" class="form-control" id="dateTime"
                                       name="dateTime"
                                       data-toggle="tooltip"
                                       data-placement="left" title="请输入日期"
                                       aria-describedby="dateTimeHelp" placeholder="Date Time"
                                       readonly>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                            </div>
                            <small id="dateTimeHelp" class="form-text text-muted">

                            </small>
                            <!--预计结课时间-->
                            <label for="dateTime">预计结课时间</label>
                            <div class="input-group date form_datetime">
                                <input type="text" class="form-control" id="dateTime"
                                       name="dateTime"
                                       data-toggle="tooltip"
                                       data-placement="left" title="请输入日期"
                                       aria-describedby="dateTimeHelp" placeholder="Date Time"
                                       readonly>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                            </div>
                            <small id="dateTimeHelp" class="form-text text-muted">

                            </small>

                        </div>
                        <div class="col col-md-3">
                            <div class="alert alert-danger" role="alert">

                                <h4 class="alert-heading">报名人员限制</h4>

                                <!--专业限制-->
                                <h5>专业限制
                                    <input type="checkbox" aria-label="Checkbox for following text input"
                                           id="major_limit">
                                </h5>
                                <div class="form-group cancel_all" id="major" style="display: none">
                                    <label for="courseTime">系别</label>
                                    <select class="form-control" id="department" @change="changeDepartment">
                                        <option selected="selected" id="departmentOption">-- 请选择系别 --</option>
                                        <option v-for="item in departments" :value="item.id"
                                                v-text="item.name"></option>
                                    </select>
                                    <label for="courseTime">专业</label>
                                    <select class="form-control" id="exampleFormControlSelect1">
                                        <option selected="selected" id="majorOption">-- 请选择专业 --</option>
                                        <option v-for="item in majors" :value="item.id"
                                                v-text="item.name"></option>
                                    </select>
                                </div>
                                <div class="dropdown-divider"></div>
                                <!--性别限制-->
                                <h5>性别限制
                                    <input type="checkbox" aria-label="Checkbox for following text input"
                                           id="sex_limit">
                                </h5>
                                <div class="form-group cancel_all" align="center" id="sex" style="display: none;">
                                    <label for="male">男</label>
                                    <input type="radio" name="sex" id="male" checked/>

                                    <label for="female">女</label>
                                    <input type="radio" name="sex" id="female"/>
                                </div>
                                <div class="dropdown-divider"></div>
                                <!--年级限制-->
                                <h5>年级限制
                                    <input type="checkbox" aria-label="Checkbox for following text input"
                                           id="grade_limit">
                                </h5>
                                <div class="form-group cancel_all" id="grade" style="display: none;">
                                    <select class="form-control" id="exampleFormControlSelect1" name="enrollmentYear">
                                        <option>大学一年级</option>
                                        <option>大学二年级</option>
                                        <option>大学三年级</option>
                                        <option>大学四年级</option>
                                    </select>
                                </div>
                                <div class="dropdown-divider"></div>
                                <!--人数限制-->
                                <h5>人数限制
                                    <input type="checkbox" aria-label="Checkbox for following text input"
                                           id="person_num_limit">
                                </h5>
                                <div id="person_num" class="form-group cancel_all" style="display: none;">
                                    <div class="form-group">
                                        <label for="courseTime">人数上限</label>
                                        <input type="email" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="courseTime">人数下限</label>
                                        <input type="email" class="form-control">
                                    </div>
                                </div>
                                <div class="dropdown-divider"></div>
                                <button type="button" class="btn btn-danger" id="hide"
                                        style="width: 100%;height:35px;font-size:15px;">全部取消
                                </button>
                            </div>
                        </div>
                    </div>
                    <!--分割线-->
                    <div class="dropdown-divider"></div>

                    <div align="center" class="col-md-10" style="height:150px;">
                        <button id="dd" type="button" class="btn btn-primary btn-lg btn-block"
                                data-toggle="modal" data-target="#myModal" onclick="textChange()">发布课程
                        </button>
                        <!-- 模态框（Modal） -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">

                                        <h4 class="modal-title" id="myModalLabel">
                                            提示
                                        </h4>
                                    </div>
                                    <div class="modal-body">
                                        您的申请已提交，请耐心等待一到两个工作日，我们会在第一时间给您消息，谢谢。
                                    </div>
                                    <div class="modal-footer">
                                        <button id="qd" type="button" class="btn btn-light" data-dismiss="modal">确定
                                        </button>

                                    </div>
                                </div><!-- /.modal-content -->
                            </div><!-- /.modal -->
                        </div>
                    </div>
                </form>

            </div>
            <div class="col col-md-1" id="external">

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
        created: function () {
        },
        updated: function () {
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
        }
    })
    /*submit点击后不可选取*/
    $(document).ready(function () {
        $("#qd").click(function () {
            $("#dd").addClass('diabled');
            $("#dd").prop('disabled', true);
        });
    });
    /*点击展开限制条件*/
    $(document).ready(function () {
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