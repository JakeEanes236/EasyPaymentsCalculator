package com.easyPayments.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PermutationUtil<E> {

	 public List<List<E>> generatePerm(List<E> original) {
	     if (original.size() == 0) { 
	       List<List<E>> result = new ArrayList<List<E>>();
	       result.add(new ArrayList<E>());
	       return result;
	     }
	     E firstElement = original.remove(0);
	     List<List<E>> returnValue = new ArrayList<List<E>>();
	     List<List<E>> permutations = generatePerm(original);
	     for (List<E> smallerPermutated : permutations) {
	       for (int index=0; index <= smallerPermutated.size(); index++) {
	         List<E> temp = new ArrayList<E>(smallerPermutated);
	         temp.add(index, firstElement);
	         returnValue.add(temp);
	       }
	     }
	     return returnValue;
	   }
}
