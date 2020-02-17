package com.interviewbit;

public class SquareRootOfANumber {

	public int sqrt(int a) {

		if (a == 0 || a == 1)
			return a;

		long start = 0, end = a / 2 + 1, resp = 0;

		while (start <= end) {
			long mid = (start + end) / 2;
			if (mid * mid == a)
				return (int) mid;

			if (mid * mid > a)
				end = mid - 1;
			else {
				start = mid + 1;
				resp = mid;
			}
		}

		return (int) resp;
	}

}
