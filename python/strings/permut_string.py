import itertools

c = itertools.permutations("ABC", r=3)

for item in c:
    print("".join(item))
