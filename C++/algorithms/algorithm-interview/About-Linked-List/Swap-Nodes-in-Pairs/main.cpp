/**
 * Created by Thpffcj on 2017/9/21
 */

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

#include <iostream>

using namespace std;

/// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

/// LinkedList Test Helper Functions
ListNode* createLinkedList(int arr[], int n){

    if( n == 0 )
        return NULL;

    ListNode* head = new ListNode(arr[0]);
    ListNode* curNode = head;
    for( int i = 1 ; i < n ; i ++ ){
        curNode->next = new ListNode(arr[i]);
        curNode = curNode->next;
    }

    return head;
}

void printLinkedList(ListNode* head){

    if( head == NULL ){
        cout<<"NULL"<<endl;
        return;
    }

    ListNode* curNode = head;
    while( curNode != NULL ){
        cout<<curNode->val;
        if( curNode->next != NULL )
            cout<<" -> ";
        curNode = curNode->next;
    }

    cout<<endl;

    return;
}

void deleteLinkedList(ListNode* head){

    ListNode* curNode = head;
    while( curNode != NULL ){
        ListNode* delNode = curNode;
        curNode = curNode->next;
        delete delNode;
    }

    return;
}

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {

        ListNode* dummyHead = new ListNode(0);
        dummyHead->next = head;

        ListNode* p = dummyHead;
        while ( p->next && p->next->next) {
            ListNode* node1 = p->next;
            ListNode* node2 = node1->next;
            ListNode* next = node2->next;

            node2->next = node1;
            node1->next = next;
            p->next = node2;

            p = node1;
        }

        ListNode* retNode = dummyHead->next;
        delete dummyHead;

        return head;
    }
};

int main() {

    int arr[] = {1, 2, 3, 4};
    int n = sizeof(arr)/sizeof(int);

    ListNode* head = createLinkedList(arr, n);
    printLinkedList(head);

    head = Solution().swapPairs( head );
    printLinkedList(head);

    deleteLinkedList(head);

    return 0;
}