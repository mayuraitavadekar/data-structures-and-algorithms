const readline = require('readline-sync');
const process = require('process');


var arr = new Array();
var brr = new Array();
var result = new Array();
var size = 0;

const get_data = () => {

    size = readline.questionInt('enter the dimension : ');
    
    // matrix creation

    for(var i=0;i<size;i++) {
        arr[i] = new Array();
        brr[i] = new Array();
        result[i] = new Array();
    }

    

    console.log("enter matrix 1 : ");
    for(var i=0;i<size;i++) {
        console.log(`enter the ${i} row : `);
        for(var j=0;j<size;j++) {
            arr[i][j] = readline.questionInt();
        }
    }

    console.log("enter matrix 1 : ");
    for(var i=0;i<size;i++) {
        console.log(`enter the ${i} row : `);
        for(var j=0;j<size;j++) {
            brr[i][j] = readline.questionInt();
        }
    }
}

const add = () => {
    
    for(var i=0;i<size;i++) {
        for(var j=0;j<size;j++) {
            result[i][j] = arr[i][j] + brr[i][j];
        }
    }

    console.log("addition : ");
    for(var i=0;i<size;i++) {
        for(var j=0;j<size;j++) {
            process.stdout.write(result[i][j]+" ");
        }
        console.log();
    }

}

const mult = () => {

    var sum  = 0;

    for(var i=0;i<size;i++) {
        for(var j=0;j<size;j++) {
            sum = 0;
            for(var k=0;k<size;k++) {
                sum = sum + arr[i][k] * brr[k][j];
            }
            result[i][j] = sum;
        }
    }

    console.log("multiplication : ");
    for(var i=0;i<size;i++) {
        for(var j=0;j<size;j++) {
            process.stdout.write(result[i][j]+" ");
        }
        console.log();
    }
}

do {
    
    get_data();
    var choice = readline.questionInt('1. addition 2. multiplication 0. EXIT');
    if(choice===1) add();
    else if(choice===2) mult();
    else console.log('wrong choice.');

}while(choice!=0);
