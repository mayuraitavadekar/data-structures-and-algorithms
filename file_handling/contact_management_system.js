const readline = require('readline-sync');
const process = require('process');
const fs = require('fs');

var att = ['name','roll_number','city','phone_number']; 

function add_record() {

    
    var list = new Array();

    for(var i=0;i<att.length;i++) {
        list[i] = readline.question("enter "+att[i]+" ");    
    }

    fs.appendFile('data.txt','\n',function(err){
        if(err) throw err;
    });

    fs.appendFile('data.txt',list,function(err) {
        if(err) throw err;
        // else
        console.log("Record added!");
    });
}

function update_record() {

    var roll_number = readline.question("enter roll number : ");
    
    var data = fs.readFileSync('data.txt');
    data = data.toString();
    
    var main_list = data.split('\n');
    console.log(main_list);
    
    for(var i=0;i<main_list.length;i++) {
        var list = main_list[i];
        sub_list = list.split(',');
        if(sub_list[1]!=roll_number) {
            
            fs.appendFile('temp.txt','\n',function(err){
                if(err) throw err;
            });

            fs.appendFile('temp.txt',main_list[i],function(err){
                if(err) throw err;
            });
        }
        else if(sub_list[1]===roll_number) {
            
            // take new data

            var new_data = new Array();

            for(var i=0;i<att.length;i++) {
                new_data[i] = readline.question("enter "+att[i]+" ");
            }

            fs.appendFile('temp.txt','\n',function(err){
                if(err) throw err;
            });

            // add this list to temp
            fs.appendFile('temp.txt',new_data,function(err){
                if(err) throw err;
            });

            fs.appendFile('temp.txt','\n',function(err){
                if(err) throw err;
            });
        }
    }

    fs.unlink('data.txt',function(err){
        if(err) throw err;
    });

    fs.rename('temp.txt','data.txt',function(err){
        if(err) throw err;
    });
    
}

function delete_record() {

    var roll_number = readline.question("enter roll number : ");

    var count=0;

    var data = fs.readFileSync('data.txt');
    data = data.toString();

    var main_list = data.split('\n');

    for(var i=0;i<main_list.length;i++) {
        var list = main_list[i];
        var sub_list = list.split(',');
        if(sub_list[1]!=roll_number) {

            fs.appendFile('temp.txt','\n',function(err){
                if(err) throw err;
            });

            fs.appendFile('temp.txt',main_list[i],function(err){
                if(err) throw err;
            });

            count++;
        }
   }

    if(count===main_list.length) {
        console.log("record not present.");
        // deleting temp.txt file
        fs.unlink('temp.txt',function(err){
            if(err) throw err;
        });
    }
    else {
        fs.unlink('data.txt',function(err){
            if(err) throw err;
        });
    
        fs.rename('temp.txt','data.txt',function(err){
            if(err) throw err;
        });
    
        console.log("deleted.");
    }
}

function display() {

    var data = fs.readFileSync('data.txt');
    console.log(data.toString());

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