package Pocket_Gem_OA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class coursera1 {
	public static void main(String[] args
			){
		HashMap<String,Integer>  map = new HashMap<String,Integer>();
		map.put("Alex", 1);
		map.put("Michael", 1);
		map.put("Michael", 1);
		map.put("Mary",1);
		map.put("Mary",1);
		String name = "";
		int value = Integer.MIN_VALUE;
		for(Map.Entry<String , Integer> entry : map.entrySet()) {
			if(entry.getValue() > value){
				value = entry.getValue();
				name = entry.getKey();
			}else if(entry.getValue() == value){
				String temp = entry.getKey();
				name = temp.compareTo(name) > 0? temp : name;
			}
		}
		
		StringBuilder sb = new StringBuilder("abcd");
		sb.reverse();
		System.out.println(sb.toString());
//		System.out.println(Arrays.toString(s.toCharArray()));
	}
}
