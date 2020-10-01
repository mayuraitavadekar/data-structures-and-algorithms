const readline = require('readline-sync');
const process = require('process');
const fs = require('fs');

var global_id = 1;

function add() {

    // getting data
    var name = readline.question("name : ");
    var roll_number = readline.question("roll number : ");
    var city = readline.question("city : ");
    var phone_number = readline.question("phone number : ");

    var list = global_id+"\t"+name+"\t"+roll_number+"\t"+city+"\t"+phone_number;

    fs.appendFile('data.txt',list,function(err) {
        if(err) console.log("error occurred while writing record into file.");
        // else
        console.log("Record added!");
    });
}

do {
    console.log("\t\tSTUDENT RECORD SYSTEM\t\t");
    console.log("1. ENTER RECORD ");
    console.log("2. UPDATE RECORD");
    console.log("3. DELETE RECORD");
    console.log("4. DISPLAY ALL RECORD");
    console.log("0. EXIT");
    var choice = Number(readline.question());

    switch(choice) {
        case 1 :
        add_record();
        break;

        case 2 : 
        update_record();
        break;

        case 3 : 
        delete_record();
        break;
        
        case 4 : 
        display();
        break;
    }
}while(choice!=0);