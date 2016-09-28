package Binary_Search;
/**
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Have you met this question in a real interview? Yes
Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.


 * @author kaizhang
 *
 */
public class First_Position_of_Target {
	public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || target >nums[nums.length - 1]) {
            return -1;
        }
        int l = 0, r = nums.length - 1, mid;
        while( l + 1 < r) {
            mid = (l + r) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
                return mid;
            }else if(nums[mid] < target){
                l = mid+ 1;
            }else {
                r = mid - 1;
            }
        }
        
        if (nums[l] == target){
            return l;
        }else if(nums[r] == target) {
            return r;
        }else {
            return -1;
        }
    }
}
