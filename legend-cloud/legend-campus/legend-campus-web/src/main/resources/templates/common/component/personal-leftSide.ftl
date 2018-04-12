<div class="col col-md-3" id="personal">
    <!-- 个人信息 -->
    <div class="card">
        <a href="#">
            <img class="card-img-top" src="/static/image/avatar/Avatar.png"
                 data-toggle="tooltip"
                 data-placement="bottom" title="更换头像"
                 alt="Card image cap">
        </a>
        <div class="card-body">
            <h5 class="card-title font-weight-bold" v-text="user.nickname"></h5>
            <h6 class="card-title font-weight-normal" v-text="user.username"></h6>
            <div class="dropdown-divider"></div>
            <p class="card-text font-weight-light" v-text="user.dept+'-'+user.major"></p>
            <div class="dropdown-divider"></div>
            <p class="card-text font-weight-light" v-text="user.signature"></p>
        </div>
        <div class="dropdown-divider"></div>
        <div class="card-body">
            <a href="/direct/myProfile?type=course" class="card-link">详细信息</a>
            <a href="/direct/verify" class="card-link">教师认证</a>
        </div>
    </div>
</div>
