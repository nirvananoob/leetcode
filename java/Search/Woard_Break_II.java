package Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Woard_Break_II {
	/**
	 * Given a string s and a dictionary of words dict, add spaces in s to
	 * construct a sentence where each word is a valid dictionary word.
	 * 
	 * Return all such possible sentences.
	 * 
	 * For example, given s = "catsanddog", dict = ["cat", "cats", "and",
	 * "sand", "dog"].
	 * 
	 * A solution is ["cats and dog", "cat sand dog"].
	 * 
	 */public List<String> wordBreak(String s, Set<String> wordDict) {
         List<String> res = new ArrayList<String> ();
         if (s == null || s.length() == 0) {
             return res;
         }
         int maxlen = 0;
         
         for (String str : wordDict) {
             if (str.length() >maxlen) {
                 maxlen = str.length();
             }
         }
         if (!isValid (s, wordDict, maxlen)) {
             return res;
         }
         String sb = new String();
         
         dfs(res,sb,s, 0,wordDict, maxlen);
         return res;
     
 }
 private void dfs(List<String> res, String sb, String s, int start, Set<String> dict, int max) {
     if (start >= s.length()) {
         
         String str = new String(sb);
         res.add(str);
         return ;
     }
     for (int i = start; i <= start + max  && i <= s.length(); i++){
         String sub = s.substring(start, i);
         if (dict.contains(sub)){
             int curlen = sb.length();
             sb += sub;
             if( i < s.length()){
             sb +=" ";
             }
             dfs(res, sb, s, i,dict,max);
             sb = sb.substring(0, curlen);
             
         }
     }
     return ;
 }
 //use dp to optimizing the solution : 
 private  boolean isValid(String s, Set<String> dict, int max){
     boolean[] res = new boolean[s.length() + 1];
     res[0] = true;
     for(int i = 1; i < res.length; i++) {
        
         for(int j = Math.max(1, i - max + 1); j <= i; j++){
            if( res[j - 1] && dict.contains(s.substring(j -1, i) )){
                res[i] = true;
                break;
            }
         }
     }
     return res[res.length -1];
     
 }
}
