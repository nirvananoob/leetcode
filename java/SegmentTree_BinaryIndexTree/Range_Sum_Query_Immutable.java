package SegmentTree_BinaryIndexTree;
/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */
public class Range_Sum_Query_Immutable {
	private int[] arr;
	// Array to store the Tree elements
	private int[] Tree;

    public Range_Sum_Query_Immutable (int[] nums) {
        this.arr = nums;
        buildTree();
    }
    private void buildTree() {
		this.Tree = new int[arr.length + 1];
		for (int i = 1; i < Tree.length; i++) {
			updateTree(i, arr[i - 1]);
		}
		return;

	}

	/**
	 * get the right most 1 in the binary presentation of the index.
	 * 
	 * @param index
	 * @return
	 */
	private int lowBit(int index) {
		return index & -index;
	}

	/**
	 * update the value at any position in source array
	 *
	 * @param index
	 * @param value
	 * @return
	 */
	private int update(int index, int value) {
		if (index >= arr.length) {
			throw new IllegalArgumentException("array out of bounds ");
		}
		int diff = value - arr[index];
		arr[index] = value;
		return updateTree(index, diff) == 1 ? 1 : -1;
	}

	/**
	 * update the binary index tree.
	 * 
	 * @param index
	 * @param diff
	 * @return
	 */

	private int updateTree(int index, int diff) {
		while (index < Tree.length) {
			Tree[index] += diff;
			index = getNext(index);
		}
		return 1;

	}

	/**
	 * get the prefix sum
	 * 
	 * @param index
	 * @return
	 */
	private int getSum(int index) {
		int sum = 0;
		++index;
		while (index > 0) {
			sum += Tree[index];
			index = getParent(index);
		}
		return sum;
	}

	/**
	 * get the parent Node in BIT
	 * 
	 * @param index
	 * @return
	 */
	private int getParent(int index) {
		return index - lowBit(index);
	}
	private int getNext(int index) {
		return index + lowBit(index);
	}
    public int sumRange(int i, int j) {
        return this.getSum(j) - this.getSum(i - 1);
    }
    public static void main(String[] args ) {
    	int[] input = new int[] {-2, 0, 3, -5, 2, -1};
    	Range_Sum_Query_Immutable  test = new Range_Sum_Query_Immutable (input);
    	System.out.println(test.sumRange(0, 2));
    	System.out.println(test.sumRange(2, 5));
    	System.out.println(test.sumRange(0, 5));
    	
    	
    }
}
