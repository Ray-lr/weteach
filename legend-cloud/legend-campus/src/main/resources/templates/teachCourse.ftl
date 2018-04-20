<#include "common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">课程详细信息</h1>

            <hr class="line">
            <!--左侧信息栏-->
            <div class="col col-md-3" id="others">
            <#include "common/component/other-info.ftl">
                <div class="dropdown-divider"></div>
                <!--参与者名单-->
                <div>
                    <span style="font-weight: bold">报名者名单:</span>
                </div>
                <div class="dropdown-divider"></div>
                <div style="height:150px;">
                    <div align="center">
                        <a href="/direct/lesson">
                            <button type="button" class="btn btn-success"
                                    style="width: 100%">课时设置
                            </button>
                        </a>
                    </div>
                    <div align="left" style="height: 25px">
                        <span style="font-weight: bold">当前课时状态:未开课</span>
                    </div>
                    <h6 style="font-weight: bold">当前课程进度:3/4</h6>
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar"
                             aria-valuenow="63" aria-valuemin="0" aria-valuemax="100" style="width: 63%"></div>
                    </div>
                    <div class="dropdown-divider"></div>
                </div>

            </div>
            <!--课程详细信息部分-->
            <div class="col-12 col-md-6" id="principal">
                <!--标题-->
                <h3 align="center" v-text="course.title"></h3>
                <div class="dropdown-divider"></div>
                <!-- 系别，专业，课程信息展示 -->
                <div class="form-group">
                    <label for="province">课程信息</label>
                    <div class="row">
                        <!-- 系别-->
                        <div class="col-md-4 alert alert-secondary ">
                            <span v-text="course.dept_string"></span>
                        </div>
                        <!-- 专业 -->
                        <div class="col-md-4 alert alert-secondary ">
                            <span v-text="course.major_string"></span>
                        </div>
                        <!-- 课程 -->
                        <div class="col col-md-4 alert alert-secondary ">
                            <span v-text="course.course_string"></span>
                        </div>

                    </div>
                </div>
                <!--课程描述-->
                <label for="description">课程描述</label>
                <div class="alert alert-success">
                    <p v-text="course.description"></p>
                </div>
                <!--课程备注-->
                <label for="remark">相关备注</label>
                <div class="alert alert-warning">
                    <p v-text="course.remark"></p>
                </div>
                <div class="row">

                </div>
                <!--当前报名人数-->
                <label for="personNum">当前报名人数</label>
                <div class="alert alert-info">
                    <span v-text="course.personNum"></span>
                </div>
                <!--积分-->
                <label for=" credits">参与所需积分</label>
                <div class="alert alert-info">
                    <span v-text="course.getCredits"></span>
                </div>
                <!--课时节数-->
                <label for="lessonNum">课时节数</label>
                <div class="alert alert-info">
                    <span v-text="course.lessonNum"></span>
                </div>

                <!--以下三个内容查询campus_course_lesson课时表-->
                <!--开课地点-->
                <label for="location">开课地点</label>
                <div class="alert alert-info">
                    <span></span>
                </div>
                <!--开课时间-->
                <label for="beginTime">开课时间</label>
                <div class="alert alert-info">
                    <span></span>
                </div>
                <!--结课时间-->
                <label for="endTime">结课时间</label>
                <div class="alert alert-info">
                    <span></span>
                </div>

            </div>
            <div class="col col-md-3" id="external">
                <div>
                    <a href="#">
                        <button id="applyButton" type="button" class="btn btn-info" data-toggle="modal"
                                data-target="#MyModal"
                                style="width: 100%;height:50px;font-size:20px;" @click="validate_apply">我要报名
                        </button>
                        <!--检测条件满足后模态框提示-->
                        <div class="modal fade" id="MyModal" tabindex="-1" role="dialog"
                             aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h4 class="modal-title" id="myModalLabel">
                                            提示
                                        </h4>
                                    </div>
                                    <div class="modal-body" id="message">
                                    <#--是否确定报名该课程?-->
                                    </div>
                                    <div class="modal-footer">
                                        <button id="YesToApply" type="button" class="btn btn-light"
                                                data-dismiss="modal">确定
                                        </button>
                                        <button type="button" class="btn btn-light" data-dismiss="modal">取消
                                        </button>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="dropdown-divider"></div>
                <div class="alert alert-info" role="alert">
                    <h5>相似课程</h5>
                    <div class="dropdown-divider"></div>
                    <div class="card-body row">
                        <img class="rounded-circle cover"
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
                    <div class="dropdown-divider"></div>
                    <div class="card-body row">
                        <img class="rounded-circle cover"
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
                    <div class="dropdown-divider"></div>
                    <div class="card-body row">
                        <img class="rounded-circle cover"
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
    </div>
</div>
<#include "common/js.ftl">
<script>
    let vm = new Vue({
        el: "#vm",
        data: {
            course: {},
            otherUser: {}
        },
        created: function () {
            let _this = this;
            $.ajax({
                url: "/campus/course/details/${id}",
                type: "GET",
                success: function (data) {
                    if (data.result) {
                        _this.course = data.data;
                        $.ajax({
                            url: "/campus/account/details/" + data.data.userId,
                            type: "get",
                            success: function (data) {
                                if (data.result) {
                                    _this.otherUser = data.data;
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
            })
        },
        methods: {
            validate_apply: function () {
                $.ajax({
                    url: "/campus/course/apply/" + vm.course.id,
                    type: "put",
                    success: function (data) {
                        if (data.result) {
                            $("#message").html("是否确定报名该课程?");
                            $("button#YesToApply").click(function () {
                                $.ajax({
                                    url: "/campus/course/yesToApply/" + vm.course.id,
                                    type: "put",
                                    success: function (data) {
                                        if (data.result) {
                                            alert(data.msg);
                                        } else {
                                            alert(data.msg);
                                        }
                                    }
                                })
                            });
                        } else {
                            $("#message").html(data.msg);
                        }
                    }
                })
            },

        }
    })

</script>

<#include "common/foot.ftl">