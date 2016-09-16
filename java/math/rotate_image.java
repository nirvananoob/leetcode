package math;

import java.util.Arrays;

public class rotate_image {
	public static void rotate(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return ;
        }
        int len = matrix.length;
        int mid =  len - 1;//(double  the value of mid point's coordination)
        int pre;
        for (int x = 0 ; x < matrix.length / 2; x++){
            for (int y = 0; y < (matrix.length + 1 ) / 2; y ++) {
                
                pre  = matrix[mid - y ][x];
               matrix[mid - y][x] = matrix[mid - x][mid - y];
               matrix[mid - x ][mid - y ] = matrix[ y][mid - x];
               matrix[ y][mid - x]  = matrix[x][y];
               matrix[x][y] = pre;
            }
        }
        return ;
    }
	public static void main(String[] args) {
		int[][] arr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		
		rotate(arr);
		//System.out.println(Arrays.toString(arr));
		for(int i = 0 ; i < arr.length; i ++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		//System.out.println(1 << 2);
	}
}
