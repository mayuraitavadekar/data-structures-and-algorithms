class Stack:
    
    pivote = -1
    stack = []
    size = 5
    
    def is_empty(self):
        if self.pivote > -1:
            return False
        
        return True
    
    def is_full(self):
        if self.pivote == self.size-1:
            return True
            
        return False
    
    def push(self, num):
        self.pivote += 1
        self.stack.insert(self.pivote, num)
        
    def pop(self):
        self.pivote -= 1
    
    def print_stack(self):
        for i in range(self.pivote+1):
            print(self.stack[i], end=" ")
        
        print("\n")
        
obj = Stack()
while True:
    print("1. push", end="\n")
    print("2. pop", end="\n")
    print("3. print", end="\n")
    print("0. EXIT", end="\n")
    
    ans = int(input())
    
    if ans == 1:
        res = obj.is_full()
        if res != True:
            num = int(input("enter number : "))
            obj.push(num)
        else:
            print("stack is full. pop() some elements")
        continue
    
    elif ans == 2:
        res = obj.is_empty()
        if res != True:
            obj.pop()
        else:
            print("stack is empty. Push() some elements")
        continue
    
    elif ans == 3:
        obj.print_stack()
        continue
    
    else:
        break
