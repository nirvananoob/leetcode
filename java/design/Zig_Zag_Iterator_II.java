package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Follow up Zigzag Iterator: What if you are given k 1d vectors? How well can your code be extended to such cases? The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".

Have you met this question in a real interview? Yes
Example
Given k = 3 1d vectors:

[1,2,3]
[4,5,6,7]
[8,9]
Return [1,4,8,2,5,9,3,6,7].


 * @author kaizhang
 *
 */
public class Zig_Zag_Iterator_II {
	   private int size;
	    private int cur;
	    private List<Iterator<Integer>> master = new ArrayList<Iterator<Integer>>  ();
	    public Zig_Zag_Iterator_II(ArrayList<ArrayList<Integer>> vecs) {
	        // initialize your data structure here.
	        for (ArrayList<Integer> list : vecs){
	            master.add(list.iterator());
	            size = master.size();
	            cur = 0;
	        }
	    }

	    public int next() {
	        // Write your code here
	        if(!hasNext()){
	            return -1;
	        }
	       while(!master.get(cur).hasNext()){
	           cur = (cur + 1) % size;
	       }
	       int temp = master.get(cur).next();
	       cur = (cur + 1) % size;
	       return temp;
	    }

	    public boolean hasNext() {
	        // Write your code here  
	        for(Iterator<Integer> iter : master) {
	            if(iter.hasNext()) {
	                return true;
	            }
	        }
	        return false;
	    }
}
