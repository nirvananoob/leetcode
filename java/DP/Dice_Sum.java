package DP;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dice_Sum {
		private long[][] arr;
		private long sum;
	 public List<Map.Entry<Integer, Double>> dicesSum(int n) {
	        // Write your code here
	        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
	        // to create the pair
	        List<Map.Entry<Integer, Double>> res = new   ArrayList<Map.Entry<Integer, Double>>();
	        if(n <= 0 ) {
	            res.add(new AbstractMap.SimpleEntry<Integer, Double>(0, 1.00));
	            return res;
	        }
//	        int[][] 
	        arr = new long[2][6 * n + 1];
	        arr[0][0] = 1;
	        for(int i = 1 ; i <= n; i++){
	            for(int j = i - 1; j <= 6 * i - 6; j++ ){
	                for(int next = 1; next < 7; next++){
	                    arr[i % 2][j + next]+= arr[(i -1) % 2][j];
	                }
	               arr[(i -1) % 2][j] = 0 ;
	            }
	        }	        
	         sum =(int) Math.pow((double) 6, (double)n) ; 
	        
	        for(int  i = n; i<= 6 * n; i++) {
	        	
	            double pro = (double)arr[n % 2][i] / sum;
	            pro = (double) Math.round(pro *100)/100;
	            res.add(new AbstractMap.SimpleEntry<Integer, Double>(i, pro));
	        }
	        return res;
	    }
	 public static void main(String[] args) {
		 Dice_Sum test = new Dice_Sum();
		 System.out.println(1 / 12);
		 System.out.println(test.dicesSum(7).toString());
		 System.out.println(test.arr[7 % 2][22]);
		 System.out.println(test.sum);
		 System.out.println((double)test.arr[7 % 2][22] / test.sum);
		 
	 }
}
