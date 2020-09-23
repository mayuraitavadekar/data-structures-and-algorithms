#include<iostream>

using namespace std;

int main () {

    int n = 5; // no of lines
    int spaces = 0;


    for(int i=1;i<=n;i++) {
        for(int j=5;j>=i;j--) {
            cout<<"*";
        }
        cout<<endl;
    }

}

/*

*****
****
***
**
*

*/
