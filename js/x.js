const readline = require('readline-sync');
const process = require("process");

class Node {
    constructor () {
        this.data = null;
        this.next = null;
        this.arr = new Array();
    }
}

class GRAPH {

    constructor() {
        this.points = 0;

        // initialise matrix
        this.matrix = new Array();
        for(let i=0;i<this.points;i++) {
            this.matrix[i] = new Array();
        }

    }

    getdata = () => {

        this.points = readline.questionInt("enter no of points : ");
        
        for(let i=0;i<this.points;i++) {
            process.stdout.write("enter the row "+(i+1));
            for(let j=0;j<this.points;j++) {
                this.matrix[i][j] = readline.questionInt();
            }
        }

        
        console.log("MATRIX");

        for(let i=0;i<this.points;i++) {
            for(let j=0;j<this.points;j++) {
                process.stdout.write(this.matrix[i][j]);
            }
            console.log();
        }

    }


}

// DRIVER CODE 
const obj = new GRAPH();

do {
    console.log("1. enter the graph : ");

    choice = readline.questionInt();
    switch(choice) {
        case 1 :
            obj.getdata();
            break;
    }
}while(choice!=0);
