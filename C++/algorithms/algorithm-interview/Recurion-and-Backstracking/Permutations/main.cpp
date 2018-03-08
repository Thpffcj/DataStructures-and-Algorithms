/**
 * Created by Thpffcj on 2017/9/24
 */

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

#include <iostream>
#include <vector>
using namespace std;

class Solution {
private:
    vector<vector<int>> res;
    vector<bool> used;

    // p中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    void generatePermutation( const vector<int>& nums, int index, vector<int>& p){

        if ( index == nums.size() ) {
            res.push_back(p);
            cout<<"------------"<<endl;
            return;
        }

        for ( int i = 0; i < nums.size(); i++ ) {
            if ( !used[i] ) {
                p.push_back( nums[i] );
                used[i] = true;
                cout<<"begin"<<endl;
                printVector(p);
                generatePermutation(nums, index+1, p);
                cout<<"end"<<endl;
                printVector(p);
                // 状态回溯
                p.pop_back();
                used[i] = false;
            }
        }

        cout<<"***********"<<endl;
        return;
    }

    void printVector(const vector<int> &nums) {
        cout<<"print ";
        for( int i = 0 ; i < nums.size() ; i ++ ){
            cout<<nums[i]<<" ";
        }
        cout<<endl;
    }

public:
    vector<vector<int>> permute(vector<int>& nums) {

        res.clear();
        if ( nums.size() ==0 ) {
            return res;
        }

        used = vector<bool>(nums.size(), false);
        vector<int> p;
        generatePermutation( nums, 0, p);

        return res;
    }
};

int main() {

    int nums[] = {1, 2, 3};
    vector<int> vec(nums, nums + sizeof(nums)/sizeof(int) );

    vector< vector<int> > res = Solution().permute(vec);
    for( int i = 0 ; i < res.size() ; i ++ ){

        for( int j = 0 ; j < res[i].size() ; j ++ )
            cout<<res[i][j]<<" ";
        cout<<endl;
    }

    return 0;
}
