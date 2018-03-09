package com.general.geeks.graph;

import java.util.Set;

import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

public class GuavaGraph {
	public static void main(String[] args) {
		
		Graph<Integer> graph = GraphBuilder.directed().build();
		
		MutableGraph<Integer> mg = GraphBuilder.directed().build();
		mg.addNode(12);
		mg.addNode(20);
		mg.putEdge(2	, 3);
		mg.putEdge(2, 20);
		Set<Integer> succ = mg.successors(2);
		succ.forEach(a->{
			System.out.println(a);
		});
		
	}
}
