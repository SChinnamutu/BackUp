var taskManagerModule = angular.module('expenseApp', ['ngAnimate']);

taskManagerModule.controller('expenseController', function ($scope,$http) {
	
	var urlBase = "http://localhost:8080/TaskManagerApp";
	$scope.toggle = true;
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
	
	//get all tasks and display initially
	$http.get(urlBase+'/expenses').
    	success(function(data) {
    		alert(data);
	        $scope.expenses = data;
    });
	
	
 


	//add a new task
	$scope.addExpense = function addExpense() {
		if($scope.expenseName == "" || $scope.expenseDescription == "" || $scope.expenseAmount == "" ){
			alert("Insufficient Data! Please provide values for expense name, description, priortiy and status");
		}
		else{
		 $http.post(urlBase + '/expenses/insert/' +$scope.expenseName+'/'+$scope.expenseDescription+'/'+$scope.expenseAmount).
		  success(function(data) {
			 alert("Expenses added");
			 $scope.expenses = data;	
			 $scope.expenseName = "";
			 $scope.expenseDescription = "";
			 $scope.expenseAmount = "";
			 //$scope.id = "";
			 $scope.toggle='!toggle';			 
		    });
		}
	};

	
});

	/*// toggle selection for a given task by task id
	  $scope.toggleSelection = function toggleSelection(taskId) {
	    var idx = $scope.selection.indexOf(taskId);

	    // is currently selected
	    if (idx > -1) {
	      $http.post(urlBase + '/tasks/' +taskId+'/ACTIVE').
		  success(function(data) {
			 alert("Task unmarked");archiveTasks()
			 
			 $scope.tasks = data;		       
		    });
	      $scope.selection.splice(idx, 1);
	    }

	    // is newly selected
	    else {
	      $http.post(urlBase + '/tasks/' +taskId+'/COMPLETED').
		  success(function(data) {
			 alert("Task marked completed");
			 $scope.tasks = data;
		    });
	      $scope.selection.push(taskId);
	    }
	  };
*/	  
	
	// Archive Completed Tasks
	/*$scope.archiveTasks = function archiveTasks() {
		  $http.post(urlBase + '/tasks/archive/' + $scope.selection).
		  success(function(data) {
			  $scope.tasks = data;
		       alert("Successfully Archived");
		    });
	  };
	
	});*/

	/*//Angularjs Directive for confirm dialog box
	taskManagerModule.directive('ngConfirmClick', [
		function(){
	         return {
	             link: function (scope, element, attr) {
	                 var msg = attr.ngConfirmClick || "Are you sure?";
	                 var clickAction = attr.confirmedClick;
	                 element.bind('click',function (event) {
	                     if ( window.confirm(msg) ) {
	                         scope.$eval(clickAction);
	                     }
	                 });
	             }
	         };
	 }] );*/


