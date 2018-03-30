<#include "./common/head.ftl">
<div id="vm">
    <nav class="navbar navbar-expand-lg navbar-dark bg-grayblack-tp90 sticky-top">
        <div class="container">
            <!-- 图标 -->
            <a class="navbar-brand" id="Logo" href="index">
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
                            <a class="dropdown-item" href="messages">Messages</a>
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
            <h1 class="alert-heading">Teacher Verify</h1>

            <hr width=100% size=1 color=#bbbcbc style="border:1 dashed #bbbcbc">

            <div class="col col-md-2" id="personal">

            </div>
            <div class="col-12 col-md-8" id="principal">
                <div>
                    <form>

                        <div class="form-group">
                            <label for="exampleFormControlSelect1">认证系别</label>
                            <select class="form-control" id="exampleFormControlSelect1">
                                <option v-for="item in departments" value="item.id"
                                        v-text="item.name"></option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">认证专业</label>
                            <select class="form-control" id="exampleFormControlSelect1">
                                <option v-for="item in majors" value="item.id"
                                        v-text="item.name"></option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">认证理由</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">认证文件证明</label>
                            <div class="input-group mb-3">

                                <div class="input-group-prepend">
                                    <button class="btn btn-outline-secondary" type="button">Upload</button>
                                </div>
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="inputGroupFile03">
                                    <label class="custom-file-label" for="inputGroupFile03">Choose file</label>
                                </div>
                            </div>
                        </div>
                        <div align="center" style="height:150px;">
                            <button type="button" class="btn btn-outline-success btn-lg btn-block"
                                    data-toggle="modal" data-target="#myModal">Submit
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
                                            <button type="button" class="btn btn-light" data-dismiss="modal">确定
                                            </button>

                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal -->
                            </div>
                        </div>


                    </form>

                </div>
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
            departments: [],
            majors: []
        },
        beforeCreate: function () {
            $.ajax({
                url: "/campus/major/list",
                data: {
                    typeMajor: 1
                },
                success: function (data) {
                    if (data.result) {
                        vm.departments = data.data;
                    }

                }
            });
            $.ajax({
                url: "/campus/major/list",
                data: {
                    typeMajor: 2
                },
                success: function (data) {
                    if (data.result) {
                        vm.majors = data.data;
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
            }
        }
    })
</script>
<#include "./common/foot.ftl">