package booking;

import java.util.*;

/**
 * find the numbers which are stored in all arrays, get the minimum of them.
 * for example,
 * give arrays[1,2,3], [2,3,4,5],[3,4,5,6]
 * return 3
 * @author kaizhang
 *
 */
public class get_minimum_number_in_all_sets {
	public int findcommonsmallest (List<Set<Integer>> lst) {
		HashSet<Integer> res = new HashSet<Integer> (lst.get(0));
		for(Set<Integer> set : lst) {
			res.retainAll(set);
		}
		
		int minvalue = Integer.MAX_VALUE;
		for(int a : res){
			minvalue = Math.min(a, minvalue);
		}
		return minvalue;
				
	   
	}
	public static void main(String[] args) {
//		int[] arr1 = {1,2,3,4};
//		int[] arr2 = {2,3,4,5};
		Set<Integer> set = new HashSet<Integer> ();
		set.add(1);
		set.add(2);
		set.add(3);
		Set<Integer> set1 = new HashSet<Integer> ();
		set1.add(2);
		set1.add(3);
		Set<Integer> set2 = new HashSet<Integer> ();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		List<Set<Integer>> list = new ArrayList<Set<Integer>> ();
		list.add(set1);
		list.add(set2);
		list.add(set);
		
		get_minimum_number_in_all_sets test = new get_minimum_number_in_all_sets();
		System.out.println(test.findcommonsmallest(list));
		
		}
}
