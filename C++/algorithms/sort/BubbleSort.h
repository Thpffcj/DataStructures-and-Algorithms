//
// Created by Thpffcj on 2017/8/14.
//

#ifndef DATASTRUCTURESANDALGORITHMS_BUBBLESORT_H
#define DATASTRUCTURESANDALGORITHMS_BUBBLESORT_H

#include <iostream>
#include <algorithm>

using namespace std;

template<typename T>
void bubbleSort( T arr[] , int n){

    bool swapped;

    do{
        swapped = false;
        for( int i = 1 ; i < n ; i ++ )
            if( arr[i-1] > arr[i] ){
                swap( arr[i-1] , arr[i] );
                swapped = true;
            }

        n --;

    }while(swapped);
}

#endif //DATASTRUCTURESANDALGORITHMS_BUBBLESORT_H
