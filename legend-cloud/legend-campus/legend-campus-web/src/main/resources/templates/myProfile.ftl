<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录</title>
    <meta content="text/html" charset="utf-8">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.css" media="screen">
    <link rel="stylesheet" href="/static/external/HubSpot-messenger/build/css/messenger.css" media="screen">
    <link rel="stylesheet" href="/static/external/HubSpot-messenger/build/css/messenger-theme-air.css" media="screen">
    <link rel="stylesheet" href="/static/external/pace-master/themes/black/pace-theme-material.css" media="screen">
    <link rel="stylesheet" href="/static/external/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css"
          media="screen">
    <link rel="stylesheet" href="/static/css/main-campus.css" media="screen">
</head>
<body>
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
                        <h5 class="card-title font-weight-bold">
                        </h5>
                        <h6 class="card-title font-weight-normal"></h6>
                        <p class="card-text font-weight-light"></p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Cras justo odio</li>
                    </ul>
                    <div class="card-body">
                        <a href="#" class="card-link">Card link</a>
                    </div>

                </div>
                <div align="center">
                    <a href="verify">
                        <button type="button" class="btn btn-outline-success"
                                style="width: 100%;height:50px;font-size:20px;">我想当老师！
                        </button>
                    </a>
                </div>
            </div>
            <div class="col-12 col-md-8" id="principal">

                <!-- 课程列表 -->
                <div class="row-fluid" id="courseList">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="study-tab" data-toggle="tab" href="#study" role="tab"
                               aria-controls="study" aria-selected="true">我的课程相关</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="teaching-tab" data-toggle="tab" href="#teaching" role="tab"
                               aria-controls="teaching" aria-selected="false">个人信息中心</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="other-tab" data-toggle="tab" href="#other" role="tab"
                               aria-controls="other" aria-selected="false">浏览历史</a>
                        </li>
                    </ul>

                    <div class="tab-content" id="courseContent">
                        <!-- first list -->
                        <!--我的课程相关-->
                        <div class="tab-pane fade show active" id="study" role="tabpanel" aria-labelledby="study-tab">
                            <div class="card">
                                <div class="card-header bg-whitesmoke-tp25" id="headingOne">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne"
                                                aria-expanded="true" aria-controls="collapseOne">
                                            First Item
                                        </button>
                                    </h5>
                                </div>

                                <div id="collapseOne" class="collapse " aria-labelledby="headingOne"
                                     data-parent="#accordion">
                                    <div class="card-body">
                                        <img class="rounded-left cover" src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        aaa
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- second list -->
                        <!-- 个人信息完善 -->
                        <div class="tab-pane fade" id="teaching" role="tabpanel" aria-labelledby="teaching-tab">
                            <form>
                                <!--真实姓名-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">True name</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput1">
                                </div>
                                <!-- 真实性别 -->
                                <div class="form-group">

                                    <label for="male">Male</label>
                                    <input type="radio" name="sex" id="male"/>

                                    <label for="female">Female</label>
                                    <input type="radio" name="sex" id="female"/>
                                </div>
                                <!--真实年龄-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput2">True age</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput2"
                                           placeholder="18">
                                </div>
                                <!--电话号码-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput3">Mobile phone</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput3"
                                           placeholder="1XX-XXXX-XXXX">
                                </div>
                                <!--QQ号码-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput4">QQ number</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput4"
                                           placeholder="name@example.com">
                                </div>
                                <!--邮箱-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput5">Email address</label>
                                    <input type="email" class="form-control" id="exampleFormControlInput5"
                                           placeholder="name@example.com">
                                </div>

                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Recipient's username"
                                           aria-label="Recipient's username" aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <span class="input-group-text" id="basic-addon2">@example.com</span>
                                    </div>
                                    <div class="input-group-append">
                                        <button type="button"
                                                class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split"
                                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <span class="sr-only">Toggle Dropdown</span>
                                        </button>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" href="#">@163.com</a>
                                            <a class="dropdown-item" href="#">@126.com</a>
                                            <a class="dropdown-item" href="#">@qq.com</a>
                                            <div role="separator" class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">another email</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- 籍贯 -->
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">Hometown</label>
                                    <!-- 省份 -->
                                    <div class="input-group ">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text" for="inputGroupSelect01">-- 省份 --</label>
                                        </div>
                                        <select class="custom-select" id="inputGroupSelect01">
                                            <option v-for="item in provinces" value="item.id" v-text="item.name"></option>
                                        </select>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <select class="form-control" id="province">
                                                <option>-- 省/直辖市/自治区 --</option>
                                                <option v-for="item in provinces" value="item.id"
                                                        v-text="item.name"></option>

                                            </select>
                                        </div>
                                        <!-- 市/州 -->
                                        <div class="col-md-4">
                                            <select class="form-control" id="city">
                                                <option>-- 市/自治州 --</option>
                                                <option v-for="item in cities" value="item.id"
                                                        v-text="item.name"></option>

                                            </select>
                                        </div>
                                        <!-- 区/县 -->
                                        <div class="col col-md-4">
                                            <select class="form-control" id="county">
                                                <option>-- 区/县 --</option>
                                                <option v-for="item in counties" value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlSelect2">Example multiple select</label>
                                    <!--<select multiple class="form-control" id="exampleFormControlSelect2">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                    </select>-->
                                    <select class="custom-select" id="inputGroupSelect03">
                                        <option selected>Choose...</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1">个性签名</label>
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                                </div>
                                <div align="center" style="height:150px;">
                                    <button type="button" class="btn btn-outline-primary btn-lg btn-block">Submit
                                    </button>
                                </div>
                            </form>
                        </div>
                        <!--浏览历史-->
                        <div class="tab-pane fade" id="other" role="tabpanel" aria-labelledby="other-tab">
                            <div class="card">
                                <div class="card-header" id="headingThree">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link collapsed" data-toggle="collapse"
                                                data-target="#collapseThree" aria-expanded="false"
                                                aria-controls="collapseThree">
                                            Third Item
                                        </button>
                                    </h5>
                                </div>
                                <div id="collapseThree" class="collapse" aria-labelledby="headingThree"
                                     data-parent="#accordion">
                                    <div class="card-body">
                                        <img class="rounded-left cover" src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        three
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
            },
            provinces: [],
            cities: [],
            counties: []
        },
        beforeCreate: function () {
            $.ajax({
                url: "/base/areas/list",
                data: {
                    typeAreas: 1
                },
                success: function (data) {
                    if (data.result) {
                        vm.provinces = data.data;
                    }

                }
            });
            $.ajax({
                url: "/base/areas/list",
                data: {
                    typeAreas: 2
                },
                success: function (data) {
                    if (data.result) {
                        vm.cities = data.data;
                    }
                }
            });
            /*$.ajax({
                url: "/base/areas/list",
                data: {
                    typeAreas: 3
                },
                success: function (data) {
                    if (data.result) {
                        vm.counties = data.data;
                    }
                }
            });*/
        },
        created: function () {
        },
        updated: function () {
        },
        methods: {
            search: function (e) {
                alert($(e.currentTarget).val());
            }
        }
    })
</script>
</body>
</html>