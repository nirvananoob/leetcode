class Solution(object):
    def calcEquation(self, equations, values, query):
        """
        :type equations: List[List[str]]
        :type values: List[float]
        :type query: List[List[str]]
        :rtype: List[float]
        """
        from collections import *
        graph = defaultdict(dict);
        for (s,d), value in zip(equations,values):
            graph[s][d] = value;
            graph[d][s] = 1 / value;
        # for i in range (len(values)) :
        #     graph[equations[i][0]].update({equations[i][1] : values[i]});
        #     graph[equations[i][1]].update({equations[i][0] : 1 /values[i]});
        res = [];
        # print graph;
        for i in range(len(query)):
            s = query[i][0];
            t = query[i][1];
            if s not in graph or t not in graph:
                res.append(float(-1));
            else:
                nodes = set([s,t]);
                # print i;
                if self.dfs(s,t,graph,res,1.0,nodes) == False:
                    res.append(float(-1));
        return res;
    def dfs(self,s,t,graph,res,val,nodes):
        # print s,t,val;
        if (s == t):
            # print s,t;
            res.append(float(val));
            return True;
        else :
            for key, value in graph[s].items():
                if key == t:
                    res.append(float(val* value));
                    return True;
                if key in nodes: 
                    continue;
                else:
                    nodes.add(key);
                    val *= value;
                    # print val;
                    if self.dfs(key,t,graph,res,val,nodes) == True:
                        return True;
                    else:
                        nodes.remove(key);
                        val /= value;
        return False;