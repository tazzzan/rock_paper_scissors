
App.controller('simpleController', function ($rootScope, $http, $scope) {

    $scope.items = [];
    $scope.scores = [];

    $scope.played = false;
    $scope.resultText = "";
    $scope.itemPCName = "";

    $scope.welcomeMessage = "";
    
/**
 * 	AJAX
 */
    $scope.fetchItems = function(){
        $http.get('game/items.json').success(function(items){
            $scope.items = items;
        })
    }

    $scope.fetchScores = function(){
        $http.get('game/score/').success(function(scores){
            $scope.scores = scores;
        })
    }

    $scope.play = function(item){
        $http.post('game/play/' + item.name).success(function(reply){
            $scope.played = true;
            $scope.resultText = reply.text;
            $scope.itemPCName = reply.itemPC;
            $scope.fetchScores();
        })
    }

    $scope.getWelcome = function(){
        $http.get('game/welcome').success(function(reply){
            $scope.welcomeMessage = reply.text;
        })
    }

    $scope.restartTheGame = function(){
        $http.post('game/restart').success(function(){
            $scope.fetchScores();
        })
    }





    /**
     *  Execution on reload
     */
    $scope.fetchItems();
    $scope.fetchScores();
    $scope.getWelcome();

});



