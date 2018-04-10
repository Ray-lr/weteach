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
                                <input type="hidden" name="id" :value="userInfo.info.id">
                                <!--真实姓名-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput1">真实姓名</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput1"
                                           name="name" :value="userInfo.info.name">
                                </div>
                                <!-- 真实性别 -->
                                <div class="form-group">

                                    <label for="male">男</label>
                                    <input type="radio" name="sex" id="male" :value="userInfo.info.sex" checked/>

                                    <label for="female">女</label>
                                    <input type="radio" name="sex" id="female"/>
                                </div>
                                <!--昵称-->
                                <div class="form-group">
                                    <label for="exampleFormControlInput2">昵称</label>
                                    <input type="text" class="form-control" id="exampleFormControlInput2"
                                           placeholder="18" name="nickname" :value="userInfo.info.nickname">
                                </div>
                                <!--生日-->
                                <div class="form-group">
                                    <label for="birthday" class="col-md-2 control-label">出生日期</label>
                                    <input type="hidden" :value="userInfo.info.birthday" name="birthday"
                                           id="birthday">
                                    <div class="input-group date form_date"
                                         data-link-field="birthday">
                                        <input class="form-control" size="16" type="text"
                                               :value="userInfo.info.birthday | date"
                                               data-toggle="tooltip"
                                               data-placement="left" title="请输入日期"
                                               aria-describedby="dateHelp" placeholder="Date"
                                               readonly>
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-th"></span></span>
                                    </div>
                                    <small id="dateHelp" class="form-text text-muted">

                                    </small>
                                </div>
                                <!--入学年份-->
                                <div class="form-group">
                                    <label for="enrollmentYear">入学年份</label>
                                    <select class="form-control" id="enrollmentYear" name="enrollmentYear"
                                            v-model="userInfo.info.enrollmentYear">
                                        <option value="2014">2014</option>
                                        <option value="2015">2015</option>
                                        <option value="2016">2016</option>
                                        <option value="2017">2017</option>
                                    </select>
                                </div>
                                <!--电话号码-->
                                <div class="form-group">
                                    <label for="phone">手机号</label>
                                    <input type="text" class="form-control" id="phone"
                                           placeholder="1XX-XXXX-XXXX" name="phone" :value="userInfo.info.phone">
                                </div>
                                <!--QQ号码-->
                                <div class="form-group">
                                    <label for="contact">联系方式</label>
                                    <input type="text" class="form-control" id="contact"
                                           name="contact" :value="userInfo.info.contact"
                                           placeholder="QQ，微信或其他">
                                </div>
                                <!--邮箱-->
                                <div class="form-group">
                                    <label for="email">邮箱</label>
                                    <input type="text" class="form-control" id="email"
                                           placeholder="name@example.com" name="email" :value="userInfo.info.email">
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
                                    <label for="province">籍贯</label>
                                    <div class="row">
                                        <!-- 省、直辖市-->
                                        <div class="col-md-4">
                                            <select class="form-control" name="province"
                                                    v-model="userInfo.info.province"
                                                    data-toggle="tooltip"
                                                    data-placement="left" title="请选择">
                                                <option v-for="item in provinces" :value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>
                                        <!-- 市/州 -->
                                        <div class="col-md-4">
                                            <select class="form-control" name="city"
                                                    v-model="userInfo.info.city"
                                                    data-toggle="tooltip"
                                                    data-placement="left" title="请选择">
                                                <option v-for="item in cities" :value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>
                                        <!-- 区/县 -->
                                        <div class="col col-md-4">
                                            <select class="form-control" name="country"
                                                    v-model="userInfo.info.country"
                                                    data-toggle="tooltip"
                                                    data-placement="left" title="请选择">
                                                <option v-for="item in counties" :value="item.id"
                                                        v-text="item.name"></option>
                                            </select>
                                        </div>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1">个性签名</label>
                                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"
                                              name="signature" :value="userInfo.info.signature"></textarea>
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
            courseInfo: {
                list: []
            },
            personInfo: {
                list: []
            },
            myCourseInfo: {
                list: []
            },
            provinces: [{}],
            cities: [{}],
            counties: [{}]
        },
        beforeCreate: function () {

        },
        created: function () {
            vm.provinces = vm.getAreas(0);
            let _this = this;
            //获取我的课程相关
            $.ajax({
                url: "/campus/course/list",
                type: "get",
                data: {
                    userId: _this.userInfo.id
                },
                success: function (data) {
                    if (data.result) {
                        vm.myCourseInfo.list = data.data;
                    }
                }
            });
        },
        methods: {
            update: function (e) {
                $(e.currentTarget).ajaxSubmit({
                    url: "/campus/userInfo/update",
                    type: "POST",
                    data: {
                        _method: "PUT"
                    },
                    success: function (data) {
                        if (data.result) {
                            alert(data.msg);
                            window.location.reload();
                        }
                    }
                });
            },
            getAreas: function (val) {
                let areas = [];
                $.ajax({
                    url: "/base/areas/list",
                    type: "get",
                    data: {
                        parentId: val
                    },
                    success: function (data) {
                        if (data.result) {
                            areas = data.data;
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
                return areas;
            }

        },
        watch: {
            userInfo: {
                province: function () {
                    vm.cities = vm.getAreas(this.userInfo.province);
                },
                city: function () {
                    vm.counties = vm.getAreas(this.userInfo.city);
                }
            }
        }
    });

</script>
<#include "./common/foot.ftl">