package com.hackerrank.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvenTree {


    public static Map<Integer, ArrayList<Integer>> tree;
    public static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfNodes = scanner.nextInt();
        int numOfEdges = scanner.nextInt();

        tree = new HashMap<>();
        for (int i = 1; i <= numOfNodes; i++) {
            tree.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < numOfEdges; i++) {
            int child = scanner.nextInt();
            int parent = scanner.nextInt();

            ArrayList<Integer> parentNode = tree.get(parent);
            parentNode.add(child);
        }

        for (int i = 2; i <= tree.size(); i++) {
            if ((countChildren(i) % 2) != 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static int countChildren(int node) {
        int totalChild = tree.get(node).size();
        for (int child : tree.get(node)) {
            totalChild += countChildren(child);
        }
        return totalChild;
    }


}
