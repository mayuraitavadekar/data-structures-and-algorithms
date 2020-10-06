#include <iostream>

using namespace std;

void insert(int arr[], int n)
{

    int i = n;
    int temp = arr[i];

    while (i > 1 && temp > arr[i / 2])
    {

        arr[i] = arr[i / 2];
        i = i / 2;
    }

    arr[i] = temp;
}

void Delete(int arr[], int n) // adjustment is everything in delete
{

    int x = arr[1]; // put first element in x
    arr[1] = arr[n];

    int i = 1, j = 2 * i;
    int temp;

    while (j <= n - 1)
    {

        if (arr[j + 1] > arr[j])
            j = j + 1;

        if (arr[i] < arr[j])
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i = j;
            j = j * 2;
        }

        else
        {
            break;
        }
    }

    arr[n] = x;
}

int main()
{

    // take the random array
    int arr[] = {0, 10, 40, 30, 20, 60, 90, 80};

    int n = sizeof(arr) / sizeof(arr[0]);

    // creating an heap by inserting elements one by one
    for (int i = 2; i <= n - 1; i++)
    {
        insert(arr, i);
    }

    cout << "created heap : " << endl;

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;

    /*
        1. take element from top
        2. put the last element on the top
        3. adjust the heap
        4. put the deleted element in step one at the last
    */
    for (int i = n - 1; i > 1; i--)
    {
        Delete(arr, i);
    }

    cout << "sorted array after deletion operation : " << endl;

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;

    return 0;
}