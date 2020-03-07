#include<iostream>

using namespace std;

typedef struct Node {
    int data;
    int priority;
    Node *next;
} Node;

Node *head = NULL;
Node *newnode = NULL;
Node *curr = NULL;
Node *previ = NULL;
int flag = 0;
int min_p = 0;

int insertElement() {

    Node *newnode = new Node(); // newnode created;

    if(!newnode) {
        cout<<"queue is full."<<endl;
        exit(0); 
    }

    // take data into node;
    cout<<"enter element : "<<endl; cin>>newnode->data;
    cout<<"enter priority : "<<endl; cin>>newnode->priority;

    if(head == NULL) {
        head = newnode;
        min_p = newnode->priority;
        return 1; // element added;
    }

    else {

        if(newnode->priority < head->priority) {
            newnode->next = head;
            head = newnode;
            return 1; // element added;
        }

        else if(newnode->priority > min_p) {
            min_p = newnode->priority;
            // insert this element in the end;
            curr = head;
            while(curr->next!=NULL) {
                curr = curr->next;
            }  
            curr->next = newnode;
            return 1; // element added;
        }

        else {

            curr = head;
            previ = head;
            while(curr->next != NULL) {
                previ = curr;
                curr = curr->next;
                if(newnode->priority <= curr->priority) {
                    newnode->next = curr;
                    previ->next = NULL;
                    previ->next = newnode;
                    flag = 1;
                    break;
                }
            }

            if(flag!=1) return -1;

            return 1;

        }
    }
}

int removeElement() {

    int p;

    if(head == NULL) {
        cout<<"queue is empty."<<endl;
        return -1;
    }

    curr = head;
    head = head->next;
    p = curr->priority;
    free(curr);
    
    return p; // return priority;
    
}

void display() {

    curr = head;
    while(curr->next != NULL) {
        cout<<"|"<<curr->data<<"|"<<curr->priority<<"|->";
        curr = curr->next;
    }
    cout<<"|"<<curr->data<<"|"<<curr->priority<<"|"<<endl;
    return;
}

int main () {

    int choice;
    int res;

    do {

        cout<<"1. add element : "<<endl;
        cout<<"2. remove element : "<<endl;
        cout<<"3. display queue : "<<endl;

        cin>>choice;
        
        switch(choice) {

            case 1 : 
            res = insertElement();
            if(res == -1) cout<<"error!"<<endl;
            cout<<"element added."<<endl;
            break;

            case 2 :
            res = removeElement();
            if(res != -1) cout<<"element of priority "<<res<<" removed.";
            break;

            case 3 :
            display();
            break;
        }

    }while(choice!=0);

    return 0;
}
