package List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class anagrams {
	
	    public List<List<String>> groupAnagrams(String[] strs) {
	       List< List<String>> res = new ArrayList<List<String>> ();
	         if (strs == null || strs.length == 0 ) {
	        	 res.add(new ArrayList<String> ());
	             return res;
	         	         }
	         List<String> list ;
	        HashSet<Integer> keyset = new HashSet<Integer> ();
	       HashMap<Integer,List<String>> map = new  HashMap<Integer,List<String>> ();
	       for (String a : strs) {
	           int key = getKey(a);
	           if (!map.containsKey(key)) {
	               list = new ArrayList<String>();
	             
	           }else {
	               keyset.add(key);
	               list = map.get(key);
	           }
	         
	           list.add(a);
	           map.put(key, list);
	       }
	       if(keyset.isEmpty())
	       for (Integer i : keyset) {
	           res.add(map.get(i));
	       }
	       return res;
	    }
	    
	    
	     private int getKey(String a) {
	            int[] count = new int[26];
	            int code = 0;
	            for(char c : a.toCharArray()) {
	                count[c - 'a'] ++;
	            }
	           for (int i = 0 ; i < count.length; i++) {
	               code = code * 33 + count[i];
	           }
	           return code;
	        }
	     public static void main(String[] args) {
	    	 anagrams test = new anagrams();
	    	 String[] abc = {""};
	    	System.out.println( test.groupAnagrams(abc).toString());
	    	 
	     }
}
