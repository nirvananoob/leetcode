package List;
class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };
public class copyrandomlist {
	  public RandomListNode copyRandomList(RandomListNode head) {
	        if (head == null) {
	            return null;
	        }
	        RandomListNode cur = head,temp;
	        //create copy
	        while (cur != null) {
	           temp = cur.next;
	            RandomListNode node = new  RandomListNode(cur.label);
	            cur.next = node;
	            node.next = temp;
	            cur = temp;
	        }
	        cur = head;
	        //copy random
	        while (cur != null ) {
	            if(cur.random != null){
	            cur.next.random = cur.random.next;}
	            cur = cur.next.next;
	        }
	        //split 
	         RandomListNode dummy = new  RandomListNode(-1);
	         cur = head;
	         temp = dummy;
	         while(cur != null) {
	             
	             temp.next = cur.next;
	             cur.next = cur.next.next;
	             temp = temp.next;
	             cur = cur.next;
	         }
	         return dummy.next;
	        
	    }
}
