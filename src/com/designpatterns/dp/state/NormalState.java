package com.designpatterns.dp.state;

public class NormalState implements State {

	private Person person;

	public NormalState(Person person) {
		this.person = person;
	}

	@Override
	public void observe() {
		System.out.println(person+ " is Normal person");

	}

	@Override
	public void onEnterState() {
		System.out.println(person+ " getting normal");

	}

}
