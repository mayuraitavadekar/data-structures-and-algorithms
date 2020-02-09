#include<iostream>

using namespace std;

class stack {

    private : 
    int size;
    int arr[100];
    int top;


    public : 

    stack() {
        top = -1;
        size = 10;
    }
    
    bool is_full() {
    	
    	if(top==size-1) {
    		return true;
    	}
    	
    	return false; 
    
    }
    
    bool is_empty() {
    	
    	if(top==-1) {
    		return true;
    		
    	}
    	return false;
    
    }

    void push() {

        int element;
        cout<<"enter element : "<<endl;
        cin>>element;
        
        if(is_full()) {
            cout<<"stack is full."<<endl;
            exit(0);
        }
        else {
            top++;
            arr[top] = element;
            cout<<"pushed."<<endl;
        }
        
    }

    int pop() {

        if(is_empty()) {
            cout<<"stack is empty"<<endl;
            exit(0);
        }
        else {
            int element = arr[top];
            top--;
            return element;
        }

        
    }

    void display() {

        for(int i=top;i>=0;i--) {
            cout<<arr[i]<<" "<<endl;
        }

    }

};

int main () {

    int choice;

    stack obj;

    do {

        cout<<"1. push : "<<endl;
        cout<<"2. pop : "<<endl;
        cout<<"3. display : "<<endl;

        cin>>choice;
        
        switch(choice) {

        case 1 :
        obj.push();
        break;

        case 2 : 
        cout<<obj.pop()<<"popped."<<endl;
        break;

        case 3 : 
        obj.display();
        break;

        }
        
    }while(choice!=0);

    return 0;
}
