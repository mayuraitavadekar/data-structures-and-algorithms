const readline = require('readline-sync');

var name;

var arr = new Array();

for(var i=0;i<3;i++) {
    arr[i] = new Array();
}

console.log("enter array : ");

for(var i=0;i<3;i++) {
    for(var j=0;j<3;j++) {
        name = readline.question("enter name : ");
        arr[i][j] = name;
    }
}

console.log(arr);

for(var i=0;i<3;i++) {
        for(var j=0;j<3;j++) {
            console.log(arr[i][j]);
        }
}