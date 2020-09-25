const readline = require('readline-sync');

class Node {
    constructor() {
        this.data = null;
        this.next = null;
    }
}

class QueueUsingLinkList {
    constructor() {
        this.front = null;
        this.rear = null;
        this.new_node = null;
        this.size = 0;
    }

    enQueue() {
        var data = Number(readline.question("enter the data : "));
        // creating new node;
        this.new_node = new Node();
        this.new_node.data = data;
        
        if(this.size===5) {
            console.log("queue is full");
            return;
        }

        else if(this.front===null && this.rear===null) {
            // queue is empty
            this.front = this.new_node;
            this.rear = this.new_node;
        }
        else {
            this.rear.next = this.new_node;
            this.rear = this.rear.next;
            this.size++;
        }

    }

    deQueue() {
        if (this.size===-1) {
            console.log("queue is empty");
            return;
        }
        else {
            var element = this.front.data;
            this.front = this.front.next;
            console.log(element+" removed.");
            this.size--;
        }
    }

    display() {
        if(this.size===-1) {
            console.log("cannot display empty queue.");
            return;

        }
        // else display this.
        var temp = this.front;
        while(temp!=this.rear) {
            console.log(temp.data);
            temp = temp.next;
        }
        console.log(temp.data);
        return;
    }
}

var obj = new QueueUsingLinkList(); // obj is pointing to class

do {
    console.log("1. add element in queue : ");
    console.log("2. remove element from queue : ");
    console.log("3. display queue : ");

    var choice = readline.question("enter choice : ");

    switch(choice) {
        case '1' : 
            obj.enQueue();
            break;
        
        case '2' : 
            obj.deQueue();
            break;

        case '3' :
            obj.display();
            break;
    }
}while(choice!='0');
