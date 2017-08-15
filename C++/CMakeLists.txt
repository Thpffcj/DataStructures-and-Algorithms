cmake_minimum_required(VERSION 3.7)
project(DataStructuresAndAlgorithms)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES algorithms/sort/SortTestHelper.h algorithms/sort/SelectionSort.h algorithms/sort/InsertionSort.h algorithms/sort/ShellSort.h algorithms/sort/BubbleSort.h algorithms/sort/MergeSort.h algorithms/sort/QuickSort.h dataStructures/heap/main.cpp)
add_executable(DataStructuresAndAlgorithms ${SOURCE_FILES})