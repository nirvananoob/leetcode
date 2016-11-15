
public class Longest_Palindrome {
	//bug : 1. dont initialize the dp array;
	//2 set maxlen = 0
	 public String longestPalindrome_dp(String s) {
		 
	        if(s == null || s.length() <= 1){
	            return s;
	        }
	        boolean[][] dp = new boolean[s.length()][s.length()];
	        for(int  i = 0 ; i < s.length(); i++) {
	            dp[i][i] = true;
	        }
	        int maxlen = 1;
	        int start = 0;
	        for(int k = 2 ; k <= s.length(); k++) {
	            for(int j = 0 ; j < s.length() - k  + 1; j++) {
	                if((k == 2 || dp[j + 1][j + k - 2]) && s.charAt(j) == s.charAt(j + k - 1)){
	                    dp[j][j + k - 1] = true;
	                    if(k > maxlen){
	                        maxlen = k;
	                        start = j;
	                    }
	                }
	            }
	        }
	        return s.substring(start, start + maxlen);
	        
	    }
	 // manacher
	 public String longestPalindrome(String s) {
		  String str = preprocess(s);
	       int maxlen = 0 ;
	       int pos = 0;
	       int mid = 1;
	       int bound = 0;
	       int[] lens = new int[str.length()];
	       for(int i = 1; i < str.length(); i++){
	           int mirror = mid * 2 - i;
	           // bug 1:
	           int cur = Math.max(Math.min(lens[mirror], bound - i), 0);
	           while(i - cur > 0 && i + cur < str.length() && str.charAt(i - cur - 1) == str.charAt(i + cur + 1)){
	               ++cur;
	           }
	           lens[i] = cur;
	           if(i + lens[i] > bound){
	               mid = i;
	               bound = i + lens[i];
	           }
	       }
	       for(int i = 0 ; i < str.length(); i++){
	           if(lens[i] > maxlen) {
	               maxlen = lens[i];
	              pos = i;
	           }
	       }
	       return s.substring(s.charAt((pos - maxlen) / 2), s.charAt((pos + maxlen) / 2));
	       
//	       String str = preprocess(s);
//	       //1st :
//	       int maxlen = 0 ;
//	       int pos = 0;
//	       int mid = 0;
//	       int bound = 0;
//	       int[] lens = new int[str.length()];
//	       for(int i = 1; i < s.length(); i++){
//	           int mirror = mid * 2 - i ;
////	           // bug 1:
////	           int cur = Math.max(lens[mirror], 0);
////	           while(i - cur > 0 && str.charAt(i - cur - 1) == str.charAt(i + cur + 1)){
////	               ++cur;
////	           }
////	           len[i] = cur;
////	           if(i + len[i] > bound){
////	               mid = i;
////	               bound = i + len[i];
////	           }
////	       }
////	       for(int i = 0 ; i < str.length(; i++){
////	           if(lens[i] > maxlen) {
////	               maxlen = lens[i];
////	              pos = i;
////	           }
////	       }
////	       return s.substring(s.charAt((pos - maxlen) / 2, s.charAt(pos + maxlen) / 2));
////	       
//	       }
	    }
	    private String preprocess(String s){
	        StringBuilder sb = new  StringBuilder ();
	        sb.append('.');
	        for(char c : s.toCharArray()){
	            sb.append(c);
	            sb.append('*');
	        }
	        return sb.toString();
	    }
	    public static void main(String[] args) {
	    	Longest_Palindrome test = new Longest_Palindrome();
	    	String s = "babad";
	    	System.out.println(test.longestPalindrome(s));
	    }
}
