const readline = require('readline-sync');
const process = require('process');
const perf = require('execution-time')();


function binary_search(arr,left,right,element) {

    if(left<=right) {

        var mid = (left+right)/2;

        if(arr[mid]===element) {
            return 1;
        }

        else if(element<arr[mid]) {
            binary_search(arr,left,mid-1,element);
        }
        
        return binary_search(arr,mid+1,right,element);
    }

    return 0;

}

var arr = [30,40,50,60,10,20];
var temp = 0;

for(var i=0;i<arr.length;i++) {
    for(var j=i+1;j<arr.length;j++) {
        if(arr[i]>arr[j]) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}


console.log(arr);

var element = readline.questionInt("enter element : ");

console.log(element);

var result = binary_search(arr,0,arr.length-1,element);

if(result===1) console.log("element found.");   
else console.log("element not found.");


 