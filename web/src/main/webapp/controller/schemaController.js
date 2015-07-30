routeApp.controller('schemasShowController',schemasShowController);

function schemasShowController($scope, $http,$route){
    $http.get('/web/schemaOperate/schemaShow')
        .success(function(schemas) {
            $scope.schemas = schemas;
        });
    $http.get('/web/schemaOperate/schemaEmployeeShow')
        .success(function(employees) {
            $scope.employees = employees;
            $http.get('/web/schemaOperate/schemaCourseShow')
                .success(function(courses) {
                    $scope.courses = courses;
                });
        });

    $scope.schemaDelete = function(schemaId){
        $http.delete('/web/schemaOperate/'+schemaId)
            .success(function(){
                $route.reload();
            });
    }
    $scope.schemaAdd = function(){
        //$http.post('/web/schemaOperate/addSchema',{'courseId':$scope.courseId,'coachId': $scope.coachId,'date': $scope.date})
        //    .success(function(){
        //
        //    });
        $http({
            method: 'POST',
            url: '/web/schemaOperate/addSchema',
            params: {
                'courseId': $scope.courseId,
                'coachId': $scope.coachId,
                'date': $scope.date
            }
        }).success(function(){
            $route.reload();
        });
    };
}