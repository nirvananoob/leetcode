package design;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Vector;

public class Counting_Bloomfilter {
	 class HashFunction{
	        int capacity;
	        int seed;
	        public HashFunction(int cap, int seed){
	            this.capacity = cap;
	            this.seed = seed;
	        }
	        public int hashcode(String word) {
	            int res = 0;
	            for(char c : word.toCharArray()) {
	                res += res * seed + (int)c;
	                res %= capacity;
	            }
	            return res;
	        }
	    }
	    private BitSet bits;
	    private  int[] counts;
	    private List<HashFunction> hashs;
	    public Counting_Bloomfilter(int k) {
	        // initialize your data structure here 
	        this.bits = new BitSet(100000);
	        this.counts = new int[100000];
	        this.hashs = new ArrayList<HashFunction> ();
	        for(int i = 0 ; i < k ; i++){
	            hashs.add(new HashFunction (100000, 33 + i));
	        }
	        
	    }

	    public void add(String word) {
	        // Write your code here
	        for(HashFunction hash : hashs){
	           int pos = hash.hashcode(word);
	           bits.set(pos);
	           ++counts[pos];
	       }
	    }

	    public void remove(String word) {
	        // Write your code here
	        for(HashFunction hash : hashs){
	           int pos = hash.hashcode(word);
	           bits.set(pos);
	           --counts[pos];
	       }
	    }

	    public boolean contains(String word) {
	        // Write your code here
	         for(HashFunction hash : hashs){
	           int pos = hash.hashcode(word);
	           if(counts[pos] <= 0){
	               return false;
	           }
	       }
	       return true;
	    }

	  
	    public static void main(String[] args) {
	    	Counting_Bloomfilter test = new Counting_Bloomfilter(4);
	    	String a = "bloom";
	    	String b = "berg";
	    	String c = "bloomberg";
	    	test.add(a);
	    	assert test.contains(a) == true;
	    	test.add(b);
	    	test.remove(a);
	    	assert test.contains(b) == false;
	    	test.add(c);
	    	assert test.contains(c) == true;
	    }
}
