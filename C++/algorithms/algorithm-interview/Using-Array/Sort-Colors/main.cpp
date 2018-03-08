//
// Created by Thpffcj on 2017/9/17.
//

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the
 * colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class Solution {
public:
    // 时间复杂度: O(n)
    // 空间复杂度: O(k), k为元素的取值范围
    // 对整个数组遍历了两遍
    void sortColors(vector<int>& nums) {

        int count[3] = {0}; // 存放0,1,2三个元素的频率
        for ( int i = 0; i < nums.size(); i++ ) {
            assert( nums[i] >= 0 && nums[i] <= 2 );
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i++ ) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++ ) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++ ) {
            nums[index++] = 2;
        }
    }
};

int main() {

    int nums[] = {2, 2, 2, 1, 1, 0};
    vector<int> vec = vector<int>( nums , nums + sizeof(nums)/sizeof(int));

    Solution().sortColors( vec );
    for( int i = 0 ; i < vec.size() ; i ++ ) {
        cout<<vec[i]<<" ";
    }
    cout<<endl;

    return 0;
}
