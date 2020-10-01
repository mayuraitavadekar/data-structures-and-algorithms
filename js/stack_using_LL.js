const readline = require('readline-sync');

class Node {
    constructor() {
        this.data = null;
        this.next = null;
    }
}

class linked_list_stack {
    constructor() {
        this.head = null;
        this.root = null;
        this.newnode = null;
    }

    push() {
        
        var element = Number(readline.question("enter data : "));
        // creating new node
        this.newnode = new Node();  // new node will point to class Node
        this.newnode.data = element; // newnode.next = null
        
        if(this.head===null) {
            this.head = this.newnode;
        }
        else {
            this.newnode.next = this.head
            this.head = this.newnode;
        }
    }

    pop() {
        if(this.head===null) {
            console.log("stack underflow!!");
        }
        this.head = this.head.next;  // just decremented head
    }

    display() {
        var temp = this.head;
        if(this.head===null) {
            console.log("stack underflow!!");
        }
        while(temp!=null) {
            console.log(temp.data);
            temp = temp.next;
        }
    }

    getpeek() {
        console.log("peek is = "+this.head.data);
        return;
    }
}

var obj = new linked_list_stack();

do {
    console.log("1. push : ");
    console.log("2. pop : ");
    console.log("3. get peek element : ");
    console.log("3. display : ");

    var choice = readline.question("enter choice : ");
    switch(choice) {
        case '1' :
            obj.push();
            break;

        case '2' : 
            obj.pop();
            break;

        case '3' :
            obj.getpeek();
            break;

        case '4' : 
            obj.display();
            break;
    }
}while(choice!='0');