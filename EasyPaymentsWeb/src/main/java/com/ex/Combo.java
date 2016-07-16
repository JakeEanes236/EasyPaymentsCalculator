package com.ex;

import java.util.List;

public class Combo {
	private List<User> one;
	private List<User> two;
	
	public Combo(){}

	public Combo(List<User> one, List<User> two) {
		super();
		this.one = one;
		this.two = two;
	}

	public List<User> getOne() {
		return one;
	}

	public void setOne(List<User> one) {
		this.one = one;
	}

	public List<User> getTwo() {
		return two;
	}

	public void setTwo(List<User> two) {
		this.two = two;
	}

	@Override
	public String toString() {
		return "Combo [one=" + one + ", two=" + two + "]";
	}
	
	
	
}
