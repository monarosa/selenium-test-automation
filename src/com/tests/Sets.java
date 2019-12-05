package com.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Sets {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
//		
//		list.add("a");
//		list.add("a");
//		
//		System.out.println(list);
//		System.out.println(list.get(0));
		
		// set guarantees that every element is unique
		Set<String> set = new HashSet<>();
		
		set.add("a");
		System.out.println(set);
		set.add("b");
		System.out.println(set);
		set.add("a");
		System.out.println(set);
		
		for (String string : set) {
			System.out.println(string);
		}
		
	}
}




