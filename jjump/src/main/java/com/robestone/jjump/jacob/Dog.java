package com.robestone.jjump.jacob;

public class Dog {

	int age;
	String barkSound;
	
	public Dog(int age, String barkSound) {
		this.age = age;
		this.barkSound = barkSound;
	}


	String bark() {
		return barkSound;
	}
	
}
