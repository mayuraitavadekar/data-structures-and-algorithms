#include<iostream>

using namespace std;

int main () {
    
    int maxpt = 5;
    int symmetry = maxpt -1;

    for(int i=1;i<=symmetry;i++) {
        for(int j=1;j<=i;j++) {
            cout<<"*";
        }
        cout<<endl;
    }

    for(int i=1;i<=maxpt;i++) {
        cout<<"*";
    }

    cout<<endl;

    for(int i=symmetry;i>=0;i--) {
        for(int j=1;j<=i;j++) {
            cout<<"*";
        }
        cout<<endl;
    }


    return 0;
}

/*

1   *
2   * *
3   * * * 
4   * * * * maxpt
5   * * *
6   * * 
7   *

*/
