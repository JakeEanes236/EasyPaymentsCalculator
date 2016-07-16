package com.easyPayments.TransferObjects;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PaymentCalculatorInput {

	List<User> users;
	
	public PaymentCalculatorInput() {
		// TODO Auto-generated constructor stub
	}

	public PaymentCalculatorInput(List<User> users) {
		super();
		this.users = users;
	}
	
}
