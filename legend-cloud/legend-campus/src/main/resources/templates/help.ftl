<#include "./common/head.ftl">
<div id="vm">
    <!--顶部功能栏-->
<#include "common/component/navbar.ftl">

    <div class="container margin-top10" id="principal">
        <div class="row">
            <h1 class="alert-heading">用户手册</h1>
            <hr class="line">
        </div>
        <div>
            <div class="col col-2">

            </div>
            <div class="col col-10">
                <!--关于页面使用-->
                <h2 class="alert alert-primary">关于页面使用</h2>
                <!--顶端功能栏-->
                <div class="alert alert-info">
                    <h3 style="text-indent:2em">顶端功能栏</h3>
                    <div style="text-indent:2em">
                        <p>页面顶端是一个具有导航性质的功能栏，它存在于每一个页面内。
                            上面的元素有系统logo，搜索栏，主页，个人信息中心，课程发布，积分商城，个人头像。
                            其中系统logo，主页，个人信息中心，课程发布，积分商城都能连接到相应页面，而个人头像则可以展开，
                            里面有三个功能，连接到个人中心，连接到帮助页面和退出登录。</p>
                    </div>
                </div>
                <!--个人信息卡-->
                <div class="alert alert-info">
                    <h3 style="text-indent:2em">个人信息卡</h3>
                    <div style="text-indent:2em">
                        <p>在部分与用户关联密切的页面里，会在页面左侧栏布置一个用户个人信息卡他上面展示了用户的昵称，
                            实名，联系电话，系别专业与个性签名，同时还有两个连接，可以直接连接到个人信息中心和验证教师资格。</p>
                    </div>
                </div>
                <!--课程分页栏-->
                <div class="alert alert-info">
                    <h3 style="text-indent:2em">课程分页栏</h3>
                    <div style="text-indent:2em">
                        <p>课程展示有三种类型的展示，一种是求学课程贴，展示系统里所有的求学贴；一种是教学课程贴，
                            展示系统里所有的教学贴；最后是我参与的贴，展示我申请授课的教学贴与我报名参加的求学贴。</p>
                    </div>
                </div>
                <!--关于系统业务-->
                <h2 class="alert alert-primary">关于系统业务</h2>
                <!--求学贴-->
                <div class="alert alert-info">
                    <h3 style="text-indent:2em">求学贴</h3>
                    <div style="text-indent:2em">
                        <p>学生在平时的学校学习生活中，总是会有这么一些情况发生：有的会对部分课程感到苦手，
                            或是理解不透，或是出于其他原因影响了学习，有的人又亦或是学有余力，对于课时之外的东西产生了兴趣，
                            但没有途径，从而欲学而不得；不管那种情况，学生都想从一些途径来补学或多学，在本系统内，
                            学生可以发布求学贴，找“老师来帮助自己”。</p>
                    </div>
                </div>
                <!--教学贴-->
                <div class="alert alert-info">
                    <h3 style="text-indent:2em">教学贴</h3>
                    <div style="text-indent:2em">
                        <p>于是应于这些需求，我们开发了这个系统，让学生来当老师，教其他学生知识。
                            让学生做老师有这么些好处，一是老师只有一个，没有那么多精力和时间来解决所有同学的问题；
                            二是同学与同学相互交流更加轻松融洽，容易拉进距离；第三是学生当老师去教别人，
                            同时等于是在自我巩固，帮自己复习，是双方共同促进进步的好方法。</p>
                    </div>
                </div>
                <!--教师资格-->
                <div class="alert alert-info">
                    <h3 style="text-indent:2em">教师资格</h3>
                    <div style="text-indent:2em">
                        <p>教师资格需要认证，认证需要相应证明，举个例子，一位同学想要教英语，成为英语老师，
                            那么英语必须要好，那么用户就要提交相关的证明材料，例如四级证书，期末英语成绩单一类的证明材料，
                            提交后系统会审核，审核通过了才能拥有相应的教师资格</p>
                    </div>
                </div>
                <!--关于积分系统-->
                <h2 class="alert alert-primary">关于积分系统</h2>
                <!--积分获取-->
                <div class="alert alert-info">
                    <h3 style="text-indent:2em">积分获取</h3>
                    <div style="text-indent:2em">
                        <p>对于每一位学生，系统都在信息导入之初赠送了30积分，初次之外，学生们需要验证了教师资格，
                            成为了“老师”后，去申请授课或是主动开课，以此来赚取积分</p>
                    </div>
                </div>
                <!--积分损耗-->
                <div class="alert alert-info">
                    <h3 style="text-indent:2em">积分损耗</h3>
                    <div style="text-indent:2em">
                        <p>当学生发布求学贴请求帮助时，或者参与其他“老师”所开设的教学贴时，
                            都要根据发起者所设置的数额交纳一定的积分</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "common/bottom.ftl">
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