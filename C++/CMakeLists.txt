cmake_minimum_required(VERSION 3.7)
project(DataStructuresAndAlgorithms)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES algorithms/sort/SortTestHelper.h algorithms/sort/SelectionSort.h algorithms/sort/InsertionSort.h algorithms/sort/ShellSort.h algorithms/sort/BubbleSort.h algorithms/sort/MergeSort.h algorithms/sort/QuickSort.h dataStructures/heap/MaxHeap.h dataStructures/heap/HeapSort.h dataStructures/heap/IndexMaxHeap.h dataStructures/heap/MinHeap.h dataStructures/heap/IndexMinHeap.h dataStructures/tree/main.cpp dataStructures/tree/BST.h dataStructures/tree/FileOps.h dataStructures/tree/SequenceST.h)
add_executable(DataStructuresAndAlgorithms ${SOURCE_FILES})