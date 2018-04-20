<#include "common/head.ftl">
<div id="vm">
    <div class="jumbotron jumbotron-fluid align-items-center">
        <div class="page-header ">
            <div class="container ">
                <h1 class="display-4">欢迎来到校园学生互助系统!</h1>
            </div>
            <hr class="my-4">
            <div class="container ">
                <div class="row justify-content-end">
                    <div class="col-lg-4">
                        <form id="loginForm" class="form-horizontal font-weight-bold text-left ">
                            <div class="row form-group ">
                                <label class="col-lg-3 col-3 control-label text-lg-right " for="username">用户名</label>
                                <div class="col-lg-9 col-12">
                                    <input type="text" class="form-control" id="username"
                                           v-model="username" name="username"
                                           placeholder="Enter Username">
                                </div>
                            </div>
                            <div class="row form-group">
                                <label class="col-lg-3 col-3 control-label text-lg-right" for="password">密码</label>
                                <div class="col-lg-9 col-12">
                                    <input type="password" class="form-control" id="password"
                                           v-model="password" name="password"
                                           placeholder="Enter Password">
                                </div>
                            </div>
                            <div class="row form-group">
                                <label class="col-sm-3 col-3 form-label text-lg-right" for="rememberMe">记住我</label>
                                <div class="col-1 col-1 form-check">
                                    <input class="form-check-input" type="checkbox" id="rememberMe" checked="checked"
                                           name="rememberMe">
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-lg-4 offset-lg-3 col-12">
                                    <button type="submit" class="btn btn-primary">Sign up</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "common/js.ftl">
<script>
    let vm = new Vue({
        el: "#vm",
        contentType: "application/json;charset=utf-8",
        data: {
            username: null,
            password: null,
            host: "base"
        },
        created: function () {
            $(function () {
                $('#loginForm').bootstrapValidator({
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    live: 'enabled',
                    fields: {
                        username: {
                            validators: {
                                notEmpty: {
                                    message: '用户名不能为空'
                                },
                                regexp: {
                                    regexp: /^[a-zA-Z0-9_\.]+$/,
                                    message: '用户名只能由字母，数字，\'.\'和\'_\'组成'
                                }
                            }
                        },
                        password: {
                            validators: {
                                notEmpty: {
                                    message: '密码不能为空'
                                }
                            }
                        }
                    },
                    submitHandler: function (validator, form, submitButton) {
                        console.log("login submit");
                    },

                }).on("success.form.bv", function (e) {
                    e.preventDefault();
                    $(e.currentTarget).ajaxSubmit({
                        url: "/" + vm.host + "/user/login",
                        type: "post",
                        success: function (data) {
                            Messenger().post({
                                id: "loginMessenger",
                                message: data.msg,//提示信息
                                type: data.result ? 'success' : 'error',//消息类型。error、info、success
                                hideAfter: 2,//多长时间消失
                                showCloseButton: true,//是否显示关闭按钮
                                hideOnNavigate: false//是否隐藏导航
                            });
                            setTimeout(function () {
                                window.location.href = data.url;
                            }, 2000);

                        }
                    });
                });
            })
        }
    });


</script>
<#include "common/foot.ftl">