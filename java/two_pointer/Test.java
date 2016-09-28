package two_pointer;

import java.util.Arrays;
class type{
	String c;
 type(String s) {
		this.c = s;
	}
}
public class Test {
	 
 public static void main(String[] args) {
	 Test c = new Test();
	 type a = new type("1");
	
	int[] test= {1,2,3,4};
	 c.swap(test,0,test.length - 1);
	 System.out.print(Integer.MAX_VALUE);
	 for(int obj : test){
	 System.out.println(obj);}
 }
 public  void swap(int[] arr, int i, int j) {
	 int temp = arr[i];
	 arr[i] = arr[j];
	 arr[j] = temp;
 }
}
