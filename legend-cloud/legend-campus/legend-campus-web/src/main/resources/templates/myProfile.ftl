<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "./common/top.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
        <#include "./personal/personal-info.ftl">
            <div class="col-12 col-md-8" id="principal">
                <!-- 课程列表 -->
                <div class="row-fluid" id="courseList">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="study-tab" data-toggle="tab" href="#study" role="tab"
                               aria-controls="study" aria-selected="true">我的课程相关</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="teaching-tab" data-toggle="tab" href="#teaching" role="tab"
                               aria-controls="teaching" aria-selected="false">个人信息中心</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="other-tab" data-toggle="tab" href="#other" role="tab"
                               aria-controls="other" aria-selected="false">浏览历史</a>
                        </li>
                    </ul>

                    <div class="tab-content" id="courseContent">
                        <!-- first list -->
                        <!--我的课程相关-->
                        <div class="tab-pane fade show active" id="study" role="tabpanel" aria-labelledby="study-tab">
                            <div class="card">
                                <div class="card-header bg-whitesmoke-tp25" id="headingOne">
                                    <h5 class="mb-0">
                                        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne"
                                                aria-expanded="true" aria-controls="collapseOne">
                                            First Item
                                        </button>
                                    </h5>
                                </div>

                                <div id="collapseOne" class="collapse " aria-labelledby="headingOne"
                                     data-parent="#accordion">
                                    <div class="card-body">
                                        <img class="rounded-left cover" src="/static/image/avatar/Avatar.png"
                                             alt="Cover">
                                        aaa
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- second list -->
                        <!-- 个人信息完善 -->
                        <div class="tab-pane fade" id="teaching" role="tabpanel" aria-labelledby="teaching-tab">
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
                                    <input type="text" class="form-control" id="dateTime"
                                           name="dateTime"
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
                                    <select class="form-control" id="exampleFormControlSelect1">
                                        <option>2014</option>
                                        <option>2015</option>
                                        <option>2016</option>
                                        <option>2017</option>
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
                                <!-- 籍贯 -->
                                <div class="form-group">
                                    <label for="exampleFormControlSelect1">籍贯</label>
                                    <div class="row">
                                        <!-- 省、直辖市-->
                                        <div class="col-md-4">
                                            <select class="form-control" id="province">
                                                <option>-- 省/直辖市/自治区 --</option>
                                                <option v-for="item in provinces" value="item.id"
                                                        v-text="item.name"></option>

                                            </select>
                                        </div>
                                        <!-- 市/州 -->
                                        <div class="col-md-4">
                                            <select class="form-control" id="city">
                                                <option>-- 市/自治州 --</option>
                                                <option v-for="item in cities" value="item.id"
                                                        v-text="item.name"></option>

                                            </select>
                                        </div>
                                        <!-- 区/县 -->
                                        <div class="col col-md-4">
                                            <select class="form-control" id="county" name="native_place">
                                                <option>-- 区/县 --</option>
                                                <option v-for="item in counties" value="item.id"
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
            study: {
                list: []
            },
            teaching: {
                list: []
            },
            other: {
                list: []
            },
            provinces: [],
            cities: [],
            counties: []
        },
        beforeCreate: function () {

            $.ajax({
                url: "/base/areas/list",
                data: {
                    typeAreas: 1
                },
                success: function (data) {
                    if (data.result) {
                        vm.provinces = data.data;
                    }
                }
            });
        },
        created: function () {
            let _this = this;
            $.get("/campus/userInfo/detail/" + _this.user.id, function (data) {
                if (data.result) {
                    vm.userInfo = data.data;
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
            }
        }
    })
</script>
<#include "./common/foot.ftl">