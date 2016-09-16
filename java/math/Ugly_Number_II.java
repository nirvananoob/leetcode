package math;

import java.util.ArrayList;
/**
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
 * @author kaizhang
 *
 */
public class Ugly_Number_II {
	 public  static int nthUglyNumber(int n) {
	        if(n == 1) {
	            return 1;
	        }
	        ArrayList<Integer>  nums = new ArrayList<Integer> ();
	        nums.add(1);
	        int cur = 2;
	        int p1 = 0, p2 = 0, p3 = 0;
	        int min1 , min2, min3, next;
	        while(nums.size() < n) {
	            while(nums.get(p1) * 2 < cur){
	                p1++;
	            }
	             min1 = nums.get(p1) * 2;
	            while(nums.get(p2) * 3 < cur) {
	                p2++;
	            }
	            min2 = nums.get(p2) * 3;
	            while(nums.get(p3) * 5 < cur) {
	                p3++;
	            }
	            min3 = nums.get(p3) * 5;
	            next = Math.min(Math.min(min1, min2), min3);
	            nums.add(next);
	            cur = next + 1;
	        }
	        return nums.get(n - 1);
	    }
	 public static void main(String[] args) {
		 System.out.println(nthUglyNumber(5));
	 }
}
