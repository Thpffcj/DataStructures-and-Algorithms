/**
 * Created by Thpffcj on 2017/9/20
 */

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] +
 * C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of
 * -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * Example:
 *
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

#include <iostream>
#include <vector>
#include <unordered_map>
#include <cassert>

using namespace std;

class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {

        assert( A.size() == B.size() && B.size() == C.size() && C.size() == D.size() );

        unordered_map<int ,int> record;
        for ( int i = 0; i < C.size(); i++ ) {
            for ( int j = 0; j < D.size(); j++ ) {
                record[ C[i] + D[j] ]++;
            }
        }

        int res = 0;
        for ( int i = 0; i < A.size(); i++) {
            for ( int j = 0; j < B.size(); j++ ) {
                if ( record.find( 0 -A[i] - B[j] ) != record.end() ) {
                    res += record[0 -A[i] - B[j]];
                }
            }
        }

        return res;
    }
};

int main() {

    int a[] = {1, 2};
    int b[] = {-2, -1};
    int c[] = {-1, 2};
    int d[] = {0, 2};
    vector<int> a_vec = vector<int>( a , a + sizeof(a)/sizeof(int));
    vector<int> b_vec = vector<int>( b , b + sizeof(b)/sizeof(int));
    vector<int> c_vec = vector<int>( c , c + sizeof(c)/sizeof(int));
    vector<int> d_vec = vector<int>( d , d + sizeof(d)/sizeof(int));

    cout<<Solution().fourSumCount( a_vec, b_vec, c_vec, d_vec )<<endl;

    return 0;
}

