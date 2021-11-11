def validate_user_name(username):
    # user name should only contain lower case and upper case letters and numbers
    
    username = username.lower()
    
    chars_username = list(username)
    
    for item in chars_username:
        if ((ord(item)>=97 and ord(item)<=122) or (ord(item)>=65 and ord(item)<=90) or ((ord(item)>=48 and ord(item)<=57))):
            continue
        else:
            return False
    
    return True
    

res = validate_user_name("Mayur123")

if res == True:
    print("valid username")

else:
    print("invalid username")

