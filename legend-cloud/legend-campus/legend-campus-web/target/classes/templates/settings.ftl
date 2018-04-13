<#include "common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
    <#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <div class="col col-md-3" id="personal">
                <!-- 个人信息 -->
                <div class="card">
                    <a href="#">
                        <img class="card-img-top" src="/static/image/avatar/Avatar.png"
                             data-toggle="tooltip"
                             data-placement="bottom" title="更换头像"
                             alt="Card image cap">
                    </a>
                    <div class="card-body">
                        <h5 class="card-title font-weight-bold">{{user.nickName}}
                        </h5>
                        <h6 class="card-title font-weight-normal">{{user.username}}</h6>
                        <p class="card-text font-weight-light">{{user.phone}}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Cras justo odio</li>
                    </ul>
                    <div class="card-body">
                        <a href="/direct/myProfile" class="card-link">详细信息</a>
                    </div>
                </div>
            </div>
            <div class="col-12 col-md-6" id="principal">

            </div>
            <div class="col col-md-2" id="external">

            </div>
        </div>
    </div>
</div>
<#include "common/js.ftl">
<script>
    let vm = new Vue({
        el: "#vm",
        data: {
            user: "",

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
                url: "/base/user/getUser",
                type: "GET",
                success: function (data) {
                    if (data.result) {
                        vm.user = data.data;
                    }
                }
            });
            $.ajax({
                url: "/campus/course/studyList",
                type: "GET",
                success: function (data) {
                    if (data.result) {
                        vm.study.list = data.data;
                    }
                }
            })
        },
        created: function () {
        },
        updated: function () {
        },
        methods: {
            search: function (e) {
                alert($(e.currentTarget).val());
            },
            SignOut: function () {
                $.ajax({
                    url: "/base/user/logout",
                    type: "POST",
                    data: {
                        _method: "PUT"
                    },
                    success: function (data) {
                        if (data.result) {
                            window.location.href = data.url;
                        }
                    }
                })
            }
        }
    })
</script>
<#include "common/foot.ftl">