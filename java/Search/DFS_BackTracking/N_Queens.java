package Search.DFS_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 * @author kaizhang
 *
 */
public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>> ();
        if (n <= 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer> ();
        dfs(res, list, n);
        return res;
    }
    private void dfs ( List<List<String>> res, ArrayList<Integer> list, int length ) {
        if (list.size() == length) {
            List<String>  sol = new ArrayList<String> ();
            for (int i = 0 ; i < list.size(); i++) {
                int col = list.get(i);
                StringBuilder sb = new StringBuilder();
                int cur = 1;
                while(cur < col ) {
                    sb.append('.');
                    cur++;
                }
                sb.append('Q');
                while(cur < length) {
                    sb.append('.');
                    cur ++;
                }
                sol.add(sb.toString());
            }
            res.add(sol);
            return;
        }
        for (int i = 1 ; i <= length; i++) {
            if(!isValid(list,i)) {
                continue;
            }
            list.add(i);
            dfs(res,list,length);
            list.remove(list.size() - 1);
        }
    }
    private boolean isValid (ArrayList<Integer>  list, int next){
        if (list.size() == 0 ) {
            return true;
        }
        int size = list.size();
        int cur ;
        for (int i = 0; i < size; i++) {
            cur = list.get(i);
            if (cur == next || cur - next  == size - i || cur  - next == i - size) {
                return false;
            }
        }
        return true;
        
    } 
}
