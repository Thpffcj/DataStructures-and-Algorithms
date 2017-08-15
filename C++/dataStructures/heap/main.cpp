//
// Created by Thpffcj on 2017/8/15.
//

#include <iostream>
#include <algorithm>
#include <string>
#include <ctime>
#include <cmath>
#include <cassert>
#include "Heap.h"
#include "HeapSort.h"
#include "SortTestHelper.h"

using namespace std;

template<typename T>
void __shiftDown(T arr[], int n, int k){

    while( 2*k+1 < n ){
        int j = 2*k+1;
        if( j+1 < n && arr[j+1] > arr[j] )
            j += 1;

        if( arr[k] >= arr[j] )break;

        swap( arr[k] , arr[j] );
        k = j;
    }
}

template<typename T>
void __shiftDown2(T arr[], int n, int k){

    T e = arr[k];
    while( 2*k+1 < n ){
        int j = 2*k+1;
        if( j+1 < n && arr[j+1] > arr[j] )
            j += 1;

        if( e >= arr[j] ) break;


        arr[k] = arr[j];
        k = j;
    }

    arr[k] = e;
}

template<typename T>
void heapSort(T arr[], int n){

    for( int i = (n-1)/2 ; i >= 0 ; i -- )
        __shiftDown2(arr, n, i);

    for( int i = n-1; i > 0 ; i-- ){
        swap( arr[0] , arr[i] );
        __shiftDown2(arr, i, 0);
    }
}

int main() {

    int n = 1000000;

    // 测试1 一般性测试
    cout<<"Test for Random Array, size = "<<n<<", random range [0, "<<n<<"]"<<endl;
    int* arr1 = SortTestHelper::generateRandomArray(n,0,n);
    int* arr2 = SortTestHelper::copyIntArray(arr1, n);
    int* arr3 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Heap Sort 1", heapSort1, arr1, n);
    SortTestHelper::testSort("Heap Sort 2", heapSort2, arr2, n);
    SortTestHelper::testSort("Heap Sort 3", heapSort, arr3, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;

    cout<<endl;


    // 测试2 测试近乎有序的数组
    int swapTimes = 100;
    cout<<"Test for Random Nearly Ordered Array, size = "<<n<<", swap time = "<<swapTimes<<endl;
    arr1 = SortTestHelper::generateRandomArray(n,0,n);
    arr2 = SortTestHelper::copyIntArray(arr1, n);
    arr3 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Heap Sort 1", heapSort1, arr1, n);
    SortTestHelper::testSort("Heap Sort 2", heapSort2, arr2, n);
    SortTestHelper::testSort("Heap Sort 3", heapSort, arr3, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;

    cout<<endl;


    // 测试3 测试存在包含大量相同元素的数组
    cout<<"Test for Random Array, size = "<<n<<", random range [0,10]"<<endl;
    arr1 = SortTestHelper::generateRandomArray(n,0,n);
    arr2 = SortTestHelper::copyIntArray(arr1, n);
    arr3 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Heap Sort 1", heapSort1, arr1, n);
    SortTestHelper::testSort("Heap Sort 2", heapSort2, arr2, n);
    SortTestHelper::testSort("Heap Sort 3", heapSort, arr3, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;

    return 0;
}