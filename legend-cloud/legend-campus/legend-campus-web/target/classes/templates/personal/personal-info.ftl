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
            <h5 class="card-title font-weight-bold" v-text="userInfo.nickname">
            </h5>
            <h6 class="card-title font-weight-normal" v-text="user.username"></h6>
            <p class="card-text font-weight-light" v-text="userInfo.phone"></p>
        </div>
        <div class="dropdown-divider"></div>
        <div class="card-body">
            <p class="card-text font-weight-light" v-text="userInfo.dept"></p>
            <p class="card-text font-weight-light" v-text="userInfo.major"></p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item" v-text="user.id"></li>
        </ul>
        <div class="card-body">
            <a href="myProfile" class="card-link">详细信息</a>
        </div>
    </div>
</div>
