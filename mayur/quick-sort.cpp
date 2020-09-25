#include <iostream>
#define max 100

using namespace std;

int quicksort(int arr[], int low, int high)
{
    int i, j, pivot, temp;

    if (low < high)
    {
        pivot = low;
        i = low;
        j = high;

        while (i < j)
        {
            while (arr[i] <= arr[pivot])
            {
                i++;
            }

            while (arr[j] > arr[pivot])
            {
                j--;
            }

            if (i < j)
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;

        quicksort(arr, low, j - 1);
        quicksort(arr, j + 1, high);
    }
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

    quicksort(arr, 0, n - 1);

    cout << "finally sorted array is : " << endl;

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;
}
