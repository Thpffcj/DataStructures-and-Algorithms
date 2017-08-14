//
// Created by Thpffcj on 2017/8/10.
//
#include <iostream>
#include "SortTestHelper.h"
#include "SelectionSort.h"
#include "InsertionSort.h"
#include "BubbleSort.h"
#include "ShellSort.h"

using namespace std;

int main() {

    int n = 10000;

    // Test for Random Array
    cout<<"Test for Random Array, size = "<<n<<", random range [0, "<<n<<"]"<<endl;

    int *arr1 = SortTestHelper::generateRandomArray(n,0,n);
    int *arr2 = SortTestHelper::copyIntArray(arr1, n);
    int *arr3 = SortTestHelper::copyIntArray(arr1, n);
    int *arr4 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Selection Sort", selectionSort, arr1, n);
    SortTestHelper::testSort("Insertion Sort", insertionSort, arr2, n);
    SortTestHelper::testSort("Bubble Sort", bubbleSort, arr3, n);
    SortTestHelper::testSort("Shell Sort", shellSort, arr4, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;

    cout<<endl;

    // Test for Random Nearly Ordered Array
    int swapTimes = 100;

    cout<<"Test for Random Nearly Ordered Array, size = "<<n<<", swap time = "<<swapTimes<<endl;

    arr1 = SortTestHelper::generateNearlyOrderedArray(n, swapTimes);
    arr2 = SortTestHelper::copyIntArray(arr1, n);
    arr3 = SortTestHelper::copyIntArray(arr1, n);
    arr4 = SortTestHelper::copyIntArray(arr1, n);

    SortTestHelper::testSort("Selection Sort", selectionSort, arr1, n);
    SortTestHelper::testSort("Insertion Sort", insertionSort, arr2, n);
    SortTestHelper::testSort("Bubble Sort", bubbleSort, arr3, n);
    SortTestHelper::testSort("Shell Sort", shellSort, arr4, n);

    delete[] arr1;
    delete[] arr2;
    delete[] arr3;
    delete[] arr4;

    return 0;
}
