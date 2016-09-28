class Solution:
    def valid(self, _list):
        from collections import defaultdict;
        _map = defaultdict(int);
        for i in _list:
            _map[i] += 1;
        # print _map;
        _set = _map.keys();
        print type(_set);
        for key in _set:
            if _map[key] < 2:
                _set.remove(key);
        # print type(_set),_set;
        for k in _set :
            l = k - 1;
            r = k + 1;
            while l in _set:
                _set.remove(l);
                l -= 1;
            while  r in _set:
                _set.remove(r);
                r += 1;
            
            if r - l - 1 >= 3:
                return True;
            # else:
            #     _list.remove(temp);
        return False;
[219,130,167,113,225,151,149,32]

#test
if __name__ == '__main__':
    solution = Solution();
    _list = [1,2,4,4,6,7,8,2,3,4,5,6,3,2,1];
    print solution.valid(_list);