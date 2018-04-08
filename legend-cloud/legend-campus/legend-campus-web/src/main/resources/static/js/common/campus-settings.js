$(document).ready(function () {
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    });

    $._messengerDefaults = {
        extraClasses: 'messenger-fixed messenger-theme-air messenger-on-center-sm'
    };

    Pace.options = {
        ajax: true, // disabled
        document: false, // disabled
        eventLag: false // disabled
    };

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
});