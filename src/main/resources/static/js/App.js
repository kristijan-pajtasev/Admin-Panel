var app = angular.module("AdminPanel", ["ngResource"]);

app.controller("MainController", ["$scope", "$http", "Files", function($scope, $http, Files){
    console.log("MainController");
    $scope.folders = Files.post();

    this.goToFolder = function(folder) {
        if(folder.directory) {
            $scope.folders = Files.post(folder.absolutePath);
        }
    };

    this.getClass = function(file) {
        if(file.directory) {
            return "glyphicon glyphicon-folder-open";
        }
        return "glyphicon glyphicon-file";
    };

    this.logout = function() {
        $http.post("/logout").then(function(){window.location.href= "/logout";});
    };
}]);

app.factory('Files', ['$resource', function($resource) {
    return $resource('/content', null,
        {
            'post': { method:'POST', isArray: true },
            'get': { method:'GET', isArray: true }
        });
}]);
