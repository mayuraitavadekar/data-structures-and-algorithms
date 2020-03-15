#include<iostream>

using namespace std;

typedef struct Node {
    int data;
    Node *left;
    Node *right;
} Node;

void inorder(Node*);
void preorder(Node*);
void postorder(Node*);
void display();
int insertNode(int);
int searchNode(int);


Node *root = NULL;
Node *curr = NULL;
Node *previ = NULL;
Node *newnode = NULL;

int insertNode(int d) {

    // this is recursive approach
    newnode = new Node();
    newnode->data = d;
    newnode->left = NULL;
    newnode->right = NULL;

    if(root == NULL) {
        root = newnode;
        return newnode->data;
    }

    else {
        curr = root;
        previ = root;

        while(curr!=NULL) {
            previ = curr;
            if(newnode->data < curr->data) curr = curr->left;
            else if(newnode->data > curr->data) curr = curr->right;
            else if(newnode->data == curr->data) return -1;
        }

        if(newnode->data < previ->data) {
            previ->left = newnode;
            return newnode->data;
        }
        else if(newnode->data > previ->data) {
            previ->right = newnode;
            return newnode->data;
        }
    }
}

int searchNode(int d) {

    if(root->data == d) {
        return root->data;
    }

    int flag = 0;

    curr = root;
    previ = root;

    while(curr!=NULL) {

        if(curr->data == d) {
            flag = 1;
            break;
        }

        previ = curr;

        if(d < curr->data) curr = curr->left;
        else if(d > curr->data) curr = curr->right;

    }

    if(flag !=1) return -1; // not found;
    else return 1; // element found;
}

void searchKey(Node* &curr, int key, Node* &parent)
{
	// traverse the tree and search for the key
	while (curr != nullptr && curr->data != key)
	{
		// update parent node as current node
		parent = curr;

		// if given key is less than the current node, go to left subtree
		// else go to right subtree
		if (key < curr->data)
			curr = curr->left;
		else
			curr = curr->right;
	}
}

int deleteNode(int d) {

    int flag = 0;
		Node* previ = nullptr;
 		Node* curr = root;
 		searchKey(curr, d, previ);
        Node *temp1 = NULL;
        Node *temp2 = NULL;


        if(curr->left == NULL && curr->right == NULL) {
            if(previ->left == curr) previ->left=NULL;
            else previ->right=NULL;
            free(curr);
            return 1;
            //flag = 1;
            //break;
        }

        else if(curr->left != NULL && curr->right != NULL) {
            temp1 = curr;
            temp2 = curr;

            // move to right subtree
            temp2 = temp2->right;
            while(temp2->left != NULL) {
                temp2 = temp2->left;
            }

            temp1->data = temp2->data;
            free(temp2);

            return 1;
            //  break;
        }

        else if(curr->left == NULL && curr->right!=NULL) {
            // means traverse in right subtree find minimum in right subtree
            temp2 = curr;
            curr = curr->right;
            if(previ->data < curr->data) {
                // previ->right linkage else previ->left linkage
                previ->right = NULL;
                temp2->right = NULL;
                previ->right = curr; // node linked;
            }

            else if(previ->data > curr->data) {
                // previ->left linkage
                previ->left = NULL;
                temp2->right = NULL;
                previ->left = curr;
            }
            free(temp2);

                return 1;
            //  break;
        }

        else if(curr->right == NULL && curr->left != NULL) {
            temp2 = curr;
            curr = curr->left;
            if(previ->data < curr->data) {
                // previ->right linkage
                previ->right = NULL;
                temp2->left = NULL;
                previ->right = curr;
            }

            else if(previ->data > curr->data) {
                // previ->left linkage
                previ->left = NULL;
                temp2->left = NULL;
                previ->left = curr;
            }
            free(temp2);

            return 1;
            //break;
        }
//if(flag != 1) return -1; // node not found;
//else return 1; // node found;
}



void display() {

    int choice;

    curr = root; // retrieve root;

    cout<<"1. inorder 2. preorder 3. postorder "<<endl;
    cin>>choice;

    switch(choice) {
        case 1 :
        inorder(curr);
        break;

        case 2 :
        preorder(curr);
        break;

        case 3 :
        postorder(curr);
        break;
    }
}

void inorder(Node *root) {

    if(root == NULL) return;

    inorder(root->left);
    cout<<root->data<<" ";
    inorder(root->right);

}

void preorder(Node *root) {

    if(root == NULL) return;

    cout<<root->data<<" ";
    preorder(root->left);
    preorder(root->right);
}

void postorder(Node *root) {

    if(root == NULL) return;

    postorder(root->left);
    postorder(root->right);
    cout<<root->data<<" ";
}



// driver code
int main () {

    int choice;
    int element;
    int data;

    do {
		cout<<endl;
        cout<<"1. insert : "<<endl;
        cout<<"2. search : "<<endl;
        cout<<"3. delete : "<<endl;
        cout<<"4. display: "<<endl;

        cin>>choice;

        switch(choice) {

            case 1 :
            cout<<"enter data : "<<endl;
            cin>>data;
            element = insertNode(data);
            if(element!=-1) cout<<element<<" added."<<endl;
            else cout<<"not added."<<endl;
            break;

            case 2 :
            cout<<"enter element to search : "<<endl;
            cin>>data;
            element = searchNode(data);
            if(element!=-1) cout<<element<<" found."<<endl;
            else cout<<"not found."<<endl;
            break;

            case 3 :
            cout<<"enter element to delete : "<<endl;
            cin>>data;
            element = deleteNode(data);
            if(element!=1) cout<<"not deleted"<<endl;
            else cout<<"deleted."<<endl;

            case 4 :
            display();
            break;
        }

    }while(choice!=0);

}
