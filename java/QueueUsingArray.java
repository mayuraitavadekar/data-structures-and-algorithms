// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class QueueUsingArray {
    
    public int front, rear, size;
    public int[] queue;
    
    public QueueUsingArray(int front, int rear, int size)
    {
        this.front = front;
        this.rear = rear;
        this.size = size;
        queue = new int[size];
    }
    
    public void enQueue(int data)
    {
        if(rear == size-1)
        {
            System.out.println("Queue is full");
            return;
        }
        else
        {
            rear++;
            queue[rear] = data;
        }
    }
    
    public int deQueue()
    {
        int removed;
        
        if(front == rear)
        {
            System.out.println("Queue is empty");
            return -1;
        }
        
        else
        {
            removed = queue[front+1];
            front++;
            return removed;
        }
    }
    
    public void display()
    {
        System.out.println();
        
        for(int i=front+1;i<=rear;i++)
        {
            System.out.printf("%d ", queue[i]);
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        QueueUsingArray obj = new QueueUsingArray(-1, -1, 5);
        
        obj.enQueue(10);
        obj.enQueue(20);
        obj.enQueue(30);
        obj.enQueue(40);
        obj.enQueue(50);
        obj.enQueue(60);
        
        System.out.println("removed " + obj.deQueue());
        
        System.out.println("removed " + obj.deQueue());
        
        obj.display();
        
        System.out.println("removed " + obj.deQueue());
        System.out.println("removed " + obj.deQueue());
        System.out.println("removed " + obj.deQueue());
        System.out.println("removed " + obj.deQueue());
    }
}
