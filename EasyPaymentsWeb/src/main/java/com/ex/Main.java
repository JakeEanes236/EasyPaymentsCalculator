package com.ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//.3-.2=.1
//Currency, BigDecimal
/*
 * TODO: remove user when no longer owes or owed in Situation
 * 
 * TODO: find way around reseting amountIOwe and amountIAmOwed variables
 * 
 * TODO: don't use floating point number, use BigDecimal or Currency instead
 * 
 * TODO: make dope ass app		
 */
public class Main {
	public static void main(String[] args) {
		
		Expense cable = new Expense(89.86);
		Expense electric = new Expense(104);
		Expense gas = new Expense(42.43);
//		Expense water = new Expense(225);
		Expense trashWater = new Expense(-24);
		
		
		List<Expense> jakesExpenses = new ArrayList<>();
		jakesExpenses.add(cable);
		jakesExpenses.add(electric);
		
		List<Expense> taylorsExpenses = new ArrayList<>();
		taylorsExpenses.add(gas);
//		taylorsExpenses.add(water);
		
		
		
		List<Expense> antoniosExpenses = new ArrayList<>();
		
		List<Expense> jeffsExpenses = new ArrayList<>();
		jeffsExpenses.add(trashWater);
		
//		List<Expense> davidExpenses = new ArrayList<>();
//		davidExpenses.add(three);
		
		
		
		User jake = new User("Jake", jakesExpenses);
		User taylor = new User("Taylor", taylorsExpenses);		
		User antonio = new User("Antonio", antoniosExpenses);
		User jeff = new User("Jeff", jeffsExpenses);
//		User david = new User("David", davidExpenses);
		
		
		
		List<User> roommates = new ArrayList<>();
		roommates.add(jake);
		roommates.add(taylor);
		roommates.add(antonio);
		roommates.add(jeff);
//		roommates.add(david);
		
		
		
		
		setup(roommates);
		
		for(User roommate : roommates){
			System.out.println(roommate.getName() + "\t" + roommate.getOwedToRoommates() + "\t" + roommate.isiOweMoney());
		}

		
		
		
		
		
		/*
		 * test brute force	
		 */
		Situation bestSituation = findBestSituation(roommates);
		
		for(Payment temp : bestSituation.payments){
			System.out.println(temp.getFrom().getName() + "\t" + temp.getTo().getName() + "\t" + temp.getAmount());
		}
		
//		bruteForceNumFewestPayments(roommates);
		
		
		
	}

	public static void setup(List<User> roommates){
		/*
		 * Get total
		 */
		double total = 0;
		for(User roommate : roommates) {
			total += roommate.getOwedToExpenses();
		}
		
		System.out.println(total);
		
		/*
		 * Calculate what each person still owes
		 */
		double totalForEachRoommate = total / roommates.size();
		System.out.println("Total for each roommate: " + totalForEachRoommate);
		for(User roommate : roommates){
			roommate.calculateOwedToRoommates(totalForEachRoommate);
		}

	}
	
	public static void setAmountsOwedAndOwes(List<User> roommates){
		/*
		 * Set amountIOwe and amountImOwed
		 */
		for(User temp : roommates){
			if(temp.isiOweMoney()){
				temp.amountIOwe = temp.getOwedToRoommates();
			}else {
				temp.amountImOwed = temp.getOwedToRoommates() * -1;
			}
		}
	}
	
	public static Situation findBestSituation(List<User> roommates){
		
		List<Situation> situationList = new ArrayList<>();
		
		List<User> roommatesWhoOwe = new ArrayList<>();
		List<User> roommatesWhoAreOwed = new ArrayList<>();
		
		/*
		 * Split owed vs whoOwes
		 */
		for(User temp : roommates){
			if(temp.isiOweMoney()){
				roommatesWhoOwe.add(temp);
			}else {
				roommatesWhoAreOwed.add(temp);
			}
		}
		
		
		/*
		 * ASSERT: we have 2 lists
		 * 
		 * Need to get all permutations of those two lists
		 */
		List<Combo> allPerms = PermMain.findPermTwoLists(roommatesWhoAreOwed, roommatesWhoOwe);
		
		for(Combo combo : allPerms){
			Situation situation = new Situation();
			
			setAmountsOwedAndOwes(roommates); //yay
			
			List<User> owedList = combo.getOne();
			List<User> whoOwesList = combo.getTwo();
			
			Iterator<User> owedIter = owedList.iterator();
			
			outer:
			while(owedIter.hasNext()){
				Iterator<User> whoOwesIter = whoOwesList.iterator();
				
				User owed = owedIter.next();
				double owedAmount = owed.amountImOwed;
				
				while(whoOwesIter.hasNext()){
					
					User whoOwes = whoOwesIter.next();
					double whoOwesAmount = whoOwes.amountIOwe;
					
					
					if(owedAmount < whoOwesAmount){
						whoOwes.amountIOwe -= owedAmount;
						owed.amountImOwed = 0;
						situation.payments.add(new Payment(whoOwes, owed, owedAmount));
						
						//TODO: payout outer person
						//		remove outer person
//						owedIter.remove();
						continue outer;
					}else if(owedAmount > whoOwesAmount){
						whoOwes.amountIOwe = 0;
						owed.amountImOwed -= whoOwesAmount;
						situation.payments.add(new Payment(whoOwes, owed, whoOwesAmount));
						
						//TODO: payout outer person
						//		remove inner person
//						whoOwesIter.remove();
						continue;
					}else {
						whoOwes.amountIOwe = 0;
						owed.amountImOwed  = 0;
						situation.payments.add(new Payment(whoOwes, owed, owedAmount));
						
						//TODO: payout outer person
						//		remove both inner and outer people
//						owedIter.remove();
//						whoOwesIter.remove();
						continue outer;

					}
					
					
					
				}
			}
			
			
			situationList.add(situation);
		}
		
		
		
		
		Collections.sort(situationList);
		System.out.println("size: " + situationList.size());
		if(situationList.size() > 0){
			return situationList.get(0);
		}else {
			return null;
		}
		
		
	}

	
	
	
	public static void bruteForceNumFewestPayments(List<User> roommates){
		
		List<User> roommatesWhoOwe = new ArrayList<>();
		List<User> roommatesWhoAreOwed = new ArrayList<>();
		
		for(User temp : roommates){
			if(temp.isiOweMoney()){
				roommatesWhoOwe.add(temp);
				temp.amountIOwe = temp.getOwedToRoommates();
			}else {
				roommatesWhoAreOwed.add(temp);
				temp.amountImOwed = temp.getOwedToRoommates() * -1;
			}
		}
		
		Iterator<User> oweIter = roommatesWhoOwe.iterator();
		Iterator<User> owedIter = roommatesWhoAreOwed.iterator();
		
		while (owedIter.hasNext()) {
			
			User owedUser = owedIter.next();
			double tempAmountImOwed = owedUser.amountImOwed;
			
			while (oweIter.hasNext()) {
				User oweUser = oweIter.next();
				double tempAmountIOwe = owedUser.amountIOwe;
				
				if(tempAmountIOwe <= tempAmountImOwed) {
					
				}
				
				
			}
		}
		
		
		
	}
	
}



