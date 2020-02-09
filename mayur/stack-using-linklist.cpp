#include<iostream>

using namespace std;

typedef struct Node {
    int data;
    Node *next;
} Node;

Node *head = NULL;
Node *newnode = NULL;

void push() {

    int element;
    
    cout<<"enter element : "<<endl;
    cin>>element;
    
    if(head==NULL) {
        // create newnode
        newnode = new Node();
        newnode->next = NULL;
        newnode->data = element;
        head = newnode;
    }

    else {

        // create newnode
        newnode = new Node();
        newnode->next = NULL;
        newnode->data = element;

        newnode->next = head;
        head = newnode;
        
    }

    cout<<"pushed."<<endl;

}

int pop() {

    if(head==NULL) {
        cout<<"stack is empty"<<endl;
        exit(0);
    }
    Node *temp = NULL;
    temp = head;
    int element = temp->data;
    head = head->next;
    free(temp);
    return element;
}

void display() {

    Node *temp = NULL;
    temp = head;
    while(temp->next!=NULL) {
        cout<<temp->data<<endl;
        temp=temp->next;
    }
    cout<<temp->data<<endl;
}

int main() {

    int choice;
    int element;

    do {

        cout<<"1. push : "<<endl;
        cout<<"2. pop : "<<endl;
        cout<<"3. display : "<<endl;
        cout<<"0. EXIT : "<<endl;

        cin>>choice;

        switch(choice) {

            case 1 :
            push();
            break;

            case 2 : 
            element = pop();
            cout<<element<<"popped"<<endl;
            break;

            case 3 : 
            display();
            break;
        }

    }while(choice!=0);

    return 0;

}
