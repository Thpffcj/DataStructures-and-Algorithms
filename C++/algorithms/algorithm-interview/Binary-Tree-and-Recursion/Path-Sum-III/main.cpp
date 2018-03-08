/**
 * Created by Thpffcj on 2017/9/23
 */

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes
 * to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
Return 3. The paths that sum to 8 are:
1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
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
    // 在以root为根节点的二叉树中,寻找和为sum的路径,返回这样的路径个数
    int pathSum(TreeNode* root, int sum) {

        if ( root == NULL) {
            return 0;
        }

        int res = findPath( root, sum );
        res += pathSum( root->left,  sum );
        res += pathSum( root->right, sum );

        return res;
    }

private:

    // 在以node为根节点的二叉树中,寻找包含node的路径,和为sum
    // 返回这样的路径个数
    int findPath( TreeNode* node, int num){

        if ( node == NULL ) {
            return 0;
        }

        int res = 0;
        if ( node->val == num ) {
            res += 1;
        }

        res += findPath( node->left, num - node->val );
        res += findPath( node->right, num - node->val );

        return res;
    }
};

int main() {

    TreeNode* node1 = new TreeNode(3);
    TreeNode* node2 = new TreeNode(-2);

    TreeNode* node3 = new TreeNode(3);
    node3->left = node1;
    node3->right = node2;

    TreeNode* node4 = new TreeNode(1);
    TreeNode* node5 = new TreeNode(2);
    node5->right = node4;

    TreeNode* node6 = new TreeNode(5);
    node6->left = node3;
    node6->right = node5;

    TreeNode* node7 = new TreeNode(11);
    TreeNode* node8 = new TreeNode(-3);
    node8->right = node7;

    TreeNode* node9 = new TreeNode(10);
    node9->left = node6;
    node9->right = node8;

    cout<<Solution().pathSum( node9, 8)<<endl;

    return 0;
}
