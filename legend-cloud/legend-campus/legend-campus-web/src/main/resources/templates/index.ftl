<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "./common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
        <#include "./common/component/personal-leftSide.ftl">
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
                            <a class="nav-link" id="other-tab" data-toggle="tab" href="#other" role="tab"
                               aria-controls="other" aria-selected="false">我的课程</a>
                        </li>
                    </ul>

                    <div class="tab-content" id="courseContent">
                        <!-- first list -->
                        <div class="tab-pane fade show active" id="study" role="tabpanel" aria-labelledby="study-tab">
                            <!--first demonstration-->
                            <div class="card">
                                <div class="card-header" id="headingOne">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link collapsed" data-toggle="collapse"
                                                data-target="#collapseOne" aria-expanded="false"
                                                aria-controls="collapseOne" style="font-weight: bold;">
                                            急求学霸一名来教教我线性代数，十万火急！
                                        </button>
                                    </h5>
                                </div>
                                <div id="collapseOne" class="collapse" aria-labelledby="headingOne"
                                     data-parent="#study">
                                    <div class="card-body row">
                                        <img class="rounded-0 cover"
                                             src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        <div class="col" style="text-overflow:ellipsis;">
                                            <a style="font-weight: bold" href="/direct/course">急求学霸一名来教教我线性代数，十万火急！</a>
                                            <a id="hhh" style="width:100%;word-break:break-all;display:-webkit-box;-webkit-line-clamp:2;
                                            -webkit-box-orient:vertical;overflow:hidden;" href="/direct/course">
                                                如题，这学期我们在学线性代数，原本还能跟得上，后来家里有事请了一周假，回来后上课就听不懂了，现在急求一位学长或学姐能够帮帮我，不然下星期的课还是听不懂的话就越来越麻烦了，十万火急，希望能有学霸帮忙！</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!--<div class="card" v-for="(item,index) of study.list">
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
                            </div>-->
                        </div>
                        <!-- second list -->
                        <div class="tab-pane fade" id="teaching" role="tabpanel" aria-labelledby="teaching-tab">
                            <!--first demonstration-->
                            <div class="card">
                                <div class="card-header" id="headingTwo">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link collapsed" data-toggle="collapse"
                                                data-target="#collapseTwo" aria-expanded="false"
                                                aria-controls="collapseTwo" style="font-weight: bold;">
                                            英语四级作文写作技巧教学
                                        </button>
                                    </h5>
                                </div>
                                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
                                     data-parent="#teaching">
                                    <div class="card-body row">
                                        <img class="rounded-0 cover"
                                             src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        <div class="col" style="text-overflow:ellipsis;">
                                            <a style="font-weight: bold" href="/direct/course">英语四级作文写作技巧教学</a>
                                            <!--单行隐藏内容加省略号<p style="text-overflow:ellipsis;white-space:nowrap;width:30em;overflow:hidden;">-->
                                            <a id="hhh" style="width:100%;word-break:break-all;display:-webkit-box;-webkit-line-clamp:2;
                                            -webkit-box-orient:vertical;overflow:hidden;" href="/direct/course">
                                                同学，你是否苦恼于自己的英语作文每次考试都拉分？是否对于英语作文怎么写而感到迷茫？那么你可以参加我的技巧教学，只需两天，保证让你英语写作上升一个档次</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!--second demonstration-->
                            <div class="card">
                                <div class="card-header" id="headingThree">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link collapsed" data-toggle="collapse"
                                                data-target="#collapseThree" aria-expanded="false"
                                                aria-controls="collapseThree" style="font-weight: bold;">
                                            英语四级作文写作技巧教学
                                        </button>
                                    </h5>
                                </div>
                                <div id="collapseThree" class="collapse" aria-labelledby="headingThree"
                                     data-parent="#teaching">
                                    <div class="card-body row">
                                        <img class="rounded-0 cover"
                                             src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        <div class="col" style="text-overflow:ellipsis;">
                                            <a style="font-weight: bold" href="/direct/course">英语四级作文写作技巧教学</a>
                                            <!--单行隐藏内容加省略号<p style="text-overflow:ellipsis;white-space:nowrap;width:30em;overflow:hidden;">-->
                                            <a id="hhh" style="width:100%;word-break:break-all;display:-webkit-box;-webkit-line-clamp:2;
                                            -webkit-box-orient:vertical;overflow:hidden;" href="/direct/course">
                                                同学，你是否苦恼于自己的英语作文每次考试都拉分？是否对于英语作文怎么写而感到迷茫？那么你可以参加我的技巧教学，只需两天，保证让你英语写作上升一个档次</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!--third demonstration-->
                            <div class="card">
                                <div class="card-header" id="headingFour">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link collapsed" data-toggle="collapse"
                                                data-target="#collapseFour" aria-expanded="false"
                                                aria-controls="collapseFour" style="font-weight: bold;">
                                            英语四级作文写作技巧教学
                                        </button>
                                    </h5>
                                </div>
                                <div id="collapseFour" class="collapse" aria-labelledby="headingFour"
                                     data-parent="#teaching">
                                    <div class="card-body row">
                                        <img class="rounded-0 cover"
                                             src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        <div class="col" style="text-overflow:ellipsis;">
                                            <a style="font-weight: bold" href="/direct/course">英语四级作文写作技巧教学</a>
                                            <!--单行隐藏内容加省略号<p style="text-overflow:ellipsis;white-space:nowrap;width:30em;overflow:hidden;">-->
                                            <a id="hhh" style="width:100%;word-break:break-all;display:-webkit-box;-webkit-line-clamp:2;
                                            -webkit-box-orient:vertical;overflow:hidden;" href="/direct/course">
                                                同学，你是否苦恼于自己的英语作文每次考试都拉分？是否对于英语作文怎么写而感到迷茫？那么你可以参加我的技巧教学，只需两天，保证让你英语写作上升一个档次</a>
                                        </div>

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
                    <a href="/direct/publish">
                        <button type="button" class="btn btn-success"
                                style="width: 100%;height:50px;font-size:20px;">发布课程
                        </button>
                    </a>
                </div>
                <div class="dropdown-divider"></div>
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
<#include "./common/style.ftl">
<script>
    let vm = new Vue({
        el: "#vm",
        data: {
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
                url: "/campus/course/list",
                type: "GET",
                success: function (data) {
                    if (data.result) {
                        vm.study.list = data.data;
                    }
                }
            });
        },
    })
</script>
<#include "./common/foot.ftl">