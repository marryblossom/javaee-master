routeApp.controller('customerShowController',customerShowController);

function customerShowController($scope, $http,$route,$location){
    $http.get('/web/customerOperate/customerShow')
        .success(function(customers) {
            $scope.customers = customers;
        });
    $scope.customerDelete = function(customerId){
        $http.delete('/web/customerOperate/'+customerId)
            .success(function(){
                $route.reload();
            });
    }
    $scope.customerUnlock = function(customerId){
        $http.get('/web/customerOperate/unlockCustomer/'+customerId)
            .success(function(){
                $route.reload();
            });
    }
    $scope.customerAdd = function(){
        $http({
            method: 'POST',
            url: '/web/customerOperate/addCustomer',
            params: {
                'customerName': $scope.customerName,
                'introduction':$scope.introduction
            }
        }).success(function(){
            //$location.path('/customerOperate');
            $route.reload();
        });
    };
}