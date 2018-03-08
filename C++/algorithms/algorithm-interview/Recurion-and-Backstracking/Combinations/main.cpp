/**
 * Created by Thpffcj on 2017/9/24
 */

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    vector<vector<int>> res;

    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    void generateCombinations(int n, int k, int start, vector<int> &c){

        if ( c.size() == k ) {
            res.push_back(c);
            return;
        }

        for ( int i = start; i <= n; i++ ) {
            c.push_back(i);
            generateCombinations(n, k, i + 1, c);
            // 回溯状态
            c.pop_back();
        }

        return;
    }
public:
    vector<vector<int>> combine(int n, int k) {

        res.clear();
        if ( n <= 0 || k <= 0 || k > n) {
            return res;
        }

        vector<int> c;
        generateCombinations(n, k, 1, c);

        return res;
    }
};

int main() {

    vector<vector<int>> res = Solution().combine(4,2);
    for( int i = 0 ; i < res.size() ; i ++ ){
        for( int j = 0 ; j < res[i].size() ; j ++ )
            cout<<res[i][j]<<" ";
        cout<<endl;
    }
    return 0;
}