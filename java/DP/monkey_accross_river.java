package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class monkey_accross_river {
	public int solution(int[] A, int D){
		if(A == null ) {
			return -1;
		}
		if (D >= A.length){
			return 0;
		}
		//preprocess the Array:
		int maxtime = -1;
		HashMap<Integer,Integer> timeline = new HashMap<Integer, Integer> ();
		for(int i = 0 ; i < A.length; i++) {
			if(A[i] == -1) {
				continue;
			}
			timeline.put(A[i],i);
			maxtime = Math.max(maxtime, A[i]);
		}
//		HashSet<Integer> reachble_set = new HashSet<Integer> ();
		HashSet<Integer> unuse_set = new HashSet<Integer> ();
		int bound =  0;
//		int max = -1;
		int N = A.length;
//		for (int i = 0; i < D ; i++) {
////			if(A[i] != -1){
//			reachble_set.add(i);
//			
////			max = Math.max(i,max);
////			}
//		}
		int max = D - 1 ;
		for(int i = 0 ; i < maxtime; i++) {
			if(!timeline.containsKey(i)) {
				continue;
			}
			int pos = timeline.get(i);
			if (pos < bound) {
				continue;
//				pos > reachble_set.size() - 1
			}else if(pos > max ){
				unuse_set.add(pos);
			}else {
				//update the state:
				int cur = max + 1;
				int tmp = pos + D;
				while(cur <= tmp){
					if (unuse_set.contains(cur)){
						unuse_set.remove(cur);
						tmp = cur + D;
					}
//					reachble_set.add(cur);
//					++max;
					++cur;
				}
				max = cur - 1;
				bound = cur - D ;
				if(max >= N) {
					return i;
				}
			}
		}
		return -1;	
		
	}
	public static void main(String[] args) {
		monkey_accross_river test = new monkey_accross_river();
		 int[] A =  new int[0];
//		 Arrays.fill(A,  -1);
//		 A[1] = 1;
//		 A[2] = 4;
//		 A[3] = 3;
//		 A[4] = 15;
//		 A[5] = 14;
//		 A[6] = 19;
//		 A[9] = 25;
//		A[8] = 36;
		
		 System.out.println(test.solution(A,3));
	}
}
