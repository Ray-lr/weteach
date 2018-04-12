<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录</title>
    <meta content="text/html" charset="utf-8">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/external/HubSpot-messenger/build/css/messenger.css" media="screen">
    <link rel="stylesheet" href="/static/external/HubSpot-messenger/build/css/messenger-theme-air.css" media="screen">
    <link rel="stylesheet" href="/static/external/pace-master/themes/black/pace-theme-material.css" media="screen">
    <link rel="stylesheet" href="/static/external/bootstrap-datetimepicker-master/css/datetimepicker.css"
          media="screen">
    <link rel="stylesheet" href="/static/external/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css"
          media="screen">
    <link rel="stylesheet" href="/static/css/bootstrap.css" media="screen">
    <link rel="stylesheet" href="/static/external/star-rating/jquery.raty.css" media="screen">
    <link rel="stylesheet" href="/static/css/main-campus.css" media="screen">
    <link rel="stylesheet" href="/static/external/star-rating/jquery.raty.css" media="screen">
    <link rel="stylesheet" href="/static/external/icheck-1.x/skins/all.css">
    <link rel="stylesheet" href="/static/external/icheck-1.x/skins/minimal/_all.css">

</head>
<body>
<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/js/jquery.form.js"></script>
<script src="/static/js/popper.js"></script>
<script src="/static/js/vue.js"></script>
<script src="/static/external/HubSpot-messenger/build/js/messenger.js"></script>
<script src="/static/external/pace-master/pace.js"></script>
<script src="/static/external/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script src="/static/external/star-rating/jquery.raty.js"></script>
<script src="/static/external/icheck-1.x/icheck.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/jquery-validate.min.js"></script>
<script src="/static/js/date.js"></script>
<script src="/static/js/common/vue/vue-global.js"></script>
<script src="/static/js/common/campus-settings.js"></script>
<script src="/static/js/echarts.common.min.js"></script>
<script>
    Vue.prototype.user = <#if currentUser??>${currentUser}<#else>null</#if>;
</script>