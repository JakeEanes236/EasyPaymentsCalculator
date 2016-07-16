package com.easyPayments.TransferObjects;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PaymentCalculatorOutput {

	List<Payment> payments;
	
	public PaymentCalculatorOutput() {
		// TODO Auto-generated constructor stub
	}

	public PaymentCalculatorOutput(List<Payment> payments) {
		super();
		this.payments = payments;
	}
	
}