import java.util.LinkedList;
import java.util.Scanner;

public class Linked {
    Node head;
    private int size;

    Linked() {
        this.size = 0;
    }

    class Node {
        String data;
        int data2;
        Node next;
        
        Node(int data) {
            this.data2 = data;
        }
        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    //add - first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void printList() {
        Node temp = head;
        if(head == null) {
            System.out.println(head.data);
            return;
        }
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void deleteFirst() {
        if(head == null) {
            System.out.println("Nothing to delete");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast() {
        Node temp = head.next;
        Node prev = head;
        if(head == null) {
            System.out.println("NOthing to delete");
            return;
        }
        size--;
        if(head.next == null) {
            head = null;
            return;
        }
 

        while(temp.next != null) {
            temp = temp.next;
            prev = prev.next;
        }
        prev.next = null;

    }

    public int getSize() {
        return this.size;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        int[] arr = {1, 5, 6, 65,43,54,32,64,67,432,876,445,346,547,547,56,7865,756};

        
        
    }
}