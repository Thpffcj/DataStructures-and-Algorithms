/**
 * Created by Thpffcj on 2017/9/22
 */

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

#include <iostream>
#include <vector>
#include <queue>
#include <cassert>

using namespace std;

/// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {

        vector<vector<int>> res;
        if ( root == NULL) {
            return res;
        }

        queue< pair<TreeNode*, int> > q;
        q.push( make_pair( root, 0 ) );
        while( !q.empty() ) {

            TreeNode* node = q.front().first;
            int level = q.front().second;
            q.pop();

            if ( level == res.size() ) {
                res.push_back( vector<int>() );
            }

            res[level].push_back( node->val );

            if( node->left ) {
                q.push( make_pair( node->left, level+1 ) );
            }
            if( node->right ) {
                q.push( make_pair( node->right, level+1 ) );
            }
        }

        return res;
    }
};

int main() {

    return 0;
}
