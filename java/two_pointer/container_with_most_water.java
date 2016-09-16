package two_pointer;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author kaizhang
 *
 */
public class container_with_most_water {
	public static int maxArea(int[] height) {
		int area = 0;
		int start = 0, end = height.length - 1;
		int smaller, width;
		while (start < end) {

			width = end - start;
			if (height[start] < height[end]) {
				smaller = height[start];
				while (start < end && height[start] <= smaller) {
					start++;
				}
			} else {
				smaller = height[end];
				while (start < end && height[end] <= smaller) {
					end--;
				}
			}
			area = Math.max(area, smaller * width);
		}
		return area;

	}

	public static void main(String[] args) {
		int[] test = { 3, 1, 4, 2, 1, 5 };
		int res = maxArea(test);
		System.out.print(res);

	}
}
