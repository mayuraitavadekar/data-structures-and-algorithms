// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class QueueUsingLinkedList {
    
    class Node
    {
        int data;
        Node next;
    }
    
    public Node front, rear;
    
    public QueueUsingLinkedList()
    {
        front = null;
        rear = null;
    }
    
    public void enQueue(int data)
    {
        // create node
        Node node = new Node();
        
        if(node == null)
        {
            System.out.println("Queue is full");
        }
        else
        {
            node.data = data;
            node.next = null;
            
            if(front == null)
            {
                // queue is empty till now
                front = node;
                rear = node;
            }
            else
            {
                rear.next = node;
                rear = node;
            }
        }
    }
    
    public int deQueue()
    {
        int removed = -1;
        
        if(front == null)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            removed = front.data;
            Node temp = front;
            front = front.next;
            temp.next = null;
        }
        
        return removed;
    }
    
    public void display()
    {
        Node current = front;
        
        if(current == null)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            while(current != null)
            {
                System.out.printf("%d ", current.data);
                current = current.next;
            }
            
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        QueueUsingLinkedList obj = new QueueUsingLinkedList();
        obj.enQueue(10);
        obj.enQueue(20);
        
        obj.display();
        
        obj.deQueue();
        obj.deQueue();
        
        obj.display();
    }
}
