#include <iostream>

using namespace std;

void delete_element(int arr[], int n, int heap_size_pointer)
{

    int x = arr[1];
    arr[1] = arr[heap_size_pointer];
    arr[n - 1] = x;
    heap_size_pointer--;

    int i = 1, j = 2 * i, temp;
    while (j < heap_size_pointer)
    {

        if (arr[j + 1] > arr[j])
        {
            j = j + 1;
        }

        if (arr[i] < arr[j])
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i = j;
            j = 2 * j;
        }

        else
        {
            break;
        }
    }

    cout << "heap after deletion of an element : " << endl;
    for (int k = 1; k <= heap_size_pointer; k++)
    {
        cout << arr[k] << " ";
    }

    cout << endl;

    return;
}

int main()
{

    int arr[] = {0, 40, 35, 30, 15, 10, 25, 5}; //for simplicity put arr[0] = 0 and start ops from 1

    int n = sizeof(arr) / sizeof(arr[0]); // n=8 and from 1 to 7
    int heap_size_pointer = n - 1;        // initially = 7

    delete_element(arr, n, heap_size_pointer);

    return 0;
}