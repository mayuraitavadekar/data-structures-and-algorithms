def check_anagrams(a, b):
    
    if len(a) != len(b):
        return False
    
    for item in a:
        if item not in b:
            return False
            
    return True
    
a = "medical"
b = "decimal"
res = check_anagrams(a,b)

if res == True:
    print("yes, anagrams")
else:
    print("no, not anagrams")
