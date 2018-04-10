/**
 * 全局变量
 */
Vue.prototype.userInfo = null;

/**
 * 全局函数
 */
Vue.prototype.search = function (val) {
    alert(val);
};

/**
 * 全局过滤器
 */
Vue.filter('dateTime', function (value) {
    return new Date(value).Format('yyyy-MM-dd hh:mm:ss');
});
Vue.filter('date', function (value) {
    return new Date(value).Format('yyyy-MM-dd');
});
Vue.filter('time', function (value) {
    return new Date(value).Format('hh:mm:ss');
});
