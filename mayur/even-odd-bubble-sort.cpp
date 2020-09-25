#include <iostream>
#define max 100

using namespace std;

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void even_odd_bubble_sort(int arr[], int n)
{

    bool is_sorted = false;

    while (!is_sorted)
    {

        is_sorted = true;

        // swap odd elements
        for (int i = 1; i <= n - 2; i += 2)
        {
            if (arr[i] > arr[i + 1])
            {
                swap(&arr[i], &arr[i + 1]);
                is_sorted = false;
            }
        }

        // swap even elements
        for (int i = 0; i <= n - 2; i += 2)
        {
            if (arr[i] > arr[i + 1])
            {
                swap(&arr[i], &arr[i + 1]);
                is_sorted = false;
            }
        }
    }

    return;
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

    even_odd_bubble_sort(arr, n);

    cout << "sorted array is : " << endl;

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;

    return 0;
}
