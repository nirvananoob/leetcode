import java.util.*;
public class Window_Sum {
	 public List<Integer> GetSum(List<Integer> A, int k) {
		 ArrayList<Integer> res = new ArrayList<> ();
		 int sum = 0 ; 
		 for(int i = 0 ; i < A.size(); i++) {
			 sum += A.get(i);
			 if(i >= k){
				 sum -= A.get(i - k);
			 }
			 if(i >= k - 1){
				 res.add(sum);
			 }
		 }
		 return res;
//	        ArrayList<Integer> res = new ArrayList<>();
//	        int len = A.size();
//	        for (int i = 0; i + k - 1 < len; ++i) {
//	            int sum = 0;
//	            for (int j = 0; j < k; ++j) {
//	                sum += A.get(i+j);
//	            }
//	            res.add(i,sum);
//	        }
//	        return res;
	 }
}
