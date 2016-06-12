#include <iostream>

using namespace std;

/**
 * 2D array. Write a method in C that allocates a 2 dimensions array of integers minimizing the number of allocate calls.
 *
 * Resolved 2d array allocation with two methods:
 *  1. Allocating each column of the array in one step.
 *  2. Allocating all the columns memory with one single malloc.
 *     With this method the number of allocate calls is reduced significantly as the time metrics shown.
 */

void allocate_mem(int ***array, int nRow, int nColumn) {

    *array = (int **) malloc(nRow * sizeof(int *));

    for (int i = 0; i < nRow; i++) {

        (*array)[i] = (int *) malloc(nColumn * sizeof(int));
    }
}

void deallocate_mem(int ***arr, int n) {

    for (int i = 0; i < n; i++) {

        free((*arr)[i]);
    }

    free(*arr);
}

int *allocate_mem_consecutive_blocks(int ***array, int nRow, int nColumn) {

    *array = (int **) malloc(nRow * sizeof(int *));

    int *arr_data = (int *) malloc(nRow * nColumn * sizeof(int));

    for (int i = 0; i < nRow; i++) {

        (*array)[i] = arr_data + i * nColumn;
    }

    return arr_data; //free point
}

void deallocate_mem_continue(int ***arr, int *arr_data) {

    free(arr_data);
    free(*arr);
}

int main() {
    int m = 100000, n = 10000;
    int **arr;
    int **arr2;

    clock_t tic = clock();
    allocate_mem(&arr, n, m);
    clock_t toc = clock();
    printf("Elapsed: %f seconds, 2d array simple version\n", (double) (toc - tic) / CLOCKS_PER_SEC);

    tic = clock();
    deallocate_mem(&arr, n);
    toc = clock();
    printf("Elapsed: %f seconds, release memory of 2d array simple version\n",
           (double) (toc - tic) / CLOCKS_PER_SEC);

    tic = clock();
    int *arrData = allocate_mem_consecutive_blocks(&arr2, n, m);
    toc = clock();
    printf("Elapsed: %f seconds, 2d array consecutive cells version\n",
           (double) (toc - tic) / CLOCKS_PER_SEC);

    tic = clock();
    deallocate_mem_continue(&arr2, arrData);
    toc = clock();
    printf("Elapsed: %f seconds, release memory of 2d array consecutive cells version\n",
           (double) (toc - tic) / CLOCKS_PER_SEC);

    cout << "\nArray allocation measure done!" << endl;

    return 0;
}