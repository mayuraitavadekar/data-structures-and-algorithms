// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class CircularQueue {
    
    public int front, rear, size;
    public int[] queue;
    
    
    public CircularQueue(int front, int rear, int size)
    {
        this.front = front;
        this.rear = front;
        this.size = size;
        queue = new int[size];
    }
    
    public void enqueue(int data)
    {
        if(front == (rear+1) % size)
        {
            System.out.println("Queue is full");
            return;
        }
        else
        {
            rear = (rear+1)%size;
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
            front = (front+1) % size;
            removed = queue[front];
        }
        
        return removed;
    }
    
    public void display()
    {
        if(front == rear)
        {
            System.out.println("Queue is empty");
            return;
        }
        
        int i = (front+1) % size;
        
        do
        {
            System.out.printf("%d ", queue[i]);
            i = (i+1) % size;
        }
        while(i != (rear+1) % size);
    
        System.out.println();
    }
    
    public static void main(String[] args) {
        
        CircularQueue obj = new CircularQueue(0,0,5);
        
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.enqueue(40);
        obj.enqueue(50); // cannot store
        obj.display();
        
        System.out.println("removed "+obj.deQueue());
        
        obj.enqueue(10);
        
        obj.display();
        
    }
}
