package com.general.geeks.maths;

/**
 * Given two strings representing two complex numbers.
 * 
 * You need to return a string representing their multiplication. Note i2 = -1
 * according to the definition.
 * 
 * Example 1: Input: "1+1i", "1+1i" Output: "0+2i" Explanation: (1 + i) * (1 +
 * i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2: Input: "1+-1i", "1+-1i" Output: "0+-2i" Explanation: (1 - i) * (1
 * - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * 
 * The input strings will not have extra blank. The input strings will be given
 * in the form of a+bi, where the integer a and b will both belong to the range
 * of [-100, 100]. And the output should be also in this form.
 * 
 * 
 * @author skadavath
 *
 */
public class ComplexNumberMultiplication {

	public static void main(String[] args) {

		System.out.println(new ComplexNumberMultiplication().complexNumberMultiply("1+-1i", "0+0i"));

	}

	public String complexNumberMultiply(String a, String b) {

		String[] aComplex = a.split("\\+");
		String[] bComplex = b.split("\\+");
		StringBuilder sb = new StringBuilder();

		int firstA = Integer.parseInt(aComplex[0]);
		int firstB = Integer.parseInt(bComplex[0]);

		int secA = Integer.parseInt(aComplex[1].substring(0, aComplex[1].indexOf("i")));
		int secB = Integer.parseInt(bComplex[1].substring(0, bComplex[1].indexOf("i")));

		int secondComplex = firstA * secB + firstB * secA;

		int firstComplex = (firstA * firstB) + (secA * secB) * -1;
		sb.append(firstComplex);
		sb.append("+" + secondComplex + "i");

		return sb.toString();

	}

}
