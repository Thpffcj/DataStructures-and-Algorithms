/**
 * Created by Thpffcj on 2017/9/25
 */

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

#include <iostream>
#include <vector>

using namespace std;

// 动态规划
class Solution {

public:
    int climbStairs(int n) {

        vector<int> memo(n+1, -1);
        memo[0] = 1;
        memo[1] = 1;

        for ( int i = 2; i <= n; i++ ) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }
};

int main() {

    cout<<Solution().climbStairs(10)<<endl;
    return 0;
}

