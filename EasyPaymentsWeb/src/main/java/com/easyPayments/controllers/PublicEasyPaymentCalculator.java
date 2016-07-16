package com.easyPayments.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easyPayments.TransferObjects.PaymentCalculatorInput;
import com.easyPayments.TransferObjects.PaymentCalculatorOutput;
import com.easyPayments.services.EasyCalculateService;

@RestController
public class PublicEasyPaymentCalculator {

	@Autowired
	EasyCalculateService  calcService;
	@RequestMapping(value = "/calculate", method=RequestMethod.POST)
	public PaymentCalculatorOutput prepareUserExpenses(@RequestBody PaymentCalculatorInput input){
		PaymentCalculatorOutput output = new PaymentCalculatorOutput(calcService.retrieveCalculatedPayments(input));
		return output;
	}
}
