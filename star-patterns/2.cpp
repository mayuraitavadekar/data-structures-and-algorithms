/*

1          *
2        * *
3      * * *
4    * * * *
5  * * * * *

*/

#include<iostream>

using namespace std;

int main () {
    
    int n = 5;
    int spaces = n-1;
    for(int i=1;i<=n;i++) {
        for(int j=1;j<=spaces;j++) {
            cout<<" ";
        }

        spaces--;

        for(int k=1;k<=i;k++) {
            cout<<"*";
        }
        cout<<endl;
    }


}

/* 
line                    space stars
1 space space space space * 4 1
2 space space space *   *   3 2
3 space space * * *         2 3
4 space * * * *             1 4  
5 * * * * *                 0 5

*/
