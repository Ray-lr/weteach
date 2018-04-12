<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">教师资格认证</h1>

            <hr width=100% size=1 color=#bbbcbc style="border:1dppx dashed #bbbcbc">

            <div class="col-12 col-md- align-content-center" id="principal">
                <form @submit.prevent="verify($event)">
                    <div class="form-group">
                        <label for="course">认证课程</label>
                        <div class="row">
                            <div class="col col-md-4">
                                <select class="form-control" id="dept" name="dept"
                                        data-toggle="tooltip"
                                        data-placement="bottom" title="">
                                    <option selected="selected" id="departmentOption">-- 请选择系别 --</option>
                                    <option v-for="item in departments" :value="item.id"
                                            v-text="item.name"></option>
                                </select>
                            </div>
                            <div class="col col-md-4">
                                <select class="form-control" id="major" name="major"
                                        data-toggle="tooltip"
                                        data-placement="bottom" title="">
                                    <option selected="selected" id="majorOption">-- 请选择专业 --</option>
                                    <option v-for="item in majors" :value="item.id"
                                            v-text="item.name"></option>
                                </select>
                            </div>
                            <div class="col col-md-4">
                                <select class="form-control" id="course" name="course"
                                        data-toggle="tooltip"
                                        data-placement="bottom" title="">
                                    <option selected="selected" id="courseOption">-- 请选择课程 --</option>
                                    <option v-for="item in courses" :value="item.id"
                                            v-text="item.name"></option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">认证理由</label>
                        <textarea name="reason" class="form-control" id="exampleFormControlTextarea1"
                                  rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleFormControlTextarea1">认证文件证明</label>
                        <div class="input-group mb-3">

                            <div class="input-group-prepend">
                                <button class="btn btn-outline-secondary" type="button" @click="upload">上传</button>
                            </div>
                            <div class="custom-file">
                                <input name="evidence" type="file" class="custom-file-input" id="inputGroupFile03">
                                <label class="custom-file-label" for="inputGroupFile03">选择文件</label>
                            </div>
                        </div>
                    </div>
                    <div align="center" style="height:150px;">
                        <button id="dd" type="submit" class="btn btn-success btn-lg btn-block"
                                data-toggle="modal" data-target="#examineMessage" v-text="submit">提交申请
                        </button>
                    </div>
                </form>
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
            courses: [],
            submit: "提交申请"
        },
        beforeCreate: function () {
            $.ajax({
                url: "/campus/courseCategory/list",
                type: "get",
                data: {
                    typeCourseCategory: 1
                },
                success: function (data) {
                    if (data.result) {
                        vm.departments = data.data;
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
            verify: function (e) {
                $(e.currentTarget).ajaxSubmit({
                    url: "/campus/verify/add",
                    type: "post",
                    data: {
                        userId: vm.user.id
                    },
                    success: function (data) {
                        Messenger().post({
                            id: "error",
                            message: data.msg,//提示信息
                            type: data.result ? 'success' : 'error',//消息类型。error、info、success
                            hideAfter: 3,//多长时间消失
                            showCloseButton: true,//是否显示关闭按钮
                            hideOnNavigate: false//是否隐藏导航
                        });
                        setTimeout(function () {
                            window.location.reload();
                        }, 3000);
                    }
                })
            }
        }
    });
</script>
<#include "./common/foot.ftl">