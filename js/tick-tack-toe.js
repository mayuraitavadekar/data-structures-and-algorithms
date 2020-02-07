const readline = require('readline-sync');
const process = require('process');


var matrix = new Array();
var size = 3;



const create_matrix = () => {
        
    for(var i=0;i<size;i++) {
        matrix[i] = new Array();
    }

    for(var i=0;i<size;i++) {
        for(var j=0;j<size;j++) {
            matrix[i][j] = 'x';
        }
    }
}

const entries = () => {

    do {

        for(var i=0;i<size;i++) {
            for(var j=0;j<size;j++) {
                process.stdout.write(matrix[i][j]+" ");
            }
            console.log();
        }

        var val_1 = readline.questionInt('user 1 : ');
        switch(val_1) {
            case 1 : matrix[0][0] = 0; break;
        
            case 2 : matrix[0][1] = 0; break;

            case 3 : matrix[0][2] = 0; break;

            case 4 : matrix[1][0] = 0; break;
            
            case 5 : matrix[1][1] = 0; break;
            
            case 6 : matrix[1][2] = 0; break;
        
            case 7 : matrix[2][0] = 0; break;

            case 8 : matrix[2][1] = 0; break;

            case 9 : matrix[2][2] = 0; break;
        }
        
        var val_2 = readline.questionInt('user_2 : ');

        switch(val_2) {
            case 1 : matrix[0][0] = 1; break;
        
            case 2 : matrix[0][1] = 1; break;

            case 3 : matrix[0][2] = 1; break;

            case 4 : matrix[1][0] = 1; break;
            
            case 5 : matrix[1][1] = 1; break;
            
            case 6 : matrix[1][2] = 1; break;
        
            case 7 : matrix[2][0] = 1; break;

            case 8 : matrix[2][1] = 1; break;

            case 9 : matrix[2][2] = 1; break;
        }

        // checking cases

        if(matrix[0][0]===matrix[0][1] && matrix[0][1]===matrix[0][2] && matrix[0][0]===0) {console.log("user 1 won");break;}
        else if(matrix[0][0]===matrix[0][1] && matrix[0][1]===matrix[0][2] && matrix[0][0]===1) {console.log("user 2 won");break;}

        else if(matrix[1][0]===matrix[1][1] && matrix[1][1]===matrix[1][2] && matrix[1][0]===0) {console.log("user 1 won");break;}
        else if(matrix[1][0]===matrix[1][1] && matrix[1][1]===matrix[1][2] && matrix[1][0]===1) {console.log("user 2 won");break;}

        else if(matrix[2][0]===matrix[2][1] && matrix[2][1]===matrix[2][2] && matrix[2][0]===0) {console.log("user 1 won");break;}
        else if(matrix[2][0]===matrix[2][1] && matrix[2][1]===matrix[2][2] && matrix[2][0]===1) {console.log("user 2 won");break;}
    
        else if(matrix[0][0]===matrix[1][0] && matrix[1][0]===matrix[2][0] && matrix[0][0]===0) {console.log("user 1 won");break;}
        else if(matrix[0][0]===matrix[1][0] && matrix[1][0]===matrix[2][0] && matrix[0][0]===1) {console.log("user 2 won");break;}

        else if(matrix[0][1]===matrix[1][1] && matrix[1][1]===matrix[2][1] && matrix[0][1]===0) {console.log("user 1 won");break;}
        else if(matrix[0][1]===matrix[1][1] && matrix[1][1]===matrix[2][1] && matrix[0][1]===1) {console.log("user 2 won");break;}

        else if(matrix[0][2]===matrix[1][2] && matrix[1][2]===matrix[2][2] && matrix[0][2]===0) {console.log("user 1 won");break;}
        else if(matrix[0][2]===matrix[1][2] && matrix[1][2]===matrix[2][2] && matrix[0][2]===1) {console.log("user 2 won");break;}
        
    
        else {
            var count = 0;
            for(var i=0;i<size;i++) {
                for(var j=0;j<size;j++) {
                    if(i===j) {
                        if(matrix[i][j]===0) count++;
                    }
                }
            }

            if(count===3) {
                console.log('user 1 won.'); process.exit(1);
            }

            count=0;
            for(var i=0;i<size;i++) {
                for(var j=0;j<size;j++) {
                    if(i===j) {
                        if(matrix[i][j]===1) count++;
                    }
                }
            }
            if(count===3) {
                console.log('user 2 won.'); process.exit(1);
            }

            count=0;
            for(var i=0;i<size;i++) {
                for(var j=0;j<size;j++) {
                    if((i+j)===size-1) {
                        if(matrix[i][j]===0) count++;
                    }
                }
            }
            if(count===3) {
                console.log("user 1 won"); process.exit(1);
            }

            count=0;
            for(var i=0;i<size;i++) {
                for(var j=0;j<size;j++) {
                    if((i+j)===size-1) {
                        if(matrix[i][j]===1) count++;
                    }
                }
            }
            if(count===3) {
                console.log("user 2 won"); process.exit(1);
            }
        }
            
    }while(1);
}

const main = () => {

    var user1 =0, user2 = 1;
    console.log(`user 1 will play with ${user1} and user 2 will play with ${user2}`);

    create_matrix();
    entries();
}

main ();
