#include <iostream>
#define max 100

using namespace std;

void merge(int arr[], int l, int m, int h)
{

    int i, j, k;
    int n1 = m - l + 1;
    int n2 = h - m;

    // create two empty lists
    int L[n1];
    int R[n2];

    for (i = 0; i < n1; i++)
    {
        L[i] = arr[l + i];
    }

    for (j = 0; j < n2; j++)
    {
        R[j] = arr[m + 1 + j];
    }

    // merge arrays
    i = 0; // first index of L
    j = 0; // first index of R
    k = l; // left of merged array

    while (i < n1 && j < n2)
    {
        if (L[i] < R[j])
        {
            arr[k++] = L[i++];
        }

        else
        {
            arr[k++] = R[j++];
        }
    }

    while (i < n1)
    {
        arr[k++] = L[i++];
    }

    while (j < n2)
    {
        arr[k++] = R[j++];
    }
}

void mergesort(int arr[], int l, int h)
{

    if (l < h)
    {

        int mid = l + (h - l) / 2;

        mergesort(arr, l, mid);
        mergesort(arr, mid + 1, h);

        merge(arr, l, mid, h);
    }

    return ;
}

int main()
{

    int arr[max], n;

    cout << "enter how many elements : " << endl;
    cin >> n;

    cout << "enter elements one by one : " << endl;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    mergesort(arr, 0, n - 1);

    cout << "the sorted array is : " << endl;

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}