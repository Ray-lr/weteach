<div class="card">
    <a href="#">
        <img class="card-img-top" src="/static/image/avatar/Avatar.png"
             data-toggle="tooltip"
             data-placement="bottom" title="点击查看相关信息"
             alt="Card image cap">
        <!--<img class="rounded-0 cover"
                src="/static/image/avatar/Avatar.png"
                alt="Cover">-->
    </a>
    <div class="card-body">
        <h5 class="card-title font-weight-bold" v-text="user.nickname">
        </h5>
        <h6 class="card-title font-weight-normal" v-text="user.username"></h6>
        <p class="card-text font-weight-light" v-text="user.phone"></p>
        <div class="dropdown-divider"></div>
        <p class="card-text font-weight-light" v-text="user.dept"></p>
        <p class="card-text font-weight-light" v-text="user.major"></p>
        <div class="dropdown-divider"></div>
        <div data-toggle="tooltip"
             data-placement="left" title="当前信誉星级">
            <div class="star" :data-num="user.creditsLevel"></div>
        </div>
        <div class="dropdown-divider"></div>
        <p class="card-text font-weight-light">课程完成率:64%</p>
    </div>
</div>

