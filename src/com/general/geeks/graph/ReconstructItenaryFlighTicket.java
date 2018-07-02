package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note:
 * 
 * If there are multiple valid itineraries, you should return the itinerary that
 * has the smallest lexical order when read as a single string. For example, the
 * itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. All
 * airports are represented by three capital letters (IATA code). You may assume
 * all tickets form at least one valid itinerary. Example 1:
 * 
 * Input: tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR",
 * "SFO"]] Output: ["JFK", "MUC", "LHR", "SFO", "SJC"] Example 2:
 * 
 * Input: tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible
 * reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in
 * lexical order.
 * 
 * @author skadavath
 *
 */
public class ReconstructItenaryFlighTicket {
	
	private Map<String, List<String>> graph = new HashMap<>();
	LinkedList<String> routes = new LinkedList<>();
	int totalTickets = 0;
	int usedTickets = 0;
	
	public static void main(String[] args) {
		
		String[][] tickets = {
								{"MUC","LHR"},
								{"JFK","MUC"},
								{"SFO","SJC"},
								{"LHR","SFO"}
								};
		
		List<String> result = new ReconstructItenaryFlighTicket().findItinerary(tickets);
		for(String s : result) {
			System.out.print(s+" ");
		}
	}
	
	public List<String> findItinerary(String[][] tickets) {
		
		totalTickets = tickets.length;
		//build graph
		for(String[] ticket : tickets) {
			
			if(!graph.containsKey(ticket[0])) {
				graph.put(ticket[0], new ArrayList<>());
			}
			graph.get(ticket[0]).add(ticket[1]);
		}
		
		//sort it if needed
		for(Map.Entry<String, List<String>> entry : graph.entrySet()) {
			Collections.sort(entry.getValue());
		}
		
		routes.add("JFK");
		findRoutes("JFK");
		return routes;
		
	}
	
	public void findRoutes(String source) {
		
		if(!graph.containsKey(source))
			return;
		
		List<String> destinations = graph.get(source);
		for(int i=0;i<destinations.size();i++) {
			
			String dest = destinations.get(i);
			destinations.remove(i);
			routes.add(dest);
			usedTickets++;
			findRoutes(dest);
			
			if(usedTickets==totalTickets)
				return;
			
			//at this point , we have to consider other tickets
			
			destinations.add(i, dest);
			usedTickets--;
			routes.removeLast();
			
			
		}
		
	}
	
	

}
