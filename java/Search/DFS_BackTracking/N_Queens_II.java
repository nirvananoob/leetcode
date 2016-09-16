package Search.DFS_BackTracking;

import java.util.ArrayList;

/**
 * Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 * @author kaizhang
 *
 */
public class N_Queens_II {
	 static int totalnumber ;
	    public int totalNQueens(int n) {
	        if(n <= 0) {
	            return 0;
	        }
	        totalnumber = 0;
	        ArrayList<Integer>  list = new ArrayList<Integer> ();
	        dfs(list,n);
	        return totalnumber;
	    }
	    public void dfs( ArrayList<Integer> list, int count) {
	        if (list.size() == count){
	            totalnumber ++;
	            return;
	        }
	        for(int i = 1 ; i <= count; i++ ) {
	            if(isValid(i, list)) {
	                list.add(i);
	                dfs(list,count);
	                list.remove(list.size() - 1);
	            }
	        }
	        return;
	    }
	    private boolean isValid(int next, ArrayList<Integer> list) {
	        if(list.size() == 0) {
	            return true;
	        }
	        int size = list.size();
	        int cur;
	        for(int i = 0 ; i < size; i++) {
	            cur = list.get(i);
	            if(cur == next || cur - next == i - size || cur - next == size - i) {
	                return false;
	            }
	        }
	        return true;
	    } 
	    public static void main(String[] args) {
	    	N_Queens_II test  = new N_Queens_II();
	    	int size = 2;
	    	System.out.println(test.totalNQueens(size));
	    }
}
