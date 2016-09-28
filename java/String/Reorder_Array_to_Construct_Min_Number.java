package String;

import java.util.Arrays;
import java.util.Comparator;

public class Reorder_Array_to_Construct_Min_Number {
	 public String minNumber(int[] nums) {
	        // Write your code here
	        Comparator<String> comp = new Comparator<String> () {
	            public int compare(String s1, String s2) {
	                int index = 0;
	                while(index < s1.length() && index < s2.length() ){
	                    if(s1.charAt(index) != s2.charAt(index)){
	                        return s1.charAt(index) - s2.charAt(index);
	                    }
	                    ++index;
	                }
	                if(index == s1.length()){
	                    return index == s2.length() ? 0 : s1.charAt(0) - s2.charAt(index);
	                }
	                return s1.charAt(index) - s2.charAt(0);
	            }
	        };
	        String[] arr = new String[nums.length];
	        int cur = 0;
	        for(int i : nums) {
	        	  arr[cur++] = Integer.toString(i);
	        	  }
	        Arrays.sort(arr,comp);
	        StringBuilder sb = new StringBuilder();
	        for(String s : arr) {
	            sb.append(s);
	        }
	        return sb.toString();
	    }
	 public static void main(String[] args) {
		 int[] arr = new int[] {3,32,321};
		 Reorder_Array_to_Construct_Min_Number test = new Reorder_Array_to_Construct_Min_Number();
		 System.out.println(test.minNumber(arr));
	 }
}
