package DP;

/**
 * There is a stone game.At the beginning of the game the player picks n piles
 * of stones in a line.
 * 
 * The goal is to merge the stones in one pile observing the following rules:
 * 
 * At each step of the game,the player can merge two adjacent piles to a new
 * pile. The score is the number of stones in the new pile. You are to determine
 * the minimum of the total score.
 * 
 * 
 * Example For [4, 1, 1, 4], in the best solution, the total score is 18:
 * 
 * 1. Merge second and third piles => [4, 2, 4], score +2 
 * 2. Merge the first two piles => [6, 4]，score +6 
 * 3. Merge the last two piles => [10], score +10
 * 
 * @author kaizhang
 *
 */
public class Stone_Game {
	public int stoneGame(int[] A) {
		// Write your code here
		if (A == null || A.length == 0) {
			return 0;
		}
		int len = A.length;
		int[][] res = new int[len][len];
		boolean[][] visited = new boolean[len][len];
		int sum[] = new int[len];
		sum[0] = A[0];
		for (int i = 1; i < len; i++) {
			sum[i] = sum[i - 1] + A[i];
		}
		return search(visited, res, 0, len - 1, sum);
	}

	private int search(boolean[][] visited, int[][] res, int l, int r, int[] sum) {
		if (l > r) {
			return Integer.MAX_VALUE;
		}
		if (visited[l][r]) {
			return res[l][r];
		}
		visited[l][r] = true;
		res[l][r] = Integer.MAX_VALUE;
		if (l == r) {
			res[l][r] = 0;
		} else {
			int basescore = l == 0 ? sum[r] : sum[r] - sum[l - 1];
			for (int i = l; i < r; i++) {
				res[l][r] = Math.min(
						search(visited, res, l, i, sum)
								+ search(visited, res, i + 1, r, sum)
								+ basescore, res[l][r]);
			}
		}
		return res[l][r];
	}
}
