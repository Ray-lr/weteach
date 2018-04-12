<nav class="navbar navbar-expand-lg navbar-dark bg-grayblack-tp90 sticky-top">
    <div class="container">
        <!-- 图标 -->
        <a class="navbar-brand" id="Logo" href="/direct/index">
            <img src="/static/image/icon/bootstrap-solid.png" width="30" height="30"
                 class="d-inline-block align-top"
                 alt="Logo">
        </a>
        <!-- 搜索框 -->
        <form class="form-inline my-1 my-lg-0 input-group-sm">
            <input class="form-control mr-sm-1 rounded " type="search" placeholder="Search"
                   aria-label="Search"
                   @keyup.enter="this.search($event)">
        </form>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler-left"
                aria-controls="navbarToggler-left" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- 内容 -->
        <div class="collapse navbar-collapse" id="navbarToggler-left">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <!--主页index-->
                <li class="nav-item ">
                    <a class="nav-link " href="/direct/index">Home <span class="sr-only">(current)</span></a>
                </li>
                <!--个人中心具体选项-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink1"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        个人中心
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink1">
                        <a class="dropdown-item" href="/direct/myProfile?type=course">我的课程相关</a>
                        <a class="dropdown-item" href="/direct/myProfile?type=personal">个人信息中心</a>
                        <a class="dropdown-item" href="/direct/myProfile?type=data">我的数据统计</a>
                    </div>
                </li>
                <!--发布publish-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink2"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        发布课程
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink2">
                        <a class="dropdown-item" href="/direct/publish?type=seek">求学贴</a>
                        <a class="dropdown-item" href="/direct/publish?type=teach">教学贴</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/direct/messages">消息中心</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/direct/shop">积分商城</a>
                </li>


            </ul>
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="personalMenu"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <img class="avatar-small image-fluid rounded" src="/static/image/avatar/Avatar.png"
                             alt="Avatar">
                    </a>
                    <div class="dropdown-menu" aria-labelledby="personalMenu">
                        <a class="dropdown-item" href="/direct/myProfile?type=course">个人主页</a>
                    <#if currentUser??>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/direct/publish">发布课程</a>
                    </#if>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/direct/settings">设置</a>
                        <a class="dropdown-item" href="/direct/help">帮助</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item " href="/logout">退出登录</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>