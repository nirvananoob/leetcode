package String;
/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".


 * @author kaizhang
 *
 */
public class Shortest_Palindrome {
	 public String shortestPalindrome(String s) {
	        if(s == null || s.length () == 0) {
	            return s;
	        }
	     
	        int len = s.length();
	        StringBuilder sb= new StringBuilder(s);
	        sb.reverse();
	        String temp = s + "#"+ sb.toString();
	     
	        char[] arr = temp.toCharArray();
	        int[] pre = new int[arr.length];
	        int i  = 1, j = 0;
	        while(i < arr.length) {
	            if(arr[i] == arr[j]) {
	            	pre[i++] = ++j;
	              
	            }else {
	                if(j == 0){
	                    i++;
	                }else{
	                    j = pre[j - 1];
	                }
	            }
	        }
	        // sb.delete(len - pre[arr.length - 1] + 1, len);
	        // sb.append(s);
	        StringBuilder sc = new StringBuilder(s.substring(pre[arr.length - 1], len));
	        sc.append(s);
	        return  sc.toString();
	    }
	 public static void main(String[] args) {
		 String s = "acecaa";
		 Shortest_Palindrome test = new Shortest_Palindrome();
		 System.out.println(test.shortestPalindrome(s));
	 }
}
