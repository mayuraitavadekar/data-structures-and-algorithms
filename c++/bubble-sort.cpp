#include <iostream>
#define max 100

using namespace std;

void bubble_sort(int arr[], int n)
{

    int temp;
    int total_swappings = 0; // in worrst case - (n-1) + (n-2) + (n-3) + ...... + 2  + 1
    bool at_least_one_time_swapped_or_not = false;

    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < (n - i - 1); j++)
        {
            if (arr[j] > arr[j + 1])
            {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                total_swappings++;
                at_least_one_time_swapped_or_not = true;
            }
        }

        if (at_least_one_time_swapped_or_not != true)
        {
            // it is best case. otherwise, in the first iteration there has to been at least one swapping.

            cout << "elements are already sorted." << endl;
            break;
        }
    }

    cout << "total swappings : " << total_swappings << endl;
}

int main()
{

    int arr[max];
    int n;

    cout << "how many elements to enter : " << endl;
    cin >> n;

    cout << "enter elements one by one : " << endl;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    bubble_sort(arr, n);

    cout << "sorted array is : " << endl;

    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }

    cout << endl;

    return 0;
}
