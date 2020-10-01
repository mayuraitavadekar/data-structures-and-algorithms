import java.util.*;

public class BST {

    public class Node {
        private int data;
        private Node left;
        private Node right;
    }

    public static Scanner scanner = new Scanner(System.in);
    private Node root;
    private Node newnode;
    private Node temp;

    BST() {

        root = null;
        newnode = null;
        temp = null;
    }

    public void insert() {

    }

    public static void main(String args[]) {

        BST obj = new BST();

        int choice;
        System.out.println("1. insert : ");
        choice = scanner.nextInt();

        if (choice == 1)
            obj.insert();
    }

}
