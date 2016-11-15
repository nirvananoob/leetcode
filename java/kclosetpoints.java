import java.util.*;
class Point{
	int x;
	int y;
}
public class kclosetpoints {
	 public Point[] Solution(Point[] array, Point origin, int k) {
		 Comparator<Point> comp = new Comparator<Point> (){
			 @Override
			 public int compare(Point p1, Point p2){
				 double d1 = getDistance(p1, origin);
				 double d2 = getDistance(p2,origin);
				 return Double.compare(d2, d1);
			 }
		 };
		 Point[] res = new Point[k];
		 PriorityQueue<Point> queue = new PriorityQueue<Point> (k, comp);
		 
		 for(Point temp : array){
			 queue.offer(temp);
			 if(queue.size() > k){
				 queue.poll();
			 }
		 }
		 for(int i = 0 ;i < k; i++){
			 res[i] = queue.poll();
		 }
		 return res;
	 }
	 public double getDistance(Point p1, Point p2) {
		 return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)) ;
	 }
}
