$(document).ready(function () {
    /**
     * bootstrap的相关设置
     */
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    });

    /**
     * messenger的相关设置
     */
    $._messengerDefaults = {
        extraClasses: 'messenger-fixed messenger-theme-air messenger-on-center-sm'
    };

    /**
     * Pace的相关设置
     */
    Pace.options = {
        ajax: true, // disabled
        document: false, // disabled
        eventLag: false // disabled
    };

    /**
     * dateTimePicker的相关设置
     */
    $('.form_datetime').datetimepicker({
        format: "yyyy-mm-dd hh:ii",
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        clearBtn: 1,
        forceParse: 0
    });

    $('.form_date').datetimepicker({
        format: "yyyy-mm-dd",
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        clearBtn: 1,
        forceParse: 0
    });

    $('.form_time').datetimepicker({
        format: "hh:ii",
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        clearBtn: 1,
        forceParse: 0
    });

    /**
     * 星级插件设置
     */
    $(".star").raty({
        score: function () {
            return $(this).attr("data-num");
        },
        starOn: '/static/external/star-rating/image/star-on.png',
        starOff: '/static/external/star-rating/image/star-off.png',
        starHalf: '/static/external/star-rating/image/star-half.png',
        readOnly: true,
        halfShow: true,
        size: 34,
    });

    /**
     * iCheck插件设置
     */
    $('input').iCheck({
        checkboxClass: 'icheckbox_minimal-blue',
        radioClass: 'iradio_minimal-blue',
        increaseArea: '20%' // optional
    });
});