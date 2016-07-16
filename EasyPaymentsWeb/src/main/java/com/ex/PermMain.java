package com.ex;

import java.util.ArrayList;
import java.util.List;

/*
 * m! * n!
 * 
 * number of permutations between two lists
 */
public class PermMain {
	
	public static List<Combo> findPermTwoLists(List<User> one, List<User> two){
		
		PermUtil<User> permUtil = new PermUtil<>();
		
		List<List<User>> onePerms = permUtil.generatePerm(one);
		List<List<User>> twoPerms = permUtil.generatePerm(two);
		
		List<Combo> comboList = new ArrayList<>();
		
		for(List<User> oneTemp : onePerms){
			for(List<User> twoTemp : twoPerms){
				comboList.add(new Combo(oneTemp, twoTemp));
			}
		}
		
		return comboList;
	}
	
	
//	public static void main(String[] args) {
//		
//		List<Integer> integerList = new ArrayList<>();
//		
//		integerList.add(1);
//		integerList.add(2);
//		integerList.add(3);
//		integerList.add(4);
//		
//		
//		PermUtil<Integer> permUtil = new PermUtil<>();
//		
//		List<List<Integer>> integerListPermutations = permUtil.generatePerm(integerList);
//		
//		List<String> stringList = new ArrayList<>();
//		
//		stringList.add("a");
//		stringList.add("b");
//		stringList.add("c");
//		stringList.add("d");
//		
//		
//		PermUtil<String> permUtil2 = new PermUtil<>();
//		
//		List<List<String>> stringListPermutations = permUtil2.generatePerm(stringList);
//		
//		List<Combo> comboList = new ArrayList<>();
//		
//		for(List<Integer> integerTemp : integerListPermutations){
//			for(List<String> stringTemp : stringListPermutations){
//				comboList.add(new Combo(integerTemp, stringTemp));
//			}
//		}
//		
//	}
}
