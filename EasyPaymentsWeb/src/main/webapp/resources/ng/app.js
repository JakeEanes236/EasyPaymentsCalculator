/**
 * 
 */

angular.module("EPApp", ["ui.router",
                         "ui.bootstrap",
                         "ngAnimate"
                         ]);

angular.module("EPApp")
.config(function($stateProvider, $urlRouterProvider) {
  //
  // For any unmatched url, redirect to /state1
  $urlRouterProvider.otherwise("/home");
  //
  // Now set up the states
  $stateProvider
    .state('HomeState', {
      url: "/home",
      controller : "HomeCtrl as hData",
      templateUrl: "resources/ng/templates/home.html"
    })
    .state('CalculatorState', {
      url: "/calculator",
      templateUrl: "resources/ng/templates/calculator.html",
      controller: "CalculatorCtrl as cData"
    });
  
});

angular.module("EPApp")
.controller("SidebarCtrl", function($state){
	var sidebarData = this;
	
	sidebarData.$state = $state;
	
});

angular.module("EPApp")
.controller("HomeCtrl", function(){
	
});

angular.module("EPApp")
.controller("CalculatorCtrl", function(EPService){
	var calculatorData = this;
	
//	calculatorData.users = EPService.testInput.users;
	calculatorData.users = [];
	
	calculatorData.addUser = function(newUserName){
		var newUser = {
				name : newUserName,
				myExpenses : []
		};
		
		calculatorData.users.unshift(newUser);
	}
	
	calculatorData.removeUser = function(userToRemove){
		calculatorData.users.splice(calculatorData.users.indexOf(userToRemove), 1);
	}
	
	calculatorData.addUserExpense = function(user, newExpenseName, newExpenseAmount){
		
		var newExpense = {
				name   : newExpenseName,
				amount : newExpenseAmount
		};
		
		user.myExpenses.unshift(newExpense);
		
	}
	
	calculatorData.removeUserExpense = function(user, expenseToRemove){
		user.myExpenses.splice(user.myExpenses.indexOf(expenseToRemove), 1);
	}
	
	calculatorData.calculate = function(){
		
		calculatorData.result = null;
		calculatorData.showResults = true;
		calculatorData.hideConfig = true;
		
		var input = {
			users : calculatorData.users
		};
		
		var promise = EPService.calculate(input);
		
		promise.then(function(response){
			//success
			calculatorData.result = response.data;
		}, function(response){
			//error
		});
		
	}
	
	
	
	
});


angular.module("EPApp")
.service("EPService", function($http){
  var epserviceData = this;
  
  epserviceData.calculate = function(input){
	  return $http({
		  method:"POST",
		  url:"calculate",
		  data:input
	  });
  }
  
  /*
  epserviceData.testInput = {
	    "users" : [
	            
	            {
	                "name":"jacob",
	                "myExpenses":[
	                        {
	                            "name":"cable",
	                            "amount":150
	                        },
	                        {
	                            "name":"electric",
	                            "amount":76.50
	                        }
	                    ]
	            },
	            
	            {
	                "name":"Taylor",
	                "myExpenses":[
	                        {
	                            "name":"trash",
	                            "amount":45
	                        }
	                    ]
	            },

	            {
	                "name":"jeff",
	                "myExpenses":[
	                        {
	                            "name":"water",
	                            "amount":230
	                        }
	                    ]
	            },
	            {
	                "name":"david",
	                "myExpenses":[
	                        {
	                            "name":"douchbag jar",
	                            "amount":80
	                        }
	                    ]
	            },
	            {
	                "name":"antonio",
	                "myExpenses":[
	                        {
	                            "name":"nothing",
	                            "amount":0
	                        }
	                    ]
	            }
	        
	        ]
	};
	*/
});
