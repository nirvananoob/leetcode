
import java.util.*;
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
 };
public class Copy_With_Random_List {
	public RandomListNode copyRandomList(RandomListNode head) {
	 if(head == null) {
         return null;
     }
     RandomListNode cur = head;
     while(cur != null){
         RandomListNode tmp  = cur.next;
         RandomListNode node = new RandomListNode(cur.label);
         cur.next = node;
         node.next = tmp;
         cur = tmp;
     }
     cur= head;
     while(cur != null){
    	 //ÐèÒª¼Óbug
         if(cur.random != null){
         cur.next.random = cur.random.next;
         }
         cur = cur.next.next;
     }
     RandomListNode dummy = new RandomListNode (- 1);
     RandomListNode pre = dummy;
     cur = head;
     while(cur != null) {
         pre.next = cur.next;
         cur.next = cur.next.next;
         pre = pre.next;
         cur = cur.next;
     }
     return dummy.next;
 }
}
