
var App = angular.module("App", ['ngRoute']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
    when('/start', {templateUrl: 'game/layout'}).

    otherwise({redirectTo: '/start'});
}]);





