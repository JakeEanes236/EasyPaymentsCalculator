package com.ex;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	private List<Expense> myExpenses = new ArrayList<>();
	private double owedToExpenses;
	private double owedToRoommates;
	private boolean iOweMoney;
	
	double amountIOwe;
	double amountImOwed;
	

	public User(){}
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(String name, List<Expense> myExpenses) {
		super();
		this.name = name;
		this.myExpenses = myExpenses;
		calculateOwedToExpenses();
	}
	
	private void calculateOwedToExpenses(){
		for(Expense expense : myExpenses){
			owedToExpenses += expense.getAmount();
		}
	}

	//TODO: account for owedToRoommates == 0
	public void calculateOwedToRoommates(double totalIShouldPay) {
		this.owedToRoommates = totalIShouldPay - owedToExpenses;
		if(this.owedToRoommates > 0){
			this.iOweMoney = true;
		}else {
			this.iOweMoney = false;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isiOweMoney() {
		return iOweMoney;
	}

	public List<Expense> getMyExpenses() {
		return myExpenses;
	}

	public void setMyExpenses(List<Expense> myExpenses) {
		this.myExpenses = myExpenses;
	}

	public double getOwedToExpenses() {
		return owedToExpenses;
	}

	public double getOwedToRoommates() {
		return owedToRoommates;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", myExpenses=" + myExpenses + ", owedToExpenses=" + owedToExpenses
				+ ", owedToRoommates=" + owedToRoommates + ", iOweMoney=" + iOweMoney + "]";
	}

	
	
	
	
}
