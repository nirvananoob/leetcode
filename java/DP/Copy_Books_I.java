package DP;

/**
 * Given an array A of integer with size of n( means n books and number of pages
 * of each book) and k people to copy the book. You must distribute the
 * continuous id books to one people to copy. (You can give book A[1],A[2] to
 * one people, but you cannot give book A[1], A[3] to one people, because book
 * A[1] and A[3] is not continuous.) Each person have can copy one page per
 * minute. Return the number of smallest minutes need to copy all the books.
 * 
 * Example Given array A = [3,2,4], k = 2.
 * 
 * Return 5( First person spends 5 minutes to copy book 1 and book 2 and second
 * person spends 4 minutes to copy book 3. )
 * 
 * Challenge Could you do this in O(n*k) time ?
 * 
 * @author kaizhang
 *
 */
public class Copy_Books_I {
	/**
	 * method 1: complexity: O(n ^2 * k) DP equations res[i][j] =
	 * Math.min(Math.max(res[i - 1][t], sum(t, j)) for i - 1 <= t <= j
	 * 
	 * @param pages
	 * @param k
	 * @return
	 */
	public int copyBooks(int[] pages, int k) {
		// write your code here
		if (pages == null || pages.length == 0 || k == 0) {
			return 0;
		}
		k = Math.min(k, pages.length);
		int[][] arr = new int[pages.length + 1][k + 1];

		for (int i = 1; i <= k; i++) {
			arr[1][1] = pages[0];
		}
		for (int i = 2; i <= pages.length; i++) {
			arr[i][1] = arr[i - 1][1] + pages[i - 1];
		}

		for (int i = 2; i <= pages.length; i++) {
			for (int j = 2; j <= k; j++) {
				arr[i][j] = arr[i][j - 1];
				if (i < j) {
					continue;
				}
				int last = pages[i - 1];
				int m = i - 1;
				while (m >= j - 1) {

					if (Math.max(arr[m][j - 1], last) > arr[i][j]) {
						break;
					}
					arr[i][j] = Math.max(arr[m][j - 1], last);
					m--;
					last += pages[m];
				}
			}
		}
		return arr[pages.length][k];

	}

	/**
	 * method 2: Complexity: O(n * k):
	 * 
	 * @param pages
	 * @param k
	 * @return
	 */
	public int copyBooks_better(int[] pages, int k) {
		if (pages == null || pages.length == 0 || k == 0) {
			return 0;
		}
		k = Math.min(k, pages.length);
		int[][] arr = new int[k + 1][pages.length + 1];
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= pages.length; j++) {
				arr[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 1; i <= k; i++) {
			arr[i][1] = pages[0];
		}
		for (int i = 2; i <= pages.length; i++) {
			arr[1][i] = arr[1][i - 1] + pages[i - 1];
		}
		for (int i = 2; i <= k; i++) {
			int left = 1, right = 2;
			int sum = pages[right - 1];
			while (true) {

				arr[i][right] = Math.min(arr[i][right],
						Math.max(sum, arr[i - 1][left]));

				if (left < right && arr[i - 1][left] < sum) {
					left++;
					sum -= pages[left - 1];
				} else {
					if (left > 1) {
						sum += pages[left - 1];
						left--;
					}
					right++;
					if (right > pages.length) {
						break;
					}
					sum += pages[right - 1];
				}
			}
		}
		return arr[k][pages.length];
	}

	public static void main(String[] args) {
		Copy_Books_I test = new Copy_Books_I();
		int[] arr = new int[] { 3, 2, 4 };
		int k = 2;
		System.out.println(test.copyBooks(arr, k));
		System.out.println(test.copyBooks_better(arr, k));
	}
}
