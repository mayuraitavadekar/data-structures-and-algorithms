class Node:
    def __init__(self, dataval, nextval=None):
        self.dataval = dataval
        self.nextval = None
        
class LinkedList:
    def __init__(self):
        self.head = None 
        
    
""" main start here """

# create three nodes and make link list
node1 = Node(10)
head = node1 

node2 = Node(20)
node1.nextval = node2

node3 = Node(30)
node2.nextval = node3


# print dataval of nodes
curr = head
while(curr != None):
    print(curr.dataval)
    curr = curr.nextval



