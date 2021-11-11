def string_comparision(a, b):
    if len(a) != len(b):
        return False
    
    else:
        for i in range(len(a)):
            if a[i] != b[i]:
                return False
        
        return True
        
a = "painter"
b = "printer"
res = string_comparision(a, b)

if res == True:
    print("the strings are equal.")

else:
    print("strings are not equal.")
