//
// Created by Thpffcj on 2017/9/16.
//
#include <iostream>
#include <cmath>
#include <ctime>
#include "MyUtil.h"
#include "MyAlgorithmTester.h"

using namespace std;

int main() {

    // 数据规模倍乘测试binarySearch
    // O(logn)
    cout<<"Test for binarySearch:"<<endl;
    for( int i = 10 ; i <= 28 ; i ++ ){

        int n = pow(2,i);
        int *arr = MyUtil::generateOrderedArray(n);

        clock_t startTime = clock();
        MyAlgorithmTester::binarySearch(arr,n,0);
        clock_t endTime = clock();

        cout<<"data size 2^"<<i<<" = "<<n<<"\t";
        cout<<"Time cost: "<<double(endTime - startTime)/CLOCKS_PER_SEC<<endl;

        delete[] arr;
    }

    return 0;
}
