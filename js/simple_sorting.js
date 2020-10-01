const readline =  require('readline-sync');
const process = require('process');

function bubble_sort(array) {
    
    var temp;

    for(var i=0;i<size;i++) {
        for(var j=i;j<size;j++) {
            if(array[i]>array[j]) {
                temp  = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    console.log("sorted array is : ");
    for(var i=0;i<size;i++) {
            process.stdout.write(array[i]+" ");
        
    }
    console.log();

    return;

}

function insertion_sort(array) {
    
    var temp;

    for(var j=2;j<size;j++) {
        key = array[j];
        i = j-1;
        while(array[i]>key && i>0) {
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = key;
    }

    console.log("sorted array is : ");
    for(var i=0;i<size;i++) {
            process.stdout.write(array[i]+" ");
        
    }
    console.log();

    return;
}

function selection_sort(array) {
    
    var min,temp;

    for(var i=0;i<size;i++) {
        min = i;
        for(var j=i+1;j<size;j++) {
            if(array[j]<array[min]) {
                min = j;
            }
        }
        if(min!=i) {
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    console.log("sorted array is : ");
    for(var i=0;i<size;i++) {
            process.stdout.write(array[i]+" ");
        
    }
    console.log();

    return;

}

// take the input array

var array = new Array();

var size = Number(readline.question("enter the size of array : "));

console.log("enter array of size "+size);

for(var i=0;i<size;i++) {
    array[i] = Number(readline.question());
}

// printing unsorted array
console.log("unsorted array is : ");
for(var i=0;i<size;i++) {
    process.stdout.write(array[i]+" ");
}
console.log();

do {

    console.log("1. bubble sort : ");
    console.log("2. insertion_sort : ");
    console.log("3. selection_sort : ");

    var choice = readline.question("enter the choice : ");

    switch(choice) {
        case '1' : 
        bubble_sort(array);
        break;

        case '2' : 
        insertion_sort(array);
        break;

        case '3' : 
        selection_sort(array);
        break;
    }
}while(choice!='0');
