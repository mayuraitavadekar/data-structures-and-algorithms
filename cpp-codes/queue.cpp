/* This algorithm stores one less element than the size provided.
   As Add and Delete are used many times in operations involving queue,
   loss of one position is more than made up by less computing time.
*/
#include<iostream>
using namespace std;

class queue{
private:
  int *arr,pop,item;
  int front,rear,size,check;
public:
  queue(int msize){
    size = msize;
    arr = new int[size];
    front = rear = 0;
  }
  bool AddQ();
  int deleteQ();
  void display();
  bool isFull();
};
/*
bool queue :: isFull(){
    check = rear;
    check = (++check)%size;
    if(front==check){
      cout<<"QUEUE IS FULL\n";
      return true;
    }
}
*/
bool queue :: AddQ(){
  rear = (++rear)%size;
  if(front==rear){
    cout<<"QUEUE IS FULL\n\n";
    if(!front)
      rear = size-1;
    else
      rear--;
    return false;
  }
  else{
    cout<<"ENTER ELEMENT: ";
    cin>>item;
    cout<<"\n";
    arr[rear] = item;
  }
}

int queue :: deleteQ(){
  if(front  == rear){
    cout<<"QUEUE IS EMPTY\n";
    return 0;
  }
  else{
    front = (++front)%size;
    pop = arr[front];
  }
  return pop;
}

void queue :: display(){
  if(front == rear){
    cout<<"QUEUE IS EMPTY\n";
  }
  else if(rear>front){
    cout<<"QUEUE : ";
    for(int i=front+1;i<=rear;i++)
      cout<<arr[i]<<" ";
  }
  else if(rear<front){
    cout<<"QUEUE: ";
    for(int i =front+1 ;i<size;i++)
      cout<<arr[i]<<" ";
    for(int i =0;i<=rear;i++)
      cout<<arr[i]<<" ";
  }
}

int main(){
  int ch,cir;
  cout<<"ENTER SIZE: ";
  cin>>cir;
  cout<<"\n";
  queue s(cir);
  cout<<"\n*******EFFICIENT QUEUE*******\n";
  do{
    cout<<"1.PUSH\n2.POP\n3.DISPLAY\n4.Exit\nENTER CHOICE :- ";
    cin>>ch;
    cout<<"\n";
    switch(ch){
      case 1:
        s.AddQ();
        break;
      case 2:
        cout<<"Element popped: "<<s.deleteQ()<<endl;
        cout<<"\n";
        break;
      case 3:
        cout<<"\n";
        s.display();
        cout<<"\n";
        //cout<<"With "<<s.peek()<<" on top ;)\n";
        break;
      default:
        cout<<"Looks like you don't wanna continue\n";
        return 0;
    }
  }while(ch!=4);
  return 0;
}
