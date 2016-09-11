class Solution:
    def valid(self, _list):
        from collections import defaultdict;
        _set = defaultdict(int);
        for i in _list:
            _set[i] += 1;
        print _set;
        _list = [];
        for key in _set:
            if _set[key] >= 2:
                _list.append(key); 
        print _list; 
        for temp in _list :
            l = temp - 1;
            r = temp + 1;
            while l in _list:
                # _list.remove(l);
                l -= 1;
            while  r in _list:
                # _list.remove(r);
                r += 1;
            print l, temp, r
            if r - l - 1 >= 3:
                return True;
            # else:
            #     _list.remove(temp);
        return False;


#test
if __name__ == '__main__':
    solution = Solution();
    _list = [1,2,4,4,6,7,8,2,3,4,5,6,3,2,1];
    print solution.valid(_list);