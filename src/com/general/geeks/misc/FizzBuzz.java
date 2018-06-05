package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 * 
 * Example:
 * 
 * n = 15,
 * 
 * Return: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
 * "11", "Fizz", "13", "14", "FizzBuzz" ]
 * 
 * @author skadavath
 *
 */
public class FizzBuzz {

	public static void main(String[] args) {

		List<String> list = new FizzBuzz().fizzBuzz(15);
		for (String s : list) {
			System.out.println(s);
		}
	}

	public List<String> fizzBuzz(int n) {

		List<String> resp = new ArrayList();
		for (int i = 1, fiz = 0, buz = 0; i <= n; i++) {
			fiz++;
			buz++;
			if (fiz == 3 && buz == 5) {
				resp.add("FizzBuzz");
				fiz = 0;
				buz = 0;
			} else if (fiz == 3) {
				resp.add("Fizz");
				fiz = 0;
			} else if (buz == 5) {
				resp.add("Buzz");
				buz = 0;
			}

			else {
				resp.add(String.valueOf(i));
			}
		}

		return resp;

	}

}
