<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>error</title>
    <script src="/js/jquery-3.2.1.js"></script>
    <script src="/js/jquery.form.js"></script>
    <script src="/js/vue.js"></script>
</head>
<body>
<div id="vm">
    <div>error</div>
</div>
<script>
    $.get("/campus/campusCourse/list", function (data) {
        alert(data.msg);
    })
</script>
</body>
</html>