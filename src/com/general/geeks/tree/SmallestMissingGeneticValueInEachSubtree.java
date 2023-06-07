package com.general.geeks.tree;


import java.util.*;

/**
 * There is a family tree rooted at 0 consisting of n nodes numbered 0 to n - 1. You are given a 0-indexed integer array parents, where parents[i] is the parent for node i. Since node 0 is the root, parents[0] == -1.
 * <p>
 * There are 105 genetic values, each represented by an integer in the inclusive range [1, 105]. You are given a 0-indexed integer array nums, where nums[i] is a distinct genetic value for node i.
 * <p>
 * Return an array ans of length n where ans[i] is the smallest genetic value that is missing from the subtree rooted at node i.
 * <p>
 * The subtree rooted at a node x contains node x and all of its descendant nodes.
 */
public class SmallestMissingGeneticValueInEachSubtree {

    public static void main(String[] args) {

        SmallestMissingGeneticValueInEachSubtree smallestMissingGeneticValueInEachSubtree = new SmallestMissingGeneticValueInEachSubtree();
        int[] resp = smallestMissingGeneticValueInEachSubtree.smallestMissingValueSubtree(new int[]{-1,0,0,2},new int[]{1,2,3,4});
        System.out.println(Arrays.toString(resp));

    }

    HashMap<Integer, List<Integer>> m = new HashMap<>();
    int[] A;
    int miss = 1;
    HashSet<Integer> set = new HashSet<>();

    public int[] smallestMissingValueSubtree(int[] parent, int[] nums) {

        int n = parent.length;
        A = nums;
        for (int i = 0; i < n; i++) {
            m.computeIfAbsent(parent[i], k->new ArrayList<>()).add(i);
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return res;
        int s = idx;
        int pre = -1; // pre handled node
        while (s != -1) {
            List<Integer> list = m.get(s);
            if (list != null) {
                for (int j : m.get(s)) {
                    if (j == pre)  continue; // skip handled
                    dfs(j);
                }
            }
            set.add(A[s]);
            while (set.contains(miss)) {
                miss++;
            }
            res[s] = miss;

            pre = s; // update pre and s
            s = parent[s]; // path from 1 up to root

        }
        return res;
    }

    void dfs(int i) {
        set.add(A[i]);
        List<Integer> list = m.get(i);
        if (list == null) return;
        for (int j : list) {
            dfs(j);
        }
    }

}
