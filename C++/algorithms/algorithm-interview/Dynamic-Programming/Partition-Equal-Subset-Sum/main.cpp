/**
 * Created by Thpffcj on 2017/9/27
 */

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that
 * the sum of elements in both subsets is equal.
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class Solution {
private:
    // memo[i][c] 表示使用索引为[0...i]的这些元素,是否可以完全填充一个容量为c的背包
    // -1 表示为未计算; 0 表示不可以填充; 1 表示可以填充
    vector<vector<int>> memo;

    // 使用nums[0...index], 是否可以完全填充一个容量为sum的背包
    bool tryPartition(const vector<int> &nums, int index, int sum){

        if( sum == 0 ) {
            return true;
        }

        if( sum < 0 || index < 0 ) {
            return false;

        }

        if( memo[index][sum] != -1 ) {
            return memo[index][sum] == 1;
        }

        memo[index][sum] = (tryPartition(nums, index-1 , sum ) ||
                            tryPartition(nums, index-1 , sum - nums[index] ) ) ? 1 : 0;

        return memo[index][sum] == 1;
    }
public:
    bool canPartition(vector<int>& nums) {

        int sum = 0;
        for( int i = 0 ; i < nums.size() ; i ++ ){
            assert( nums[i] > 0 );
            sum += nums[i];
        }

        if( sum%2 ) {
            return false;
        }

        memo = vector<vector<int>>(nums.size(), vector<int>(sum/2+1,-1));
        return tryPartition(nums, nums.size()-1 , sum/2 );
    }
};

int main() {

    int nums1[] = {1, 5, 11, 5};
    vector<int> vec1(nums1, nums1 + sizeof(nums1)/sizeof(int));
    if( Solution().canPartition(vec1) )
        cout<<"true"<<endl;
    else
        cout<<"false"<<endl;

    int nums2[] = {1, 2, 3, 5};
    vector<int> vec2(nums2, nums2 + sizeof(nums2)/sizeof(int));
    if( Solution().canPartition(vec2) )
        cout<<"true"<<endl;
    else
        cout<<"false"<<endl;

    return 0;
}