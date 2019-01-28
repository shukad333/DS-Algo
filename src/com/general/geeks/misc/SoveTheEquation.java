package com.general.geeks.misc;

/**
 * Solve a given equation and return the value of x in the form of string
 * "x=#value". The equation contains only '+', '-' operation, the variable x and
 * its coefficient.
 * 
 * If there is no solution for the equation, return "No solution".
 * 
 * If there are infinite solutions for the equation, return "Infinite
 * solutions".
 * 
 * If there is exactly one solution for the equation, we ensure that the value
 * of x is an integer.
 * 
 * Example 1: Input: "x+5-3+x=6+x-2" Output: "x=2" Example 2: Input: "x=x"
 * Output: "Infinite solutions" Example 3: Input: "2x=x" Output: "x=0" Example
 * 4: Input: "2x+3x-6x=x+2" Output: "x=-1" Example 5: Input: "x=x+2" Output: "No
 * solution"
 * 
 * @author skadavath
 *
 */
public class SoveTheEquation {

	public static void main(String[] args) {

		System.out.println(new SoveTheEquation().solveEquation("x=x+2"));
		String e = "+5x";

		System.out.println();
	}

	public String solveEquation(String equation) {

		String lhs = equation.split("=")[0];
		String rhs = equation.split("=")[1];

		int[] r1 = evaluateExpr(lhs);
		int[] r2 = evaluateExpr(rhs);

		r1[1] -= r2[1];

		r1[0] = r2[0] - r1[0];
		
		if (r1[0] == 0 && r1[1] == 0) return "Infinite solutions";
	    if (r1[0] == 0) return "No solution";
	    return "x=" + r1[1]/r1[0];

		
	}

	private int[] evaluateExpr(String expr) {

		int[] resp = new int[2];

		for (String s : expr.split("(?=[-+])")) {
			
			if (s.equals("x") || s.equals("+x"))
				resp[0] += 1;
			else if (s.equals("-x"))
				resp[0] -= 1;
			else if (s.contains("x"))
				resp[0] += Integer.parseInt(s.substring(0, s.indexOf("x")));
			else
				resp[1] += Integer.parseInt(s);
		}
		return resp;

	}

}
