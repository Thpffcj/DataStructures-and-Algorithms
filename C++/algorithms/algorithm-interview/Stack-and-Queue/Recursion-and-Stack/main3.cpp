/**
 * Created by Thpffcj on 2017/9/21
 */

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
   return [3,2,1].
 */

#include <iostream>
#include <vector>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {

        vector<int> res;
        __postorderTraversal( root , res );
        return res;
    }

private:
    void __postorderTraversal( TreeNode* node, vector<int> &res ){

        if( node ){
            __postorderTraversal( node->left, res );
            __postorderTraversal( node->right, res );
            res.push_back( node->val );
        }
    }
};

int main() {

    return 0;
}
