package com.easyPayments.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.easyPayments.TransferObjects.Payment;
import com.easyPayments.TransferObjects.PaymentCalculatorInput;
import com.easyPayments.TransferObjects.PaymentCalculatorOutput;

@RestController
public class PublicEasyPaymentCalculator {

	
	PaymentCalculatorInput input;
	public void prepareUserExpenses(){
		//TODO call calculate service;
		
	}
	
	public PaymentCalculatorOutput prepareUserPayments(List<Payment> payments){
		PaymentCalculatorOutput output = new PaymentCalculatorOutput(payments);
		return output;
	}
}
