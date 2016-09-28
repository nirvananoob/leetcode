package union_Find;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110 
 * 11010 
 * 11000 
 * 00000 Answer: 1
 * 
 * Example 2:
 * 
 * 11000 
 * 11000 
 * 00100 
 * 00011 Answer: 3
 * 
 * @author kaizhang
 *
 */
public class Number_of_Islands_I {
	// version1 : union find
	class unionFind {
		HashMap<Integer, Integer> map;

		public unionFind(int x) {
			this.map = new HashMap<Integer, Integer>();
			for (int i = 0; i < x; i++) {
				map.put(i, i);
			}
		}

		public int find(int x) {
			// if(!map.containsKey (x) ) {
			// throw new IllegalArgumentException("can't find the key :" +
			// Integer.toString(x));
			// }
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
			int fx = find(x);
			int next = -1;
			while (x != fx) {
				next = map.get(x);
				map.put(x, fx);
				x = next;
			}
			return fx;
		}
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length, col = grid[0].length;
		unionFind uf = new unionFind(row * col);
		int[] dx = { 0, 1 };
		int[] dy = { 1, 0 };

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					int cur = i * col + j;
					int nx, ny;
					for (int m = 0; m < dx.length; m++) {
						nx = i + dx[m];
						ny = j + dy[m];
						if (nx < row && ny < col && grid[nx][ny] == '1') {
							uf.union(cur, nx * col + ny);
						}
					}
				}
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					set.add(uf.compress_find(i * col + j));
				}
			}
		}
		return set.size();
	}

	// version2 : dfs
	 public int numIslands_dfs(char[][] grid) {
	        if(grid == null || grid.length == 0|| grid[0].length == 0) {
	            return 0;
	        }
	        boolean[][] visited = new boolean[grid.length][grid[0].length];
	        for(int i = 0; i < grid.length; i++) {
	            for(int j = 0; j < grid[0].length; j++) {
	                if(grid[i][j] =='1') {
	                    visited[i][j] = true;
	                }
	            }
	        }
	        int ans = 0;
	        int[] dx = {0,1,0,-1};
	        int[] dy = {1,0,-1,0};
	        for (int i = 0; i < grid.length; i++) {
	            for(int j = 0; j < grid[0].length; j++){
	                if (visited[i][j]) {
	                    ans++;
	                    dfs(visited, i, j,dx,dy);
	                }
	            }
	        }
	        return ans;
	    }
	 private void dfs(boolean[][] arr, int x, int y,int[] dx, int[] dy) {
	        if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
	            return;
	        }
	        
	        if(arr[x][y] ){
	            arr[x][y]  = false;
	            for(int i = 0; i< dx.length; i++) {
	                dfs(arr,x + dx[i], y + dy[i],dx,dy);
	            }
	        }
	        return;
	    }

	// data pre-processing
	private char[][] getArray(String[] str) {
		int row = str.length;
		int col = str[0].length();
		char[][] arr = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = str[i].charAt(j);
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		Number_of_Islands_I test = new Number_of_Islands_I();
//		String[] str = { "11110", "11010", "11000", "00000" };
		String[] str = {"111", "010","111"};
		char[][] arr = test.getArray(str);
		long s1 = System.currentTimeMillis( );
		System.out.println(test.numIslands(arr));
		long s2 = System.currentTimeMillis( );
		
		
		System.out.println(test.numIslands_dfs(arr));
		long s3 = System.currentTimeMillis( );
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println("union find need time:" + (s2 -s1));
		System.out.println("dfs need time:" + (s3 -s2));

	}
}
