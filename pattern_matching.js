const readline = require('readline-sync');
const process = require('process');

var main_string = readline.question('enter the string  : ');

var main_token = main_string.split('');

console.log(main_token);

var search_pattern = readline.question('enter pattern to search : ');

var search_token = search_pattern.split('');

console.log(search_token);

var flag = false;

// search_token = j; main_token = i;

var i=0,j=0,count=0;

/*
if(search_pattern.includes(main_string)!==-1) console.log('matched.');
else console.log('not matched.');
*/

while(i<main_token.length) {
    count = 0; j = 0;
    while(j<search_token.length) {
        if(main_token[i]===search_token[j]) {
            count++;
            i++;
            j++
            if(count===search_token.length) {
                console.log("matched.");
                process.exit(1);
            }
        }
        else {
            i++;
            j=0;
        }
    }
}