package com.designpatterns.dp.state;

public class DrunkardState implements State{
	
	private Person person;
	
	public DrunkardState(Person person) {
		
		this.person = person;
		
	}

	@Override
	public void observe() {
		System.out.println(person+ " is drunkard person");
		
	}

	@Override
	public void onEnterState() {
		System.out.println(person+ " is getting drunkard");
		
	}

}
