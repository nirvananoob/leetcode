package booking;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Booking_OA_3 {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int sqaure = 0;
		int rec = 0;
		int others = 0;
		boolean isValid = true;
		
		while (true) {
			
			String line = in.nextLine();
			if(line.equals("")) {
				break;
			}
			String[] numbers = line.split("\\s+");
			int[] nums = new int[numbers.length];
			for (int i = 0; i < numbers.length; i++) {
				nums[i] = Integer.valueOf(numbers[i]);
				if (nums[i] <= 0) {
					
					isValid = false;
					
				}
			}
			if(!isValid){
				++others;
				
			}
			else{
				if(nums[0] != nums[2] || nums[1] != nums[3])
				 {
					++others;
				} else {
					if (nums[0] != nums[1]){
					++rec;
				} else {
					++sqaure;

				}
				}
			}
		
			
			
		}
		in.close();
		System.out.print(sqaure);
		System.out.print(" ");
		System.out.print(rec);
		System.out.print(" ");
		System.out.print(others);

	}
}
