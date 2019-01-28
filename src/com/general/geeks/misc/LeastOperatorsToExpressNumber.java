package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a single positive integer x, we will write an expression of the form x
 * (op1) x (op2) x (op3) x ... where each operator op1, op2, etc. is either
 * addition, subtraction, multiplication, or division (+, -, *, or /). For
 * example, with x = 3, we might write 3 * 3 / 3 + 3 - 3 which is a value of 3.
 * 
 * When writing such an expression, we adhere to the following conventions:
 * 
 * The division operator (/) returns rational numbers. There are no parentheses
 * placed anywhere. We use the usual order of operations: multiplication and
 * division happens before addition and subtraction. It's not allowed to use the
 * unary negation operator (-). For example, "x - x" is a valid expression as it
 * only uses subtraction, but "-x + x" is not because it uses negation. We would
 * like to write an expression with the least number of operators such that the
 * expression equals the given target. Return the least number of operators
 * used.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 3, target = 19 Output: 5 Explanation: 3 * 3 + 3 * 3 + 3 / 3. The
 * expression contains 5 operations. Example 2:
 * 
 * Input: x = 5, target = 501 Output: 8 Explanation: 5 * 5 * 5 * 5 - 5 * 5 * 5 +
 * 5 / 5. The expression contains 8 operations. Example 3:
 * 
 * Input: x = 100, target = 100000000 Output: 3 Explanation: 100 * 100 * 100 *
 * 100. The expression contains 3 operations.
 * 
 * 
 * Note:
 * 
 * 2 <= x <= 100 1 <= target <= 2 * 10^8
 * 
 * @author skadavath
 *
 */
public class LeastOperatorsToExpressNumber {

	public static void main(String[] args) {

		System.out.println(new LeastOperatorsToExpressNumber().leastOpsExpressTarget(3, 19));

	}

	Map<Integer, Integer> memo = new HashMap<>();

	public int leastOpsExpressTarget(int x, int target) {

		if (target == 1) {
			return x == 1 ? 0 : 1;
		}

		if (memo.containsKey(target))
			return memo.get(target);

		long prod = x;
		int count = 0;
		while (prod < target) {
			count++;
			prod *= x;
		}

		// case 1 : x*x*x + (.....)
		int first = Integer.MAX_VALUE;

		if (prod == target) {
			first = count;
		}

		else if (prod - target < target) {
			first = count + leastOpsExpressTarget(x, (int)(prod - target)) + 1;
		}

		// case 2 : x*x*x - (....)

		int second = Integer.MAX_VALUE;

		prod /= x;
		// count == 0 means x is greater or equal to target, so we use x / x + (......)
		// to continue the search, there are two more operators which are "/" and "+",
		// so we add 2. If count != 0, count-1 represents the number of operators used
		// in x * x * ... * x, we need one more operator "+" to connect it with
		// (......), so we should add count - 1 + 1 = count.
		second = leastOpsExpressTarget(x, (int)(target - prod)) + (count == 0 ? 2 : count);
		int resp = Math.min(first, second);
		memo.put(target, resp);
		return resp;

	}

}
