<#include "./common/head.ftl">
<div id="vm">

</div>
<#include "common/js.ftl">
<script>
    let vm = new Vue({
        el: "#vm",
        contentType: "application/json;charset=utf-8",
        beforeCreate: function () {
            Messenger().post({
                id: "loginMessenger",
                message: ${msg},//提示信息
                type: 'error',//消息类型。error、info、success
                hideAfter: 0,//多长时间消失
                showCloseButton: false,//是否显示关闭按钮
                hideOnNavigate: false//是否隐藏导航
            });
        }
    });
</script>
<#include "./common/foot.ftl">