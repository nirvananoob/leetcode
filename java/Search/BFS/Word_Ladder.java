package Search.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Word_Ladder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null ||wordList == null ||wordList.size() == 0 || beginWord.length() == 0) {
            return 0;
        }
        //Double_BFS
        wordList.add(beginWord);
        wordList.add(endWord);
        HashSet<String> start = new HashSet<String> ();
        Queue<String> queue1 = new LinkedList<String> ();
        HashSet<String> end = new HashSet<String> ();
        Queue<String> queue2 = new LinkedList<String> ();
        queue1.offer(beginWord);
        start.add(beginWord);
        queue2.offer(endWord);
        end.add(endWord);
        int spath = 0, tpath = 0;
        while(!queue1.isEmpty() &&!queue2.isEmpty()) {
            ++spath;
            int size1 = queue1.size();
            for(int i = 0 ;  i <size1; i++){
            String s = queue1.poll();
            Set<String> set1 = getNeighbors(s, wordList);
            for(String next : set1) {
                if (end.contains(next)){
                    return spath + tpath + 1;
                }
                if(!start.contains(next)){
                    queue1.offer(next);
                    start.add(next);
                }
            }
            }
            ++tpath;
            int size2 = queue2.size();
            for(int i = 0 ; i < size2; i++) {
                String t = queue2.poll();
                 Set<String> set2 = getNeighbors(t, wordList);
            for(String next : set2) {
                if (start.contains(next)){
                    return spath + tpath + 1;
                }
                if(!end.contains(next)){
                    queue2.offer(next);
                    end.add(next);
                }
            }
            }
        }
        return 0;
        
    }
    //get the neighbor words to traverse
    private Set<String> getNeighbors(String word, Set<String> dict) {
        HashSet<String> set = new HashSet<String> ();
        char[] arr = word.toCharArray();
        for(int i = 0 ; i < arr.length; i++) {
            char temp = arr[i];
            for(char j = 'a'; j <= 'z' ; j++){
                if (j == temp) {
                    continue;
                }
                arr[i] = j;
                String next = new String(arr);
                if (dict.contains(next)){
                    set.add(next);
                }
                
            }
            arr[i] = temp;
        }
        return set;
        
    }
    public static void main(String[] args) {
    	String a = "hit";
    	String b = "cog";
    	Set<String> set = new HashSet<String> ();
    	set.add("hot");
    	set.add("dog");
    	set.add("dot");
    	set.add("log");
    	set.add("lot");
    	Word_Ladder test  = new Word_Ladder();
    	System.out.println(test.ladderLength(a, b, set));
    }

}
