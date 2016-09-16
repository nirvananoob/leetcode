package Pocket_Gem_OA;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/**
 *  class for the graph
 *
 * @author kaizhang
 *
 */
class GraphNode {
    String label;
    List<GraphNode> neighbors;
    GraphNode(String str) {
        this.label = str;
        this.neighbors = new ArrayList<GraphNode>();
    }
}

public class PathFinder {
    
    
    private static GraphNode source, destination;
    private static HashMap<String, GraphNode> map;
    
    public static void main(String[] args) throws FileNotFoundException,
    IOException {
        		String filename = "input_1.txt";
        //		String filename = "input_2.txt";
        //      String filename = "input_3.txt";
        if (args.length > 0) {
            filename = args[0];
        }
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename)
    throws FileNotFoundException, IOException {
        /*
         * Don't modify this function
         */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();
        
        return parseLines(allLines);
    }
    
    static List<String> parseLines(List<String> lines) {
        /*
         *
         * Your code goes here
            if paths exist, return the list of all paths; if not return null.
         */
        String[] input = lines.get(0).split("\\s+");
        map = new HashMap<String, GraphNode>();
        GraphNode node, neighbor;
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] nodeedges = line.split(":");
            String label = nodeedges[0].trim();
            if (!map.containsKey(label)) {
                node = new GraphNode(label);
                map.put(label, node);
            }
            node = map.get(label);
            String[] neighbors = nodeedges[1].trim().split("\\s+");
            for (String s : neighbors) {
                
                if (!map.containsKey(s)) {
                    map.put(s, new GraphNode(s));
                    // graph.add(map.get(s));
                }
                neighbor = map.get(s);
                node.neighbors.add(neighbor);
            }
        }
        source = map.get(input[0].trim());
        destination = map.get(input[1].trim());
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        HashSet<String> visited = new HashSet<String>();
        dfs(source, destination, res, sb, visited);
        return res.size() != 0 ? res : null;
        
    }
    /**
     * classical Depth first search to get all paths from source vertex to destination
     * @param s
     * @param d
     * @param res
     * @param sb
     * @param visited
     */
    static void dfs(GraphNode s, GraphNode d, List<String> res,
                    StringBuilder sb, HashSet<String> visited) {
        if (s == null || visited.contains(s.label)) {
            return;
        }
        int size = sb.length();
        visited.add(s.label);
        sb.append(s.label);
        
        if (s.label.equals(d.label)) {
            
            res.add(sb.toString());
            visited.remove(s.label);
            sb.delete(size, sb.length());
            return;
        }
        for (GraphNode neighbor : s.neighbors) {
            dfs(neighbor, d, res, sb, visited);
        }
        visited.remove(s.label);
        sb.delete(size, sb.length());
    }
}