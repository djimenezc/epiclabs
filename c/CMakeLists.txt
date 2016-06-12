cmake_minimum_required(VERSION 3.5)
project(2dArray)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES 2dArrayAllocate.cpp)
add_executable(2dArray ${SOURCE_FILES})