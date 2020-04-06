package com.general.geeks.bits;

public class BitwiseAnd {

	/**
	 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
	 * of all numbers in this range, inclusive.
	 * 
	 * For example, given the range [5, 7], you should return 4.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(bitwiseAnd(26, 30));
	}

	static int bitwiseAnd(int x, int y) {

		/**
		 *
		 * int iterations=0;
		 * 		while(x!=y) {
		 * 			x>>=1;
		 * 			y>>=1;
		 * 			iterations++;
		 *                }
		 *
		 */

		int iterations=0;
		while(x!=y) {
			x>>=1;
			y>>=1;
			iterations++;
		}

		return x<<iterations;
	}

	static int _bitwiseAnd(int x, int y) {

		int res = 0;
		while (x > 0 && y > 0) {

			int msbX = getMSB(x);
			int msbY = getMSB(y);

			if (msbX != msbY) {
				break;
			}

			int msbExp = (1 << msbX);
			res += msbExp;

			x = x - msbExp;
			y = y - msbExp;

		}

		return res;
	}

	static int getMSB(int x) {
		int msb = -1;
		while (x > 0) {
			x = x >> 1;
			msb++;
		}

		return msb;
	}
}
