package org.dsa.practice.linkedlist;

public class InsertLinkedListOperations {
    static void main() {
        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(10);
        list.add(8);
        list.add(32);
        list.add(2);

        list.addAtFirst(100);

        list.print();



        list.addAtIndex(3, 99);
        System.out.println(list.size);
        list.print();


        list.addAtIndex(0, 65);
        System.out.println(list.size);
        list.print();

    }
}
