#include <iostream>
#include <bits/stdc++.h>
#include <queue>
#define max 100

using namespace std;

int arr[max][max];
int n;
int visited[max];
queue<int> my_queue;

void BFS(int i)
{
    int u = 0;
    cout << i << " ";
    visited[i] = 1;
    my_queue.push(i);

    while (my_queue.empty() != true)
    {

        u = my_queue.front(); // take element out of the queue
        my_queue.pop();       // remove it from queue

        // start expoloration
        for (int j = 1; j <= n; j++)
        {

            if (visited[j] == 0 && arr[u][j] == 1)
            {
                cout << j << " ";
                visited[j] = 1;
                my_queue.push(j);
            }
        }
    }
}

int main()
{
    // initialisation
    for (int i = 0; i < max; i++)
    {
        for (int j = 0; j < max; j++)
        {
            arr[i][j] = 0;
        }
    }

    // initialisation
    for (int i = 0; i <= n; i++)
    {
        visited[i] = 0;
    }

    // start the driver code
    cout << "enter no of vertices : " << endl;
    cin >> n;

    cout << "enter the adjecency matrix : " << endl;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            cin >> arr[i][j];
        }
    }

    cout << "BFS graph traversal : ";

    BFS(1); // sending the starting vertex
}