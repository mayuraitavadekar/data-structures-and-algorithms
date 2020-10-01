#include<iostream>

using namespace std;

class circular_queue {

    private : 
    int element;
    int q_size;
    int *arr;
    int front;
    int rear;

    public :

    circular_queue(int q_size) {
        this->q_size = q_size;
        arr = new int[q_size];
        front = -1;
        rear = -1;
    }

    void enQueue() {

        if((front==0 && rear==q_size-1) || rear==(front-1)%(q_size-1)) {
            cout<<"queue is full."<<endl;
            return;
        }

        cout<<"enter element : "<<endl;
        cin>>element;

        if(front==-1 && rear==-1) {
            // intial condition
            front++;
            rear++;
            arr[rear] = element;
        }
        /*
        else if(front !=0 && rear == q_size-1) {
            rear = 0;
            arr[rear] = element;
        }
        */
        else {
            arr[(++rear%(q_size))] = element;
        }

        cout<<element<<" added."<<endl;
    }

    int deQueue() {
        
        if(front==-1) {
            return -1;
        }

        element = arr[front];
        arr[front] = 0;

        // now what to do with front
        if(front==q_size-1) {
            front=-1;
        }

        else if(front>rear) {
            front=-1;
            rear=-1;
        }
        else {
            front++;
        }

        return element;
    }   

    void display() {
        if(front==-1 && rear==-1) cout<<"queue is empty"<<endl;

        if(rear>=front) {
            
            for(int i=front;i<=rear;i++) {
                cout<<arr[i]<<"<-";
            }
            cout<<endl;
        }

        else {

            for(int i=front;i<q_size;i++) {
                cout<<arr[i]<<"<-";
            }

            for(int i=0;i<=rear;i++) {
                cout<<arr[i]<<"<-";
            }
            cout<<endl;
        }

        return;
    }

};

int main () {

    int choice;
    int element;
    int size;
    bool res;

    cout<<"enter size of queue : "<<endl;
    cin>>size;

    circular_queue obj(size);

    do {
        cout<<"1. add element : "<<endl;
        cout<<"2. delete element : "<<endl;
        cout<<"3. display element : "<<endl;

        cin>>choice;

        switch(choice) {
            
            case 1 :
            obj.enQueue();
            break;

            case 2 :
            element = obj.deQueue();
            if(element!=-1) cout<<element<<" removed."<<endl;
            else cout<<"queue is empty."<<endl;
            break;

            case 3 : 
            obj.display();
            break;
        }
    }while(choice!=0);
    

}