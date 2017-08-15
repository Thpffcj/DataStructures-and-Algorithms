cmake_minimum_required(VERSION 3.7)
project(DataStructuresAndAlgorithms)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES library.cpp library.h algorithms/sort/SortTestHelper.h algorithms/sort/main.cpp algorithms/sort/SelectionSort.h algorithms/sort/InsertionSort.h algorithms/sort/ShellSort.h algorithms/sort/BubbleSort.h algorithms/sort/MergeSort.h)
add_executable(DataStructuresAndAlgorithms ${SOURCE_FILES})