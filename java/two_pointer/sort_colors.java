package two_pointer;

import java.util.Arrays;

public class sort_colors {
	/**
	 * Given an array with n objects colored red, white or blue, sort them so
	 * that objects of the same color are adjacent, with the colors in the order
	 * red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 * 
	 * Notice
	 * 
	 * You are not suppose to use the library's sort function for this problem.
	 * You should do it in-place (sort numbers in the original array).
	 * 
	 * Example Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].
	 */
	public void sortColors(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}

		int pl = 0;
		int pr = a.length - 1;
		int i = 0;
		while (i <= pr) {
			if (a[i] == 0) {
				swap(a, pl, i);
				pl++;
				i++;
			} else if (a[i] == 1) {
				i++;
			} else {
				swap(a, pr, i);
				pr--;
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	/**
	 * FOLLOW UP: Given an array of n objects with k different colors (numbered
	 * from 1 to k), sort them so that objects of the same color are adjacent,
	 * with the colors in the order 1, 2, ... k.
	 */
	public void sortColors2(int[] colors, int k) {
		int count = 0;
		int color1 = 1;
		int color2 = k;
		int left = 0, right = colors.length - 1, i = 0;

		while (count < k) {

			while (i <= right) {
				if (colors[i] == color1) {
					swap(colors, i, left);
					left++;
					i++;

				} else if (colors[i] == color2) {
					swap(colors, i, right);
					right--;
				} else {
					i++;
				}
			}
			++color1;
			--color2;
			i = left;
			count += 2;
		}

	}

	public static void main(String[] args) {
		int[] test = { 3, 2, 3, 3, 4, 3, 3, 2, 4, 4, 1, 2, 1, 1, 1, 3, 4, 3, 4,
				2 };
		sort_colors a = new sort_colors();
		a.sortColors2(test, 4);
		System.out.println(Arrays.toString(test));
	}
}
