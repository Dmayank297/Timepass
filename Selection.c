// TOPOLOGICAL
#include<stdio.h>

int main() {
    int n, a[20][20], visited[20] = {0};

    printf("Enter number of vertices: ");''
    scanf("%d", &n);

    printf("Enter adjacency matrix:\n");
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &a[i][j]);

    printf("Topological Order: ");
    for (int count = 0; count < n; count++) {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int indegree = 0;
                for (int j = 0; j < n; j++)
                    if (a[j][i] && !visited[j])
                        indegree = 1;

                if (!indegree) {
                    printf("%d ", i + 1);
                    visited[i] = 1;
                    break;
                }
            }
        }
    }

    return 0;
}

//SUBSET
#include <stdio.h>

int S[20], path[20], n, d;

void subset(int i, int sum, int p) {
    
    if (sum == d) {
        for (int j = 0; j < p; j++) printf("%d ", path[j]);
        printf("\n");
        return;
    }
    if (i == n || sum > d) return;

    // include S[i]
    path[p] = S[i];
    subset(i + 1, sum + S[i], p + 1);

    // exclude S[i]
    subset(i + 1, sum, p);
}

int main() {
    scanf("%d%d", &n, &d);
    for (int i = 0; i < n; i++) scanf("%d", &S[i]);

    subset(0, 0, 0);
    return 0;
}


FLOYD
#include <stdio.h>
#define INF 9999

int main() {
    int n, d[20][20];
    scanf("%d", &n);
    
    // Input matrix
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &d[i][j]);

    // Floyd’s logic
    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (d[i][k] + d[k][j] < d[i][j])
                    d[i][j] = d[i][k] + d[k][j];

    // Output
    printf("All-Pairs Shortest Path:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            printf("%d ", d[i][j] == INF ? -1 : d[i][j]);
        printf("\n");
    }
    return 0;
}


WARSHALL
#include <stdio.h>

int main() {
    int n, r[20][20];
    scanf("%d", &n);

    // Input adjacency matrix
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &r[i][j]);

    // Warshall’s logic
    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                r[i][j] = r[i][j] || (r[i][k] && r[k][j]);

    // Output
    printf("Transitive Closure:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            printf("%d ", r[i][j]);
        printf("\n");
    }
    return 0;
}


MERGE
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void merge(int arr[], int low, int mid, int high) {
    int temp[high - low + 1];
    int left = low, right = mid + 1, k = 0;

    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp[k++] = arr[left++];
        } else {
            temp[k++] = arr[right++];
        }
    }

    while (left <= mid) {
        temp[k++] = arr[left++];
    }

    while (right <= high) {
        temp[k++] = arr[right++];
    }

    for (int i = 0; i < k; i++) {
        arr[low + i] = temp[i];
    }
}

void mergeSort(int arr[], int low, int high) {
    if (low < high) {
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
}

void generateRandomArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 10000;  // Random integers between 0 and 9999
    }
}

int main() {
    int n;
    
    // Prompt user to input the number of elements
    printf("Enter the number of elements (n > 5000): ");
    scanf("%d", &n);

    if (n <= 5000) {
        printf("n must be greater than 5000. Exiting...\n");
        return 1;
    }

    int arr[n];
    generateRandomArray(arr, n);  // Generate random elements


    clock_t start_time = clock();  // Start the timer
    mergeSort(arr, 0, n - 1);     // Perform Merge Sort
    clock_t end_time = clock();    // End the timer

    // Calculate time taken for sorting
    double time_taken = (double)(end_time - start_time) / CLOCKS_PER_SEC;

    printf("Time taken to sort the array: %.6f seconds\n", time_taken);

    return 0;
}




QUICK
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Quick Sort Partition function
int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}

// Quick Sort Function
void quickSort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

// Generate Random Array
void generateRandomArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 10000;  // Random integers between 0 and 9999
    }
}

int main() {
    int n;
    
    printf("Enter the number of elements (n > 5000): ");
    scanf("%d", &n);

    if (n <= 5000) {
        printf("n must be greater than 5000. Exiting...\n");
        return 1;
    }

    int arr[n];
    generateRandomArray(arr, n);  // Generate random elements

    printf("Sorting array of size %d...\n", n);

    clock_t start_time = clock();  // Start the timer
    quickSort(arr, 0, n - 1);     // Perform Quick Sort
    clock_t end_time = clock();    // End the timer

    double time_taken = (double)(end_time - start_time) / CLOCKS_PER_SEC;

    printf("Time taken to sort the array: %.6f seconds\n", time_taken);

    return 0;
}



SELECTION
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Selection Sort function
void selectionSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int min_idx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[min_idx]) {
                min_idx = j;
            }
        }
        int temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }
}

// Generate Random Array
void generateRandomArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 10000;  // Random integers between 0 and 9999
    }
}

int main() {
    int n;
    
    printf("Enter the number of elements (n > 5000): ");
    scanf("%d", &n);

    if (n <= 5000) {
        printf("n must be greater than 5000. Exiting...\n");
        return 1;
    }

    int arr[n];
    generateRandomArray(arr, n);  // Generate random elements

    printf("Sorting array of size %d...\n", n);

    clock_t start_time = clock();  // Start the timer
    selectionSort(arr, n);         // Perform Selection Sort
    clock_t end_time = clock();    // End the timer

    double time_taken = (double)(end_time - start_time) / CLOCKS_PER_SEC;

    printf("Time taken to sort the array: %.6f seconds\n", time_taken);

    return 0;
}