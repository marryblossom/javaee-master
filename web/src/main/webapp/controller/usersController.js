routeApp.controller('usersShowController',usersShowController);

function usersShowController($scope, $http,$route){
    $http.get('/web/userOperate/hello')
        .success(function(users) {
        $scope.users = users;
    });
    $scope.userDelete = function(userId){
        $http.delete('/web/userOperate/'+userId)
            .success(function(){
               $route.reload();
        });
    }
    $scope.userUnlock = function(userId){
        $http.get('/web/userOperate/unlock/'+userId)
            .success(function(){
                $route.reload();
            });
    }
    $scope.userAdd = function(){
        $http({
            method: 'POST',
            url: '/web/userOperate/addUserAndEmployee',
            params: {
                'username': $scope.userName,
                'password': $scope.userPass,
                'employeename': $scope.employeeName,
                'gender':$scope.userGender,
                'email':$scope.userEmail,
                'introduction':$scope.userIntroduction
            }
        }).success(function(){
            $route.reload();
        });
    };
}