/**
 * Created by Thpffcj on 2017/9/22
 */

#include <iostream>
#include <vector>
#include <queue>
#include <stdexcept>

using namespace std;

// 优化
class Solution {
public:
    int numSquares(int n) {

        if( n == 0 )
            return 0;

        queue< pair<int,int> > q;
        q.push( make_pair( n , 0 ) );

        vector<bool> visited(n+1, false);
        visited[n] = true;

        while( !q.empty() ){
            int num = q.front().first;
            int step = q.front().second;
            q.pop();

            for( int i = 1 ; ; i ++ ){
                int a = num - i*i;
                if( a < 0 )
                    break;

                if( !visited[a] ){
                    if( a == 0 )
                        return step + 1;
                    q.push( make_pair( a , step + 1 ) );
                    visited[a] = true;
                }
            }
        }

        throw invalid_argument("No Solution.");
    }
};

int main() {

    cout<<Solution().numSquares(12)<<endl;
    cout<<Solution().numSquares(13)<<endl;

    return 0;
}

