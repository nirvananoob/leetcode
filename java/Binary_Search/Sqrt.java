package Binary_Search;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author kaizhang
 *
 */
public class Sqrt {
	public int mySqrt(int x) {
		if (x < 0) {
			return -1;
		}
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		long l = 0, r = (long) x;
		long mid;
		while (l + 1 < r) {
			mid = (l + 1);
			if (mid * mid == (long) x) {
				return (int) mid;
			} else if (mid * mid > (long) x) {
				r = mid;
			} else {
				l = mid;
			}
		}
		if (r * r <= (long) x) {
			return (int) r;
		}
		return (int) l;
	}
}
