package two_pointer;

import java.util.Arrays;

/**
 * Given an array with positive and negative integers. Re-range it to
 * interleaving with positive and negative integers.
 * 
 * @author kaizhang
 *
 */
public class interleaving_pos_neg {
	public void rerange(int[] A) {
		// write your code here
		if (A == null || A.length == 0) {
			return;
		}
		int start = 0, end = A.length - 1;
		while (start <= end) {
			while (start <= end && A[start] > 0) {
				start++;
			}
			while (start <= end && A[end] < 0) {
				end--;
			}
			if (start <= end) {
				swap(A, start, end);
				start++;
				end--;
			}
		}
		int firstindex, lastindex;
		if (start == A.length - start) {
			firstindex = 1;
			lastindex = A.length - 2;
		} else if (start > A.length - start) {
			firstindex = 1;
			lastindex = A.length - 1;
		} else {
			firstindex = 0;
			lastindex = A.length - 2;
		}
		boolean swap = true;
		while (firstindex < start) {
			if (swap) {
				swap(A, firstindex, lastindex);
			}
			swap = !swap;
			firstindex++;
			lastindex--;
		}
		return;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		interleaving_pos_neg a = new interleaving_pos_neg();
		int[] test = { -13, -8, -12, -15, -14, 35, 7, -1, 11, 27, 10, -7, -12,
				28, 18 };
		a.rerange(test);
		System.out.println(Arrays.toString(test));
	}
}
