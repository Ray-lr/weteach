<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/js/vue.js"></script>
<script src="/static/js/jquery.form.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/jquery-validate.js"></script>
<script src="/static/external/HubSpot-messenger/build/js/messenger.js"></script>
<script src="/static/external/pace-master/pace.js"></script>
<script src="/static/external/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="/static/external/star-rating/jquery.raty.js"></script>
<script src="/static/external/icheck-1.x/icheck.js"></script>
<script src="/static/js/plugin/popper.js"></script>
<script src="/static/js/plugin/echarts.js"></script>
<script src="/static/js/common/vue/vue-global.js"></script>
<script src="/static/js/common/customize/validate-methods.js"></script>
<script src="/static/js/common/customize/date.js"></script>
<script src="/static/js/common/campus-settings.js"></script>
<script>
    Vue.prototype.user = <#if currentUser??>${currentUser}<#else>null</#if>;
</script>