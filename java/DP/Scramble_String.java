package DP;
/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
Challenge 
O(n3) time
 * @author kaizhang
 *
 */
public class Scramble_String {
	/**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if(s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if(s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        boolean[][][] visited = new boolean[len][len][len];
        boolean[][][] res = new boolean[len][len][len];
        return search(res, visited,s1,s2,0, 0, len);
    }
    private boolean search(boolean[][][] visited, boolean[][][] res, String s1, String s2, int lstart, int rstart, int len) {
        if (visited[lstart][rstart][len - 1] ) {
            return res[lstart][rstart][len - 1];
        }
        if(lstart + len > s1.length() || rstart + len > s1.length()) {
            return false;
        }
        visited[lstart][rstart][len - 1] = true;
        if(len == 1) {
            res[lstart][rstart][len - 1] = s1.charAt(lstart) == s2.charAt(rstart) ? true : false;
        }else {
            for (int i = 1; i < len; i++) {
                res[lstart][rstart][len - 1] = res[lstart][rstart][len - 1] || (search(res, visited,s1,s2,lstart,rstart, i) && search(res, visited,s1,s2,lstart + i , rstart + i, len - i)) || (search(res, visited,s1,s2,lstart,rstart + len  - i, i) && search(res, visited,s1,s2,lstart + i , rstart + i, len - i)) ;
            }
        }
        return res[lstart][rstart][len - 1];
    }
    public static void main(String[] args) {
    	Scramble_String test = new Scramble_String();
    	System.out.println(test.isScramble("ab", "ba"));
    }
}
