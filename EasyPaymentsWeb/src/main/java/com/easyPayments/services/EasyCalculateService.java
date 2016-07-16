package com.easyPayments.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyPayments.TransferObjects.Payment;
import com.easyPayments.TransferObjects.PaymentCalculatorInput;
import com.easyPayments.TransferObjects.Situation;
import com.easyPayments.components.CalculatePaymentComponent;

@Transactional
@Service
public class EasyCalculateService {

	@Autowired
	CalculatePaymentComponent calcPayment;
	public List<Payment> retrieveCalculatedPayments(PaymentCalculatorInput input){
		//TODO logic and calls for calculation logic
		Situation bestSituation = calcPayment.CalculateBestSituation(input.getUsers());
		return bestSituation.getPayments();
	}
}
