/**
 * Created by Thpffcj on 2017/9/24
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    vector<vector<int>> res;

    // 求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素
    void generateCombinations(int n, int k, int start, vector<int> &c){

        if( c.size() == k ){
            res.push_back(c);
            return;
        }

        // 还有k - c.size()个空位, 所以,[i...n]中至少要有k-c.size()个元素
        // i最多为 n - (k-c.size()) + 1
        for( int i = start ; i <= n - (k-c.size()) + 1 ; i ++ ){
            c.push_back( i );
            generateCombinations(n, k, i + 1 , c );
            c.pop_back();
        }

        return;
    }
public:
    vector<vector<int>> combine(int n, int k) {

        res.clear();
        if( n <= 0 || k <= 0 || k > n )
            return res;

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
