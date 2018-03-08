/**
 * Created by Thpffcj on 2017/9/21
 */

/**
 * Reverse a singly linked list.
 */

#include <iostream>

using namespace std;


struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

// 时间复杂度: O(n)
// 空间复杂度: O(1)
class Solution {
public:
    ListNode* reverseList(ListNode* head) {

        ListNode* pre = NULL;
        ListNode* current = head;
        while ( current != NULL) {
            ListNode* next = current->next;

            current->next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }
};

int main() {

    return 0;
}
