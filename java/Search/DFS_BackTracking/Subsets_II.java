package Search.DFS_BackTracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a list of numbers that may has duplicate numbers, return all possible subsets

 Notice

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.

Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @author kaizhang
 *
 */
public class Subsets_II {
	 public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
	        //     // write your code here
	        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
	        ArrayList<Integer> list = new ArrayList<Integer> ();
	        Collections.sort(S);
	        dfs(res, list, 0, S);
	        return res;
	    }
	    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int pos, ArrayList<Integer> S ) {
	        res.add(new ArrayList<Integer> (list));
	        for(int i = pos; i < S.size() ;i++) {
	        	   if ( i != pos && S.get(i) == S.get(i - 1)) {
	                   continue;
	               }    
	            list.add(S.get(i));
	            dfs(res, list, i + 1, S);
	            list.remove(list.size() - 1);
	        }
	        return;
	    }
	    public static void main(String[] args) {
	    	 Subsets_II test = new  Subsets_II();
	    	int[] arr = {5,5,5};
	    	ArrayList<Integer> list = new ArrayList<Integer> ();
	    	for(int cur : arr) {
	    		list.add(cur);
	    	}
	    	System.out.println(test.subsetsWithDup(list));
	    }
}
