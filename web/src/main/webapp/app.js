var routeApp = angular.module('user_manager', ['ngRoute']);
routeApp.config(function ($routeProvider) {
    $routeProvider
        .when('/userOperate/hello', {
            templateUrl: 'views/users.html',
            controller: 'usersShowController'
        })
        .when('/courseOperate',{
            templateUrl: 'views/courses.html',
            controller: 'coursesShowController'
        })
        .when('/customerOperate',{
            templateUrl: 'views/customers.html',
            controller: 'customerShowController'
        });

        //.when('/list/:id', {
        //    templateUrl: 'views/route/detail.html',
        //    controller: 'RouteDetailCtl'
        //})
        //.otherwise({
        //    redirectTo: '/list'
        //});
});
//angular.module('user_manager', ['ngRoute']).
//    config(function($routeProvider) {
//        $routeProvider.
//            when('/userOperate/hello', {templateUrl: 'views/users.html',   controller:usersShowController}).
//            when('/courseOperate', {templateUrl: 'views/courses.html',   controller:coursesShowController});
//            //when('/phones/:phoneId', {templateUrl: 'partials/phone-detail.html', controller: PhoneDetailCtrl}).
//            //otherwise({redirectTo: '/phones'});
//    });