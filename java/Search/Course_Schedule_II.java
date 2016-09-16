package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
 * @author kaizhang
 *
 */
public class Course_Schedule_II {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        if(numCourses == 0 || prerequisites == null) {
            return new int[0];
        }
        int[] arr = new int[numCourses];
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
            arr[ count] = temp;
            ++count;
            for (Integer i : res.get(temp)){
                if(map.get(i)  == 1){
                    queue.offer(i);
                }
                map.put(i, map.get(i) - 1);
            }
        }
        return count == numCourses ?  arr : new int[0];
}
}
