package com.easyPayments.TransferObjects;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Expense {

	BigDecimal amount;
	String name;
	
	Expense() {}

	public Expense(BigDecimal amount, String name) {
		super();
		this.amount = amount;
		this.name = name;
	};
	
}
