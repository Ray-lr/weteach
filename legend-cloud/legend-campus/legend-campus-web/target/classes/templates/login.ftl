<#include "./common/head.ftl">
<div id="vm">
    <div class="jumbotron jumbotron-fluid align-items-center">
        <div class="container-fluid ">
            <div class="container ">
                <h1 class="display-4">欢迎来到校园学生互助系统!</h1>
                <p class="lead " align="center">
                    请先登录
                </p>
            </div>
            <hr class="my-4">
            <div class="container">
                <div class="row justify-content-end">
                    <div class="col-4 ">
                        <form @submit.prevent="login($event)">
                            <div class="form-group">
                                <label for="username">用户名</label>
                                <input type="text" class="form-control" id="username"
                                       v-model="username" name="username"
                                <#--正则表达式禁止输入汉字和特殊符号，粘贴也不行-->
                                       onkeyup="value=value.replace(/[\W]/g,'') "
                                       onbeforepaste="clipboardData.setData
                                       ('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
                                       data-toggle="tooltip"
                                       data-placement="left" title="请输入有效的用户名"
                                       aria-describedby="usernameHelp" placeholder="Enter Username">
                                <small id="usernameHelp" class="form-text text-muted">

                                </small>
                            </div>
                            <div class="form-group">
                                <label for="password">密码</label>
                                <input type="password" class="form-control" id="password"
                                       v-model="password" name="password"
                                       data-toggle="tooltip"
                                       data-placement="left" title="请输入密码"
                                       aria-describedby="passwordHelp" placeholder="Password">
                                <small id="passwordHelp" class="form-text text-muted">

                                </small>
                            </div>
                            <div class="form-group">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" id="gridCheck" checked="checked"
                                           name="rememberMe">
                                    <label class="form-check-label" for="gridCheck">
                                        记住我
                                    </label>
                                </div>
                            </div>

                            <div class="btn-group">
                                <button class="btn btn-primary" type="submit">
                                    登录
                                </button>
                                <button type="button"
                                        class="btn btn-primary dropdown-toggle dropdown-toggle-split"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="sr-only">Toggle Dropdown</span>
                                </button>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#" @click="changeHost('user')">普通用户</a>
                                    <a class="dropdown-item" href="#" @click="changeHost('admin')">管理员</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    let vm = new Vue({
        el: "#vm",
        contentType:"application/json;charset=utf-8",
        data: {
            username: null,
            password: null,
            host: "base"
        },
        methods: {
            login: function (e) {
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
            },
            changeHost: function (host) {
                vm.host = host;
            }
        }
    });
</script>
<#include "./common/foot.ftl">