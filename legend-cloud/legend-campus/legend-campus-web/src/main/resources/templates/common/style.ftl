<style>
    /*清除超链接下划线，目前还存在问题*/
    #hhh {
        text-decoration: none;
    }

    /*课程标题加粗，超越限制省略且显示省略号...*/
    .courseTitle {
        text-align: left;
        text-decoration: none !important;
        font-weight: bold;
        text-overflow: ellipsis;
        white-space: nowrap;
        width: 90%;
        overflow: hidden;
    }

    /*课程内容最多展示两行内容，去除超链接下划线，多余省略且显示省略号*/
    .courseDescription {
        width: 100%;
        word-break: break-all;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        overflow: hidden;
        text-decoration: none !important;
    }
    /*段落首行缩进2字符*/
    p {
        text-indent: 2em; /*em是相对单位，2em即现在一个字大小的两倍*/
    }
</style>