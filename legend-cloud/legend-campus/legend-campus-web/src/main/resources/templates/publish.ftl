<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
    <#include "./common/top.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">发布课程</h1>

            <hr width=100% size=1 color=#bbbcbc style="border:1 dashed #bbbcbc">

            <div class="col col-md-2" id="personal">
            ${vm.name}
            </div>
            <div class="col-12 col-md-8" id="principal">
                <form>
                    <div class="form-group" align="center">
                        <h5>课程类型</h5>
                        <label for="male">求学贴</label>
                        <input type="radio" name="sex" id="male" checked="checked"/>

                        <label for="female">教学贴</label>
                        <input type="radio" name="sex" id="female"/>
                    </div>
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
                    <!--分割线-->
                    <div class="dropdown-divider"></div>

                    <div align="center" style="height:150px;">
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
            <div class="col col-md-2" id="external">

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

    /*submit点击后文字改变*/
    function textChange() {
        document.getElementById("dd").innerHTML = "请耐心等待";
    }

</script>
<#include "./common/foot.ftl">