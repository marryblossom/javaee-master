angular.module('user_manager', ['ngRoute']).
    config(function($routeProvider) {
        $routeProvider.
            when('/userOperate/hello', {templateUrl: 'views/users.html',   controller:usersController});
            //when('/phones/:phoneId', {templateUrl: 'partials/phone-detail.html', controller: PhoneDetailCtrl}).
            //otherwise({redirectTo: '/phones'});
    });