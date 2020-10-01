#include <iostream>
#define max 100

using namespace std;

void swap(int *a, int *b)
{
    int temp;

    temp = *a;
    *a = *b;
    *b = temp;
}

void selection_sort(int arr[], int n)
{

    int i, j, min_idx;

    for (int i = 0; i < n - 1; i++)
    {
        min_idx = i;

        for (int j = i + 1; j < n; j++)

            if (arr[j] < arr[min_idx])
            {

                min_idx = j; // update minimum index
            }

        swap(&arr[min_idx], &arr[i]);
    }
}

int main()
{

    int arr[max], n;

    cout << "enter how many elements you want : " << endl;
    cin >> n;

    cout << "enter elements one by one : " << endl;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    selection_sort(arr, n);

    cout << "sorted array is : " << endl;
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;

    return 0;
}