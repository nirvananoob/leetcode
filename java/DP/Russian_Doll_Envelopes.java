package DP;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Example:
 Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

 Subscribe to see which companies asked this question

 Show Tags
 Show Similar Problems

 */
import java.util.Arrays;
import java.util.Comparator;

public class Russian_Doll_Envelopes {
	static Comparator<int[]> comp = new Comparator<int[]>() {
		public int compare(int[] arr1, int[] arr2) {
			if (arr1[0] == arr2[0]) {
				return arr2[1] - arr1[1];
			}
			return arr1[0] - arr2[0];
		}
	};

	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0
				|| envelopes[0].length == 0) {
			return 0;
		}
		if (envelopes.length == 1) {
			return 1;
		}
		Arrays.sort(envelopes, comp);
		int[] dp = new int[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			dp[i] = envelopes[i][1];
		}
		return lis(dp);
	}

	// 此处的lis不同于longest increse substring的地方是， 必须严格递增不能出现a[i] == a[i - 1]
	private int lis(int[] dp) {
		int len = dp.length;
		int[] res = new int[len];
		// res[0] = 1;
		// int max = 1;
		// for(int i = 1; i < len; i++) {
		// res[i]= 1;
		// for(int j = 0; j < i ; j++) {
		// if(dp[i] > dp[j]) {
		// res[i] = Math.max(res[i], res[j] + 1);
		// }
		// }
		// max = Math.max(max, res[i]);
		// }
		// return max;
		// }
		int max = 0;
		res[0] = dp[0];
		for (int i = 1; i < len; i++) {
			if (dp[i] < res[0]) {
				res[0] = dp[i];
			} else if (dp[i] > res[max]) {
				res[++max] = dp[i];
			} else {
				int index = binarySearch(res, 0, max, dp[i]);
				res[index] = dp[i];
			}
		}
		return max + 1;
	}

	private int binarySearch(int[] arr, int start, int end, int target) {
		int l = start, r = end;
		int mid;
		while (l + 1 < r) {
			mid = (l + r) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		if (arr[r] < target) {
			return r + 1;
		} else if (arr[l] < target) {
			return r;
		} else {
			return l;
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 33, 23 }, { 43, 3 }, { 10, 43 }, { 42, 29 },
				{ 5, 34 }, { 41, 14 }, { 40, 14 }, { 5, 37 }, { 25, 6 },
				{ 7, 2 }, { 34, 47 }, { 46, 40 }, { 7, 6 }, { 41, 40 },
				{ 16, 36 }, { 41, 30 }, { 18, 31 }, { 21, 42 }, { 10, 5 },
				{ 40, 29 }, { 8, 12 }, { 36, 13 }, { 47, 8 }, { 3, 8 },
				{ 38, 18 }, { 2, 48 }, { 15, 29 }, { 17, 4 }, { 30, 47 },
				{ 32, 36 }, { 8, 49 }, { 11, 41 }, { 34, 22 }, { 1, 48 },
				{ 4, 1 }, { 42, 35 }, { 33, 9 }, { 3, 16 }, { 29, 30 },
				{ 18, 13 }, { 30, 11 }, { 6, 43 }, { 4, 16 }, { 32, 15 },
				{ 11, 50 }, { 13, 21 }, { 40, 28 }, { 36, 21 }, { 39, 26 },
				{ 32, 31 }, { 25, 8 }, { 40, 28 }, { 30, 22 }, { 20, 42 },
				{ 43, 18 }, { 19, 40 }, { 45, 9 }, { 50, 12 }, { 50, 38 },
				{ 41, 27 }, { 47, 14 }, { 8, 39 }, { 40, 45 }, { 38, 34 },
				{ 33, 5 }, { 14, 37 }, { 35, 15 }, { 7, 6 }, { 38, 47 },
				{ 43, 46 }, { 30, 29 }, { 36, 49 }, { 4, 18 }, { 28, 47 },
				{ 50, 31 }, { 10, 34 }, { 40, 31 } };
		Russian_Doll_Envelopes test = new Russian_Doll_Envelopes();
		System.out.println(test.maxEnvelopes(arr));
	}
}
