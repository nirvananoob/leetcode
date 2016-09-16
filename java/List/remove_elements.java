package List;

import java.util.Deque;
import java.util.LinkedList;

public class remove_elements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur != null) {
			if (cur.val == val) {
				if (cur.next == null) {
					cur = null;
				} else {
					cur.val = cur.next.val;
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	 String compute(String s) {
		
		if(s.length() == 1){
			return s;
		}
		char[] arr = s.toCharArray();
		int start = 0;
		String res = s;
		int i = 1;
		while (i < arr.length) {
			if (arr[i] > arr[start]) {
				start = i;
				res = s.substring(i, arr.length);

			} else if (arr[i] == arr[start]) {
				if (res.compareTo(s.substring(i, arr.length)) < 0) {
					start = i;
					res = res = s.substring(i, arr.length);
				}
				
			}
			i++;
		}
		return res;

	}
	 int segment(int x, int[] arr) {
	        Deque<Integer>  deque = new LinkedList<Integer> ();
	        int i = 0 ; 
	        int res  = Integer.MIN_VALUE;
	       
	        for(int num : arr){
	            i++;
	            while((!deque.isEmpty() && num < deque.peekLast())){
	                deque.pollLast();
	            }
	            deque.offer(num);
	        
	        if(i > x && deque.peekFirst() == num){
	            deque.pollFirst();
	        }
	        if(i >= x){
	            res = Math.max(res, deque.peekFirst());
	        }
	        }
	        return res;
	    }



	public static void main(String[] args) {
		remove_elements test = new remove_elements();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		// System.out.println(test.removeElements(head, 1).toString());
		String s = "banana";
		int[] arr = {1,1,3,2,1};
		System.out.println(test.segment(1,arr ));
		System.out.println(test.compute(s));
	}
}
