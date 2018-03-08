/**
 * Created by Thpffcj on 2017/9/22
 */

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// Memory Limit Exceed
class Solution {
public:
    int numSquares(int n) {

        queue< pair<int, int> > q;
        q.push( make_pair( n, 0 ) );

        while ( !q.empty() ) {
            int num = q.front().first;
            int step = q.front().second;
            q.pop();

            if ( num == 0 ) {
                return step;
            } else {
                for ( int i = 1; num - i*i >= 0; i++ ) {
                    q.push( make_pair( num - i*i, step + 1) );
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
