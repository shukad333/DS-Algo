package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 * 1 / \ / \ 0 --- 2 / \ \_/
 * 
 * @author skadavath
 *
 */
public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		if(null == node) {
			return null;
		}
		Queue<UndirectedGraphNode> queue = new LinkedList();
		queue.add(node);
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
		map.put(node, new UndirectedGraphNode(node.label));

		while (!queue.isEmpty()) {
			UndirectedGraphNode polledNode = queue.poll();
			for (UndirectedGraphNode graph : node.neighbors) {

				if (!map.containsKey(graph)) {
					map.put(graph, new UndirectedGraphNode(graph.label));
					queue.add(graph);
				}

				map.get(polledNode).neighbors.add(map.get(graph));

			}

		}
		return map.get(node);
	}

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
