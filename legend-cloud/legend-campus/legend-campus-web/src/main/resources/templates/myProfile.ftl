<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "./common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
        <#include "./common/component/personal-leftSide.ftl">
            <div class="col-12 col-md-8">
                <!-- 课程列表 -->
                <div class="row-fluid" id="courseList">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link <#if !type?? || type=="course">active</#if>" id="courseInfo-tab"
                               data-toggle="tab"
                               href="#courseInfo"
                               role="tab"
                               aria-controls="courseInfo" aria-selected="false">我的课程相关
                            </a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link <#if type?? && type=="personal">active</#if>" id="personInfo-tab"
                               data-toggle="tab" href="#personInfo" role="tab"
                               aria-controls="personInfo" aria-selected="true">个人信息中心</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link <#if type?? && type=="data">active</#if>" id="dataInfo-tab"
                               data-toggle="tab" href="#dataInfo" role="tab"
                               aria-controls="dataInfo" aria-selected="false">我的数据统计</a>
                        </li>
                    </ul>

                    <div class="tab-content" id="courseContent">
                        <!--我的课程相关-->
                        <div class="tab-pane fade <#if !type?? || type=="course">show active</#if>" id="courseInfo"
                             role="tabpanel"
                             aria-labelledby="courseInfo-tab">
                            <div class="card" v-for="(item,index) of myCourseInfos">
                                <div class="card-header bg-whitesmoke-tp25" :id="'heading-myCourse-'+index">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link" data-toggle="collapse"
                                                :data-target="'#collapse-myCourse-'+index"
                                                aria-expanded="true" :aria-controls="'collapse-myCourse-'+index">
                                            <span v-text="item.title"></span>
                                        </button>
                                    </h5>
                                </div>

                                <div :id="'collapse-myCourse-'+index" class="collapse "
                                     :aria-labelledby="'heading-myCourse-'+index"
                                     data-parent="#accordion">
                                    <div class="card-body">
                                        <img class="rounded-left cover" src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        <p v-text="item.description"></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 个人信息完善 -->
                        <div class="tab-pane fade <#if type?? && type=="personal">show active</#if>" id="personInfo"
                             role="tabpanel" aria-labelledby="personInfo-tab">
                            <form @submit.prevent="update($event)">
                                <!--真实姓名-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">真实姓名</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput1"
                                           name="name" :value="userInfo.name">
                                </div>
                                <!-- 真实性别 -->
                                <div class="form-group">

                                    <label for="male">男</label>
                                    <input type="radio" name="sex" id="male" :value="userInfo.sex" checked/>

                                    <label for="female">女</label>
                                    <input type="radio" name="sex" id="female"/>
                                </div>
                                <!--昵称-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput2">昵称</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput2"
                                           placeholder="18" name="nickname" :value="userInfo.nickname">
                                </div>
                                <!--生日-->
                                <div class="form-group">
                                    <label for="birthday" class="col-md-2 control-label">出生日期</label>
                                    <div class="input-group date form_date">
                                        <input class="form-control" size="16" type="text"
                                               :value="userInfo.birthday | date"
                                               name="birthday"
                                               data-toggle="tooltip"
                                               data-placement="left" title="请输入日期"
                                               aria-describedby="dateHelp" placeholder="Date"
                                               readonly>
                                        <span class="input-group-addon"><i class="glyphicon
                                        glyphicon-remove"></i></span>
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                                    </div>
                                    <small id="dateHelp" class="form-text text-muted">

                                    </small>
                                </div>
                                <!--入学年份-->
                                <div class="form-group">
                                    <label for="enrollmentYear">入学年份</label>
                                    <select class="form-control" id="enrollmentYear" name="enrollmentYear"
                                            v-model="userInfo.enrollmentYear">
                                        <option value="2014">2014</option>
                                        <option value="2015">2015</option>
                                        <option value="2016">2016</option>
                                        <option value="2017">2017</option>
                                    </select>
                                </div>
                                <!--联系方式-->
                                <div class="form-group">
                                    <label for="contact">联系方式</label>
                                    <input type="text" class="form-control" id="contact"
                                           name="contact" :value="userInfo.contact"
                                           placeholder="QQ，微信或其他">
                                </div>
                                <!--邮箱-->
                                <div class="form-group">
                                    <label for="email">邮箱</label>
                                    <input type="email" class="form-control" id="email"
                                           placeholder="name@example.com" name="email" :value="userInfo.email">
                                </div>
                                <!-- 籍贯 -->
                                <div class="form-group">
                                    <label for="province">籍贯</label>
                                    <div class="row">
                                        <!-- 省、直辖市-->
                                        <div class="col-md-4">
                                            <select class="form-control" name="province"
                                                    v-model="userInfo.province"
                                                    data-toggle="tooltip"
                                                    data-placement="left" title="请选择省或直辖市">
                                                <option v-for="item in provinces" :value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>
                                        <!-- 市/州 -->
                                        <div class="col-md-4">
                                            <select class="form-control" name="city"
                                                    v-model="userInfo.city"
                                                    data-toggle="tooltip"
                                                    data-placement="left" title="请选择市或自治区">
                                                <option v-for="item in cities" :value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>
                                        <!-- 区/县 -->
                                        <div class="col col-md-4">
                                            <select class="form-control" name="county"
                                                    v-model="userInfo.county"
                                                    data-toggle="tooltip"
                                                    data-placement="left" title="请选择县或区">
                                                <option v-for="item in counties" :value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1">个性签名</label>
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"
                                              name="signature" :value="userInfo.signature"></textarea>
                                </div>
                                <div align="center" style="height:150px;">
                                    <button type="submit" class="btn btn-outline-primary btn-lg btn-block" value="提交">
                                        提交
                                    </button>

                                </div>
                            </form>
                        </div>
                        <!--我的数据统计-->
                        <div class="tab-pane fade <#if type?? && type=="data">show active</#if>" id="dataInfo"
                             role="tabpanel"
                             aria-labelledby="data-tab">
                            <!--统计图-->
                            <div id="semester" style="width: 700px;height:400px;"></div>
                            <!--饼图-->
                            <div>
                                <div>
                                    <div id="pie" style="width: 500px;height:300px;"></div>
                                </div>
                                <div></div>
                            </div>
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
        data: {
            userInfo: "",
            myCourseInfos: [],
            provinces: [],
            cities: [],
            counties: []
        },
        created: function () {
            let _this = this;
            $.ajax({
                url: "/campus/userInfo/details/" + this.user.id,
                type: "GET",
                success: function (data) {
                    if (data.result) {
                        _this.userInfo = data.data;
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
            $.ajax({
                url: "/base/areas/list",
                type: "get",
                data: {
                    parentId: 0
                },
                success: function (data) {
                    if (data.result) {
                        _this.provinces = data.data;
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
            //获取我的课程相关
            $.ajax({
                url: "/campus/course/list",
                type: "get",
                data: {
                    userId: this.user.baseUserId
                },
                success: function (data) {
                    if (data.result) {
                        _this.myCourseInfos = data.data;
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

        },
        methods: {
            update: function (e) {
                $(e.currentTarget).ajaxSubmit({
                    url: "/campus/userInfo/update",
                    type: "POSt",
                    data: {
                        _method: "PUT"
                    },
                    success: function (data) {
                        Messenger().post({
                            id: "error",
                            message: data.msg,//提示信息
                            type: data.result ? 'success' : 'error',//消息类型。error、info、success
                            hideAfter: 3,//多长时间消失
                            showCloseButton: true,//是否显示关闭按钮
                            hideOnNavigate: false//是否隐藏导航
                        });
                        setTimeout(function () {
                            window.location.reload();
                        }, 2000);
                    }
                });
            }
        },
        watch: {
            'userInfo.province': function (val, oldVal) {
                if (parseInt(val) === parseInt(oldVal)) {
                    return false;
                }
                let _this = this;
                $.ajax({
                    url: "/base/areas/list",
                    type: "get",
                    data: {
                        parentId: parseInt(val)
                    },
                    success: function (data) {
                        if (data.result) {
                            _this.cities = data.data;
                            _this.userInfo.city = _this.cities[0].id;
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
            },
            'userInfo.city': function (val, oldVal) {
                if (parseInt(val) === parseInt(oldVal)) {
                    return false;
                }
                let _this = this;
                $.ajax({
                    url: "/base/areas/list",
                    type: "get",
                    data: {
                        parentId: parseInt(val)
                    },
                    success: function (data) {
                        if (data.result) {
                            _this.counties = data.data;
                            _this.userInfo.county = oldVal === undefined ? _this.userInfo.county : _this.counties[0].id;
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
            },
            deep: true
        }
    });

</script>
<!--导入图表-->
<#include "./common/component/charts.ftl">

<#include "./common/foot.ftl">