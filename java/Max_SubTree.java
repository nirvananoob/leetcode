import java.util.*;
class Node{
	int val;
	ArrayList<Node> children;
	public Node (int val) {
		this.val = val;
		this.children = new ArrayList<Node> ();	
	}
}
public class Max_SubTree {
	class SumCount{
	    int sum;
	    int count;
	    public SumCount(int sum, int count){
	        this.sum = sum;
	        this.count = count;
	    }
	}
	class Result{
		int sum;
		int count;
		double maxdouble;
		Node maxnode;
		public Result(int a, int b, double c, Node node) {
			sum  = a;
			count = b;
			maxdouble = c;
			maxnode = node;
		}
	}
	private  double resAve = Double.MIN_VALUE;
    private  Node result;
    public  Node getHighAve(Node root){
        if (root == null) return null;
        dfs(root);
        return result;
    }
    
    private  SumCount dfs(Node root){
        // 这里必须先把叶子节点刨掉，注意看我的手法，其实没什么。
        if (root.children == null || root.children.size() == 0){
            return new SumCount(root.val, 1);
        }
        //把当前root的材料都准备好
        int curSum = root.val;
        int curCnt = 1;
        //注意了这里开始遍历小朋友了
        for (Node child : root.children) {
            SumCount cSC = dfs(child);
            //每次遍历一个都把sum,count都加上，更新
            curSum += cSC.sum;
            curCnt += cSC.count;
        }
        double curAve = (double) curSum/curCnt;
        //这里看一下最大值要不要更新
        if (resAve < curAve){
            resAve = curAve;
            result = root;
        }

        return new SumCount(curSum,curCnt);
    }
	public Node getMax(Node root){
		return helper(root).maxnode;
	}
	public Result helper(Node root){
		if(root == null) {
			return new Result(0,0, Integer.MIN_VALUE,null);
		}
		if(root.children.size() == 0){
			return new Result(root.val, 1, Integer.MIN_VALUE,null );
		}
		int cursum = root.val;
		int count = 1;
		double curmax = Integer.MIN_VALUE;
		Node curnode = null;
		for(Node c  : root.children){
			Result temp = helper(c);
			cursum += temp.sum;
			count += temp.count;
			if(curmax < temp.maxdouble){
				curmax = temp.maxdouble;
				curnode = temp.maxnode;
			}
		}
		double curdouble = (double) cursum / count;
		if(curdouble >= curmax){
			curmax = curdouble;
			curnode = root;
		}
		return new Result(cursum, count, curmax, curnode);
		
	}
	public static void main(String[] args) {
		Max_SubTree  test = new Max_SubTree ();
		 Node root = new Node(1);
	        Node l21 = new Node(2);
	        Node l22 = new Node(3);
	        Node l23 = new Node(4);
	        Node l31 = new Node(5);
	        Node l32 = new Node(5);
	        Node l33 = new Node(5);
	        Node l34 = new Node(5);
	        Node l35 = new Node(5);
	        Node l36 = new Node(130);

	        l21.children.add(l31);
	        l21.children.add(l32);

	        l22.children.add(l33);
	        l22.children.add(l34);

	        l23.children.add(l35);
	        l23.children.add(l36);

	        root.children.add(l21);
	        root.children.add(l22);
	        root.children.add(l23);
	        Node res = test.getMax(root);
	        
	        System.out.println(res.val);
	        Node rex = test.getHighAve(root);
	        System.out.println(rex.val);}
}