# A message containing letters from A-Z is being encoded to numbers using the following mapping:

# 'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
# Given an encoded message containing digits, determine the total number of ways to decode it.

# For example,
# Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

# The number of ways decoding "12" is 2.
class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0;
        dp = [0 for i in range(len(s) + 1)];
        dp[0] = 1;
        if s[0] != '0':
            dp[1] = 1;
        # dp[1] = 1;
        for i in range(2, len(s) + 1):
           if s[i - 1] != '0':
               dp[i] += dp[i - 1];
           if s[i - 2] == '1' or (s[i - 2] == '2' and s[i - 1] <= '6'):
               dp[i] += dp[i - 2];
        return dp[len(s)];
                
                
        