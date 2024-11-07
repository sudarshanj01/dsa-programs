package c_linked_list;

class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}

public class MyLinkedList {
    private Node head;
    private Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public void insert(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void insertAtStart(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            insert(value);
        } else {
            node.next = head;
            head = node;
        }
    }


    public void insertAt(int index, int value) {
        Node node = new Node(value);
        Node current = head;
        Node prev = null;

        if (isEmpty()) {
            insert(value);//can throw error
        } else {
            while (index > 0 && current != null) {
                prev = current;
                current = current.next;
                index--;
            }
            prev.next = node;
            node.next = current;
        }
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public int sum() {
        Node current = head;
        int sum = 0;
        while (current != null) {
            sum = sum + current.data;
            current = current.next;
        }
        return sum;

    }

    public int indexOf(int value) {
        int index = 0;
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = head.next;  

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;
        head = current;
    }


    public Node reverseRec(Node head) {
        if (head == null || head.next == null) return head;

        Node newHead = reverseRec(head.next);
        Node temp = head.next;
        temp.next = head;
        head.next = null;

        return newHead;
    }

    public void reverseRec() {
        head = reverseRec(head);
    }


    public void deleteFirstNode() {
        if (isEmpty()) return;

        Node temp = head;
        head = head.next;
        temp.next = null;

    }

    public void deleteLastNode() {
        if (isEmpty()) return;

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }


    @Override
    public String toString() {
        Node current = head;
        StringBuilder result = new StringBuilder();
        result.append("[");

        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    //same toString fun using recursion
    public void newToString(Node head) {
        if (head == null) return;
        System.out.print(head.data + ",");
        newToString(head.next);
    }

    public void newToString() {
        newToString(head);
    }

}