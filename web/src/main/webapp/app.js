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
        })
        .when('/schemaOperate',{
            templateUrl: 'views/schemas.html',
            controller: 'schemasShowController'
        });
        //.when('/privateSchemaOperate',{
        //    templateUrl: 'views/privateSchemas.html',
        //    controller: 'privateSchemaController'
        //});
    //otherwise({redirectTo: '/phones'});
});