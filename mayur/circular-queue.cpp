#include<iostream>

using namespace std;

// declaring varibales
int front = -1;
int rear = -1;
int arr[100];
int q_size;

bool enQueue() {
    
    if((rear-front==q_size-1) || (rear==front-1)) {
        cout<<"queue is full"<<endl;
        return false;
    }
    
    int element;
    cout<<"enter element : "<<endl;
    cin>>element;

    if(front==-1 && rear==-1) {
        front++;
        rear++;
        arr[rear] = element;
    }
    else {
        rear++;
        arr[rear] = element;
    }
}

int deQueue() {

    if((front==-1 && rear==-1) || (front>rear)) {
        front=-1;
        rear=-1;
        cout<<"queue is empty."<<endl;
        return -1;
    }

    int element;
    element = arr[front];
    front++;
    return element;
}

void display() {
    for(int i=front;i<=rear;i++) {
        cout<<arr[i]<<"<-";
    }
    cout<<endl;
}

int main() {

    int choice;
    bool res;
    int element;
    
    cout<<"enter size : "<<endl;
    cin>>q_size;
    

    do {
        cout<<"1. add element : "<<endl;
        cout<<"2. delete element : "<<endl;
        cout<<"3. display : "<<endl;

        cin>>choice;

        switch(choice) {
            case 1:
            res = enQueue();
            if(res!=false) cout<<"added."<<endl;
            break;

            case 2 : 
            element = deQueue();
            if(element!=-1) cout<<element<<" removed."<<endl;
            break;

            case 3 : 
            display();
            break;
        }

    }while(choice!=0);

}
