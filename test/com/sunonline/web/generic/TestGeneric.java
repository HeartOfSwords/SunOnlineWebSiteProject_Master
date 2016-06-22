package com.sunonline.web.generic;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	
	public static void main(String[] args) {
		List<Base> bases = new ArrayList<>();
		
		Cat cat = new Cat();
		cat.setColor("blue cat");
		bases.add(cat);
		
		Dog dog = new Dog();
		dog.setWeight("1000 dog");
		bases.add(dog);
		
		System.out.println(bases.size());
	}
}
