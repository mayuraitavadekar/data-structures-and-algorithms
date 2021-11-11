def find_duplicates(string):
    
    # declare dict
    dictx = {}
    
    for item in string:
        # get count
        count = string.count(item)
        dictx[item] = count
    
    print(dictx)
    
    # traverse dictionary
    for key in dictx:
        if dictx[key] > 1:
            print("{} is occurred {} times".format(key, dictx[key]))
    
    
find_duplicates("alphabets")
