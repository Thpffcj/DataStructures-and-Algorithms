/**
 * Created by Thpffcj on 2017/9/28
 */

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals
 * non-overlapping.
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 *
 * Example 1:
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 *
 * Example 2:
 * Input: [ [1,2], [1,2], [1,2] ]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 *
 * Example 3:
 * Input: [ [1,2], [2,3] ]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */

#include <iostream>
#include <vector>
#include <c++/algorithm>

using namespace std;


/// Definition for an interval.
struct Interval {
    int start;
    int end;
    Interval() : start(0), end(0) {}
    Interval(int s, int e) : start(s), end(e) {}
};

bool compare(const Interval &a, const Interval &b){

    if( a.start != b.start )
        return a.start < b.start;
    return a.end < b.end;
}

// 动态规划
class Solution {
public:
    int eraseOverlapIntervals(vector<Interval>& intervals) {

        if( intervals.size() == 0 ) {
            return 0;
        }

        sort(intervals.begin(), intervals.end(), compare);

        // memo[i]表示以intervals[i]为结尾的区间能构成的最长不重叠区间序列
        vector<int> memo( intervals.size() , 1 );
        for( int i = 1 ; i < intervals.size() ; i ++ ) {
            // memo[i]
            for( int j = 0 ; j < i ; j ++ ) {
                if( intervals[i].start >= intervals[j].end ) {
                    memo[i] = max( memo[i] , 1 + memo[j] );
                }
            }
        }

        int res = 0;
        for( int i = 0 ; i < memo.size() ; i ++ ) {
            res = max( res , memo[i] );
        }

        return intervals.size() - res;
    }
};

int main() {

    Interval interval1[] = {Interval(1,2), Interval(2,3), Interval(3,4), Interval(1,3)};
    vector<Interval> v1( interval1, interval1 + sizeof(interval1)/sizeof(Interval));
    cout<<Solution().eraseOverlapIntervals(v1)<<endl;

    Interval interval2[] = {Interval(1,2), Interval(1,2), Interval(1,2)};
    vector<Interval> v2( interval2, interval2 + sizeof(interval2)/sizeof(Interval));
    cout<<Solution().eraseOverlapIntervals(v2)<<endl;

    Interval interval3[] = {Interval(1,2), Interval(2,3)};
    vector<Interval> v3( interval3, interval3 + sizeof(interval3)/sizeof(Interval));
    cout<<Solution().eraseOverlapIntervals(v3)<<endl;

    return 0;
}