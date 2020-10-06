/*
    1. A faster method to create the heap.
    2. traditional method which goes from top to bottom takes O(nlogn) time.
    3. heapify takes O(n) time as we need to to check leaf elements.

*/

#include <iostream>

using namespace std;

void Delete(int arr[], int n)
{

    int x = arr[1];
    arr[1] = arr[n];

    int i = 1;
    int j = 2 * i;
    int temp;

    while (j <= n - 1)
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

    arr[n] = x;
}

void heapify(int arr[], int n)
{

    // ignore the leaf elements and start from first parent element
    int j;
    int temp;

    for (int i = (n / 2); i >= 1; i--)
    {
        j = 2 * i;
        // compare the children
        while (j <= n - 1)
        {
            if (arr[j + 1] > arr[j])
            {
                j = j + 1;
            }

            if (arr[j] > arr[i])
            {
                // swap
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
    }
}

int main()
{

    int arr[] = {0, 5, 10, 30, 20, 35, 40, 15};
    int n = sizeof(arr) / sizeof(arr[0]);

    // create heap using heapify
    heapify(arr, n);

    cout << "After heapify the max-heap created as follows : " << endl;

    for (int i = 1; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;

    // now you can perform the deletion operation over this max heap to get sorted array
    // we have already seen that. should I write it again? okay, let's do this ;)

    for (int i = n - 1; i >= 1; i--)
    {
        Delete(arr, i);
    }

    // finally after deletion of each element from top and puttting it in the last place
    // we can get the sorted array as follows
    for (int i = 1; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;

    return 0;
}