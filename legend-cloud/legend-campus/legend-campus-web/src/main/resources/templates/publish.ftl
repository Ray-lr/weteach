<#include "./common/head.ftl">
<#-- 宏 -->
<#import "common/macro/modal.ftl" as modal>
<div id="vm">
    <!--顶部功能栏-->
<#include "./common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">发布课程</h1>

            <hr width=100% size=1 color=#bbbcbc style="border:1 dashed #bbbcbc">

            <div class="col col-md-2" id="personal">
            ${vm.name}
            </div>
            <div class="col-12 col-md-8" id="principal">
                <form @submit.prevent="publish($event)">
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
                                <select class="form-control" id="department" @change="changeDepartment"
                                        data-toggle="tooltip"
                                        data-placement="left" title="请选择系别">
                                    <option selected="selected" id="departmentOption">-- 请选择系别 --</option>
                                    <option v-for="item in departments" :value="item.id"
                                            v-text="item.name"></option>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <select class="form-control" id="exampleFormControlSelect1"
                                        data-toggle="tooltip"
                                        data-placement="left" title="请选择专业">
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
                        <input type="submit" class="btn btn-primary btn-lg btn-block" v-model="submitText">
                    </div>
                </form>

            </div>
            <div class="col col-md-2 " id="external">

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
            publish: function (e) {
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

</script>
<#include "./common/foot.ftl">