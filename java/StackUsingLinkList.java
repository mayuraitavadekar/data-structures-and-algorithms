import java.util.*;

public class StackUsingLinkList {

    // declaring Node class
    private class Node {
        int data;
        Node next;
    }

    // declare required varibales
    public static Scanner scanner = new Scanner(System.in);
    private Node head;
    private Node newnode;

    // initialising using constructor
    StackUsingLinkList() {
        head = null;
        newnode = null;
    }

    // push function
    public void push() {

        System.out.println("enter element : ");
        int element = scanner.nextInt();

        if (head == null) {
            newnode = new Node();
            newnode.data = element;
            newnode.next = null;
            head = newnode; // allocated space is given to head
        }

        else {
            newnode = new Node();
            newnode.data = element;
            newnode.next = null;

            newnode.next = head;
            head = newnode; // allocated space is given to head
        }

        System.out.println("pushed.");
    }

    // pop function
    public int pop() {

        if (head == null) {
            System.out.println("stack is empty.");
            return -1;
        }
        int element = head.data;
        head = head.next;

        return element;

    }

    // display function
    public void display() {

        Node temp;
        temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    // driver code
    public static void main(String args[]) {

        int choice;
        int element;

        StackUsingLinkList obj = new StackUsingLinkList();

        do {
            System.out.println("1. push : ");
            System.out.println("2. pop : ");
            System.out.println("3. display : ");

            choice = scanner.nextInt();

            switch (choice) {
            case 1:
                obj.push();
                break;

            case 2:
                element = obj.pop();
                if (element != -1) {
                    System.out.println(element + " popped.");
                }
                break;

            case 3:
                obj.display();
                break;
            }

        } while (choice != 0);
    }
}
