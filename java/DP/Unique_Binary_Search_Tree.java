package DP;

public class Unique_Binary_Search_Tree {
	/**
	 * Given n, how many structurally unique BSTs (binary search trees) that
	 * store values 1...n?
	 * 
	 * 
	 * Example Given n = 3, there are a total of 5 unique BST's.
	 * 
	 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3 Tags Catalan Number
	 * Dynamic Programming
	 */
	public int numTrees(int n) {
        // write your code here
        if (n == 0 || n == 1){
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n + 1; i++) {
           for(int j = 1; j <= i; j++){
               nums[i] += nums[j-1] * nums[i - j];
           }  
        }
        return nums[n] ;
    }
}
