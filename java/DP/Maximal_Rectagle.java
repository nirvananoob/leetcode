package DP;

import java.util.Stack;

public class Maximal_Rectagle {
	/*
	 * Given a 2D boolean matrix filled with False and True, find the largest
	 * rectangle containing all True and return its area. Example Given a
	 * matrix:
	 * 
	 * [ [1, 1, 0, 0, 1], 
	 *   [0, 1, 0, 0, 1], 
	 *   [0, 0, 1, 1, 1], 
	 *   [0, 0, 1, 1, 1], 
	 *   [0, 0, 0, 0, 1] ] 
	 *   return 6.
	 *   Tags 
			Dynamic Programming Array Stack
	 */
	 /**
	  * the solution is a combination of dp and sorted stack
	  * (see the problem : how to get the largest rectangle in histogram)
	  * first create the array heights[][], heights[i][j] stores the largest height of the 
	  * rectangle end at point(i, j)
	  * then we calculate the largest rectangle for each row, so that we can get the result
	  *
	  * 
	  * 
	  * @param args
	  */
	//for optimization : just need 1 dimension array for heights
	public int maximalRectangle(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0 ; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (i == 0){
                    heights[i][j] = matrix[i][j] == true?  1: 0;
                    continue;
                }
                heights[i][j] = matrix[i][j] == true? heights[i - 1][j] + 1 : 0;
            }
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer> ();
        for (int i = 0; i < heights.length; i++){
           for (int j = 0; j <= heights[0].length; j++){
               int cur = j < heights[0].length ?  heights[i][j] :-1;
               while(!stack.isEmpty() && heights[i][stack.peek()] > cur){
                   int h = heights[i][stack.pop()];
                   int w = stack.isEmpty() ? j : j - stack.peek() - 1;
                   max = Math.max(h * w, max);
               }
               stack.push(j);
           }
           stack.pop();
        }
        return max;
    }

	    public static void main(String[] args) {
	    	Maximal_Rectagle test = new Maximal_Rectagle();
	    	boolean[][] arr = new boolean[][]{{true,true,true,true,true},{true,true,false,true,true},{false,true,true,true,true},{false,true,true,true,true}};
	    	System.out.println(test.maximalRectangle(arr));
	    }
}
