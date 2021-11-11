def palindrome(string):
    i = 0
    j = len(string)-1
    
    while i<=j:
        if string[i] != string[j]:
            return False
        i +=1
        j -=1
    
    return True
    
res = palindrome("madama")

if res == True:
    print("palindrome")
else:
    print("not palindrome")
