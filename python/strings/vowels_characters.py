# counts vowels and characters in string

string = "Hi Mayur, How are you bro!!"

print("length of string is {}".format(len(string)))

list_of_chars = list(string)

print(list_of_chars)

for i in range(len(list_of_chars)):
    list_of_chars[i] = list_of_chars[i].lower()
    
print(list_of_chars)

vowel_count = 0
character_count = 0

for item in list_of_chars:
    if item == 'a' or item == 'e' or item == 'i' or item =='o' or item =='u':
     vowel_count += 1
    
    if (ord(item) >=97 and ord(item)<=122):
        character_count += 1

print("vowel count is {}".format(vowel_count))
print("character count is {}".format(character_count))


