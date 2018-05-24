package com.general.geeks.deathmatch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDeath<T extends Exception> {
	
	private void pleaseThrow(final Exception t) throws T {
		throw (T) t;
	}
	
	
	final List<String> list = new ArrayList() {{
		add("Shuhail");
		System.out.println(list);
	}};
	public static void main(String[] args) {
		
		
		
	}

}
