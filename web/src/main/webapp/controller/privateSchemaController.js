routeApp.controller('privateSchemaController',privateSchemaController);

function privateSchemaController($scope, $http,$route){
    $http.get('/web/privateSchemaOperate/schemaPrivateShow')
        .success(function(schemas) {
            $scope.schemas = schemas;
        });
    //$http.get('/web/schemaOperate/schemaEmployeeShow')
    //    .success(function(employees) {
    //        $scope.employees = employees;
    //    });
    //$http.get('/web/schemaOperate/schemaCourseShow')
    //    .success(function(courses) {
    //        $scope.courses = courses;
    //    });
    //$http.get('/web/privateSchemaOperate/schemaPrivateCustomer')
    //    .success(function(customers) {
    //        $scope.customers = customers;
    //    });
    $scope.privateSchemaDelete = function(schemaId){
        $http.delete('/web/schemaOperate/'+schemaId)
            .success(function(){
                $route.reload();
            });
    }
    $scope.privateSchemaAdd = function(){
        $http({
            method: 'POST',
            url: '/web/privateSchemaOperate/addPrivateSchema',
            params: {
                'courseId': $scope.courseId,
                'coachId': $scope.coachId,
                'customerId': $scope.customerId,
                'date': $scope.date
            }
        }).success(function(){
            $route.reload();
        });
    };
}