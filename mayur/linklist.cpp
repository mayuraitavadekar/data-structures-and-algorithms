#include<iostream>

using namespace std;

typedef struct Node {
    int data;
    Node *next;
} Node;

Node *newnode = NULL;
Node *head = NULL;
Node *curr = NULL;
Node *previ = NULL;
int count = 0;

// insert node[at end]
void append() {

    int element;

    cout<<"enter element : "<<endl;
    cin>>element;

    newnode = new Node();
    newnode->data = element;

    if(!newnode) {
        cout<<"linklist full."<<endl;
        exit(0);
    }

    else {

        if(head==NULL) {
            head = newnode;
        }

        else {
            curr = head;
            while(curr->next!=NULL) {
                curr = curr->next;
            }
            curr->next = newnode;
        }
        count++;
    }

    cout<<"inserted."<<endl;
}

// insert node[at begining]
void insertAtBeg() {

    int element;

    cout<<"enter element : "<<endl;
    cin>>element;

    newnode = new Node();
    newnode->data = element;

    if(!newnode) {
        cout<<"link list is full"<<endl;
        exit(0);
    }

    else {
        // link list is not full; we can insert the node
        if(head==NULL) {
            // link list is empty;
            head = newnode;
        }
        else {
            newnode->next = head;
            head = newnode;
        }
        count++;
    }
    cout<<"inserted."<<endl;
}

void insertAt(int pos) {

    int element;

    cout<<"enter element : "<<endl;
    cin>>element;

    // create newnode
    newnode = new Node(); // memory allocation for newnode pointer
    newnode->data = element;

    if(!newnode) {
        cout<<"linklist is full"<<endl;
        exit(0);
    }

    else {

        if(head==NULL) {
            cout<<"linklist is empty.. adding first node"<<endl;
            head = newnode;
        }

        else {
            curr = head;
            for(int i=0;i<pos-1;i++) {
                previ = curr;
                curr = curr->next;
            }
            previ->next = newnode;
            newnode->next = curr;
        }

        count++;
    }
    cout<<"inserted."<<endl;
}

// remove from end
int removeFromEnd() {

    int element;

    if(count==0) {
        cout<<"linklist is empty"<<endl;
        exit(0);
    }

    curr = head;
    while(curr->next!=NULL) {
        previ = curr;
        curr = curr->next;
    }
    element = curr->data;
    previ->next = NULL;
    free(curr);
    count--;
    return element;
}

// remove from begining
int removeFromBeg() {

    int element;

    if(count==0) {
        cout<<"linklist is empty"<<endl;
        exit(0);
    }

    curr = head;
    head = head->next;
    element = curr->data;
    curr->next = NULL;
    free(curr);
    count--;
    return element;
}

int removeAt(int pos) {

    int element;

    if(count==0) {
        cout<<"linklist is empty"<<endl;
        exit(0);
    }

    curr = head;
    for(int i=0;i<pos-1;i++) {
        previ = curr;
        curr = curr->next;
    }

    previ->next = curr->next;
    element = curr->data;
    curr->next = NULL;
    free(curr);
    count--;
    return element;
}

// search element
void search(int element) {
    
    int flag = 0;
    int loc = 0;
    if(element == head->data) {
        cout<<"found"<<endl;
    }

    else {

        curr = head;
        while(curr->next!=NULL) {
            if(curr->data == element) {
                flag=1;
                break;
            }
            loc++;
            curr = curr->next;

        }

        if(flag==1) {
            cout<<"element found at location : "<<loc+1<<endl;
        }
        else {
            cout<<"not found"<<endl;
        }
    }

}

// display link list 
void display() {

    curr = head;
    while(curr->next!=NULL) {
        cout<<curr->data<<endl;
        curr = curr->next;
    }
    cout<<curr->data<<endl;
}

// driver code
int main () {

    int choice;
    int pos;
    int element;

    do {

        cout<<"1. insert node[at end] : "<<endl;
        cout<<"2. insert node[at begining]"<<endl;
        cout<<"3. insert node[at pos]"<<endl;
        cout<<"4. remove node[at end] : "<<endl;
        cout<<"5. remove node[at begining]"<<endl;
        cout<<"6. remove node[at pos]"<<endl;
        cout<<"7. display node : "<<endl;
        cout<<"8. search node : "<<endl;
        cout<<"0. EXIT : "<<endl;
        
        cin>>choice;

        switch(choice) {

            case 1 :
            append();
            break;

            case 2 :
            insertAtBeg();
            break;

            case 3 :
            cout<<"enter pos : "<<endl;
            cin>>pos;
            insertAt(pos);
            break;

            case 4 : 
            element = removeFromEnd();
            cout<<element<<" removed."<<endl;
            break;              

            case 5 : 
            element = removeFromBeg();
            cout<<element<<" removed"<<endl;
            break;

            case 6 : 
            cout<<"enter pos : "<<endl;
            cin>>pos;
            element = removeAt(pos);
            cout<<element<<" removed."<<endl;   
            break;

            case 7 : 
            display();
            break; 
            
            case 8 :
            cout<<"enter element : "<<endl;
            cin>>element;
            search(element);
            break;
        }

    }while(choice!=0);

}
