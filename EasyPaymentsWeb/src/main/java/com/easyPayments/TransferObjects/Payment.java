package com.easyPayments.TransferObjects;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Payment {

	User from;
	User to;
	BigDecimal amount;

	Payment() {}

	public Payment(User from, User to, BigDecimal amount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
	};
	
}
