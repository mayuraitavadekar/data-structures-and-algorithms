typedef struct Node {
	
	int data;
	Node *next;
	
} Node;

Node *temp1 = head1; // head1 is head of first linked list.
Node *temp2 = head2; // head2 is head of second linked list.

Node *head = NULL; // head is head of main merging linekd list. 
Node *newnode = NULL; // newnode pointer to create newnode.
Node *curr = NULL; // to traverse.

while(true) {

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
		continue;
		
	}
	
	if(temp2->data < temp1->data) {
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
		continue;
	}
	
	if(temp1 == NULL || temp2 == NULL) {
		break;
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
