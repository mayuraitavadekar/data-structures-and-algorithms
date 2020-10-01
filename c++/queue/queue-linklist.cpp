#include<iostream>

using namespace std;

typedef struct Node {
    int data;
    Node *next;
} Node;

Node *newnode = NULL;
Node *front = NULL;
Node *rear = NULL;
Node *curr = NULL;
int count = 0;

void add() {

    int element;
    cout<<"enter element : "<<endl;
    cin>>element;

    newnode = new Node();

    if(!newnode) {
        cout<<"queue is full"<<endl;
        exit(0);
    }

    newnode->data = element;

    if(front==NULL && rear==NULL) {
        front = newnode;
        rear = newnode;
    }

    else {
        rear->next = newnode;
        rear = newnode;
    }

    cout<<"added."<<endl;
}

void q_remove() {

    if(front==NULL && rear==NULL) {
        cout<<"queue is empty"<<endl;
        exit(0);
    }

    int element;
    curr = front;
    front = front->next;
    element = curr->data;
    free(curr);
    cout<<element<<" removed."<<endl;

}

void display() {

    curr = front;
    while(curr->next!=NULL) {
        cout<<curr->data<<"<-";
        curr = curr->next;
    }
    cout<<curr->data<<endl;
}

int main () {

    int choice;
    int element;

    do {
        cout<<"1. add element : "<<endl;
        cout<<"2. remove element : "<<endl;
        cout<<"3. display : "<<endl;
        
        cin>>choice;

        switch(choice) {

            case 1 : 
            add();
            break;

            case 2 : 
            q_remove();
            break;

            case 3 : 
            display();
            break;

        }

    }while(choice!=0);

}
