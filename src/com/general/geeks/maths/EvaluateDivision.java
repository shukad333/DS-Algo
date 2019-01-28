package com.general.geeks.maths;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Equations are given in the format A / B = k, where A and B are variables
 * represented as strings, and k is a real number (floating point number). Given
 * some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * Example: Given a / b = 2.0, b / c = 3.0. queries are: a / c = ?, b / a = ?, a
 * / e = ?, a / a = ?, x / x = ? . return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * The input is: vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries , where equations.size() ==
 * values.size(), and the values are positive. This represents the equations.
 * Return vector<double>.
 * 
 * According to the example above:
 * 
 * equations = [ ["a", "b"], ["b", "c"] ], values = [2.0, 3.0], queries = [
 * ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. The input is
 * always valid. You may assume that evaluating the queries will result in no
 * division by zero and there is no contradiction.
 * 
 * @author skadavath
 *
 */
public class EvaluateDivision {
	
	public static void main(String[] args) {
		System.out.println(new EvaluateDivision().calcEquation(new String[][] {{"a","b"},{"b","c"}}, new double[] {2.0,3.0},new String[][] {{"a","c"}}));
	}

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

		double[] res = new double[queries.length];

		Map<String, Map<String, Double>> eqMap = new HashMap<>();
		int j = 0;
		for (String[] eq : equations) {
			constructMap(eqMap, eq[0], eq[1], values[j]);
			constructMap(eqMap, eq[1], eq[0], 1 / values[j]);
			j++;
		}
		int i = 0;
		for (String[] query : queries) {
			Double r = doDfs(eqMap, query[0], query[1], new HashSet<>());
			res[i++] = null==r?-1.0:r;
		}
		return res;

	}

	private void constructMap(Map<String, Map<String, Double>> eqMap, String lhs, String rhs, Double val) {

		Map<String, Double> denomMap = eqMap.get(lhs);
		if (null == denomMap) {
			denomMap = new HashMap<>();
			eqMap.put(lhs, denomMap);
		}
		denomMap.put(rhs, val);
	}
	
	/**
	 * a/b = a/x * x/a is the basic idea
	 * @param eqMap
	 * @param num
	 * @param denom
	 * @param visited
	 * @return
	 */
	private Double doDfs(Map<String, Map<String, Double>> eqMap, String num, String denom, HashSet<String> visited) {

		String uniqKey = num + "#" + denom;
		if (visited.contains(uniqKey))
			return null;
		if (!eqMap.containsKey(num) || !eqMap.containsKey(denom))
			return null;

		if (num.equals(denom))
			return 1.0;

		visited.add(uniqKey);
		Map<String, Double> denomMap = eqMap.get(num);
		for (String key : denomMap.keySet()) {
			visited.add(key);
			Double res = doDfs(eqMap, key, denom, visited);
			if (res != null) {
				return denomMap.get(key) * res;
			}
		}
		visited.remove(uniqKey);
		return null;

	}

}
