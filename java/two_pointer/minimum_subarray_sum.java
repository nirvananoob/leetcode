package two_pointer;
/**
//Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.
//
//click to show more practice.
//
//More practice:
//If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/
public class minimum_subarray_sum {
	public static int minimumSize(int[] nums, int s) {
		// write your code here
		if (nums == null || nums.length == 0) {
			// throw new IllegalArgumentException();
			return -1;
		}
		// v1 O(n^2)
		// int size = Integer.MAX_VALUE;
		// for (int i = 0 ; i < nums.length; i++) {
		// int count = 0;
		// for(int j = i; j< nums.length; j++) {
		// count += nums[j];
		// if (count >= s) {
		// size = Math.min(size, j + 1 - i);
		// break;
		// }
		// }

		// }
		// return size != Integer.MAX_VALUE ? size : -1;
		// v2 O(n)
//		int cur_sum = 0;
//		int size = Integer.MAX_VALUE;
//		int end = -1;
//		for (int i = 0; i < nums.length; i++) {
//			while (end < nums.length - 1 && cur_sum < s) {
//				end++;
//				cur_sum += nums[end];
//
//			}
//			if (cur_sum >= s) {
//				size = Math.min(size, end - i + 1);
//				cur_sum -= nums[i];
//			} else {
//				break;
//			}
//		}
//		return size != Integer.MAX_VALUE ? size : -1;
		// V3 O(nlgn)
		int len = nums.length, res = len + 1;
		int[] sums = new int[len + 1];
		for (int i = 0 ; i < len; i++){
			sums[i + 1] = sums[i] + nums[i];
		}
		
		for (int i = 0 ; i < len + 1; i ++) {
			int right = binarysearch(sums, i + 1, sums.length - 1, sums[i] + s);
			 if (right == len + 1) break;
	         if (res > right - i) res = right - i;
	         
			
		}
		return res == len + 1 ? -1 : res;
	}
	private static int binarysearch (int[] arr, int start, int end, int target) {
		int mid;
		while(start + 1 < end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == target) {
				return mid;
			}else if (arr[mid] > target){
				end = mid -1;
			}else {
				start = mid + 1;
			}
		}
		if (arr[start] >= target ) {
			return start;
		}else if (arr[end] < target) {
			return end + 1;
		}
		return end;
	}
	public static void main(String[] args) {
		int[] test = { 2, 3, 1, 2, 4, 3 };
		long x = 0;
		int y = 100;
		while(y != 0) {
			x += y /10;
			y = y /10;
		}
		System.out.println(x);
		int res = minimumSize(test, 7);
		System.out.print(res);
	}
}
