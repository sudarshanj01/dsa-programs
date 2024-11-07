package c_linked_list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

    public static void main(String[] args) {

        // Built-in LinkedList
        List<Integer> list = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        list.iterator().forEachRemaining(System.out::println);
        System.out.println("Built-in LinkedList: " + list);

        // Custom LinkedList
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(1);
        myLinkedList.insert(2);
        myLinkedList.insert(3);
        myLinkedList.insert(4);
        myLinkedList.insert(2);

        System.out.println(myLinkedList);

    }
}