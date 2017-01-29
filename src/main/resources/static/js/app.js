
var App = angular.module("App", ['ngRoute']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
    when('/start', {templateUrl: 'game/layout'}).

    otherwise({redirectTo: '/start'});
}]);


App.directive('tabIndex', function () {
    return {
        restrict: 'A',
        scope: {
            indextab: '@'
        },
        link: function (scope, $scope) {

            $scope.datasetTab = scope.indextab;

        }
    }
});


App.directive( 'editInPlace', function() {
    return {
        restrict: 'E',
        scope: { value: '=',
                 object: '='},
        template: '<span data-ng-click="edit()" data-ng-bind="value"></span><input data-ng-model="value">',
        link: function ( $scope, element, attrs ) {
            // Let's get a reference to the input element, as we'll want to reference it.
            var inputElement = angular.element( element.children()[1] );

            // This directive should have a set class so we can style it.
            element.addClass( 'edit-in-place' );

            // Initially, we're not editing.
            $scope.editing = false;

            // ng-click handler to activate edit-in-place
            $scope.edit = function () {
                $scope.editing = true;

                // We control display through a class on the directive itself. See the CSS.
                element.addClass( 'active' );

                // And we must focus the element.
                // `angular.element()` provides a chainable array, like jQuery so to access a native DOM function,
                // we have to reference the first element in the array.
                inputElement[0].focus();
            };

            // When we leave the input, we're done editing.
            inputElement.prop( 'onblur', function() {
                $scope.editing = false;
                element.removeClass( 'active' );

            });
            
            $scope.$apply();
            $scope.editTopic(object)	
          
        }
    };
});




