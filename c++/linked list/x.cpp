#include<iostream>

using namespace std;

typedef struct Node {
	
	int data;
	Node *next;
	
} Node;


Node *head1 = NULL;
Node *head2 = NULL;

Node *head = NULL;
Node *newnode = NULL;
Node *curr = NULL;
Node *temp = NULL;

int d = 0;

void createLinkedList() {
	
	for(int i=0;i<2;i++) {

		d=d+10;
		newnode = new Node();
		newnode->data = d;
	
		if(head1 == NULL) {
			head1 = newnode;
		}
		else {
			curr = head1;
			while(curr->next !=NULL) {
				curr = curr->next;
			}
			curr->next = newnode;
		}

	}

	cout<<"first list created."<<endl;

	d = -5;

	for(int i=0;i<3;i++) {
		
		d = d+10;
		newnode = new Node();
		newnode->data = d+10;

		if(head2 == NULL) {
			head2 = newnode;
		}
		else {
			curr = head2;
			while(curr->next !=NULL) {
				curr = curr->next;
			}
			curr->next = newnode;
		}
	}

	cout<<"second list created."<<endl;
}

void mergeList() {
	
	Node *temp1;
	Node *temp2;
	
	temp1 = head1;
	temp2 = head2;
	
	while(temp1!=NULL && temp2!=NULL) {
		
		newnode = new Node();
		
		if(temp1->data < temp2->data) {
			newnode->data = temp1->data;
			if(head == NULL) {
				head = newnode;
			}
			else {
				curr = head;
				while(curr->next!=NULL) {
					curr = curr->next;
				}
				curr->next = newnode;
			}	
			temp1 = temp1->next;
		}
		
		else {
			newnode->data = temp2->data;
			if(head == NULL) {
				head = newnode;
			}
			else {
				curr = head;
				while(curr->next!=NULL) {
					curr =  curr->next;
				}
				curr->next = newnode;
			}
			temp2 = temp2->next;
		}
	}

	if(temp1 == NULL) {
		curr = head;
		while(curr->next!=NULL) {
			curr = curr->next;
		}
		curr->next = temp2;
	}

	if(temp2 == NULL) {	
		curr = head;
		while(curr->next!=NULL) {
			curr = curr->next;
		}
		curr->next = temp1;
	}

}

void display() {

	curr = head;
	while(curr->next!=NULL) {
		cout<<curr->data<<endl;
		curr = curr->next;
	}
	cout<<curr->data<<endl;

}

// driver code.

int main() {

	cout<<"create two linked list : "<<endl;
	createLinkedList();
	
	cout<<"calling merge"<<endl;
	mergeList();
	cout<<"calling display"<<endl;
	display();
}