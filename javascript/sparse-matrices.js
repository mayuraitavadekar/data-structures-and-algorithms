const readline = require('readline-sync');
const process = require('process');

function main() {

    // matrix creation
    var size = readline.questionInt("enter the size of matrix : ");
    
    var arr = new Array();

    for(var i=0;i<size;i++) {
        arr[i] = new Array;
    }

    // square matrix has been created;

    console.log("enter the matrix elements : ");

    for(var i=0;i<size;i++) {
        console.log("enter the row : "+i);
        for(var j=0;j<size;j++) {
            arr[i][j] = readline.questionInt();
        }
    }

    console.log("entered matrix is : ");
    for(var i=0;i<size;i++) {
        for(var j=0;j<size;j++) {
            process.stdout.write(arr[i][j]+" ");
        }
        console.log();
    }

    // sparse operations started;

    var non_zero_count = 0;

    for(var i=0;i<size;i++) {
        for(var j=0;j<size;j++) {
            if(arr[i][j]!=0) {
                non_zero_count++;
            }
        }
    }

    // sparse matrix creation

    var sparse_matrix = new Array();

    for(var i=0;i<3;i++) {
        sparse_matrix[i] = new Array(non_zero_count); 
    }

    // enetering values in sparse matrix

    var k=0;

    for(var i=0;i<size;i++) {
        for(var j=0;j<size;j++) {
            if(arr[i][j]!=0) {
                sparse_matrix[0][k] = i;
                sparse_matrix[1][k] = j;
                sparse_matrix[2][k] = arr[i][j]; // actual element in third row
                k++;
            }
        }
    } 

    // printing required sparse matrix
    var att = ['row','column','element'];

    for(var i=0;i<3;i++) {
        process.stdout.write(att[i]+"\t");
        for(var j=0;j<non_zero_count;j++) {
            process.stdout.write(sparse_matrix[i][j]+" ");
        }
        console.log();
    }
}

main();
