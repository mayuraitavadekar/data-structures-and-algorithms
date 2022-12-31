class Node:
    def __init__(self, dataval, nextval=None):
        self.dataval = dataval
        self.nextval = None
        
class LinkedList:
    def __init__(self):
        self.head = None 
        self.tail = None 
        self.curr = None
    
    def insert_at_end(self, dataval):
        
        newNode = Node(dataval)
        
        if self.head == None:
            self.tail = newNode
            self.head = newNode
        else:
            self.tail.nextval = newNode
            self.tail = newNode
    
    def printLinkedList(self):
        self.curr = self.head
        while(self.curr != None):
            print(self.curr.dataval)
            self.curr = self.curr.nextval

""" main """

linklist = LinkedList()

linklist.insert_at_end(10)
linklist.insert_at_end(20)
linklist.insert_at_end(30)
linklist.insert_at_end(-20)

linklist.printLinkedList()




