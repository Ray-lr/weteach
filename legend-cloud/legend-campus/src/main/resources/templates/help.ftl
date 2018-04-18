<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">To Users</h1>

            <hr class="line">

        </div>
    </div>
</div>
<#include "common/js.ftl">
<script>
    Messenger().post({
        id: "error",
        message: "尚未开放，敬请期待！",//提示信息
        type: 'error',//消息类型。error、info、success
        hideAfter: 0//多长时间消失
        showCloseButton: false,//是否显示关闭按钮
        hideOnNavigate: false//是否隐藏导航
    });
</script>
<#include "./common/foot.ftl">