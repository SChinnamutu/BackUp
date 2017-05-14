<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app="expenseApp">

<head>


<link href='./css/style.css' rel="stylesheet" type="text/css"></link>
<link href='./css/css/font-awesome.css' rel="stylesheet" type="text/css"></link>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<script data-require="angular.js@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular.js"></script>
<script data-require="angular-animate@*" data-semver="1.2.13" src="http://code.angularjs.org/1.2.13/angular-animate.js"></script>
<script type="text/javascript" src="./js/expense.js"></script>
<script type="text/javascript" src="./js/app.js"></script>

</head>

<body>

<div ng-controller="expenseController">

<h2 class="page-title">Various Expenses</h2>

	
	
	<div id="add-task-panel" class="fadein fadeout addpanel panel" ng-hide="toggle">
		
		<div class="panel-heading">
			<i class="panel-title-icon fa fa-plus"></i>
			<span class="panel-title">Add Expense</span>
			<div class="panel-heading-controls">
				<button ng-click="toggle = !toggle" class="btn-panel">Show All Expense</button>
			</div>
		</div>
		
		<div class="panel-body">
			<div class="task" >
				<table class="add-task">
					<tr>
						<td>Expense Name:</td>
						<td><input type="text" ng-model="expenseName"/></td>
					</tr>
					<tr>
						<td>Expense Description:</td>
						<td><input type="text" ng-model="expenseDescription"/></td>
					</tr>
					<tr>
						<td>Expense Amount:</td>
						<td><input type="text" ng-model="expenseAmount"/></td>
					</tr>
					<tr>
						<td><br/><button ng-click="addExpense()" class="btn-panel-big">Add New Expense</button></td>
					</tr>
				</table>								
			</div>
		</div>
	</div>

	<div id="task-panel" class="fadein fadeout showpanel panel"  ng-show="toggle">	
		
		<div class="panel-heading">
			
			<i class="panel-title-icon fa fa-tasks"></i>
			
			<span class="panel-title">Recent Expense</span>
			
			<div class="panel-heading-controls">
				<button ng-click="toggle = !toggle" class="btn-panel">Add New Expense</button>
				<button class="btn-panel" confirmed-click="archiveTasks()" ng-confirm-click="Would you like to archive completed tasks?">Clear completed tasks</button>
			</div>
			
		</div>
	
		  <div class="panel-body">
			<div class="task" ng-repeat="task in expenses">
				<span class="priority priority-red">
					{{task.expenseName}}
				</span>
				<span class="priority priority-yellow">
					{{task.expenseDescription}}
				</span>
				<span class="priority priority-green">
					{{task.expenseAmount}}
				</span>
			</div>
		</div>
		
		
		
	</div>
	

	
</div>
</body>
</html>