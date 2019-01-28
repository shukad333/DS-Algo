package com.designpatterns.dp.state;

public class Person {

	private State state;

	public Person() {
		state = new NormalState(this);
	}

	public void timePasses() {
		if (state.getClass().equals(NormalState.class)) {
			changeStateTo(new DrunkardState(this));
		} else
			changeStateTo(new NormalState(this));
	}

	private void changeStateTo(State newState) {
		this.state = newState;
		this.state.onEnterState();
	}

	@Override
	public String toString() {

		return "Person";
	}

	public void observe() {
		this.state.observe();
	}
	
	
	public static void main(String[] args) {
		
		Person person = new Person();
		person.observe();
		person.timePasses();
		person.observe();
		person.timePasses();
		person.observe();
		person.timePasses();
		person.observe();
		
	}

}
