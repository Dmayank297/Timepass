
public class Linked {
    Node head;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
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
        
        head = head.next;
    }

    public void deleteLast() {
        Node temp = head.next;
        Node prev = head;
        if(head == null) {
            System.out.println("NOthing to delete");
            return;
        }

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

    public static void main(String[] args) {
        Linked list = new Linked();
        list.addFirst("first");
        list.addFirst("this");
        list.printList();

        list.addLast("time");
        list.addLast("trying");
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();
    }
}
