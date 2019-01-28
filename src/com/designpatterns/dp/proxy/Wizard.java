package com.designpatterns.dp.proxy;

public class Wizard {

	private String name;

	public Wizard(String name) {

		this.name = name;
	}

	@Override
	public String toString() {

		return name;
	}

}
