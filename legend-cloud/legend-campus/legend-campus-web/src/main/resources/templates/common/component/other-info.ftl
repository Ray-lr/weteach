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
        <h5 class="card-title font-weight-bold" v-text="userInfo.info.nickname">
        </h5>
        <h6 class="card-title font-weight-normal" v-text="userInfo.user.username"></h6>
        <p class="card-text font-weight-light" v-text="userInfo.info.phone"></p>
    </div>
    <div class="dropdown-divider"></div>
    <div class="card-body">
        <p class="card-text font-weight-light" v-text="userInfo.info.dept"></p>
        <p class="card-text font-weight-light" v-text="userInfo.info.major"></p>
    </div>
    <div class="dropdown-divider"></div>
    <div class="card-body" data-toggle="tooltip"
         data-placement="left" title="当前信誉星级">
        <div id="star" data-num="3.5"></div>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item" v-text="userInfo.info.creditsLevel"></li>
    </ul>
</div>

