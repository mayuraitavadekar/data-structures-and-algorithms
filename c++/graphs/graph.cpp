#include<iostream>

using namespace std;


class Node {
    public : 

    int vertex;
    Node *next;
};

class graph {

    private : 
    int max;
    Node *headnodes[100];
    Node *newnode;
    Node *curr;
    Node *previ;

    public : 
    graph (int max) {
        this->max = max;
        for(int i=0;i<max;i++) {
            headnodes[i] = NULL;
        }
    }

    void createGraph() {
        
        int n,v;

        for(int i=0;i<max;i++) {

            // create Newnode
            headnodes[i] = new Node();

            headnodes[i]->vertex = (i+1);

            cout<<"no of vertices connected to "<<headnodes[i]->vertex<<endl;
            cin>>n; 

            for(int j=0;j<n;j++) {

                curr = headnodes[i];

                // create newnode
                newnode = new Node();

                cout<<"enter vertex : "<<endl;
                cin>>v;

                if(v>max || v<1) {
                    cout<<"vertex out of range"<<endl;
                    exit(0);
                }

                newnode->next = NULL;
                newnode->vertex = v;

                while(curr->next!=NULL) {
                    curr = curr->next;
                }

                curr->next = newnode;

            } 
        }

    }

    void display () {
        
        for(int i=0;i<max;i++) {
            curr = headnodes[i];
            while(curr->next!=NULL) {
                cout<<curr->vertex<<"->";
                curr = curr->next;
            }

            if(curr->next == NULL) {
                cout<<curr->vertex<<endl;
                continue;
            }
        }
    }

};

int main () {

    int max;
    int res,choice;


    cout<<"enter total no of vertices : "<<endl;
    cin>>max;

    graph obj(max);

    do {
        cout<<"1. create graph : "<<endl;
        cout<<"2. display graph : "<<endl;

        cin>>choice;

        switch(choice) {
            case 1 :
            obj.createGraph();
            break;

            case 2 : 
            obj.display();
            break;
        }
    }while(choice!=0);

    return 0;
}