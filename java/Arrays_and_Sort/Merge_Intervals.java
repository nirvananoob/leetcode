package Arrays_and_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {
	/**
	Given a collection of intervals, merge all overlapping intervals.

	Have you met this question in a real interview? Yes
	Example
	Given intervals => merged intervals:

	[                     [
	  [1, 3],               [1, 6],
	  [2, 6],      =>       [8, 10],
	  [8, 10],              [15, 18]
	  [15, 18]            ]
	]
	*/
	/**
	 * Definition of Interval:
	 * public class Interval {
	 *     int start, end;
	 *     Interval(int start, int end) {
	 *         this.start = start;
	 *         this.end = end;
	 *     }
	 */
	class Interval{
		int start, end;
		Interval(int s, int e)
		{
			this.start = s;
			this.end = e;
		}	
	}
	public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        Comparator<Interval> comp = new Comparator<Interval> () {
            public int compare (Interval t1 , Interval t2) {
                if (t1.start != t2.start) {
                    return t1.start - t2.start;
                }else{
                    return t1.end - t2.end;
                }
            }
        };
        List<Interval> list = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            return list;
        }
        Collections.sort(intervals,comp);
        int index = 0 ; int next,nextstart, nextend;
        int len = intervals.size();
        while(index  < len) {
            nextstart = intervals.get(index).start;
            nextend = intervals.get(index).end;
            next = index + 1;
            while(next < len && intervals.get(next).start <= nextend){
                   nextend = Math.max(nextend,intervals.get(next).end);
                next ++;
             
            }
            list.add(new Interval(nextstart, nextend));
            index = next;
        }
        return list;
    }


}
