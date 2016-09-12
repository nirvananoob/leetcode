# Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

# Note:
# The array size can be very large. Solution that uses too much extra space will not pass the judge.

# Example:

# int[] nums = new int[] {1,2,3,3,3};
# Solution solution = new Solution(nums);

# // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
# solution.pick(3);

# // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
# solution.pick(1);
class Solution(object):
   
    def __init__(self, nums):
        from collections import defaultdict;
        """
        
        :type nums: List[int]
        :type numsSize: int
        """
        # self._map = defaultdict(list);
        # for i in range(len(nums)):
        #     self._map[nums[i]].append(i);
        self.num = nums;
        
        

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        # return self._map[target][random.randint(0, len(self._map[target]) - 1)];
        res = None;
        count = 0;
        for i,x in enumerate(self.num):
            if x == target:
                count += 1;
                temp = random.randint(1, count );
                if temp == count:
                    res = i;
        return res;
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)