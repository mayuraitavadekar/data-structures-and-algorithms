#include <iostream>

using namespace std;

int main()
{

    int arr[5] = {1, 5, 6, 4, 7};

    int n = sizeof(arr) / sizeof(arr[0]);

    cout << "n = " << n << endl;

    int i, j;

    for (j = 1; j < n; j++)
    {
        int key = arr[j];
        i = j - 1;

        while (i > 0 && arr[i] > key)
        {
            arr[i + 1] = arr[i];
            i = i - 1;
        }

        arr[i + 1] = key;
    }

    cout << "sorted array : " << endl;

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
}
