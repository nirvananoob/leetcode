from collections import *;
class _UndirectedNode:
    def __init__(self, val):
        self.label = val;
        self.neighbors = [];
class Six_Degree(object):
    '''
    @param {UndirectedGraphNode[]} graph a list of Undirected graph node
    @param {UndirectedGraphNode} s, t two Undirected graph nodes
    @return {int} an integer
    '''
    
    def bfs(self,_list,s,t):
        if  not _list: 
            return -1;
        queue = deque();
        _set = defaultdict(int);
        level = 0;
        _set[s] = 0;
        queue.append(s);
        while queue and level <= 6:
            level += 1;
            for i in range(len(queue)):
                node = queue.popleft();
                for neighbor in node.neighbors:
                    if neighbor in _set:
                        continue;
                    else:
                        _set[neighbor] = level;
                        if neighbor == t:
                            return level;
                        queue.append(neighbor);
                       
        return -1;
    def bi_bfs(self, list, s, t):
        _fqueue = deque();
        _bqueue = deque();
        _fset = defaultdict(int);
        _bset = defaultdict(int);
        _fqueue.append(s);
        _bqueue.append(t);
        spath = 0;
        tpath = 0;
        _fset[s] = 0;
        _bset[t] = 0;
        while _fqueue and _bqueue and spath + tpath <= 6:
            spath+= 1;
            for i in range(len(_fqueue)):
                node = _fqueue.popleft();
                for neighbor in node.neighbors:
                    if neighbor in _fset:
                        continue;
                    else:
                        _fset[neighbor] = spath;
                        if neighbor in _bset:
                            return spath + tpath;
                        _fqueue.append(neighbor);
            tpath+= 1;
            for i in range(len(_bqueue)):
                node = _bqueue.popleft();
                for neighbor in node.neighbors:
                    if neighbor in _bset:
                        continue;
                    else:
                        _bset[neighbor] = tpath;
                        if neighbor in _fset:
                            return spath + tpath;
                        _bqueue.append(neighbor);
        return - 1;
    # limited deepth dfs:
    def dfs(self,_list,s,t):
        # if s == t:
        #     return 0;
        visited = [];
        # print s.label
        visited.append(s);
        return self.dfs_helper(s,t,0,_list,visited);
    def dfs_helper(self, s, t, cur, _list,visited):
        if cur > 6:
            return -1;
        if s == t:
            return cur;
        for  neighbor in s.neighbors:
            if neighbor in visited:
                continue;
            visited.append(neighbor);
            temp = self.dfs_helper(neighbor,t,cur + 1,_list,visited);
            if temp != - 1:
                return temp;
            visited.remove(neighbor);
        return -1;

    # iterative deepening:
    def idfs(self,list, s, t):
        # if s == t:
        #     return 0;
        visited = [];
        visited.append(s);
        for level in range (0, 7):
            res = self.dls(s,t,level,visited);
            if res != -1:
                return res;
        return -1;

    def dls(self,s,t,level,visited):
        # print s.label, level;
        if level == 0 and s == t:
            return level;
        elif level > 0:
            for neighbor in s.neighbors:
                if neighbor in visited:
                    continue;
                visited.append(neighbor);
                temp = self.dls(neighbor,t,level - 1,visited);
                visited.remove(neighbor);
                if temp != - 1:
                    return level;
        return -1;



#test:
if __name__ == '__main__':
    solution = Six_Degree();
    a = _UndirectedNode(1);
    b = _UndirectedNode(2);
    c = _UndirectedNode(3);
    d = _UndirectedNode(4);
    e = _UndirectedNode(5);
    f = _UndirectedNode(6);
    a.neighbors.append(b);
    b.neighbors.append(a);
    a.neighbors.append(c);
    c.neighbors.append(a);
    b.neighbors.append(d);
    d.neighbors.append(b);
    d.neighbors.append(e);
    e.neighbors.append(d);
    e.neighbors.append(f);
    f.neighbors.append(e);
    _list = [a,b,c,d];
    print solution.bfs(_list,a,f);
    print solution.bi_bfs(_list,a,f);
    print solution.dfs(_list,a,f);
    print solution.idfs(_list,a,f);





