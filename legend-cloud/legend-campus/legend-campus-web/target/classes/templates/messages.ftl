<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
    <#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">消息中心</h1>

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
    })
</script>
<#include "./common/foot.ftl">