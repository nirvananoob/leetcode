import java.util.*;
class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }
}

public class Mst {
	static class UnionFind{
		HashMap<String, String> map;
		public UnionFind(HashMap<String, String> map) {
			this.map = map;
		}
		public void union(String a, String b){
			String f1 = find(a);
			String f2 = find(b);
			if(f1 != f2){
				map.put(f1, f2);
			}
		}
		public String find(String key){
			String cur = key;
			while(map.get(key) != key){
				key = map.get(key);
			}
			String tmp = key;
			String nxt ;
			while(cur != tmp){
				nxt = map.get(cur);
				map.put(cur, tmp);
				cur = nxt;
			}
			return tmp;
		}
	}
	public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
		Comparator<Connection> comp = new Comparator<Connection> (){
			@Override
			public int compare(Connection n1 , Connection n2){
				String s1 = n1.node1;
				String s2 = n2.node1;
				if(!s1.equals(s2)) {
					return s1.compareToIgnoreCase(s2);
				}
				return n1.node2.compareToIgnoreCase(n2.node2);
			}
		};
		Comparator<Connection> comp_2 = new Comparator<Connection> (){
			@Override
			public int compare(Connection n1 , Connection n2){
				return n1.cost - n2.cost;
			}
		};
		HashMap<String, String> map = new HashMap<String, String> ();
		ArrayList<Connection> res = new ArrayList<Connection> ();
		Collections.sort(connections,comp_2);
		for(Connection tmp : connections){
			if(!map.containsKey(tmp.node1)){
				map.put(tmp.node1, tmp.node1);
			}
			if(!map.containsKey(tmp.node2)) {
				map.put(tmp.node2, tmp.node2);
			}
		}
		UnionFind uf = new UnionFind(map);
		int total  = map.values().size();
		for(Connection tmp : connections) {
			if(uf.find(tmp.node1) != uf.find(tmp.node2)) {
				res.add(tmp);
				uf.union(tmp.node1, tmp.node2);
				--total;
			}
		}
		if(total != 1){
			return new ArrayList<Connection> ();
		}
		Collections.sort(res, comp);
		return res;
	}
	public static void main(String[] args) {
	    ArrayList<Connection> connections = new ArrayList<>();
	    //下面的图是个苯环，中间加上了几根，如果想验证空表，去掉几根线就行。
	    connections.add(new Connection("A","B",6));
	    connections.add(new Connection("B","C",4));
	    connections.add(new Connection("C","D",5));
	    connections.add(new Connection("D","E",8));
	    connections.add(new Connection("E","F",2));
	    connections.add(new Connection("B","F",10));
	    connections.add(new Connection("E","C",9));
	    connections.add(new Connection("F","C",7));
	    connections.add(new Connection("B","E",3));
	    connections.add(new Connection("A","F",16));
	    //这里就输出一下看看结果。
	    ArrayList<Connection> res = getLowCost(connections);
	    for (Connection c : res){
	        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
	    }
	}
}
