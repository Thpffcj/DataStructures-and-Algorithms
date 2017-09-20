/**
 * Created by Thpffcj on 2017/9/20
 */

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the
 * distance between i and j equals the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range
 * [-10000, 10000] (inclusive).
 *
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */

#include <iostream>
#include <vector>
#include <unordered_map>
#include <cassert>
#include <stdexcept>

using namespace std;

class Solution {
public:
    int numberOfBoomerangs(vector<pair<int, int>>& points) {

        int res = 0;
        for ( int i = 0; i < points.size(); i++ ) {

            // record中存储 点i 到所有其他点的距离出现的频次
            unordered_map<int, int> record;
            for ( int j = 0; j < points.size(); j++ ) {
                if ( j != i) {
                    record[ dis(points[i], points[j] ) ]++;
                }
            }

            for( unordered_map<int, int>::iterator iter = record.begin() ; iter != record.end() ; iter ++ ) {
                res += (iter->second)*(iter->second-1);
            }
        }
        return res;
    }

private:
    int dis( const pair<int,int> &pa, const pair<int,int> &pb){
        return (pa.first - pb.first) * (pa.first - pb.first) +
               (pa.second - pb.second) * (pa.second - pb.second);
    }

};

int main() {

    vector<pair<int,int>> vec;
    vec.push_back( make_pair(0, 0) );
    vec.push_back( make_pair(1, 0) );
    vec.push_back( make_pair(2, 0) );

    cout<<Solution().numberOfBoomerangs( vec )<<endl;

    return 0;
}
