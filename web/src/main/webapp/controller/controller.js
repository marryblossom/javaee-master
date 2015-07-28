angular.module('app', [])
    .controller("ctrl", function ($scope) {
        $scope.btns = {
            ibm : 'ibm',
                ib:'88888'
        };
        $scope.hello = "hello world";
    })
    .controller("phones", PhoneListCtrl)
    .controller("people", PeopleListCtrl)
    .controller('parentCtrl', ['$scope', function($scope) {
        $scope.args = 'IBM DeveloperWorks';
    }])
    .controller('childCtrl', ['$scope', function($scope) {
    }]);


function PhoneListCtrl($scope, $http) {
    $http.get('angular/phones.json').success(function(data){
        $scope.phones = data;
        //$scope.phones = data.splice(0, 1);//过滤只显示一个数据
    });
}


function PeopleListCtrl($scope, $http){
    $http.get('angular/phones.json').success(function(data) {//phones.json是相对于index.html的路径
        $scope.phones = data;
    });

    $scope.orderProp = 'age';
}