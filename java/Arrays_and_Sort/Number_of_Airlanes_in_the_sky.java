package Arrays_and_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

/**
 * Given an interval list which are flying and landing time of the flight. How
 * many airplanes are on the sky at most?
 * 
 * Notice
 * 
 * If landing and flying happens at the same time, we consider landing should
 * happen at first.
 * 
 * 
 * Example For interval list
 * 
 * [ [1,10], [2,3], [5,8], [4,7] ] Return 3
 * 
 * 
 * @author kaizhang
 *
 */
public class Number_of_Airlanes_in_the_sky {
	class Pair {
		int value;
		int state;// state refers to landing or taking off

		public Pair(int v, int s) {
			this.value = v;
			this.state = s;
		}

	}

	// compartor for Pair object
	static Comparator<Pair> comp = new Comparator<Pair>() {
		public int compare(Pair p1, Pair p2) {
			if (p1.value != p2.value) {
				return p1.value - p2.value;
			}
			return p2.state - p1.state;
		}
	};

	public int countOfAirplanes(List<Interval> airplanes) {
		// write your code here
		if (airplanes == null || airplanes.size() == 0) {
			return 0;
		}
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (Interval temp : airplanes) {
			list.add(new Pair(temp.start, 0));
			list.add(new Pair(temp.end, 1));
		}
		Collections.sort(list, comp);

		int max = 0, count = 0;
		for (Pair p : list) {
			if (p.state == 1) {
				--count;
			} else {
				++count;
			}
			max = Math.max(max, count);
		}
		return max;

	}
}
