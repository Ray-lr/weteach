<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
    <#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">Teacher Verify</h1>

            <hr width=100% size=1 color=#bbbcbc style="border:1 dashed #bbbcbc">

            <div class="col col-md-2" id="personal">

            </div>
            <div class="col-12 col-md-8" id="principal">
                <div>
                    <form>

                        <div class="form-group">
                            <label for="exampleFormControlSelect1">认证系别</label>
                            <select class="form-control" id="department" @change="changeDepartment">
                                <option selected="selected" id="departmentOption">-- 请选择系别 --</option>
                                <option v-for="item in departments" :value="item.id"
                                        v-text="item.name"></option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">认证专业</label>
                            <select class="form-control" id="exampleFormControlSelect1">
                                <option selected="selected" id="majorOption">-- 请选择专业 --</option>
                                <option v-for="item in majors" :value="item.id"
                                        v-text="item.name"></option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">认证理由</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">认证文件证明</label>
                            <div class="input-group mb-3">

                                <div class="input-group-prepend">
                                    <button class="btn btn-outline-secondary" type="button">Upload</button>
                                </div>
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="inputGroupFile03">
                                    <label class="custom-file-label" for="inputGroupFile03">Choose file</label>
                                </div>
                            </div>
                        </div>
                        <div align="center" style="height:150px;">
                            <button id="dd" type="button" class="btn btn-success btn-lg btn-block"
                                    data-toggle="modal" data-target="#myModal" onclick="textChange()">提交申请
                            </button>
                            <!-- 模态框（Modal） -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                                 aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">

                                            <h4 class="modal-title" id="myModalLabel">
                                                提示
                                            </h4>
                                        </div>
                                        <div class="modal-body">
                                            您的申请已提交，请耐心等待一到两个工作日，我们会在第一时间给您消息，谢谢。
                                        </div>
                                        <div class="modal-footer">
                                            <button id="qd" type="button" class="btn btn-light" data-dismiss="modal">确定
                                            </button>

                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal -->
                            </div>
                        </div>


                    </form>

                </div>
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
            departments: [],
            majors: [],
        },
        beforeCreate: function () {
            $.ajax({
                url: "/campus/major/list",
                type: "get",
                data: {
                    typeMajor: 1
                },
                success: function (data) {
                    if (data.result) {
                        vm.departments = data.data;
                    }

                }
            });
            /* $.ajax({
                 url: "/campus/major/list",
                 type:"get",
                 data: {
                     typeMajor: 2
                 },
                 success: function (data) {
                     if (data.result) {
                         vm.majors = data.data;
                     }

                 }
             });*/
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
            },
            changeDepartment: function (e) {
                $.ajax({
                    url: "/campus/major/list",
                    type: "get",
                    data: {
                        deptId: e.target.value
                    },
                    success: function (data) {
                        if (data.result) {
                            vm.majors = data.data;
                            $("#majorOption").prop("selected", "selected");
                        }
                    }
                })
            },

        }
    })
    /*submit点击后不可选取*/
    $(document).ready(function () {
        $("#qd").click(function () {
            $("#dd").addClass('diabled');
            $("#dd").prop('disabled', true);
        });
    });

    /*submit点击后文字改变*/
    function textChange() {
        document.getElementById("dd").innerHTML = "请耐心等待";
    }
</script>
<#include "./common/foot.ftl">