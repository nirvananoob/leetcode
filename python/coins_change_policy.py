# give co
import sys
class Solution(object):

    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        
        dp = [sys.maxint for x in range(amount + 1) ];
        dp[0] = 0;
        
        for i in range(len(coins)):
            for j in range (coins[i], amount + 1):
                dp[j] = min(dp[j - coins[i]] + 1, dp[j]);
            # print dp;
        if dp[amount] != sys.maxint:
           return sum(dp);
        return sys.maxint;
        
    def combinations (self, number, k) :
        import sys;
        _res = [];
        _list = [];
        _list.append(1);
        # visited = [False for x in range(number)];
        self.dfs(_res, _list,2, number, k );
        # global mininum ;
        minimum = sys.maxint;
        final_list = [];
        print _res;
        for i in _res:
            next = self.coinChange(i,number);
            if minimum >= next:
                final_list = i;
                minimum = next;
        print final_list;
        return minimum;
    def dfs(self,_res, _list,start, end, count) :
        if len(_list) == count:
            _res.append(list(_list));
            return;
        for i in range (start, end + 1):
            _list.append(i);
            # print _list;
            self.dfs(_res, _list, i + 1, end, count);
            _list.pop(-1);
            # print _list;
        return;

if __name__ == '__main__':
    # k = 3;
    # number = 5;
    solution = Solution();
    print solution.combinations(20,3);


