/**
 * Created by Thpffcj on 2017/9/18
 */

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which
 * the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,the subarray [4,3] has the minimal length under the problem constraint.
 */

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

// 暴力解法
// 时间复杂度: O(n^3)
// 空间复杂度: O(1)
class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {

        int res = nums.size() + 1;
        for( int l = 0 ; l < nums.size() ; l ++ ) {
            for (int r = l; r < nums.size(); r++) {
                int sum = 0;
                for (int i = l; i <= r; i++) {
                    sum += nums[i];
                }
                if (sum >= s) {
                    res = min(res, r - l + 1);
                }
            }
        }

        if( res == nums.size() + 1 )
            return 0;

        return res;
    }
};

int main() {

    int nums[] = {2, 3, 1, 2, 4, 3};
    vector<int> vec( nums, nums + sizeof(nums)/sizeof(int) );
    int s = 7;

    cout<<Solution().minSubArrayLen(s, vec)<<endl;

    return 0;
}
