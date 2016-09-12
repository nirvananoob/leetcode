# Given an directed graph, a topological order of the graph nodes is defined as follow:

# For each directed edge A -> B in graph, A must before B in the order list.
# The first node in the order can be any node in the graph with no nodes direct to it.
# Find any topological order for the given graph.
# Definition for a Directed graph node

class DirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []

class Solution:
    """
    @param graph: A list of Directed graph node
    @return: A list of graph nodes in topological order.
    """
   
    def topSort(self, graph):
        from collections import *
        # write your code here
        if graph is None :
            return None;
        node = {};
        for v in graph: 
            node[v] = 0;
        for s in graph:
            for d in s.neighbors:
                node[d] += 1;
        lst = [];
        queue = deque();
        for k in node:
            if node[k] == 0:
                queue.append(k);
        while len(queue) != 0:
            cur = queue.popleft();
            lst.append(cur);
            for k in cur.neighbors:
                node[k] -= 1;
                if node[k] == 0:
                    queue.append(k);
        for k in lst:
            print  k.label,
        return lst;

# test:
if __name__ == "__main__":
   
    solution = Solution();
    a = DirectedGraphNode(1);
    b = DirectedGraphNode(2);
    c = DirectedGraphNode(3);
    d = DirectedGraphNode(4);
    a.neighbors.append(b);
    a.neighbors.append(c);
    b.neighbors.append(d);
    c.neighbors.append(d);
    lst = [a,b,c,d];
    solution.topSort(lst);




