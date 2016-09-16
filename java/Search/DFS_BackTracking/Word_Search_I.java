package Search.DFS_BackTracking;
/**
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * @author kaizhang
 *
 */
public class Word_Search_I {
	public boolean exist(char[][] board, String word)  {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j ++) {
                if(search(board, i, j, 0, word, dx, dy, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[][] board, int x, int y, int pos, String word, int[]dx, int[] dy, boolean[][] visited) {
       
        if (visited[x][y] || board[x][y] != word.charAt(pos)) {
            return false;
        }
        visited[x][y]  = true;
         if(pos == word.length() - 1) {
            return true;
        }
        
        int  nx, ny;
        for(int i = 0; i < dx.length; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                continue;
            }
            if (search(board, nx, ny, pos + 1, word, dx, dy,visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
