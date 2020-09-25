#include <iostream>

using namespace std;

int main()
{

    int arr[5] = {1, 2, 3, 4, 5};

    int n = sizeof(arr) / sizeof(arr[0]);

    cout << "size of array is " << n << endl;

    int element;

    cout << "enter element to search in array : " << endl;

    cin >> element;

    int left = 0;
    int right = n - 1;
    int flag = 0;

    while (left <= right)
    {
        int middle = left + (right - left) / 2;
        if (arr[middle] == element)
        {
            cout << "element found at index " << middle << endl;
            flag = 1;
            break;
        }

        else
        {
            if (element < arr[middle])
            {
                right = middle - 1;
            }

            else
            {
                left = middle + 1;
            }
        }
    }

    if (flag == 0)
        cout << "element not found." << endl;
        
    return 0;
}
