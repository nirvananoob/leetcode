package algorithms_template;

public class bit_map {
	private int size;
	private int[] arr;
	public bit_map(int n) {
		size = n;
		arr = new int[1 + size / 32];
	}
	// add the number to the array
	public void  add(int num) {
		int index = num >> 5; // the index of array
		int shift = num & 31;
		int bitpos = 1 << shift;
		arr[index] = arr[index] | bitpos;
	}
	// delete the number from  the array
	public void clear(int num) {
		int index = num >> 5;
		int shift = num & 31; 
		int mask = ~(1 << shift);
		arr[index] = arr[index] & mask;
	}
	//check 
	public boolean contain(int num) {
		int index = num >> 5;
		int shift = num & 31;
		
		if ( ((1 << shift) & arr[index] ) == 0) {
			return false ;
		}
		return true;
	}
	public static  int findDuplicate(int[] nums) {
		int len = nums.length - 1;
		bit_map check  = new bit_map(len);
		for (int i  = 0; i < nums.length; i++) {
			if (check.contain(nums[i])) {
				return nums[i];
			}
			check.add(nums[i]);
			
		}
		return -1;
		
		
	}
	public static void main(String[] args){
		int[] testarr = new int[] {1,2,2,3,4,5,6,7,8,9};
		int res = findDuplicate(testarr);
		System.out.println(14 -(14 & 13) );
		System.out.println(res);
		System.out.print((1 <<2));
	}
}
