var master_string = 'mayurnikhilmayurnikhil';

var master_token = master_string.split('');

var check = "mayur";

var check_token = check.split('');

var s = new Array();

for(var i=0;i<master_token.length;i++) {
    s.push(master_token[i]);
}

var i=0;
var count = 0;
while(i<master_token.length) {
    if(check_token.includes(master_token)!==-1) {
        count++;
        for(var j=0;j<check_token.length;j++) {
            master_token.pop();
        }
    }
    i++;
}

console.log(count);