package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Valid_Tree {
	//v1 bfs:
	 public boolean validTree_BFS(int n, int[][] edges) {
	        // Write your code here
	        // Comparator<int[]> comp  = new Comparator<int[]> () {
	        //     public int compare(int[] arr1, int[] arr2) {
	        //         if(arr1[0] != arr2[0]) {
	        //             return arr1[1] - arr2[1];
	        //         }
	        //         return arr1[0] - arr2[0];
	        //     }
	        // } 
	        
	        if ( n == 0 || edges == null || edges.length == 0) {
	            return false; 
	        }
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
	        // Arrays.sort(edges, comp);
	        HashSet<Integer> set = new HashSet<Integer> ();
	        Queue<Integer> queue = new LinkedList<Integer> ();
	        for(int i = 0 ; i < n; i++) {
	            res.add(new ArrayList<Integer> ());
	        }
	        for (int i = 0 ; i < edges.length; i++) {
	            res.get(edges[i][0]).add(edges[i][1]);
	            res.get(edges[i][1]).add(edges[i][0]);
	        }
	        queue.offer(edges[0][0]);
	        set.add(edges[0][0]);
	        while(!queue.isEmpty()) {
	            Integer temp =  queue.poll();
	            if (set.contains(temp)) {
	            	return false;
	            }
	            set.add(temp);
	            for(Integer i  : res.get((int)temp)) {
	                queue.offer(i);
	                res.get(i).remove(temp);
	            }
	            set.remove(temp);
	        }
	        if(set.size() != n ){
	            return false;
	        }
	        return true;
	    }
	 //v2 : dfs
	  public boolean validTree_DFS(int n, int[][] edges) {
	        // Write your code here
	        if (n == 0 || n == 1 ) {
	             return true;
	        }
	        if(edges.length == 0 || edges[0].length != 2  || edges.length != n - 1) {
	             return false;
	        }
	            HashSet<Integer> set = new HashSet<Integer> ();
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
	        for (int i = 0; i < n; i++) {
	          res.add(new ArrayList<Integer>()) ;
	         }
	        for(int i = 0 ; i < edges.length; i++) {
	            res.get(edges[i][0]).add(edges[i][1]);
	            res.get(edges[i][1]).add(edges[i][0]);
	        }
	        boolean[] visited = new boolean[n];
	     if (!dfs(res,visited,0,-1, n)){
	         return false;
	     }
	     for (int i = 0 ;i < n ;i++) {
	         if(!visited[i]) {
	             return false;
	         }
	     }
	        return true;
	    }
	    private boolean dfs(ArrayList<ArrayList<Integer>> res, boolean[] visited,int start,int parent ,int n ){
	        if(visited[start])  {
	            return false;
	        }
	        visited[start] = true;
	        ArrayList<Integer> list = res.get(start);
	        for (Integer temp : list){
	          if(temp != parent && !dfs(res, visited,temp,start,n)){
	              return false;
	          }
	        }
	        return true;
	        
	    }
	    //v3 :
	    public boolean validTree_UnionFind(int n, int[][] edges) {
	        // Write your code here
	        class unionfind {
	            HashMap<Integer, Integer> father = new HashMap<Integer, Integer> ();
	            unionfind(int n ) {
	                for (int i = 0 ; i < n; i++) {
	                    father.put(i,i);
	                }
	            }
	            int find(int x) {
	                int parent = father.get(x);
	                while (father.get(parent) != parent) {
	                    parent = father.get(parent);
	                }
	                int temp = -1;
	                int fa = father.get(x);
	                while(fa != parent) {
	                    temp = father.get(fa);
	                    father.put(fa, parent);
	                    fa = temp;
	                }
	                return parent;
	            }
	            void union(int x, int y) {
	                int fx = find(x);
	                int fy = find(y);
	                if(fx != fy) {
	                    father.put(fx,fy);
	                }
	                return;
	            }
	        }
	        if (n == 0 || n == 1 ) {
	            return true;
	        }
	        
	        if(edges.length == 0 || edges[0].length != 2  || edges.length != n - 1) {
	            return false;
	        }
	     
	         unionfind uf = new unionfind(n);
	        for (int i = 0 ; i < edges.length; i++) {
	          if(uf.find(edges[i][0] )== uf.find(edges[i][1])) {
	              return false;
	          }
	          uf.union(edges[i][0], edges[i][1]);
	        }
	        
	        
	        
	        return true;
	    }
	 public static void main(String[] args) {
		 int n = 5;
		 int[][] edges = new int[][] {{0,1},{0,2},{0,3},{1,4}};
		 Graph_Valid_Tree test = new  Graph_Valid_Tree ();
		 System.out.println(test.validTree_BFS(n, edges));
	 }
}
