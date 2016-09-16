package Arrays_and_Sort;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy.
 * 
 * Children with a higher rating get more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * Example Given ratings = [1, 2], return 3.
 * 
 * Given ratings = [1, 1, 1], return 3.
 * 
 * Given ratings = [1, 2, 2], return 4. ([1,2,1]).
 * 
 * Tags Greedy Array
 * 
 * @author kaizhang
 *
 */
public class Candy {
	public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        left[0] = 1;
        right[ratings.length - 1] = 1;
        for(int i = 1; i < ratings.length; i++) {
           left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
        }
        for(int i = ratings.length - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
        }
        int sum = 0;
        for(int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i] , right[i]);
        }
        return sum;
    }
}
