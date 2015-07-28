
function usersController($scope, $http){
    $http.get('/web/userOperate/hello')
        .success(function(users) {
        $scope.users = users;
    });
}