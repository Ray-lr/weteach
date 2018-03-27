<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>test</title>
    <script src="/static/js/jquery-3.3.1.js"></script>
    <script src="/static/js/vue.js"></script>
</head>
<body>
<div id="vm">
    <div>
        <form @submit.prevent="test">
            <input type="text" v-model="url" title="url">
            <select v-model="type" title="type">
                <option value="GET">GET</option>
                <option value="POST">POST</option>
            </select>
            <input type="submit" value="test">
        </form>

    </div>
    <div>
        <ul>
            <li v-for="item in list">{{item}}</li>
        </ul>
    </div>
</div>

<script>
    $(document).ready(function () {
        let vm = new Vue({
            el: "#vm",
            data: {
                url: null,
                type: null,
                list: []
            },
            methods: {
                test: function () {
                    $.ajax({
                        url: vm.url,
                        type: vm.type,
                        success: function (data) {
                            vm.list = data.data;
                        }
                    })
                }
            }
        })
    });
</script>
</body>

</html>