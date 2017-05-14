package com.perficient.springservice.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.dao.ExpenseService;
import com.perficient.dao.TaskManagerService;
import com.perficient.springservice.model.ExpenseTO;
import com.perficient.springservice.model.Task;


@RestController
public class ExpenseController {

	
	 ExpenseService expenseService = new ExpenseService();
	 
	 TaskManagerService taskManagerService = new TaskManagerService(); 
	 
	
	 @RequestMapping(value="/expenses",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<ExpenseTO> getAllTasks() {	 
		 List<ExpenseTO> expenseTOs = expenseService.getAllExpenses();
	     return expenseTOs;
	 }
	 
	 /*@RequestMapping(value="/expenses",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<Task> getAllTasks() {	 
		 List<Task> expenseTOs = taskManagerService.getAllTasks();
	     return expenseTOs;
	 }*/
	
	 @RequestMapping(value="/expenses/insert/{expenseName}/{expenseDescription}/{expenseAmount}",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<Task> addExpense(@PathVariable String expenseName,@PathVariable String expenseDescription,@PathVariable String expenseAmount) throws ParseException {	
		 ExpenseTO expenseTO = new ExpenseTO();
		 expenseTO.setExpenseName(expenseName);
		 expenseTO.setExpenseDescription(expenseDescription);
		 expenseTO.setExpenseAmount(expenseAmount);
		 expenseService.addExpense(expenseTO);
		 return taskManagerService.getAllTasks();
		 
	 }	 	 
	
}
