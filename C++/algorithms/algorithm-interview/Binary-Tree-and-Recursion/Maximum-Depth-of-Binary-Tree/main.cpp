/**
 * Created by Thpffcj on 2017/9/23
 */

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

#include <iostream>

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
    int maxDepth(TreeNode* root) {

        if ( root == NULL) {
            return 0;
        }

        int leftMaxDepth = maxDepth( root->left );
        int rightMaxDepth = maxDepth( root->right );
        return max( leftMaxDepth, rightMaxDepth) + 1;
    }
};

int main() {

    return 0;
}