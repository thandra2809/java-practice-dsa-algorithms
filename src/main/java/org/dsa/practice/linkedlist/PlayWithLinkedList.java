package org.dsa.practice.linkedlist;

import java.util.LinkedList;

public class PlayWithLinkedList {

    static void main() {

        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();

        System.out.println(list.size);
        System.out.println(list.head);

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(80);
        list.add(40);

//        list.print();
//        System.out.println(list.size);
//        System.out.println(list.head.data);
//        System.out.println(list.head.next.data);
        list.printRecursive();

        System.out.println(list.totalCountOfElements());

        System.out.println(list.sumOfAllElements());

        System.out.println(list.getTheLargestElement());

        LinkedList<Integer> test = new LinkedList<>();

    }
}
