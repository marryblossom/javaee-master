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
    };
    $scope.userUnlock = function(userId){
        $http.get('/web/userOperate/unlock/'+userId)
            .success(function(){
                $route.reload();
            });
    };
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
    $scope.userGoUpdate = function(userId){
        $scope.userId = userId;
        $("#userId").val(userId);
        //$("#userId").attributes("value");
        $("#userName").val($('#userName'+userId).html());
        $("#employeeName").val($('#employeeName'+userId).html());
        $("#userPass").val($('#password'+userId).html());
        if($('#gender'+userId).html() == "female"){
            $("#genderFemale").prop("checked", true);
        }else{
            $("#genderMale").prop("cheked", true);
        }
        $("#userEmail").val($('#email'+userId).html());
        $("#userIntroduction").val($('#introduction'+userId).html());
        $('#updateData').show();
    };
    $scope.userUpdate = function(){
        $http({
            method: 'POST',
            url: '/web/userOperate/updateUser',
            params: {
                'userId': $("#userId").val(),
                'username': $("#userName").val(),
                'password': $("#userPass").val(),
                'employeename': $("#employeeName").val(),
                'gender':"female",
                'email':$("#userEmail").val(),
                'introduction':$("#userIntroduction").val()
            }
        }).success(function(){
            $route.reload();
        });
    };
    $scope.updateCancel = function(){
        $('#updateData').hide();
    }
}