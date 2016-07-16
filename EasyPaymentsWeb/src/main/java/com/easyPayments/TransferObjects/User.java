package com.easyPayments.TransferObjects;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User {

	List<Expense> expenses;
	String name;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(List<Expense> expenses, String name) {
		super();
		this.expenses = expenses;
		this.name = name;
	}
	
}
