<#include "./common/head.ftl">
<div id="vm">
    <nav class="navbar navbar-expand-lg navbar-dark bg-grayblack-tp90 sticky-top">
        <div class="container">
            <!-- 图标 -->
            <a class="navbar-brand" id="Logo" href="#">
                <img src="/static/image/icon/bootstrap-solid.png" width="30" height="30"
                     class="d-inline-block align-top"
                     alt="Logo">
            </a>
            <!-- 搜索框 -->
            <form class="form-inline my-1 my-lg-0 input-group-sm">
                <input class="form-control mr-sm-1 rounded " type="search" placeholder="Search"
                       aria-label="Search"
                       @keyup.enter="search($event)">
            </form>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler-left"
                    aria-controls="navbarToggler-left" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- 内容 -->
            <div class="collapse navbar-collapse" id="navbarToggler-left">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item ">
                        <a class="nav-link " href="index">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                           data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            Dropdown link
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>

                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="personalMenu"
                           data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            <img class="avatar-small image-fluid rounded" src="/static/image/avatar/Avatar.png"
                                 alt="Avatar">
                        </a>
                        <div class="dropdown-menu" aria-labelledby="personalMenu">
                            <a class="dropdown-item" href="myProfile">MyProfile</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="settings">Settings</a>
                            <a class="dropdown-item" href="#">Help</a>
                            <a class="dropdown-item " href="/logout">Sign out</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container margin-top10" id="principal">
        <div class="row">
            <div class="col col-md-3" id="personal">
                <!-- 个人信息 -->
                <div class="card">
                    <a href="#">
                        <img class="card-img-top" src="/static/image/avatar/Avatar.png"
                             data-toggle="tooltip"
                             data-placement="bottom" title="更换头像"
                             alt="Card image cap">
                    </a>
                    <div class="card-body">
                        <h5 class="card-title font-weight-bold">{{user.nickName}}
                        </h5>
                        <h6 class="card-title font-weight-normal">{{user.username}}</h6>
                        <p class="card-text font-weight-light">{{user.phone}}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Cras justo odio</li>
                    </ul>
                    <div class="card-body">
                        <a href="myProfile" class="card-link">详细信息</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6" id="principal">

            </div>
            <div class="col col-md-2" id="external">

            </div>
        </div>
    </div>
</div>
<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/js/jquery.form.js"></script>
<script src="/static/js/popper.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/vue.js"></script>
<script src="/static/external/HubSpot-messenger/build/js/messenger.js"></script>
<script src="/static/external/pace-master/pace.js"></script>
<script src="/static/external/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="/static/js/main-campus.js"></script>
<script>
    let vm = new Vue({
        el: "#vm",
        data: {
            user: "",

            study: {
                list: []
            },
            teaching: {
                list: []
            },
            other: {
                list: []
            }

        },
        beforeCreate: function () {
            $.ajax({
                url: "/base/user/getUser",
                type: "GET",
                success: function (data) {
                    if (data.result) {
                        vm.user = data.data;
                    }
                }
            });
            $.ajax({
                url: "/campus/course/studyList",
                type: "GET",
                success: function (data) {
                    if (data.result) {
                        vm.study.list = data.data;
                    }
                }
            })
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
            }
        }
    })
</script>
<#include "./common/foot.ftl">