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
                        <h5 class="card-title font-weight-bold" v-text="user.nickName">
                        </h5>
                        <h6 class="card-title font-weight-normal" v-text="user.username"></h6>
                        <p class="card-text font-weight-light" v-text="user.phone"></p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">

                        </li>
                    </ul>
                    <div class="card-body">
                        <a href="/direct/myProfile" class="card-link">详细信息</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6" id="principal">
                <!-- 轮播图 -->
                <div class="carousel slide" id="carouselExampleIndicators" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="/static/image/carousel/first_slide.png" alt="First slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>first</h5>
                                <p>first</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="/static/image/carousel/second_slide.png" alt="Second slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>second</h5>
                                <p>second</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="/static/image/carousel/third_slide.png" alt="Third slide">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>third</h5>
                                <p>third</p>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <!-- 课程列表 -->
                <div class="row-fluid" id="courseList">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="study-tab" data-toggle="tab" href="#study" role="tab"
                               aria-controls="study" aria-selected="true">Study</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="teaching-tab" data-toggle="tab" href="#teaching" role="tab"
                               aria-controls="teaching" aria-selected="false">Teaching</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="other-tab" data-toggle="tab" href="#other" role="tab"
                               aria-controls="other" aria-selected="false">Other</a>
                        </li>
                    </ul>

                    <div class="tab-content" id="courseContent">
                        <!-- first list -->
                        <div class="tab-pane fade show active" id="study" role="tabpanel" aria-labelledby="study-tab">
                            <div class="card" v-for="(item,index) of study.list">
                                <div class="card-header bg-whitesmoke-tp25" :id="'heading-study-'+index">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link" data-toggle="collapse"
                                                :data-target="'#collapse-study-'+index"
                                                aria-expanded="true" :aria-controls="'collapse-study-'+index">
                                            <span v-text="item.title"></span>
                                        </button>
                                    </h5>
                                </div>

                                <div :id="'collapse-study-'+index" class="collapse "
                                     :aria-labelledby="'heading-study-'+index"
                                     data-parent="#study">
                                    <div class="card-body">
                                        <img class="rounded-left cover" src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        <p v-text="item.description"></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- second list -->
                        <div class="tab-pane fade" id="teaching" role="tabpanel" aria-labelledby="teaching-tab">
                            <div class="card">
                                <div class="card-header" id="headingTwo">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link collapsed" data-toggle="collapse"
                                                data-target="#collapseTwo" aria-expanded="false"
                                                aria-controls="collapseTwo">
                                            Second Item
                                        </button>
                                    </h5>
                                </div>
                                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
                                     data-parent="#teaching">
                                    <div class="card-body">
                                        <img class="rounded-left cover" src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        two
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- third list -->
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
                                     data-parent="#other">
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
            <div class="col col-md-2" id="external">
                <div>
                    <a href="#">
                        <button type="button" class="btn btn-info"
                                style="width: 100%;height:50px;font-size:20px;">I want to study！
                        </button>
                    </a>
                </div>
                <div>
                    <a href="#">
                        <button type="button" class="btn btn-info"
                                style="width: 100%;height:50px;font-size:20px;">I want to teach!
                        </button>
                    </a>
                </div>
                <div class="alert alert-success" role="alert">
                    <h4 class="alert-heading">Well done!</h4>
                    <p>Aww yeah, you successfully read this important alert message. This example text is going to
                        run a bit
                        longer so that you can see how spacing within an alert works with this kind of content.</p>
                    <hr>
                    <p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and
                        tidy.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    let vm = new Vue({
        el: "#vm",
        data: {
            user: ${currentUser},

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
                url: "/campus/course/studyList",
                type: "GET",
                success: function (data) {
                    if (data.result) {
                        vm.study.list = data.data;
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
            }
        }
    })
</script>
<#include "./common/foot.ftl">