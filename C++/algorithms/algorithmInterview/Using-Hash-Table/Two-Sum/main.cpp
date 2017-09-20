/**
 * Created by Thpffcj on 2017/9/20
 */

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

#include <iostream>
#include <vector>
#include <cassert>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {

        unordered_map<int, int> record;
        for ( int i = 0; i < nums.size(); i++) {

            int complement = target - nums[i];
            if ( record.find( complement ) != record.end() ) {
                int res[2] = {i, record[complement]};
                return vector<int>(res, res+2);
            }

            record[nums[i]] = i;
        }

        throw invalid_argument("the input has no solution");
    }
};

int main() {

    const int nums[] = {0,4,3,0};
    vector<int> nums_vec( nums, nums + sizeof(nums)/sizeof(int) );
    int target = 0;

    vector<int> res = Solution().twoSum(nums_vec, target);
    cout<<res[0]<<" , "<<res[1]<<endl;

    return 0;
}

