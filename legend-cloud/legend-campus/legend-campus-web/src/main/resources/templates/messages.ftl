<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
    <#include "./common/top.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <div class="col col-md-3" id="personal">

            </div>
            <div class="col-12 col-md-6" id="principal">

            </div>
            <div class="col col-md-2" id="external">

            </div>
        </div>
    </div>
</div>
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
<#include "./common/foot.ftl">