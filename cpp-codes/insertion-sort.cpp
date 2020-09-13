#include<iostream>
#include<array>

using namespace std;

int main () {
    
    std::array<int, 8> arr = {6,5,1,3,8,7,4,2} ;
    int i,j;
    
    for(j=1;j<arr.size();j++) {
        int key = arr[j];
        i = j-1;
        
        while(i>=0 && arr[i]>key) {
            arr[i+1] = arr[i];
            i = i -1;
        }
        arr[i+1] = key;
    }
    
    for(i=0;i<arr.size();i++) {
        cout<<arr[i]<<" ";
    }

    return 0;
}
