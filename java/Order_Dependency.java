import java.util.*;
class Order{
    String order = "";
    public Order(String string){
        this.order = string;
    }
}
class OrderDependency{
    Order cur;
    Order pre;
    public OrderDependency(Order o1, Order o2){
        cur = o1;
        pre = o2;
    }
}
public class Order_Dependency {
    //����������������飬�����Ȱڸ�����������һ����˼��
    public static List<Order> getOrderList(List<OrderDependency> orderDependencies){
        List<Order> result = new ArrayList<>();
        //������map,��һ���ǵ�ǰ��orderָ����ٸ�order,�����Ⱦ�����
        Map<Order, ArrayList<Order>> map = new HashMap<>();
        //�ڶ����ǵ�ǰorder�����ٸ�orderָ,��Ϊ���
        Map<Order, Integer> inMap = new HashMap<>();
        //�ѳ��ֹ��Ķ���¼����
        Set<Order> set = new HashSet<>();
        for (OrderDependency od : orderDependencies){
            Order cur = od.cur;
            Order pre = od.pre;
            set.add(cur);
            set.add(pre);
            //�����һ,������1
            if (inMap.containsKey(cur)){
                int indegree = inMap.get(cur);
                inMap.put(cur, indegree+1);
            }
            else {
                inMap.put(cur, 1);
            }
            //�������ҲҪ��pre����,��Ϊ���Ҫ����ͷ,�������Ϊ0�ĵ㡣
            if (!inMap.containsKey(pre)){
                inMap.put(pre, 0);
            }

            if (map.containsKey(pre)){
                map.get(pre).add(cur);
            }
            else {
                map.put(pre, new ArrayList<>());
                map.get(pre).add(cur);
            }
            //ע��������ʱ��,map���Կ��ɳ���,����Ϊ0ҲҪ��,�����������ж�����null
            if (!map.containsKey(cur)){
                map.put(cur, new ArrayList<Order>());
            }
        }

        Queue<Order> queue = new LinkedList<>();
        int total = set.size();

        for (Order od : inMap.keySet()){
            if (inMap.get(od) == 0){
                queue.offer(od);
            }
        }
        //����ʹ����BFS
        while (!queue.isEmpty()){
            Order order = queue.poll();
            result.add(order);
            for (Order odr : map.get(order)){
                //��������,��Ȱ����,���������0,˵��������㡣
                inMap.put(odr, inMap.get(odr) - 1);
                if (inMap.get(odr) == 0){
                    queue.offer(odr);
                }
            }
        }
        //��������л��Ļ�,�϶��ǰ���������,��ôset����ĸ�����result����ĸ�����һ�¡�
        if (result.size() != total) return new ArrayList<Order>();
        return result;
    }
    //��������
    public static void main(String[] args) {
        Order o1 = new Order("A");
        Order o2 = new Order("B");
        Order o3 = new Order("C");
        Order o4 = new Order("D");
        OrderDependency od1 = new OrderDependency(o1, o2);
        OrderDependency od2 = new OrderDependency(o2, o3);
        //�ɻ���������ǰ�o4���ĳ�o2�����������
        OrderDependency od3 = new OrderDependency(o3, o4);
        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);

        for (Order o : getOrderList(list)){
            System.out.println(o.order);
        }
    }
}