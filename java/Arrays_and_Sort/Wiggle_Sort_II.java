package Arrays_and_Sort;

import java.util.Arrays;

public class Wiggle_Sort_II {
	// general method : quickselect then sort O(n) time O(n) space
	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}

		int medium = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
		int[] temp = new int[nums.length];
		int s = 0, t = nums.length - 1, mid_index = (nums.length + 1) / 2;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < medium)
				temp[s++] = nums[i];
			else if (nums[i] > medium)
				temp[t--] = nums[i];
		}

		while (s < mid_index)
			temp[s++] = medium;
		while (t >= mid_index)
			temp[t--] = medium;

		t = nums.length;
		for (int i = 0; i < nums.length; i++)
			nums[i] = (i & 1) == 0 ? temp[--s] : temp[--t];
		return;

	}

	private int quickSelect(int[] nums, int start, int end, int k) {
		int l = start, r = end, mid;
		int pivot = nums[end];
		while (l <= r) {
			while (l <= r && nums[l] > pivot) {
				l++;
			}
			while (l <= r && nums[r] <= pivot) {
				r--;
			}
			if (l < r) {
				swap(nums, l, r);
				l++;
				r--;
			}
		}
		swap(nums, l, end);
		if (l - start == k - 1) {
			return nums[l];
		} else if (l - start > k - 1) {
			return quickSelect(nums, start, l - 1, k);
		} else {
			return quickSelect(nums, l + 1, end, k - (l - start + 1));
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}

	// method 2 : virtual index :
	private int len;
	private int maxeven;

	public void wiggle_sort_opt(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		len = nums.length;
		int medium = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
		maxeven = (len - 1) / 2 * 2;
		int maxodd = (len / 2 - 1) * 2 + 1;
		int i = 0, j = 0, k = maxodd;
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			if (nums[j] < medium) {
				swap(nums, i, j);

				i = getNext(i);
				j = getNext(j);
				low++;
			} else if (nums[j] > medium) {
				swap(nums, j, k);
				high--;
				k = getPre(k);

			} else {
				j = getNext(j);
				low++;
			}

		}
//		while (i != 0) {
//			nums[i] = medium;
//			i = getPre(i);
//		}
//		while (k != maxodd) {
//			nums[k] = medium;
//			k = getNext(k);
//		}
	}

	private int getNext(int i) {
		return i == maxeven ? 1 : i + 2;
	}

	private int getPre(int i) {
		return i == 1 ? maxeven : i - 2;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 5, 6 };
		int[] arr1 = { 1, 5, 1, 1, 6, 4 };
		Wiggle_Sort_II test = new Wiggle_Sort_II();
		test.wiggle_sort_opt(arr);
		System.out.println(Arrays.toString(arr));
	}
}
