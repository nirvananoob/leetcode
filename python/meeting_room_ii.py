# Given an array of meeting time intervals consisting of start and end times
#  [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

# For example,
# Given [[0, 30],[5, 10],[15, 20]],
# return 2.
class Solution(object):
    
    class point(object) :
        def __init__(self,a,b):
            self.tag = a;
            self.value = b; 
    def comparator(self, a, b):
        if a.value != b.value:
            return a.value - b.value;
        return  a.tag - b.tag;
    def minMeetingRooms(self, intervals):
        
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if intervals is None or len(intervals) == 0:
            return 0;
        _list = [];
        for i in intervals:
            _list.append(self.point(1,i.start));
            _list.append(self.point(-1,i.end));
        _list = sorted(_list,cmp = self.comparator);
        res = 0;
        count = 0;
        for i in _list:
           if i.tag == 1:
               count += 1;
           else :
               count -= 1;
           res = max(res,count);
       
        return res;