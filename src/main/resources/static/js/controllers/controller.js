
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






	$rootScope.fetchTopics = function(){
		$http.get('topic/topicslist.json').success(function(topics){
			var newTopics = [];
			
			angular.forEach(topics, function(topic){
				newTopic = new Topic(topic);
				newTopics.push(newTopic);

				$scope.countVotes(newTopic.id);
			});
			
			$rootScope.topics = newTopics;
		});
	}

	$scope.addTopic = function(topic){
	    http.post('topic/add', topic).success(function(){
	        alert("topic :'"+ topic.name +"' added");
        })
    }

	$scope.editTopic = function(topic){
		$http.post('topic/edit', topic).success(function(){
			$scope.fetchTopics();
		})
	}

	$scope.addVote = function(vote){
	    $http.post('vote/add', vote).success(function(){
	        $scope.countVotes(vote.referenceId);
        })
    }

    $scope.countVotes = function(topicId){
	    $http.get('vote/count/'+topicId).success(function(countVotes){
	        $scope.getTopic(topicId).countVotes = countVotes;
	    })
    }






    /**
     *  Execution on reload
     */
    $scope.fetchItems();
    $scope.fetchScores();
    $scope.getWelcome();

});



