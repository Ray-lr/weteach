<#include "common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row justify-content-md-center">
        <#include "common/component/personal-leftSide.ftl">
            <div class="col-12 col-md-6">
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
                               aria-controls="study" aria-selected="true">求学课程</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="teaching-tab" data-toggle="tab" href="#teaching" role="tab"
                               aria-controls="teaching" aria-selected="false">教学课程</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="myCourses-tab" data-toggle="tab" href="#myCourses" role="tab"
                               aria-controls="myCourses" aria-selected="false">我的课程</a>
                        </li>
                    </ul>

                    <div class="tab-content" id="courseContent">
                        <!-- 求学帖 -->
                        <div class="tab-pane fade show active" id="study" role="tabpanel" aria-labelledby="study-tab">
                            <!--first demonstration-->
                            <div class="card" v-for="(item,index) of study.list">
                                <div class="card-header bg-whitesmoke-tp25"
                                     :id="'heading-'+(study.pagination.pageSize*(study.pagination.currentPage-1)+index)">
                                    <h5 class="mb-0 d-flex justify-content-between">
                                        <button class="btn btn-link text-truncate w-75 non-text-dec font-weight-bold"
                                                data-toggle="collapse" v-text="item.title"
                                                :data-target="'#study-'+(study.pagination.pageSize*(study.pagination.currentPage-1)+index)"
                                                aria-expanded="true" aria-controls="collapseOne">
                                        </button>
                                        <img class="myIcon"
                                             src="/static/external/star-rating/image/star-on.png"
                                             data-toggle="tooltip"
                                             data-placement="right" :title="item.payCredits+'积分'">
                                    </h5>
                                </div>
                                <div :id="'study-'+(study.pagination.pageSize*(study.pagination.currentPage-1)+index)"
                                     class="collapse "
                                     :aria-labelledby="'heading-'+(study.pagination.pageSize*(study.pagination.currentPage-1)+index)"
                                     data-parent="#study">
                                    <div class="card-body row">
                                        <div class="col col-md-2 margin-right10">
                                            <img class="cover" src="/static/image/avatar/Avatar.png"
                                                 alt="Cover">
                                        </div>
                                        <div class="col" style="text-overflow:ellipsis;">
                                            <a class="non-text-dec" :href="'/direct/course?id='+item.id">
                                                <h6 class="card-title font-weight-bold" v-text="item.title"></h6>
                                            </a>
                                            <div class="dropdown-divider"></div>
                                            <p class="card-text font-weight-light courseDescription cursor-default"
                                               v-text="item.description">
                                            </p>
                                            <div class="dropdown-divider"></div>
                                            <span v-text="'报名截止时间：'+item.applyEndTime"></span>
                                            <span v-text="'开课时间：'+item.beginTime"></span>
                                            <span v-text="'参与人数：'+item.lessonNum"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 教学贴 &ndash;&gt;-->
                        <div class="tab-pane fade" id="teaching" role="tabpanel" aria-labelledby="teaching-tab">
                            <!--first demonstration-->
                            <div class="card" v-for="(item,index) of teaching.list">
                                <div class="card-header bg-whitesmoke-tp25"
                                     :id="'heading-'+(teaching.pagination.pageSize*(teaching.pagination.currentPage-1)+index)">
                                    <h5 class="mb-0 d-flex justify-content-between">
                                        <button class="btn btn-link text-truncate w-75 non-text-dec font-weight-bold"
                                                data-toggle="collapse" v-text="item.title"
                                                :data-target="'#teaching-'+(teaching.pagination.pageSize*(teaching.pagination.currentPage-1)+index)"
                                                aria-expanded="true" aria-controls="collapseOne">
                                        </button>
                                        <img class="myIcon"
                                             src="/static/external/star-rating/image/star-on.png"
                                             data-toggle="tooltip"
                                             data-placement="right" :title="item.payCredits+'积分'">
                                    </h5>
                                </div>
                                <div :id="'teaching-'+(teaching.pagination.pageSize*(teaching.pagination.currentPage-1)+index)"
                                     class="collapse "
                                     :aria-labelledby="'heading-'+(teaching.pagination.pageSize*(teaching.pagination.currentPage-1)+index)"
                                     data-parent="#teaching">
                                    <div class="card-body row">
                                        <div class="col col-md-2 margin-right10">
                                            <img class="cover" src="/static/image/avatar/Avatar.png"
                                                 alt="Cover">
                                        </div>
                                        <div class="col" style="text-overflow:ellipsis;">
                                            <a class="non-text-dec" href="/direct/course">
                                                <h6 class="card-title font-weight-bold" v-text="item.title"></h6>
                                            </a>
                                            <div class="dropdown-divider"></div>
                                            <p class="card-text font-weight-light courseDescription cursor-default"
                                               v-text="item.description">
                                            </p>
                                            <div class="dropdown-divider"></div>
                                            <span v-text="'报名截止时间：'+item.applyEndTime"></span>
                                            <span v-text="'开课时间：'+item.beginTime"></span>
                                            <span v-text="'参与人数：'+item.lessonNum"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 我的课程 -->
                        <div class="tab-pane fade" id="myCourses" role="tabpanel" aria-labelledby="myCourses-tab">
                            <!--first demonstration-->
                            <div class="card" v-for="(item,index) of myCourses.list">
                                <div class="card-header bg-whitesmoke-tp25"
                                     :id="'heading-'+(teaching.pagination.pageSize*teaching.pagination.currentPage+index)">
                                    <h5 class="mb-0 d-flex justify-content-between">
                                        <button class="btn btn-link text-truncate w-75 non-text-dec font-weight-bold"
                                                data-toggle="collapse" v-text="item.title"
                                                :data-target="'#myCourses-'+(teaching.pagination.pageSize*teaching.pagination.currentPage+index)"
                                                aria-expanded="true" aria-controls="collapseOne">
                                        </button>
                                        <img class="myIcon"
                                             src="/static/external/star-rating/image/star-on.png"
                                             data-toggle="tooltip"
                                             data-placement="right" :title="item.payCredits+'积分'">
                                    </h5>
                                </div>
                                <div :id="'myCourses-'+(teaching.pagination.pageSize*teaching.pagination.currentPage+index)"
                                     class="collapse "
                                     :aria-labelledby="'heading-'+(teaching.pagination.pageSize*teaching.pagination.currentPage+index)"
                                     data-parent="#myCourses">
                                    <div class="card-body row">
                                        <div class="col col-md-2 margin-right10">
                                            <img class="cover" src="/static/image/avatar/Avatar.png"
                                                 alt="Cover">
                                        </div>
                                        <div class="col" style="text-overflow:ellipsis;">
                                            <a class="non-text-dec" href="/direct/course">
                                                <h6 class="card-title font-weight-bold" v-text="item.title"></h6>
                                            </a>
                                            <div class="dropdown-divider"></div>
                                            <p class="card-text font-weight-light courseDescription cursor-default"
                                               v-text="item.description">
                                            </p>
                                            <div class="dropdown-divider"></div>
                                            <span v-text="'报名截止时间：'+item.applyEndTime"></span>
                                            <span v-text="'开课时间：'+item.beginTime"></span>
                                            <span v-text="'参与人数：'+item.lessonNum"></span>
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
</div>
<#include "common/js.ftl">
<script>
    let vm = new Vue({
        el: "#vm",
        data: {
            study: {
                pagination: {},
                list: []
            },
            teaching: {
                pagination: {},
                list: []
            },
            myCourses: {
                pagination: {},
                list: []
            }
        },
        created: function () {
            let _this = this;
            $.ajax({
                url: "/campus/course/list",
                type: "GET",
                data: {
                    typeCourse: "求学"
                },
                success: function (data) {
                    if (data.result) {
                        _this.study.list = data.data;
                        _this.study.pagination = data.pagination;
                    }
                }
            });
            $.ajax({
                url: "/campus/course/list",
                type: "GET",
                data: {
                    typeCourse: "教学"
                },
                success: function (data) {
                    if (data.result) {
                        _this.teaching.list = data.data;
                        _this.teaching.pagination = data.pagination;
                    }
                }
            });
            $.ajax({
                url: "/campus/course/list",
                type: "GET",
                data: {
                    userId: _this.user.id
                },
                success: function (data) {
                    if (data.result) {
                        _this.myCourses.list = data.data;
                        _this.myCourses.pagination = data.pagination;
                    }
                }
            })
        }
    });
</script>
<#include "common/foot.ftl">