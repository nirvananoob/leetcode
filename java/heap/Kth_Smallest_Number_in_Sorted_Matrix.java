package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//Find the kth smallest number in at row and column sorted matrix.
public class Kth_Smallest_Number_in_Sorted_Matrix {
	/**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
     class Node {
            int row; 
            int col;
            int val;
            Node(int a, int b , int c) {
                this.row = a;
                this.col = b;
                this.val = c;
            }
          
        }
     static Comparator<Node> comp = new Comparator<Node> () {
         public int compare(Node n1 , Node n2) {
             if (n1.val != n2.val) {
                 return n1.val - n2.val;
             }else if (n1.row != n2.row) {
                 return n1.row - n2.row;
             }else {
                 return n1.col - n2.col;
             }
         }
     };
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
       
       
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0){
            
            return -1;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        int pre = -1;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Node> queue = new PriorityQueue<Node> (k, comp);
        queue.offer(new Node(0,0,matrix[0][0]));
        visited[0][0] = true;
        while (count < k && !queue.isEmpty()) {
            Node temp = queue.poll();
            count++;
            if(temp.row + 1 < row  && visited[temp.row + 1][temp.col] == false) {
                queue.offer(new Node(temp.row + 1, temp.col,matrix[temp.row + 1][temp.col]));
                visited[temp.row + 1][temp.col]  = true;
            }
            if (temp.col + 1 < col && visited[temp.row][temp.col + 1] == false) {
                queue.offer(new Node(temp.row, temp.col + 1, matrix[temp.row][temp.col + 1]));
                visited[temp.row][temp.col + 1] = true;
            }
            pre = temp.val;
        }
        return count == k? pre : -1;
        
    }
}
