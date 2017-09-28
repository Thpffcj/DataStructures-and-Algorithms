/**
 * Created by Thpffcj on 2017/9/26
 */

/**
 * 有一个容量为5的背包
 *  id       0   1   2
 *  weight   1   2   3
 *  value    6   10  12
 *
 *      0   1   2   3   4   5
 *  0   0   6   6   6   6   6
 *  1   0   6   10  16  16  16
 *  2   0   6   10  16  18  22
 */

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class Knapsack01{

public:
    // 用 [0...index]的物品,填充容积为c的背包的最大价值
    int knapsack01(const vector<int> &w, const vector<int> &v, int C){

        assert( w.size() == v.size() && C >= 0 );

        if ( n == 0) {
            return 0;
        }

        int n = w.size();
        vector<vector<int>> memo( n, vector<int>(C+1,0));

        for ( int j = 0; j <= C; j++ ) {
            memo[0][j] = ( j >= w[0] ? v[0] : 0 );
        }

        for ( int i = 1; i < n; i++ ) {
            for ( int j = 0; j <= C; j++ ) {
                // 0~i这些物品容积为j的背包获得的最大值
                memo[i][j] = memo[i-1][j];
                if( j >= w[i] ) {
                    memo[i][j] = max( memo[i][j], v[i] + memo[i-1][j-w[i]]);
                }
            }
        }

        return memo[n-1][C];
    }
};

int main() {

    int n, W;
    cin>>n>>W;

    int v,w;
    vector<int> vs, ws;
    for( int i = 0 ; i < n ; i ++ ){
        cin>>w>>v;
        vs.push_back(v);
        ws.push_back(w);
    }

    cout<<Knapsack01().knapsack01(ws,vs,W)<<endl;
    return 0;
}
