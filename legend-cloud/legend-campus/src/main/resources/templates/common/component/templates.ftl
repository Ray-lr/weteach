<template id="">
    <!-- first list -->
    <div class="col col-md-10 tab-pane fade <#if !type?? || type=="seek">show active</#if>" id="study"
         role="tabpanel"
         aria-labelledby="study-tab">
        <form @submit.prevent="publish($event)">
        <#--隐藏的课程类型-->
            <input type="hidden" name="course.typeCourse" value="求学">
            <!--标题-->
            <div class="form-group">
                <label for="courseTitle">课程标题</label>
                <input type="text" class="form-control" id="courseTitle"
                       name="course.title"
                       placeholder="标题">
            </div>
            <!--系别/专业/课程-->
            <div class="form-group">
                <label for="course">系别/专业/课程</label>
                <div class="input-group">
                    <select class="form-control" id="dept"
                            v-model="dept" name="course.dept"
                            data-toggle="tooltip"
                            data-placement="left" title="请选择系别">
                        <option v-for="item in depts" :value="item.id"
                                v-text="item.name"></option>
                    </select>
                    <select class="form-control" id="major" v-model="major"
                            data-toggle="tooltip" name="course.major"
                            data-placement="left" title="请选择专业">
                        <option v-for="item in majors" :value="item.id"
                                v-text="item.name"></option>
                    </select>
                    <select class="form-control" id="course"
                            v-model="course" name="course.course"
                            data-toggle="tooltip"
                            data-placement="left" title="请选择课程">
                        <option v-for="item in courses" :value="item.id"
                                v-text="item.name"></option>
                    </select>
                </div>
            </div>
            <!--课程描述-->
            <div class="form-group">
                <label for="description">课程描述</label>
                <textarea class="form-control" id="description" rows="3"
                          name="course.description" placeholder="不超过100个字"></textarea>
            </div>
            <!--相关备注-->
            <div class="form-group">
                <label for="remark">相关备注</label>
                <textarea class="form-control" id="remark" rows="4"
                          name="course.remark" placeholder="选填"></textarea>
            </div>
            <!--悬赏积分-->
            <div class="form-group">
                <label for="payCredits">悬赏积分</label>
                <input type="number" class="form-control" id="payCredits"
                       name="course.payCredits"
                       :value="1"
                       min="1"
                       placeholder="最低悬赏1积分">
            </div>
            <!--报名截止时间-->
            <div class="form-group">
                <label for="applyEndTime">截止时间</label>
                <div class="input-group date form_datetime"
                     data-picker-position="top-right">
                    <input type="text" class="form-control cursor-pointer"
                           id="applyEndTime"
                           name="course.applyEndTime"
                           aria-describedby="expectedApplyEndTimeHelp"
                           placeholder="报名截止日期"
                           readonly>
                    <span class="input-group-addon"><span
                            class="glyphicon glyphicon-th"></span></span>
                </div>
                <small id="expectedApplyEndTimeHelp" class="form-text text-muted">

                </small>
            </div>
            <!--报名截止时间-->
            <div class="form-group">
                <label for="beginTime">开课时间</label>
                <div class="input-group date form_datetime"
                     data-picker-position="top-right">
                    <input type="text" class="form-control cursor-pointer"
                           id="beginTime"
                           name="course.beginTime"
                           aria-describedby="expectedBeginTimeHelp"
                           placeholder="开课时间"
                           readonly>
                    <span class="input-group-addon"><span
                            class="glyphicon glyphicon-th"></span></span>
                </div>
                <small id="expectedBeginTimeHelp" class="form-text text-muted">

                </small>
            </div>
            <!--模态框限制-->
            <button type="button" class="btn btn-danger" data-toggle="modal"
                    data-target="#exampleModal" style="width: 100%">
                增加限制条件
            </button>
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="exampleModalLabel">报名人员限制</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <!--相关限制条件-->
                            <div id="courseLimit">
                                <div class="alert alert-primary" role="alert">
                                    <!--专业限制-->
                                    <h5>
                                        <label for="seek_major_limit">专业限制</label>
                                        <input type="checkbox" class="all_check"
                                               aria-label="Checkbox for following text input"
                                               id="seek_major_limit" name="a"
                                               data-toggle="tooltip"
                                               data-placement="left" title="专业限制">
                                    </h5>
                                    <div class="input-group cancel_all" id="seek_major"
                                         style="display: none">
                                        <select class="form-control" id="dept"
                                                v-model="dept" name="course.dept"
                                                data-toggle="tooltip"
                                                data-placement="left" title="请选择系别">
                                            <option v-for="item in depts" :value="item.id"
                                                    v-text="item.name"></option>
                                        </select>
                                        <select class="form-control" id="major" v-model="major"
                                                data-toggle="tooltip" name="course.major"
                                                data-placement="left" title="请选择专业">
                                            <option v-for="item in majors" :value="item.id"
                                                    v-text="item.name"></option>
                                        </select>
                                    </div>
                                    <div class="dropdown-divider"></div>
                                    <!--性别限制-->
                                    <h5>
                                        <label for="seek_sex_limit">性别限制</label>
                                        <input type="checkbox" class="all_check"
                                               aria-label="Checkbox for following text input"
                                               id="seek_sex_limit" name="a"
                                               data-toggle="tooltip"
                                               data-placement="left" title="性别限制">
                                    </h5>
                                    <div class="form-group cancel_all" align="center" id="seek_sex"
                                         style="display: none;">
                                        <label for="male">男</label>
                                        <input type="radio" name="limit.sex" value="1" id="male" checked/>

                                        <label for="female">女</label>
                                        <input type="radio" name="limit.sex" value="0" id="female"/>
                                    </div>
                                    <div class="dropdown-divider"></div>
                                    <!--年级限制-->
                                    <h5>
                                        <label for="seek_grade_limit">年级限制</label>
                                        <input type="checkbox" class="all_check"
                                               aria-label="Checkbox for following text input"
                                               id="seek_grade_limit" name="a"
                                               data-toggle="tooltip"
                                               data-placement="left" title="年级限制">
                                    </h5>
                                    <div class="form-group cancel_all" id="seek_grade"
                                         style="display: none;">
                                        <div class="row" align="center">
                                            <p class="col col-3">大一
                                                <input type="checkbox" value="1"
                                                       name="limit.grade"
                                                       id="gradeOne"
                                                       data-toggle="tooltip"
                                                       data-placement="left" title="大一">
                                            </p>
                                            <p class="col col-3">大二
                                                <input type="checkbox" value="2"
                                                       name="limit.grade"
                                                       id="gradeTwo"
                                                       data-toggle="tooltip"
                                                       data-placement="left" title="大二">
                                            </p>
                                            <p class="col col-3">大三
                                                <input type="checkbox" value="3"
                                                       name="limit.grade"
                                                       id="gradeThree"
                                                       data-toggle="tooltip"
                                                       data-placement="left" title="大三">
                                            </p>
                                            <p class="col col-3">大四
                                                <input type="checkbox" value="4"
                                                       name="limit.grade"
                                                       id="gradeFour"
                                                       data-toggle="tooltip"
                                                       data-placement="left" title="大四">
                                            </p>
                                        </div>
                                    </div>
                                    <div class="dropdown-divider"></div>
                                    <h4>
                                        <label for="bigBox">全选/取消</label>
                                        <input type="checkbox" class="bigBox"
                                               aria-label="Checkbox for following text input"
                                               data-toggle="tooltip"
                                               data-placement="left" title="全选/取消">
                                    </h4>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary">确认</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>

                        </div>
                    </div>
                </div>
            </div>
            <!--分割线-->
            <div class="dropdown-divider"></div>
            <input type="submit" class="btn btn-primary btn-lg btn-block"
                   v-model="submitText">
        </form>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                author
            }
        }
    }
</script>