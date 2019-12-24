const readline = require('readline-sync');
const process = require('process');

function merge(arr,l,m,r) {

    var n1,n2,i,j,k;
    n1 = m-l+1;
    n2 = r-m;

    var left = new Array();
    var right = new Array();

    // copying data into left and right
    for(var i=0;i<n1;i++) {
        left[i] = arr[l+i];
    }

    for(var j=0;j<n2;j++) {
        right[j] = arr[m+1+j];
    }

    i=0,j=0,k=0;

    while(i<n1 && j<n2) {
        if(left[i]<right[j]) {
            arr[k++] = left[i++];
        }
        else{
            arr[k++] = right[j++];
        }
    }

    // copy remaining elements
    while(i<n1) {
        arr[k++] = left[i++];
    }
    while(j<n2) {
        arr[k++] = right[j++];
    }

} 

function merge_sort(arr,l,r) {

    if(l<r) {
        var mid = (l+r)/2;
        
        merge_sort(arr,l,mid);
        merge_sort(arr,mid+1,r);

        merge(arr,l,mid,r);
    }
}


var arr = new Array();

var size = Number(readline.question("enter the size : "));

console.log("enter the array of size "+size);

for(var i=0;i<size;i++) {
    arr[i] = Number(readline.question());
}

console.log("unsorted array is : ");

for(var i=0;i<size;i++) {
    process.stdout.write(arr[i]+" ");
}
console.log();

// calling merge_sort_function

var result = merge_sort(arr,0,size-1);

console.log("the sorted array is : ");
    
for(var i=0;i<arr.length;i++) {
    process.stdout.write(arr[i]+" ");
}
console.log();

// end;