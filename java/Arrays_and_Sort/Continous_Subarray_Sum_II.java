package Arrays_and_Sort;

/**
 * 
 * Given an circular integer array (the next element of the last element is the first element), find a continuous subarray in it, where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number.
 if duplicate answers exist, return any of them.
 Example
 Give [3, 1, -100, -3, 4], return [4,1].

 */
import java.util.ArrayList;

public class Continous_Subarray_Sum_II {

	/**
	 * @param A
	 *            an integer array
	 * @return A list of integers includes the index of the first number and the
	 *         index of the last number
	 */
	public ArrayList<Integer> continuousSubarraySumII(int[] A) {
		// Write your code here
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (A == null || A.length == 0) {
			return list;
		}
		int total = 0;
		int maxstart = 0, maxend = 0;
		int minstart = 0, minend = 0;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int prefixmax = 0, prefixmin = 0;
		int premaxstart = 0, preminstart = 0;
		for (int i = 0; i < A.length; i++) {
			total += A[i];
			// if(A[i] > A[singlemax]){
			// singlemax = i;
			// }
			if (prefixmax < 0) {
				premaxstart = i;
				prefixmax = 0;
			}
			if (prefixmin >= 0) {
				preminstart = i;
				prefixmin = 0;
			}
			prefixmax += A[i];
			prefixmin += A[i];
			if (prefixmax > max) {
				maxstart = premaxstart;
				max = prefixmax;
				maxend = i;
			}
			if (prefixmin < min) {
				minstart = preminstart;
				min = prefixmin;
				minend = i;
			}
		}
		if (total == min || total - min < max) {
			list.add(maxstart);
			list.add(maxend);

		} else {
			list.add((minend + 1) % A.length);
			list.add((minstart - 1 + A.length) % A.length);

		}
		return list;

	};

	public static void main(String[] args) {
		Continous_Subarray_Sum_II test = new Continous_Subarray_Sum_II();
		int[] arr = new int[] { -45, 18, 27, 67, 88, -38, 65, -8, 2, -13, -24,
				-6, 84, 17, -22, 40, -5, 19, 90 };
		
	}
}
