import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;


public class heap {
	public static void main(String[] args) {
		Comparator<Integer> comp = new Comparator<Integer> () {
			public int compare (Integer t1 , Integer t2) {
				return t2- t1;
			}
		};
		PriorityQueue<Integer> queue = new PriorityQueue<Integer> (16,comp);
		queue.offer(3);
		queue.offer(10);
		queue.offer(1000);
		queue.offer(-99);
		queue.offer(4);
		queue.offer(100);
		int time = 0;
		 Iterator it = queue.iterator();
		 while(it.hasNext() && time 
				 < 3){
		System.out.println(it.next());
		++time;
		}
		 Integer t1 = 12;
		 Integer t2 = 14;
		 System.out.print(t1.compareTo(t2));
		 String a = "d";
		 String b = "b";
		 System.out.println(b.compareTo(a));
		 System.out.println((int)a.charAt(0));
	}
}
