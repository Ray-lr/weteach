Vue.filter('dateTime', function (value) {
    return new Date(value).Format('yyyy-MM-dd hh:mm:ss');
});
Vue.filter('date', function (value) {
    return new Date(value).Format('yyyy-MM-dd');
});
Vue.filter('time', function (value) {
    return new Date(value).Format('hh:mm:ss');
});