routeApp.controller('coursesShowController',coursesShowController);

function coursesShowController($scope, $http,$route){
    $http.get('/web/courseOperate')
        .success(function(courses) {
            $scope.courses = courses;
        });
    $scope.courseDelete = function(courseId){
        $http.delete('/web/courseOperate/'+courseId)
            .success(function(){
                $route.reload();
            });
    }
    $scope.courseUnlock = function(courseId){
        $http.get('/web/courseOperate/unlockCourse/'+courseId)
            .success(function(){
                $route.reload();
            });
    }
    $scope.courseAdd = function(){
        $http({
            method: 'POST',
            url: '/web/courseOperate/addCourse',
            params: {
                'courseName': $scope.courseName,
                'introduction':$scope.introduction
            }
        }).success(function(){
            $route.reload();
        });
    };
}