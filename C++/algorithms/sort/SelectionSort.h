//
// Created by Thpffcj on 2017/8/14.
//

#ifndef DATASTRUCTURESANDALGORITHMS_SELECTIONSORT_H
#define DATASTRUCTURESANDALGORITHMS_SELECTIONSORT_H

#include <iostream>
#include <algorithm>

using namespace std;


template<typename T>
void selectionSort(T arr[], int n){

    for(int i = 0 ; i < n ; i ++){

        int minIndex = i;
        for( int j = i + 1 ; j < n ; j ++ )
            if( arr[j] < arr[minIndex] )
                minIndex = j;

        swap( arr[i] , arr[minIndex] );
    }
}

#endif //DATASTRUCTURESANDALGORITHMS_SELECTIONSORT_H
