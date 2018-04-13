<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    let myChart;
    myChart = echarts.init(document.getElementById('semester'));
    myChart = echarts.init(document.getElementById('pie'));
    //将每个要实例化的图表放入数组内
    let charts = [];

    /*柱状图*/
    mychart = echarts.init(semester);
    // 指定图表的配置项和数据
    option = {
        title: {
            text: '本学期参与课程'
        },
        tooltip: {},
        legend: {
            data: ['参与课程数']
        },
        xAxis: {
            data: ["第一周", "第二周", "第三周", "第四周", "第五周", "第六周", "第七周", "第八周", "第九周", "第十周",
                "第十一周", "第十二周", "第十三周", "第十四周", "第十五周", "第十六周", "第十七周", "第十八周"]
        },
        yAxis: {},
        series: [{
            name: '参与课程数',
            type: 'bar',
            data: [0, 0, 1, 3, 0, 2, 4, 7, 5, 3, 1, 0, 0, 0, 3, 2, 9, 0]
        }]
    };
    //实例化图表
    mychart.setOption(option);
    charts.push(myChart);

    /*饼图*/
    var mychart = echarts.init(pie);
    // 指定图表的配置项和数据
    option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
        },
        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: [
                    {value: 335, name: '直接访问'},
                    {value: 310, name: '邮件营销'},
                    {value: 234, name: '联盟广告'},
                    {value: 135, name: '视频广告'},
                    {value: 1548, name: '搜索引擎'}
                ]
            }
        ]
    };
    mychart.setOption(option);
    charts.push(myChart);

    window.onresize = function () {
        for (var i = 0; i < charts.length; i++) {
            charts[i].resize();
        }
    };

    /*// 绘制图表。
    echarts.init(document.getElementById('pie')).setOption({
        series: {
            type: 'pie',

            label: {
                normal: {
                    show: true,
                    formatter: '{b}: {c}({d}%)'
                }
            },

            data: [
                {name: '总课程发布数', value: 0},
                {name: '总课程参与数', value: 23},
                {name: '总课程完成数', value: 20}
            ]
        }
    });*/
    window.addEventListener("resize", function () {
        myChart.resize();
    });
</script>