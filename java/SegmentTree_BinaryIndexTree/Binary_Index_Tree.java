package SegmentTree_BinaryIndexTree;

/**
 * binary index tree template.
 * 
 * @author kaizhang
 *
 */
public class Binary_Index_Tree {
	// Array of input
	private int[] arr;
	// Array to store the Tree elements
	private int[] Tree;

	public Binary_Index_Tree(int[] target) {
		this.arr = target;
		buildTree();
	}

	/**
	 * Build the BIT
	 */
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

	/**
	 * get the next Node in BIT
	 * 
	 * @param index
	 * @return
	 */
	private int getNext(int index) {
		return index + lowBit(index);
	}

	/**
	 * test
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		int input[] = { 1, 2, 3, 4, 5, 6, 7 };
		Binary_Index_Tree bit = new Binary_Index_Tree(input);

		assert 1 == bit.getSum(0);
		assert 3 == bit.getSum(1);
		assert 6 == bit.getSum(2);
		assert 10 == bit.getSum(3);
		assert 15 == bit.getSum(4);
		assert 21 == bit.getSum(5);
		assert 28 == bit.getSum(6);

	}

}
