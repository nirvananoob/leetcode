package union_Find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given a n,m which means the row and column of the 2D matrix and an array of
 * pair A( size k). Originally, the 2D matrix is all 0 which means there is only
 * sea in the matrix. The list pair has k operator and each operator has two
 * integer A[i].x, A[i].y means that you can change the grid
 * matrix[A[i].x][A[i].y] from sea to island. Return how many island are there
 * in the matrix after each operator.
 * 
 * Notice
 * 
 * 0 is represented as the sea, 1 is represented as the island. If two 1 is
 * adjacent, we consider them in the same island. We only consider
 * up/down/left/right adjacent.
 * 
 * Example Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
 * 
 * return [1,1,2,2].
 * 
 * Definition for a point:
 */
class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class Number_of_Islands_II {
	class UnionFind {
		HashMap<Integer, Integer> map;

		public UnionFind(int num) {
			map = new HashMap<Integer, Integer>();
			for (int i = 0; i < num; i++) {
				map.put(i, i);
			}
		}

		public int find(int x) {
			int father = map.get(x);
			while (father != map.get(father)) {
				father = map.get(father);
			}
			return father;
		}

		public void union(int x, int y) {
			int fx = find(x);
			int fy = find(y);
			if (fx != fy) {
				map.put(fx, fy);
			}
		}

		public int compress_find(int x) {
			int father = find(x);
			int next = -1;
			while (x != father) {
				next = map.get(x);
				map.put(x, father);
				x = next;
			}
			return father;
		}
	}

	public List<Integer> numIslands2(int n, int m, Point[] operators) {
		List<Integer> list = new ArrayList<Integer>();
		if (n == 0 || m == 0 || operators == null || operators.length == 0) {
			return list;
		}
		UnionFind uf = new UnionFind(n * m);
		HashSet<Integer> set = new HashSet<Integer>();
		int sum = 0;
		int[] dx = { 0, 0, -1, +1 };
		int[] dy = { -1, 1, 0, 0 };
		int change, nx, ny, x, y, pos, prepos;
		for (Point p : operators) {
			x = p.x;
			y = p.y;
			pos = x * m + y;
			change = 1;
			set.add(pos);

			for (int i = 0; i < dx.length; i++) {
				nx = dx[i] + x;
				ny = dy[i] + y;

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}
				prepos = nx * m + ny;
				if (set.contains(prepos)) {
					if (uf.find(prepos) != uf.find(pos)) {
						--change;
						uf.union(prepos, pos);
					}
				}
			}
			sum += change;
			list.add(sum);
		}
		return list;
	}

	private Point[] preprocess(int[][] arr) {
		int len = arr.length;
		Point[] res = new Point[len];
		for (int i = 0; i < len; i++) {
			res[i] = new Point(arr[i][0], arr[i][1]);
		}
		return res;
	}

	public static void main(String[] args) {
		Number_of_Islands_II test = new Number_of_Islands_II();
		int[][] arr = new int[][] { { 1, 1 }, { 0, 1 }, { 3, 3 }, { 3, 4 } };
		Point[] data = test.preprocess(arr);
		System.out.println(test.numIslands2(4, 5, data));

	}
}
