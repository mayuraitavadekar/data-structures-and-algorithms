#include <iostream>
#include <bits/stdc++.h>
#include <vector>
#include <math.h>
using namespace std;

void swap(int *a, int *b)
{
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}

void insert(vector<int> &v, int element)
{

    v.push_back(element);

    int temp = v[v.size() - 1];

    int i = v.size() - 1;

    while (i > 0 && temp > v[i % 2 == 0 ? (i / 2) - 1 : i / 2])
    {
        v[i] = v[i % 2 == 0 ? (i / 2) - 1 : i / 2];
        i = i % 2 == 0 ? (i / 2) - 1 : i / 2;
    }

    v[i] = temp;

    cout << "heap after insertion : " << endl;

    for (int i = 0; i < v.size(); i++)
        cout << v[i] << " ";

    return;
}

int main()
{

    vector<int> vect = {50, 30, 20, 15, 10, 8, 16};

    insert(vect, 60);

    return 0;
}