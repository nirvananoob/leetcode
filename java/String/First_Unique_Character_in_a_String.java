package String;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode" return 0.
 * 
 * s = "loveleetcode", return 2. Note: You may assume the string contain only
 * lowercase letters.
 * 
 * @author kaizhang
 *
 */
public class First_Unique_Character_in_a_String {
	 public int firstUniqChar(String s) {
	        int index = s.length() - 1;
	        HashMap<Character,Integer> map = new  HashMap<Character,Integer> ();
	        while(index >= 0){
	            char c = s.charAt(index);
	            if (!map.containsKey(c)) {
	                map.put(c, index);
	               
	            }else {
	             map.put(c,Integer.MAX_VALUE);
	            }
	            --index;
	        }
	        int res = s.length();
	        for(int i : map.values()){
	            res = Math.min(res, i);
	        }
	        return res == s.length() ?-1 :res ;
	    
    }
	 public static void main(String[] args) {
		 First_Unique_Character_in_a_String test = new First_Unique_Character_in_a_String();
		 String s = "loveleetcode";
		 System.out.println(test.firstUniqChar(s));
	 }
}
