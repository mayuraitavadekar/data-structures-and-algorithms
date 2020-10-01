#include <iostream>
#include <bits/stdc++.h>
#include <vector>

using namespace std;

void insert(int arr[], int n)
{

    int i = n;
    int temp = arr[n];

    while (i > 0 && temp > arr[i % 2 == 0 ? (i / 2) - 1 : i / 2])
    {
        arr[i] = arr[i % 2 == 0 ? (i / 2) - 1 : i / 2];
        i = i % 2 == 0 ? (i / 2) - 1 : i / 2;
    }

    arr[i] = temp;

    for (int i = 0; i <= n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;

    return;
}

int main()
{

    int arr[] = {10, 20, 30, 25, 5, 40, 35};
    int array_size = sizeof(arr) / sizeof(arr[0]);

    for (int i = 1; i <= array_size - 1; i++)
    {
        insert(arr, i);
    }

    return 0;
}
