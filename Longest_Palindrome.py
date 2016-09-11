# Time:  O(n)
# Space: O(n)
#
# Given a string S, find the longest palindromic substring in S.
# You may assume that the maximum length of S is 1000,
#  and there exists one unique longest palindromic substring.
#

# Manacher's Algorithm
# http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if s is None  or len(s) <= 1:
            return s;
        res = "";
        for i in range(0, len(s)) :
            left = i - 1;
            right = i + 1;
            while (left >= 0) and (right < len(s)) and (s[left] == s[right]):
                left -= 1
                right += 1
            else :
                if right - left - 1 >= len(res) :
                    res = s[left + 1 : right ];
                left = i;
                right = i + 1;
            while left >= 0 and right < len(s) and s[left] == s[right]:
                print left,right
                left -= 1
                right += 1           
            if right - left - 1 >= len(res):
                res = s[left + 1 : right];
        return res;
if __name__ == "__main__":
    print Solution().longestPalindrome("bb")
        