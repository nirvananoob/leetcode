import java.util.*;
class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}
public class High_Five {
	 public static Map<Integer, Double> getHighFive_1(Result[] results){
	        Map<Integer, Double> map = new HashMap<>();
	        //����pValue������,����ÿ��person������Щvalue��
	        Map<Integer, ArrayList<Integer>> pValue = new HashMap<>();
	        //������ID�ѳɼ�������Ӧ���ˡ�
	        for (Result res : results){
	            int id = res.id;
	            if (pValue.containsKey(id)){
	                //����curL��ʾcurrent List
	                ArrayList<Integer> curL = pValue.get(id);
	                curL.add(res.value);
	                pValue.put(id, curL);
	            }
	            else {
	                ArrayList<Integer> curL = new ArrayList<>();
	                curL.add(res.value);
	                pValue.put(id, curL);
	            }
	        }
	        for (Integer id : pValue.keySet()){
	            ArrayList<Integer> list = pValue.get(id);
	            //����д����Щ��ɧ��,����������дcomparator
	            Collections.sort(list);
	            Collections.reverse(list);
	            double value = 0;
	            for (int k = 0; k < 5; k++){
	                value += list.get(k);
	            }
	            value = value/5.0;
	            map.put(id, value);
	        }
	        return map;
	    }
	 public static Map<Integer, Double> getHighFive_2(Result[] results){
		 Comparator<Integer> comp = new Comparator<Integer> () {
				@Override 
				public int compare(Integer t1, Integer t2) {
					return t1 - t2;
				}
			};
		 HashMap<Integer, PriorityQueue<Integer>> map = new  HashMap<Integer, PriorityQueue<Integer>> ();
		 for(Result tmp : results) {
			 if(!map.containsKey(tmp.id)) {
				 map.put(tmp.id, new PriorityQueue<Integer> (16, comp));
			 }
			 PriorityQueue<Integer>  queue = map.get(tmp.id);
			 queue.offer(tmp.value);
			 if(queue.size() > 5) {
				 queue.poll();
			 } 
		 }
		 Map<Integer, Double> ans = new HashMap<Integer, Double> ();
		 for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()){
			 int id = entry.getKey();
			 PriorityQueue<Integer> queue = entry.getValue();
			 if(queue.size() == 5) {
				 int sum = 0;
				 while(!queue.isEmpty()) {
					 sum += queue.poll();
				 }
				 ans.put(id, (double)sum / 5);
			 }
			 
		 }
		 return ans;
	 }
	  public static void main(String[] args) {
	        Result r1 = new Result(1, 95);
	        Result r2 = new Result(1, 95);
	        Result r3 = new Result(1, 91);
	        Result r4 = new Result(1, 91);
	        Result r5 = new Result(1, 93);
	        Result r6 = new Result(1, 105);

	        Result r7 = new Result(2, 6);
	        Result r8 = new Result(2, 6);
	        Result r9 = new Result(2, 7);
	        Result r10 = new Result(2, 6);
	        Result r11 = new Result(2, 6);
	        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
	        Map<Integer, Double> res = getHighFive_1(arr);
	        Map<Integer, Double> res_2 = getHighFive_1(arr);

	        System.out.println(res.get(1) + " " +res.get(2));
	        System.out.println(res_2.get(1) + " " +res_2.get(2));
	    }
}