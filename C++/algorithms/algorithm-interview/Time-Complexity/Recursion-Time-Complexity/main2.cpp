//
// Created by Thpffcj on 2017/9/16.
//
#include <iostream>
#include <cassert>

using namespace std;

// f
int f(int n){

    assert( n >= 0 );

    if( n == 0 )
        return 1;

    return f(n-1) + f(n-1);
}

// mergeSort
void mergeSort(int arr[], int l, int r){

    if( l >= r )
        return;

    int mid = (l+r)/2;
    mergeSort(arr, l, mid);
    mergeSort(arr, mid+1, r);
//    将arr[l...mid]和arr[mid+1...r]两部分进行归并
//    merge(arr, l, mid, r);
}

int main() {

    cout<<f(4)<<endl;
    return 0;
}

