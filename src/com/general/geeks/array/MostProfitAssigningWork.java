package com.general.geeks.array;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 
 * We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i]
 * is the profit of the ith job.
 * 
 * Now we have some workers. worker[i] is the ability of the ith worker, which
 * means that this worker can only complete a job with difficulty at most
 * worker[i].
 * 
 * Every worker can be assigned at most one job, but one job can be completed
 * multiple times.
 * 
 * For example, if 3 people attempt the same job that pays $1, then the total
 * profit will be $3. If a worker cannot complete any job, his profit is $0.
 * 
 * What is the most profit we can make?
 * 
 * Example 1:
 * 
 * Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker =
 * [4,5,6,7] Output: 100 Explanation: Workers are assigned jobs of difficulty
 * [4,4,6,6] and they get profit of [20,20,30,30] seperately. Notes:
 * 
 * 1 <= difficulty.length = profit.length <= 10000 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i] are in range [1, 10^5]
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class MostProfitAssigningWork {

	/**
	 * [85,47,57] [24,66,99] [40,25,25]
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String S = "Shuhail";
		System.out.println(S.substring(0,S.length()-1));

		int[] diff = new int[] { 2,4,6,8,10 };
		int[] prof = new int[] { 10,20,30,40,50 };
		int[] worker = new int[] { 4,5,6,7 };

		System.out.println(new MostProfitAssigningWork().maxProfitAssignment(diff, prof, worker));

	}

	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

		TreeMap<Integer,Integer> map = new TreeMap<>();

		map.put(0,0);
		for(int i=0;i<difficulty.length;i++) {
			map.put(difficulty[i],Math.max(profit[i],map.getOrDefault(difficulty[i],0)));
		}


		int resp = 0,best = 0;

		for(int key : map.keySet()) {
			best = Math.max(map.get(key),best);
			map.put(key,best);
		}

		for(int i=0;i<worker.length;i++) {
			resp+=map.floorEntry(worker[i]).getValue();
		}

		return resp;



	}

	 public int _maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->a[0] - b[0]);

			for (int i = 0; i < difficulty.length; i++) {

				pq.offer(new int[] { difficulty[i], profit[i] });

			}

			int resp = 0;

			Arrays.sort(worker);

			int curr = 0;
			
			for (int i = 0; i < worker.length; i++) {

				int w = worker[i];
				while (!pq.isEmpty() && pq.peek()[0] <= w)
					curr = Math.max(curr, pq.poll()[1]);
				
					resp += curr;
			}

			return resp;

		}
}
