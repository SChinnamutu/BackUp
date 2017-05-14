package com.perficient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perficient.springservice.model.ExpenseTO;
import com.perficient.springservice.utility.DBUtility;

public class ExpenseService {

	 private Connection connection;

	
	public ExpenseService() {
		  connection = DBUtility.getConnection();
	}
	
	public List<ExpenseTO> getAllExpenses() {
		 List<ExpenseTO> expenseTOs = new ArrayList<ExpenseTO>();
		  try {
			   Statement statement = connection.createStatement();
			   ResultSet rs = statement.executeQuery("select * from expenses_list");
			   while (rs.next()) {
			    ExpenseTO expenseTO = new ExpenseTO();
			    expenseTO.setId(rs.getInt("expense_id"));
			    expenseTO.setExpenseName(rs.getString("expense_name"));
			    expenseTO.setExpenseDescription(rs.getString("expense_description"));    
			    expenseTO.setExpenseAmount(rs.getString("expense_amount"));
			    expenseTOs.add(expenseTO);
			   }
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
	  return expenseTOs;
	}

	public void addExpense(ExpenseTO expenseTO) {
			  try {
			   PreparedStatement preparedStatement = connection .prepareStatement("insert into expenses_list"
			   		+ "(expense_name,expense_description,expense_amount) values (?, ?, ?)");
			   preparedStatement.setString(1, expenseTO.getExpenseName());
			   preparedStatement.setString(2, expenseTO.getExpenseDescription());   
			   preparedStatement.setString(3, expenseTO.getExpenseAmount());
			   preparedStatement.executeUpdate();
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
		
	}

}
