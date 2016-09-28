package Search.DFS_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, return all possible subsets.

 Notice

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author kaizhang
 *
 */
public class Subsets_I {
	 /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0 ; i < 1 << len; i++) {
            ArrayList<Integer> list = new ArrayList<Integer> ();
            for (int j = 0; j < len; j++ ) {
                if ((i &  1 << j) != 0){
                    list.add(nums[j]);
                }
            }
             res.add(list);
        }
        return res;
    }
}
