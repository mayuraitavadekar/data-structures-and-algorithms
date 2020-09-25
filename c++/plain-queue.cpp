#include<iostream>

using namespace std;

int rear = -1;
int front = -1;
int arr[100];
int q_size;

bool add() {

    int element;

    if(rear-front == q_size-1) {
        return false;
    }

    else {
        
        // add element

        cout<<"enter element : "<<endl;
        cin>>element;

        
        if(front==-1 && rear==-1) {
            front++;
            rear++;
            arr[front] = element; 
        }

        else {
            rear++;
            arr[rear] = element;
        }

        return true;
    }

}


int q_remove() {

    int element;

    if(front>rear || (front=-1 && rear==-1)) {
        // queue is empty. reset front & rear.
        front=-1;
        rear=-1;
        return -1;
    }
    
    else {
        // remove element
        element = arr[front];
        front++;
        return element;
    }
}

void display() {

    for(int i=front;i<=rear;i++) {
        cout<<arr[i]<<"<-";
    }
    cout<<endl;
}

int main () {

    int choice;
    bool res;
    int element;

    cout<<"enter size : "<<endl;
    cin>>q_size;

    do {
        cout<<"1. add element : "<<endl;
        cout<<"2. remove element : "<<endl;
        cout<<"3. display element : "<<endl;
        cout<<"0. EXIT : "<<endl;
        
        cin>>choice;

        switch(choice) {

            case 1 :
            res = add();
            if(res!=true) cout<<"queue is full."<<endl;
            else cout<<"added."<<endl;
            break;

            case 2 : 
            element = q_remove();
            if(element!=-1) cout<<element<<" removed."<<endl;
            else cout<<"queue is empty."<<endl;
            break;

            case 3 :
            display();
            break;
        }
    }while(choice!=0);
    

}
