package Search.DFS_BackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note: If there are multiple valid itineraries, you should return the
 * itinerary that has the smallest lexical order when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"]. All airports are represented by three capital letters (IATA
 * code). You may assume all tickets form at least one valid itinerary. 
 * Example
 * 1: tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"]. 
 * Example 2: 
 * tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"]. Another possible reconstruction
 * is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 * 
 * @author kaizhang
 *
 */
public class Reconstruct_Itinerary {
	public List<String> findItinerary(String[][] tickets) {
		LinkedList<String> path = new LinkedList<String>();
		if (tickets == null || tickets.length == 0) {
			return path;
		}
		HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
		for (String[] ticket : tickets) {
			map.putIfAbsent(ticket[0], new PriorityQueue<String>());
			map.get(ticket[0]).offer(ticket[1]);
		}
		dfs(path, map, "JFK");
		return path;
	}

	private void dfs(LinkedList<String> path,
			HashMap<String, PriorityQueue<String>> map, String pos) {
		while (map.containsKey(pos) && !map.get(pos).isEmpty()) {
			dfs(path, map, map.get(pos).poll());
		}
		path.addFirst(pos);
	}
}
