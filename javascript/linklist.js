const readline = require('readline-sync');

class Node {

    constructor() {
        this.data;
        this.next = null;
    }
}

class linklist {

    constructor() {
        this.head = null;
        this.new_node = null;
        this.current = null;
        this.size = 0;
    }

    append(element) {
                
        this.new_node = new Node();
        this.new_node.data = element;

        if(this.head===null) {
            this.head = this.new_node;
        }
        else {
            this.current = this.head;
            while(this.current.next) {
                this.current = this.current.next;
            }
            this.current.next = this.new_node;
        }
        this.size++;
    }

    insert_begening(element) {

        this.new_node = new Node(); // created new node
        this.new_node.data = element; // put data into node
        this.new_node.next = this.head; // new_node -> next = head
        this.head = this.new_node; // head = new_node
        this.size++;
    }

    remove(pos) {

        var pos = Number(pos);
        var curr,prev;
        curr = this.head;
        
        if(pos>this.size) {
            console.log("invalid");
        }
        else if(pos===1) {
            console.log("removed element : "+curr.data);
            curr = curr.next;
            this.head = curr;
        }
        else {
            for(var i=0;i<pos-1;i++) {
                prev = curr
                curr = curr.next;
            }
            prev.next = curr.next;
            console.log("removed element : "+curr.data);
        }
        this.size--;

    }

    insertAt(pos) {
        
        var pos = Number(pos);
        var curr,prev;

        this.new_node = new Node();
        var element = readline.question("enter the data into node : ");
        this.new_node.data = element;

        if(pos==1) {
            // insert at begining
            this.new_node.next = this.head;
            this.head = this.new_node;
        }
        else {
            // at any other position
            curr = this.head;
            for(var i=0;i<pos-1;i++) {
                prev = curr;
                curr = curr.next;
            }
            this.new_node.next = curr;
            prev.next = this.new_node;
        }
        this.size++;
    }

    search_element() {
        
        var curr;

        var element = readline.question("enter the element to search : ");

        curr = this.head;
        var loc = 0,flag=0;
        while(curr) {
            if(curr.data===element) {
                flag=1;
            }
            loc++;
            curr = curr.next;
        }
        if(flag!=0) {
            console.log("element found at location = "+loc);
        }
        else {
            console.log("element not found!");
        }
        
    }

    display() {

        var temp = null;
        temp = this.head;
        while(temp.next) {
            console.log(temp.data);
            temp = temp.next;
        }
        console.log(temp.data);
    }


}

// creating object of class
var obj = new linklist();

do {

    console.log("1. add at end : ");
    console.log("2. insert at begining : ");
    console.log("3. remove from pos : ")
    console.log("4. insert at pos  ");
    console.log("5. display : ");
    console.log("6. search element : ");
    console.log("0. EXIT ");

    var choice = readline.question();

    switch(choice) {
        case '1' :
                var data = readline.question("enter data into node : ");
                obj.append(data);
                break;
        
        case '2' :
                var data = readline.question("enter the data into node : ");
                obj.insert_begening(data);
                break;

        case '3' :
                var pos = readline.question("enter the position : ");
                obj.remove(pos);
                break;

        case '4' :
                var pos = readline.question("enter the position : ");
                obj.insertAt(pos);
                break;

        case '5' : 
                obj.display();
                break;

        case '6' : 
                obj.search_element();
                break;
    }

}while(choice!='0');
