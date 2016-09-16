package two_pointer;

//Given a linked list, remove the nth node from the end of list and return its head.
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class Remove_Nth_Node_From_End_of_List {
	ListNode removeNthFromEnd(ListNode head, int n) {
		// // write your code here
		// if (n <= 0 || head == null){
		// return null;
		// }
		// ListNode dummy= new ListNode(0);
		// dummy.next = head;
		// ListNode pre = dummy;
		// for (int i = 1 ; i <= n ;i ++){
		// if (head == null){
		// return null;
		// }
		// head = head .next;
		// }
		// while (head != null){
		// pre = pre.next;
		// head = head.next;
		// }
		// pre.next = pre.next.next;
		// return dummy.next;
		// }
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		for (int i = 0; i < n; i++) {
			cur = cur.next;
		}
		ListNode pre = dummy;
		while (cur != null) {
			cur = cur.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return dummy.next;

	}
}
