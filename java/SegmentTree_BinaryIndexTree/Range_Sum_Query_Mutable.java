package SegmentTree_BinaryIndexTree;

public class Range_Sum_Query_Mutable {
	private int[] arr;
	// Array to store the Tree elements
	private int[] Tree;

	public Range_Sum_Query_Mutable(int[] nums) {
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
	void update(int index, int value) {
		if (index >= arr.length) {
			throw new IllegalArgumentException("array out of bounds ");
		}
		int diff = value - arr[index];
		arr[index] = value;
		updateTree(index + 1, diff);
	}

	/**
	 * update the binary index tree.
	 * 
	 * @param index
	 * @param diff
	 * @return
	 */

	private void updateTree(int index, int diff) {
		while (index < Tree.length) {
			Tree[index] += diff;
			index = getNext(index);
		}
		return;

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

	public static void main(String[] args) {
		int[] arr = { -1 };
		Range_Sum_Query_Mutable test = new Range_Sum_Query_Mutable(arr);
		test.update(0, 1);
		System.out.println(test.sumRange(0, 0));

	}

}
