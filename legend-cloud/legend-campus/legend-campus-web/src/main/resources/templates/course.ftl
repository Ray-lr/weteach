<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
    <#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">课程详细信息</h1>

            <hr class="line">
            <!--左侧信息栏-->
            <div class="col col-md-3" id="others">
                <#include "./common/component/other-info.ftl">
                <div style="height:150px;">
                    <h6 style="font-weight: bold">当前课程进度:75%</h6>
                    <div align="left">
                        <p>已完成课时:3</p>
                        <p>剩余课时：1</p>
                    </div>
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar"
                             aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div>
                    </div>
                </div>

            </div>
            <!--课程详细信息部分-->
            <div class="col-12 col-md-6" id="principal">
                <!--标题-->
                <h3 align="center">This is the title of the course</h3>
                <div class="dropdown-divider"></div>
                <!-- 系别，专业，课程信息展示（不可选） -->
                <div class="form-group">
                    <label for="province">课程信息</label>
                    <div class="row">
                        <!-- 系别-->
                        <div class="col-md-4">
                            <select class="form-control" name="province"
                                    disabled="disabled"
                                    data-toggle="tooltip"
                                    data-placement="left" title="请选择">

                            </select>
                        </div>
                        <!-- 专业 -->
                        <div class="col-md-4">
                            <select class="form-control" name="city"
                                    disabled="disabled"
                                    data-toggle="tooltip"
                                    data-placement="left" title="请选择">

                            </select>
                        </div>
                        <!-- 课程 -->
                        <div class="col col-md-4">
                            <select class="form-control" name="county"
                                    disabled="disabled"
                                    data-toggle="tooltip"
                                    data-placement="left" title="请选择">

                            </select>
                        </div>

                    </div>
                </div>
                <!--课程描述-->
                <label for="description">课程描述</label>
                <div class="alert alert-success">
                    <p>这里是课程相关的描述吧啦吧啦......</p>
                    <p>Aww yeah, you successfully read this important alert message. This example text is going to run a
                        bit
                        longer so that you can see how spacing within an alert works with this kind of content.</p>
                </div>
                <!--课程备注-->
                <label for="remark">备注</label>
                <div class="alert alert-warning">
                    <p>这里是相关备注Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>
                </div>
                <div class="row">

                </div>
                <div class="row">
                    <!--当前报名人数-->
                    <label for="personNum">当前报名人数</label>
                    <div>
                        <input type="text" class="form-control" id="exampleFormControlInput1"
                               name="personNum" disabled="disabled">
                    </div>
                    <!--积分-->
                    <label for=" credits">参与积分</label>
                    <div>
                        <input type="text" class="form-control" id="exampleFormControlInput1"
                               name="credits" disabled="disabled">
                    </div>
                </div>

                <!--相关图片证明展示-->
                <label for="prove">图片证明</label>
                <div class="row" style="height: 15em;width: 30em">
                    <div align="center">
                        <img class="rounded-0 cover"
                             src="/static/image/avatar/Avatar.png"
                             alt="Cover" style="width: 100%;height: 100%">
                    </div>
                </div>


            </div>
            <div class="col col-md-3" id="external">
                <div>
                    <a href="#">
                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal"
                                style="width: 100%;height:50px;font-size:20px;">我要报名
                        </button>
                        <!--模态框提示-->
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
                                        是否确定报名该课程?
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-light" data-dismiss="modal">确定
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
<script>
    let vm = new Vue({
        el: "#vm",
    });
</script>
<#include "./common/foot.ftl">