//
// Created by Thpffcj on 2017/7/29.
//
#include "LinkQueue.h"
#include<string>
#include<iostream>
using namespace std;

int main()
{
    LinkQueue<string> lqueue;
    lqueue.push("one");
    lqueue.push("two");
    lqueue.push("three");
    lqueue.push("four");
    lqueue.push("five");
    cout << "���д�С��" << lqueue.size() << endl;
    while (!lqueue.isEmpty())
    {
        cout << lqueue.front() << endl;
        lqueue.pop();
    }
    getchar();
    return 0;
}

