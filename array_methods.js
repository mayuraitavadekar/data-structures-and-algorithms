
// map function 

var arr = [10,20,30,40];

var new_arr = arr.map(function(x) {
    return x*2;
});

// OR you can

var new_arr = arr.map((x)=> {
    return x*2;
});

// OR you can

var new_arr = arr.map((x) => x*2);

// OR you can

var new_arr = arr.map(x => x*2);

// find method

var new_arr = arr.find(function(x){
    if(x>20) {
        return x;
    }
});
console.log(new_arr);
// find_index

var new_arr = arr.findIndex(function(x) {
    if(x>20) {
        return x;
    }
});
console.log(new_arr);
// filter function

var new_arr = arr.filter(function(x) {
    if(x>20) {
        return x;
    }
});
console.log(new_arr);

// reduce function

var reducer = function(accumulator,curr_value) {
    return accumulator + curr_value;
}

var new_arr = arr.reduce(reducer);
console.log(new_arr);

var new_arr = arr.reduce(reducer,5);
console.log(new_arr);



