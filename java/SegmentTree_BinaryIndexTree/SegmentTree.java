package SegmentTree_BinaryIndexTree;

/**
 * SegmentTree template
 * 
 * @author kaizhang
 *
 */
public class SegmentTree {
	// class segTree{
	SegmentTree left, right;
	int start, end, count;

	SegmentTree(int start, int end) {
		this.start = start;
		this.end = end;
		this.count = 0;
		this.left = this.right = null;
	}
}

class segTree {
	private SegmentTree root;

	private SegmentTree buildTree(int start, int end) {
		if (start > end) {
			return null;
		}
		SegmentTree node = new SegmentTree(start, end);
		if (start != end) {
			int mid = start + (end - start) / 2;
			node.left = buildTree(start, mid);
			node.right = buildTree(mid + 1, end);
		}
		return node;
	}

	private void modify(SegmentTree root, int start, int end) {
		if (start == root.start && end == root.end) {
			root.count += 1;
			return;
		}
		if (start > root.end || end < root.start) {
			return;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (end <= mid) {
			modify(root.left, start, end);
		} else if (start > mid) {
			modify(root.right, start, end);
		} else {
			modify(root.left, start, mid);
			modify(root.right, mid + 1, end);
		}
		root.count = root.left.count + root.right.count;
		return;
	}

	private int search(SegmentTree root, int start, int end) {
		if (start == root.start && end == root.end) {
			return root.count;
		}
		if (start > root.end || end < root.start) {
			return 0;
		}
		int mid = root.start + (root.end - root.start) / 2;
		if (end <= mid) {
			return search(root.left, start, end);
		} else if (start > mid) {
			return search(root.right, start, end);
		} else {
			return search(root.left, start, mid)
					+ search(root.right, mid + 1, end);
		}
	}
}
