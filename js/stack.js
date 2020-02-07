const readline = require('readline-sync');

class stack {
    
    constructor() {
        this.arr = []; // var arr = new Array()
        this.top = -1; // intitially
        this.size = 10; // static declared size
    }

    push() {
        if(this.top>=this.size-1) {
            console.log("cannot push!! Stack Full!!");
        }
        else {
            var data = Number(readline.question("enter data : "));
            this.top++;
            this.arr[this.top] = data;
        }
        
    }

    pop() {
        if(this.top===-1) {
            console.log("cannot pop!! Stack Empty!!");
        }
        else {
            var data = this.arr[this.top];
            console.log(data+" removed.");
            this.top--;
        }
        
    }

    display() {
        for(var i=this.top;i>=0;i--) {
            console.log(this.arr[i]);
        }
    }

}

var obj = new stack();

do {
    console.log("1. push");
    console.log("2. pop");
    console.log("3. display");

    var choice = readline.question("enter choice : ");

    switch(choice) {
        case '1' : 
        obj.push();
        break;

        case '2' : 
        obj.pop();
        break;

        case '3' : 
        obj.display();
        break;
    }
}while(choice!='0');
