package Arrays_and_Sort;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Return 0 if the array contains less than 2 elements.

 Notice

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

 Have you met this question in a real interview? Yes
 Example
 Given [1, 9, 2, 5], the sorted form of it is [1, 2, 5, 9], the maximum gap is between 5 and 9 = 4.
 */
import java.util.Arrays;

public class Maximum_Gap {
	public int maximumGap(int[] nums) {
		// write your code here
		// v1 : bucket sort :
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		if (max == min) {
			return 0;
		}
		int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
		int[] buckets_min = new int[nums.length - 1];
		int[] buckets_max = new int[nums.length - 1];
		Arrays.fill(buckets_min, Integer.MAX_VALUE);
		Arrays.fill(buckets_max, Integer.MIN_VALUE);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == min || nums[i] == max) {
				continue;
			}
			int index = (nums[i] - min) / gap;
			buckets_min[index] = Math.min(buckets_min[index], nums[i]);
			buckets_max[index] = Math.max(buckets_max[index], nums[i]);
		}
		int maxgap = gap;
		int pre = min;
		for (int i = 0; i < nums.length - 1; i++) {
			if (buckets_min[i] == Integer.MAX_VALUE) {
				continue;
			}
			maxgap = Math.max(maxgap, buckets_min[i] - pre);
			pre = buckets_max[i];
		}
		maxgap = Math.max(max - pre, maxgap);
		return maxgap;
	}

	public int maximumGap_radix_sort(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int Radix = 10;
		
		int base = 1;
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		while (max / base >= 1) {
			int[] count = new int[Radix];
			for (int i = 0; i < nums.length; i++) {
				++count[(nums[i] / base) % 10];
			}
			for (int i = 1; i < Radix; i++) {
				count[i] += count[i - 1];
			}
			int[] aux = new int[nums.length];
			for (int i = nums.length - 1; i >= 0; i--) {
				aux[--count[(nums[i] / base) % 10]] = nums[i];
			}
			nums = aux;
			base *= 10;
		}
		int gap = -1;
		for (int i = 1; i < nums.length; i++) {
			gap = Math.max(gap, nums[i] - nums[i - 1]);
		}
		return gap;

	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1, 4, 13 };
		int[] arr1 = {0, Integer.MAX_VALUE};
		Maximum_Gap test = new Maximum_Gap();
		System.out.println(test.maximumGap(arr));
		System.out.println(test.maximumGap_radix_sort(arr1));
		System.out.println(Integer.MAX_VALUE);
	}
}
