package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an directed graph, a topological order of the graph nodes is defined as
 * follow:
 * 
 * For each directed edge A -> B in graph, A must before B in the order list.
 * The first node in the order can be any node in the graph with no nodes direct
 * to it. Find any topological order for the given graph.
 * 
 * Notice
 * 
 * You can assume that there is at least one topological order in the graph.
 * 
 * @author kaizhang
 *
 *
 */
class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
};

public class Topological_Sorting {
	public ArrayList<DirectedGraphNode> topSort_BFS(
			ArrayList<DirectedGraphNode> graph) {
		// write your code here
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0) {
            return res;
        }
        // Build the map to store the node, degree pair;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        for(DirectedGraphNode node : graph) {
            map.put(node.label, 0);
        }
        //update edge by edge
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode neighbor : node.neighbors){
                map.put(neighbor.label, map.get(neighbor.label) + 1);
            }
        }
        // HashSet<Integer> set = new HashSet<Integer> ();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode> ();
        // for(Map.Entry<DirectedGraphNode, Integer> entry : map.entrySet()){
        //     if (entry.getValue() == 0){
        //         queue.offer(entry.getKey());
        //         // set.add(entry.getKey().label);
        //     }
        // }
        for(DirectedGraphNode node : graph)  {
            if(map.get(node.label) == 0){
                queue.offer(node);
            }
        }
       
        while(!queue.isEmpty()) {
            DirectedGraphNode temp = queue.poll();
            res.add(temp);
            for(DirectedGraphNode node : temp.neighbors) {
                int deg = map.get(node.label);
                --deg;
                if (deg == 0){
                    queue.offer(node);
                }
                map.put(node.label, deg);
            }
        }
        return res;
	}
	 public ArrayList<DirectedGraphNode> topSort_DFS(ArrayList<DirectedGraphNode> graph) {
         ArrayList<DirectedGraphNode> res = new  ArrayList<DirectedGraphNode> ();
         if(graph == null || graph.size() == 0) {
             return res;
         }
         HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode,Integer> ();
         for (DirectedGraphNode v : graph) {
             map.put(v, 0);
         }
        //  for(DirectedGraphNode v : grpah) {
        //      for(DirectedGraphNode neighbor : neighbors) {
        //          if(map.get(neighbor.label) == 0)  {
        //              map.put(neighbor.label, 1);
        //          }
        //      }
        //  }
         for(DirectedGraphNode v : graph) {
             if (map.get(v) == 0) {
                 dfs(res,v,map);
             }
         }
         return res;
         
     }
     private void dfs( ArrayList<DirectedGraphNode> res, DirectedGraphNode node, HashMap<DirectedGraphNode, Integer> map) {
         if(map.get(node) != 0) {
             return;
         }
         map.put(node, 1);
         for(DirectedGraphNode neighbor : node.neighbors){
             dfs(res,neighbor,map);
         }
        //  map.put(node, 2); // change the value of map means we have sorted all the neighbor vertexes of this vertex,but it's not necessary
         res.add(0, node);
         return;
     }
}
