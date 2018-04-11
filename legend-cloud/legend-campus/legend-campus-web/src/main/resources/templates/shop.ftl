<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
    <#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">积分商城</h1>

            <hr width=100% size=1 color=#bbbcbc style="border:1 dashed #bbbcbc">

            <div class="col col-md-2" id="personal">

            </div>
            <div class="col-12 col-md-8" id="principal">
                <h3>敬请期待</h3>

            </div>
            <div class="col col-md-2" id="external">

            </div>
        </div>
    </div>
</div>
<script>
    alert("尚未开放，敬请期待！")
    let vm = new Vue({
        el: "#vm",
        data: {},
        beforeCreate: function () {

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