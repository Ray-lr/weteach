<nav class="navbar navbar-expand-lg navbar-dark bg-grayblack-tp90 sticky-top">
    <div class="container">
        <!-- 图标 -->
        <a class="navbar-brand" id="Logo" href="index">
            <img src="/static/image/icon/bootstrap-solid.png" width="30" height="30"
                 class="d-inline-block align-top"
                 alt="Logo">
        </a>
        <!-- 搜索框 -->
        <form class="form-inline my-1 my-lg-0 input-group-sm">
            <input class="form-control mr-sm-1 rounded " type="search" placeholder="Search"
                   aria-label="Search"
                   @keyup.enter="search($event)">
        </form>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler-left"
                aria-controls="navbarToggler-left" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- 内容 -->
        <div class="collapse navbar-collapse" id="navbarToggler-left">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item ">
                    <a class="nav-link " href="index">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        Dropdown link
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
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
                        <a class="dropdown-item" href="myProfile">MyProfile</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="settings">Settings</a>
                        <a class="dropdown-item" href="messages">Messages</a>
                        <a class="dropdown-item" href="#">Help</a>
                        <a class="dropdown-item " href="/logout">Sign out</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>