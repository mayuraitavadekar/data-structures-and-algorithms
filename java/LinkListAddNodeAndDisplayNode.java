// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class LinkList {
    
    class Node
    {
        int data;
        Node next;
    
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
        
    }
    
    public Node head = null;
    public Node tail = null;
    
    public void addNode(int data)
    {
        Node newNode = new Node(data);
        
        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public void display()
    {
        Node current = head;
        
        if(head == null || current == null)
        {
            System.out.println("linklist is empty");
            return;
        }
        
        while(current!=null)
        {
            System.out.print(current.data+" ");
            current = current.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkList obj = new LinkList();
        obj.display();
        obj.addNode(10);
        obj.addNode(20);
        obj.addNode(30);
        obj.display();
        obj.addNode(40);
        obj.display();
    }
}
