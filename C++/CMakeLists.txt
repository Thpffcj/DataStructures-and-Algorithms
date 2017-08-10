cmake_minimum_required(VERSION 3.7)
project(DataStructuresAndAlgorithms)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES library.cpp library.h algorithms/sort/SortTestHelper.h algorithms/sort/main.cpp)
add_executable(DataStructuresAndAlgorithms ${SOURCE_FILES})