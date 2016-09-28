package Stack;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
	/*
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],

return 10.
	 */
	 public static int largestRectangleArea(int[] heights) {
	        if(heights == null || heights.length == 0) {
	            return 0;
	        }
	        int max = 0;
	        Stack<Integer> stack = new Stack<Integer> ();
	        for(int i = 0; i <= heights.length; i++) {
	            int height = i < heights.length? heights[i] : -1;
	            while (!stack.isEmpty() && heights[stack.peek()] > height){
	               int pre = stack.pop();
	               int width = stack.isEmpty() ? i   : i - stack.peek() - 1  ;
	               max = Math.max(heights[pre] * width , max);
	            }
	            stack.push(i);
	        }
	        return max;
	        
	    }
	 public static void main(String[] args) {
		 int[] arr = {2,1,5,6,2,3};
		 System.out.print(largestRectangleArea(arr));
	 }
}
