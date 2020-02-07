#include<iostream>
using namespace std;

class TreeNode{
friend class BSTree;
private:
  TreeNode *left, *right;
  int data;
};

class BSTree{
private:
  TreeNode *tree;
  TreeNode *Search(TreeNode *t, int x);
  TreeNode* deleteNode(TreeNode*, int);

 // void inorder(tree);
public:
  BSTree(){
    tree = NULL;
  }
  TreeNode* check(TreeNode*);
  TreeNode *Search(int);      //RECURSIVE SEARCH
  TreeNode *ISearch(int);     //ITERATIVE SEARCH
  void insertNode(int);
  TreeNode* deleteNode(int);
  TreeNode *minValue(TreeNode*);
  void inorder(TreeNode*);
};

void BSTree :: insertNode(int x){
  bool found  = false;
  TreeNode *p = tree,*q;
  while((p) && found!=true){
    q=p;
    if((p->data)==x) found=true;
    else if((p->data)>x) p=(p->left);
    else p=(p->right);
  }
  if(!found){
    p = new TreeNode;
    p->data = x;
    p->left =NULL;
    p->right= NULL;
    if(tree){
      if(x<(q->data)) q->left = p;
      else q->right = p;
    }
    else
      tree =p;
  }
}

TreeNode* BSTree :: Search(int x){ return Search(tree, x); }
TreeNode* BSTree :: deleteNode(int x){ return deleteNode(tree, x); }
TreeNode* BSTree :: check(TreeNode* z){z=tree; inorder(z); }

TreeNode *BSTree :: Search(TreeNode *t , int x){
  if(t == NULL){ cout<<"\nElement not found\n"; return 0; }
  else if (x == t->data) return t;
  else if(x<t->data) return (Search(t->left, x));
  else return (Search (t->right, x));
}

TreeNode *BSTree :: ISearch(int x){
  bool found =false;
  TreeNode *t = tree;
  if(t == NULL) return 0;
  while((t) && (!found)){
    if(x == (t->data)) found = true;
    else if( x<(t->data)) t=t->left;
    else t=t->right;
  }
  if(found) return t;
  else return NULL;
}

TreeNode* BSTree :: minValue(TreeNode *node){
  TreeNode *current = node;
  while((current) && (current->left!=NULL)){
    current  = current->left;
  }
  return current;
}

TreeNode* BSTree :: deleteNode(TreeNode *t, int x){
  if(t == NULL) return 0;
  if(x<t->data) t->left = deleteNode(t->left,x);
  else if(x>t->data) t->right = deleteNode(t->right,x);
  else{
    if(t->left == NULL){
      TreeNode *temp = t->right;
      free(t);
      return temp;
    }
    else if(t->right == NULL){
      TreeNode *temp = t->right;
      free(t);
      return temp;
    }
    TreeNode *temp = minValue(t->right);
    t->data = temp->data;
    t->right = deleteNode(t->right, temp->data);
  }
  return t;
}

void BSTree :: inorder(TreeNode *t){
  //TreeNode *t = tree;
  //t = tree;
  if(t!=NULL){
    inorder(t->left);
    cout<<t->data<<" ";
    inorder(t->right);
  }
}

int main(){
  BSTree obj;
  int ch,num;
  TreeNode *root,*ser;
  //struct TreeNode *root = tree;

  do{
    cout<<"\n1. Enter\n2. Pop\n3. Display\n4. Search\n5. Exit\n=>Enter your choice : ";
    cin>>ch;
    switch(ch){
        case 1:
          cout<<"\nNumber to enter: ";
          cin>>num;
          obj.insertNode(num);
          break;
        case 2:
          cout<<"\nEnter the element to delete: ";
          cin>>num;
          root = obj.deleteNode(num);
          cout<<"\nInorder: ";
          obj.inorder(root);
          break;
        case 3:
          cout<<"\nInorder: ";
          obj.check(root);
          break;
        case 4:
          cout<<"\nEnter element to search: ";
          cin>>num;
          cout<<"\nSearching..\n";
          ser = obj.Search(num);
          if(ser) cout<<"\nElement exists\n";
          break;
    }
  }while(ch!=5);
  return 0;
}
