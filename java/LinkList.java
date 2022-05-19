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
    
    public void reverse(Node current)
    {
        if(head == null)
        {
            System.out.println("linklist is empty");
            return;
        }
        
        // breaking condition
        if(current.next == null)
        {
            System.out.print(current.data + " ");
            return;
        }
        reverse(current.next);
        System.out.print(current.data + " ");
    }
    
    public void deleteFromStart()
    {
        if(head == null)
        {
            System.out.println("linklist is empty");
            return;
        }
        
        else
        {
            if(head == tail)
            {
                // only one node is available
                head = tail = null;
            }
            else
            {
                head = head.next;
            }
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
        
        System.out.println("print linklist in reverse order");
        obj.reverse(obj.head);
        System.out.println("delete from start");
        obj.deleteFromStart();
        obj.display();
    }
}
