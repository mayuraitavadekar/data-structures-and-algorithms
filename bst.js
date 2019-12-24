const readline = require('readline-sync');

class Node {
    constructor() {
        this.data = null;
        this.left = null;
        this.right = null;
    }
}

class BST {

    constructor() {
        this.root = null;
    }

    insert(element) {

        // creating new node
        var new_node = new Node();
        new_node.data = element; 
        
        if(this.root===null) {
            this.root = new_node;
        }
        else {
            this.insert_node(this.root,new_node);
        }

    }

    insert_node(node,new_node) {
        if(new_node.data < node.data) {
            if(node.left===null) {
                node.left = new_node;
            }
            else {
                this.insert_node(node.left,new_node);
            }
        }
        else {
            if(node.right===null) {
                node.right = new_node;
            }
            else {
                this.insert_node(node.right,new_node);
            }
        }
    }

    get_root_node() {
        return this.root;
    }

    inorder(node) {
        if(node!=null) {
            this.inorder(node.left);
            console.log(node.data);
            this.inorder(node.right);
        }
    }

    postorder(node) {
        if(node!=null) {
            this.postorder(node.left);
            this.postorder(node.right);
            console.log(node.data);
        }
    }

    preorder(node) {
        if(node!=null) {
            console.log(node.data);
            this.preorder(node.left);
            this.preorder(node.right);
        }
    }

    find_minimum(node) {
        if(node.left===null) {
            console.log("minimum element is = "+node.data);
        }
        else {
            this.find_minimum(node.left);
        }
    }

    search(node,element) {
        if(node===null) {
            // the tree is empty.
            return null;
        }
        else if(element < node.data) {
            this.search(node.left,element);
        }
        else if(element > node.data) {
            this.search(node.right,element);
        }
        else {
            if(node.data===element) {
                console.log(node.data+" found!!");
            }
            else {
                console.log("not found!!")
            }
        }
    }
}

var obj = new BST();

do {
    console.log("1. insert root node :");
    console.log("2. traversal : ");
    console.log("3. Find minimum : ");
    console.log("4. search node : ");

    var choice = readline.question("enter the choice : ");

    switch(choice) {

        case '1' : 
        // insert some elements
        var element = Number(readline.question("enter element : "));
        obj.insert(element);
        break;

        case '2' : 
        var res = obj.get_root_node();
        var ch = Number(readline.question("1. inorder 2. postorder 3. preorder"));
        if(ch===1) obj.inorder(res);
        else if(ch===2) obj.preorder(res);
        else if(ch==3) obj.postorder(res);
        else console.log("invalid choice.");
        break;

        case '3' : 
        var res = obj.get_root_node();
        obj.find_minimum(res);
        break;

        case '4' : 
        var res = obj.get_root_node();
        var element = Number(readline.question("enter element to search :"));
        obj.search(res,element);
        break;
    }

}while(choice!='0');