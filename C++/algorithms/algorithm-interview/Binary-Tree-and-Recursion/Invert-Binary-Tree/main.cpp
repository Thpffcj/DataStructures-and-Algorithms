/**
 * Created by Thpffcj on 2017/9/23
 */

/**
 *Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
    TreeNode* invertTree(TreeNode* root) {

        if ( root == NULL ) {
            return NULL;
        }

        invertTree( root->left );
        invertTree( root->right );
        swap ( root->left, root->right );

        return root;
    }
};

int main() {

    return 0;
}