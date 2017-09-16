cmake_minimum_required(VERSION 3.7)
project(DataStructuresAndAlgorithms)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES algorithms/algorithmInterview/Amortized-Time-2/main.cpp algorithms/algorithmInterview/Amortized-Time-2/MyVector.h)
add_executable(DataStructuresAndAlgorithms ${SOURCE_FILES})