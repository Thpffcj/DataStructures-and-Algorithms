/**
 * Created by Thpffcj on 2017/9/26
 */

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only
 * constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you
 * can rob tonight without alerting the police.
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
    vector<int> memo;

    // 考虑抢劫nums[index...nums.size())这个范围的所有房子
    int tryRob( vector<int> &nums, int index){

        if( index >= nums.size() )
            return 0;

        if( memo[index] != -1 )
            return memo[index];

        int res = 0;
        for( int i = index ; i < nums.size() ; i ++ )
            res = max(res, nums[i] + tryRob(nums, i+2));
        memo[index] = res;
        return res;
    }
public:
    int rob(vector<int>& nums) {

        memo = vector<int>(nums.size(), -1);
        return tryRob(nums, 0);
    }
};

int main() {

    return 0;
}

