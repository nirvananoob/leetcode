package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * @author kaizhang
 *
 */
public class Course_Schedule {
/**
 * method bfs topological sorting
 */
	  public boolean canFinish(int numCourses, int[][] prerequisites) {
	        if  (prerequisites == null || prerequisites.length == 0  || numCourses == 0) {
	            return true;
	        }
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer> ();
	         ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	       
	        for(int i = 0 ; i < numCourses; i++){
	            map.put(i, 0);
	            res.add(new ArrayList<Integer> ());
	        }
	        for(int i = 0 ; i < prerequisites.length; i++) {
	            map.put(prerequisites[i][0], map.get(prerequisites[i][0]) + 1);
	            res.get(prerequisites[i][1]).add(prerequisites[i][0]);
	        }
	        Queue<Integer>  queue = new LinkedList<Integer> ();
	        int count = 0;
	        for(int i = 0 ; i < numCourses; i++) {
	            if (map.get(i) == 0){
	                queue.add(i);
	            }
	        } 
	        while(!queue.isEmpty()){
	            int temp = queue.poll();
	            ++count;
	            for (Integer i : res.get(temp)){
	                if(map.get(i)  == 1){
	                    queue.offer(i);
	                }
	                map.put(i, map.get(i) - 1);
	            }
	        }
	        return count == numCourses;
	       
	        
	    }
	  
}
