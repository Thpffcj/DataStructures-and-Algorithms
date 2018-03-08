/**
 * Created by Thpffcj on 2017/9/26
 */

#include <iostream>
#include <vector>

using namespace std;

// 改变状态定义
class Solution {

public:
    int rob(vector<int>& nums) {

        int n = nums.size();
        if( n == 0 ) {
            return 0;
        }

        // memo[i] 表示考虑抢劫 nums[0...i] 所能获得的最大收益
        vector<int> memo(n, 0);
        memo[0] = nums[0];
        for( int i = 1 ; i < n ; i ++ )
            for (int j = i; j >= 0; j--)
                memo[i] = max(memo[i], nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0) );

        return memo[n-1];
    }
};

int main() {

    int nums[] = {2,1};
    vector<int> vec(nums, nums+sizeof(nums)/sizeof(int));

    cout<<Solution().rob(vec)<<endl;

    return 0;
}