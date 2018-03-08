/**
 * Created by Thpffcj on 2017/9/21
 */

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
   return [1,2,3].
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
    vector<int> preorderTraversal(TreeNode* root) {

        vector<int> res;
        __preorderTraversal( root , res );
        return res;
    }

private:
    void __preorderTraversal( TreeNode* node, vector<int> &res ){

        if( node ){
            res.push_back( node->val );
            __preorderTraversal( node->left, res );
            __preorderTraversal( node->right, res );
        }
    }
};

int main() {

    return 0;
}