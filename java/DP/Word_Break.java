package DP;

import java.util.HashSet;
import java.util.Set;

public class Word_Break {
	/**
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * break into a space-separated sequence of one or more dictionary words.
	 * 
	 * 
	 * Example Given s = "lintcode", dict = ["lint", "code"].
	 * 
	 * Return true because "lintcode" can be break as "lint code".
	 */
	public boolean wordBreak(String s, Set<String> dict) {
		// write your code here
		if (s == null ) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int maxlen = 0;
        for (String str :dict ){
            if(str.length() > maxlen) {
                maxlen = str.length();
            }
        }
        //
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i < res.length; i++){
            for (int j = Math.max(1,i - maxlen + 1); j <= i; j++) {
                if(res[j - 1 ] && dict.contains(s.substring(j - 1, i))){
                    res[i] = true;
                    break;
                }
            }
        }
		return res[s.length()];

	}

	public static void main(String[] args) {
		Word_Break test = new Word_Break();
		Set<String> dict = new HashSet<String>();
		dict.add("lint");
		dict.add("code");
		//dict.add("abc");
		System.out.println(test.wordBreak("lintcode", dict));
		

	}
}
