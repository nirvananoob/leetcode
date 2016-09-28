package DP;

public class Edit_Distance {
	/**
	 * Given two words word1 and word2, find the minimum number of steps
	 * required to convert word1 to word2. (each operation is counted as 1
	 * step.)
	 * 
	 * You have the following 3 operations permitted on a word:
	 * 
	 * Insert a character 
	 * Delete a character 
	 * Replace a character 
	 * Example Given word1 = "mart" and
	 * word2 = "karma", return 3.
	 */
	public int minDistance(String word1, String word2){
        if (word1 == null || word2 == null){
            return Integer.MAX_VALUE;
        }
        if(word1.length() == 0){
            return word2.length();
        }
        if(word2.length() == 0) {
            return word1.length();
        }
        int[][] res = new int[1 + word1.length()][1 + word2.length()];
        for (int i = 1 ; i < res.length; i++){
            res[i][0] = i;
        }
        for (int i = 1; i < res[0].length; i++) {
            res[0][i] = i;
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j <res[0].length; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                }else {
                    res[i][j] = getMin(res[i - 1][j - 1], res[i][j - 1], res[i - 1][j] ) + 1;
                }
            }
        }
        return res[res.length - 1][res[0].length - 1];
    }
    private int getMin(int a, int b, int c) {
        return Math.min(a, b) < c ? Math.min(a, b) : c;
    }
}
