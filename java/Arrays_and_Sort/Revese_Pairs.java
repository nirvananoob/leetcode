package Arrays_and_Sort;

/**
 * For an array A, if i < j, and A [i] > A [j], called (A [i], A [j]) is a
 * reverse pair. return total of reverse pairs in A. 
 * Example Given A = [2, 4, 1,
 * 3, 5] , (2, 1), (4, 1), (4, 3) are reverse pairs. return 3
 * 
 * @author kaizhang
 *
 */
public class Revese_Pairs {
	 public long reversePairs(int[] A) {
	        // Write your code here
	        if (A == null || A.length <= 1){
	            return 0;
	        }
	        return merge(A, 0, A.length - 1);
	        
	    }
	    private long merge(int[] arr, int l , int r ){
	        if(l  >= r){
	            return 0;
	        }
	        int mid = (l + r ) / 2;
	        long left =  merge(arr, l, mid);
	        long right = merge(arr, mid + 1, r);
	        long tmp = 0;
	        int[] cache = new int[r - l + 1]; 
	        int cur = 0;
	        int t = mid + 1;
	        // while(index1 <= mid && index2 <= r){
	        //     if(arr[index2] > arr[index1]){
	        //         cache[cur++] = arr[index1 ++];
	        //         cur
	        //     }
	        // }
	        for(int i = l ; i <= mid; i++){ 
	            while(t <= r && arr[t] < arr[i]){
	                cache[cur++] = arr[t++];
	            }
	            cache[cur++] = arr[i];
	            tmp +=  t - mid -1 ;
	        }
	        System.arraycopy(cache, 0,arr,l, cur );
	        return left + right + tmp;
	    }
	    public static void main(String[] args) {
	    	int[] arr = new int[] {2, 4, 1, 3, 5};
	    	Revese_Pairs test = new Revese_Pairs();
	    	System.out.println(test.reversePairs(arr));
	    	System.out.println(Integer.toBinaryString(2));
	    }
}
