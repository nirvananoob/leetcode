# Given an array of meeting time intervals consisting of start and end times 
# [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

# For example,
# Given [[0, 30],[5, 10],[15, 20]],
# return false.
class Solution(object):
    class point(object) :
        def __init__(self,a,b):
            self.tag = a;
            self.value = b; 
    def comparator(self, a, b):
        if a.value != b.value:
            return a.value - b.value;
        return  a.tag - b.tag;
    def canAttendMeetings(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: bool
        """
        if len(intervals) == 0 or len(intervals) == 1:
            return True;
        _list = [];
        
        for i in intervals:
            _list.append(self.point(1,i.start));
            _list.append(self.point(-1,i.end));
        _list = sorted(_list,cmp = self.comparator);
        # for i in _list:
        #     print i.value,
        ts = 0;
        te = 0;
        for i in _list:
            if i.tag == 1:
                ts += 1;
            else:
                te += 1;
                if te != ts:
                    return False;
        return True;
                
            