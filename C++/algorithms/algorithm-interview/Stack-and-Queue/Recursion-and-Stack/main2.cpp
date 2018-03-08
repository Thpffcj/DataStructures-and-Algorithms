/**
 * Created by Thpffcj on 2017/9/21
 */

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
   return [1,3,2].
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
    vector<int> inorderTraversal(TreeNode* root) {

        vector<int> res;
        __inorderTraversal( root , res );
        return res;
    }

private:
    void __inorderTraversal( TreeNode* node, vector<int> &res ){

        if( node ){
            __inorderTraversal( node->left, res );
            res.push_back( node->val );
            __inorderTraversal( node->right, res );
        }
    }
};

int main() {

    return 0;
}

