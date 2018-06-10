<div class="card">
    <a href="#">
        <img class="card-img-top" src="/static/image/avatar/picture1.png"
             data-toggle="tooltip"
             data-placement="bottom" title="点击查看相关信息"
             alt="Card image cap">
        <!--<img class="rounded-0 cover"
                src="/static/image/avatar/Avatar.png"
                alt="Cover">-->
    </a>
    <div class="card-body">
        <h5 class="card-title font-weight-bold" v-text="otherUser.nickname">
        </h5>
        <h6 class="card-title font-weight-normal" v-text="otherUser.username"></h6>
        <p class="card-text font-weight-light" v-text="otherUser.phone"></p>
        <div class="dropdown-divider"></div>
        <p class="card-text font-weight-light" v-text="otherUser.dept_string"></p>
        <p class="card-text font-weight-light" v-text="otherUser.major_string"></p>
        <div class="dropdown-divider"></div>
        <div data-toggle="tooltip"
             data-placement="left" title="当前信誉星级">
            <div class="star" <#--:data-num="otherUser.creditsLevel"-->data-num="3"></div>
        </div>
        <div class="dropdown-divider"></div>
        <p class="card-text font-weight-light">课程完成率:64%</p>
    </div>
</div>

