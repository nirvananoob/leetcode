package two_pointer;

public class find_kth_largest {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return -1;
		}
		return quickSelect(nums, 0, nums.length - 1, k);
	}

	private int quickSelect(int[] arr, int left, int right, int k) {
		int start = left, end = right;
		int pivot = arr[right];
		while (start <= end) {
			while (start <= end && arr[start] > pivot) {
				start++;
			}
			while (start <= end && arr[end] <= pivot) {
				end--;
			}
			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		swap(arr, start, right);
		if (start - left == k - 1) {
			return pivot;
		} else if (start - left > k - 1) {
			return quickSelect(arr, left, start - 1, k);
		} else {
			return quickSelect(arr, start + 1, right, k - (start - left + 1));
		}

	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return;
	}

	public static void main(String[] args) {
		find_kth_largest a = new find_kth_largest();
		int[] test = { 9,8,7,6,5 };
		System.out.print(a.findKthLargest(test, 2));
	}
}
