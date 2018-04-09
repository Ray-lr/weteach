<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "common/top.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
        <#include "./personal/personal-info.ftl">
            <div class="col-12 col-md-8" id="principal">
                <!-- 课程列表 -->
                <div class="row-fluid" id="courseList">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="courseInfo-tab" data-toggle="tab" href="#courseInfo"
                               role="tab"
                               aria-controls="courseInfo" aria-selected="false">我的课程相关</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="personInfo-tab" data-toggle="tab" href="#personInfo" role="tab"
                               aria-controls="personInfo" aria-selected="true">个人信息中心</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="dataInfo-tab" data-toggle="tab" href="#dataInfo" role="tab"
                               aria-controls="dataInfo" aria-selected="false">我的数据统计</a>
                        </li>
                    </ul>

                    <div class="tab-content" id="courseContent">
                        <!-- first list -->
                        <!--我的课程相关-->
                        <div class="tab-pane fade show active" id="courseInfo" role="tabpanel"
                             aria-labelledby="courseInfo-tab">
                            <div class="card" v-for="(item,index) of myCourseInfo.list">
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
                        <!-- second list -->
                        <!-- 个人信息完善 -->
                        <div class="tab-pane fade" id="personInfo" role="tabpanel" aria-labelledby="personInfo-tab">
                            <form @submit.prevent="update($event)">
                                <!--隐藏的id-->
                                <input type="hidden" name="id" :value="userInfo.id">
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
                                <label for="dateTime">出生日期</label>
                                <div class="input-group date form_datetime">
                                    <input type="datetime-local" class="form-control" id="dateTime"
                                           :value="userInfo.birthday"
                                           name="birthday"
                                           data-toggle="tooltip"
                                           data-placement="left" title="请输入日期"
                                           aria-describedby="dateTimeHelp" placeholder="Date Time"
                                           readonly>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                                <small id="dateTimeHelp" class="form-text text-muted">

                                </small>
                                <!--入学年份-->
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">入学年份</label>
                                    <select class="form-control" id="exampleFormControlSelect1" name="enrollmentYear">
                                        <option>{{userInfo.enrollmentYear}}</option>
                                        <option :value="2014">2014</option>
                                        <option :value="2015">2015</option>
                                        <option :value="2016">2016</option>
                                        <option :value="2017">2017</option>
                                    </select>
                                </div>
                                <!--电话号码-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput3">手机号</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput3"
                                           placeholder="1XX-XXXX-XXXX" name="phone" :value="userInfo.phone">
                                </div>
                                <!--QQ号码-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput4">QQ号</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput4"
                                           name="qicq" :value="userInfo.qicq">
                                </div>
                                <!--邮箱-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput5">邮箱</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput5"
                                           placeholder="name@example.com" name="email" :value="userInfo.email">
                                </div>
                            <#--
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
                                        <a class="dropdown-item" href="#">other emails</a>
                                    </div>
                                </div>
                            </div>-->
                                <!-- 籍贯 -->
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">籍贯</label>
                                    <div class="row">
                                        <!-- 省、直辖市-->
                                        <div class="col-md-4">
                                            <select class="form-control" id="province" name="provinces"
                                                    @change="changeProvince">
                                                <option selected="selected" id="provinceOption" v-text="province"
                                                        :value="userInfo.provinces"></option>
                                                <option v-for="item in provinces.list" :value="item.id"
                                                        v-text="item.name"></option>

                                            </select>
                                        </div>
                                        <!-- 市/州 -->
                                        <div class="col-md-4">
                                            <select class="form-control" id="city" name="cities" @change="changeCity">
                                                <option selected="selected" id="cityOption" v-text="city"
                                                        :value="userInfo.cities"></option>
                                                <option v-for="item in cities" :value="item.id"
                                                        v-text="item.name"></option>

                                            </select>
                                        </div>
                                        <!-- 区/县 -->
                                        <div class="col col-md-4">
                                            <select class="form-control" id="country" name="countries">
                                                <option id="countryOption" selected="selected" v-text="country"
                                                        :value="userInfo.countries"></option>
                                                <option v-for="item in countries" :value="item.id"
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
                        <!--浏览历史-->
                        <div class="tab-pane fade" id="dataInfo" role="tabpanel" aria-labelledby="data-tab">
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
<script>
    let vm = new Vue({
        el: "#vm",
        data: {
            user: ${currentUser},
            userInfo: "",
            province: "--省/直辖市/自治区--",
            city: "--市/自治州--",
            country: "--区/县--",
            courseInfo: {
                list: []
            },
            personInfo: {
                list: []
            },
            myCourseInfo: {
                list: []
            },
            provinces: {
                list: []
            },
            cities: [],
            countries: []
        },
        beforeCreate: function () {
            /*查省*/
            $.ajax({
                url: "/base/areas/list",
                type: "get",
                data: {
                    typeAreas: 1
                },
                success: function (data) {
                    if (data.result) {
                        vm.provinces.list = data.data;
                    }
                }
            });


        },
        created: function () {
            let _this = this;
            //获取我的课程相关
            $.ajax({
                url: "/campus/course/list",
                type: "get",
                data: {
                    userId: _this.user.id
                },
                success: function (data) {
                    if (data.result) {
                        vm.myCourseInfo.list = data.data;
                    }

                }
            });
            $.get("/campus/userInfo/detail/" + _this.user.id, function (data) {
                if (data.result) {
                    vm.userInfo = data.data;
                    if (data.data.provinces != "" && data.data.cities != "" && data.data.countries != "") {
                        $.ajax({
                            url: "/base/areas/getAreaName",
                            type: "get",
                            data: {
                                provinceId: data.data.provinces,
                                cityId: data.data.cities,
                                countryId: data.data.countries
                            },
                            success: function (e) {
                                vm.province = e.data[0];
                                vm.city = e.data[1];
                                vm.country = e.data[2];
                                $.ajax({
                                    url: "/base/areas/list",
                                    data: {
                                        parentId: data.data.provinces
                                    },
                                    success: function (data) {
                                        if (data.result) {
                                            vm.cities = data.data;
                                        }
                                    }
                                });
                                $.ajax({
                                    url: "/base/areas/list",
                                    data: {
                                        parentId: data.data.cities
                                    },
                                    success: function (data) {
                                        if (data.result) {
                                            vm.countries = data.data;
                                        }
                                    }
                                });
                            }
                        })
                    }
                }
            });
        },
        updated: function () {

        },
        methods: {
            search: function (e) {
                alert($(e.currentTarget).val());
            },
            update: function (e) {
                $(e.currentTarget).ajaxSubmit({
                    url: "/campus/userInfo/update",
                    type: "PUT",

                    success: function (data) {
                        if (data.result) {
                            alert(data.msg);
                            window.location.reload();
                        }
                    }
                });
            },
            changeProvince: function (e) {
                $.ajax({
                    url: "/base/areas/list",
                    data: {
                        parentId: e.target.value
                    },
                    success: function (data) {
                        if (data.result) {
                            vm.cities = data.data;
                            /*当省改变的时候，将市的选择框改为未选择的默认值*/
                            $("#cityOption").html("--市/自治州--");
                            $("#countryOption").html("--区/县--");
                            $("#cityOption").val(0);
                            $("#countryOption").val(0);
                            vm.countries = null;
                        }
                    }
                });
            },
            changeCity: function (e) {
                $.ajax({
                    url: "/base/areas/list",
                    data: {
                        parentId: e.target.value
                    },
                    success: function (data) {
                        if (data.result) {
                            vm.countries = data.data;
                        }
                    }
                });
            },

        }
    })
    /*指定进入页面显示的分页*/
    var navTab = window.location.search;
    $(document).ready(function () {
        if (navTab == "?person") {
            $("#courseInfo-tab").removeClass("active");
            $("#courseInfo").removeClass("active").removeClass("show");
            $("#personInfo-tab").addClass("active");
            $("#personInfo").addClass("active").addClass("show");
        }
        if (navTab == "?data") {
            $("#courseInfo-tab").removeClass("active");
            $("#courseInfo").removeClass("active").removeClass("show");
            $("#dataInfo-tab").addClass("active");
            $("#dataInfo").addClass("active").addClass("show");
        }
    });
</script>
<#include "./common/foot.ftl">