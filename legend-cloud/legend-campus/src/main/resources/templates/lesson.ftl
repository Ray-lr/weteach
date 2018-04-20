<#include "common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">课时设置</h1>
            <hr class="line">
            <div class="col col-md-2" id="personal">
            </div>
            <div class="col-12 col-md-8" id="principal">
                <h6 style="font-weight: bold">总课时节数:4</h6>
                <h6 style="font-weight: bold">当前课程进度:3/4</h6>
                <div class="progress">
                    <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar"
                         aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%">75%
                    </div>
                </div>
                <!--相关备注-->
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">相关备注</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="4"
                              data-toggle="tooltip"
                              data-placement="left" title="请输入当前课时相关备注"></textarea>
                </div>
                <!--开课地点-->
                <div class="form-group">
                    <label for="location">开课地点</label>
                    <input type="text" class="form-control" id="location"
                           data-toggle="tooltip"
                           data-placement="left" title="请输入当前课时开课地点">
                </div>
                <!--开课时间-->
                <div class="form-group">
                    <label for="beginTime">开课时间</label>
                    <div class="input-group date form_datetime">
                        <input type="text" class="form-control" id="beginTime"
                               data-toggle="tooltip"
                               data-placement="left" title="请输入当前课时开课时间"
                               aria-describedby="expectedPublishTimeHelp"
                               placeholder="Begin Time"
                               readonly>
                        <span class="input-group-addon"><span
                                class="glyphicon glyphicon-th"></span></span>
                    </div>
                    <small id="expectedPublishTimeHelp" class="form-text text-muted">

                    </small>
                </div>
                <!--结课时间-->
                <div class="form-group">
                    <label for="endTime">结课时间</label>
                    <div class="input-group date form_datetime">
                        <input type="text" class="form-control" id="endTime"
                               data-toggle="tooltip"
                               data-placement="left" title="请输入当前课时结课时间"
                               aria-describedby="finishTimeHelp" placeholder="End Time"
                               readonly>
                        <span class="input-group-addon"><span
                                class="glyphicon glyphicon-th"></span></span>
                    </div>
                    <small id="finishTimeHelp" class="form-text text-muted">

                    </small>
                </div>
                <!--分割线-->
                <div class="dropdown-divider"></div>
                <div>
                    <a href="#">
                        <button id="applyButton" type="button" class="btn btn-primary" data-toggle="modal"
                                data-target="#MyModal"
                                style="width: 100%;height:50px;font-size:20px;">提交设置
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
                                        是否确定提交课时内容设置
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-light"
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
            </div>
            <div class="col col-md-2" id="external">
            </div>
        </div>
    </div>
</div>
<#include "common/bottom.ftl">
<#include "common/js.ftl">

<#include "common/foot.ftl">