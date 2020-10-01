const readline = require("readline-sync");

class Queue {
    constructor() {
        this.arr = [];
        this.rear = -1;
        this.front = -1;
        this.size = 5; // static initially;
    }

    enQueue() {

        var element = Number(readline.question("enter : "));
        if(this.rear-this.front===this.size-1) {
            console.log("Queue is full.");
            return;
        }

        else if(this.rear===-1 && this.front===-1) {
            // queue is empty
            this.rear++;
            this.front++;
            this.arr[this.rear] = element;
        }
        else {
            // queue is not empty; only increment rear
            this.rear++;
            this.arr[this.rear] = element;
        }
    }

    deQueue() {

        if(this.front>this.rear) {
            console.log("the queue is empty.");
            // reset front and rear;
            return;
        }
            
        else {
            var element = this.arr[this.front]; // getting front element;
            this.front++;
            console.log(element+" removed.");
        }
        
    }

    display() {
        for(var i=this.front;i<=this.rear;i++) {
            console.log(this.arr[i]);
        }
    }
}

var obj = new Queue();

do {
    console.log("1. add element : ");
    console.log("2. delete element : ");
    console.log("3. display element : ");

    var choice = readline.question("enter the choice : ");

    switch(choice) {
        case '1'  :
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

