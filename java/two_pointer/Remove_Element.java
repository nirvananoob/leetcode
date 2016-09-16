package two_pointer;

/**
 * Given an array and a value, remove all occurrences of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed, and the elements after the new length
 * don't matter.
 * 
 * @author kaizhang
 *
 */
public class Remove_Element {
	/** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0 ) {
            return 0;
        }
        int start = 0 , end = A.length - 1;
        while(start <= end) {
            while(start <= end && A[start] != elem) {
                start ++;
            }
            if (start == A.length) {
                return A.length;
            }
            while(start <= end && A[end] == elem) {
                end --;
            } 
            if (start < end) {
                swap(A, start, end);
                ++start;
                --end;
            }
        }
        return start;
    }
    private void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
