package org.dsa.practice.linkedlist;

public class SearchLinkedList {
    static void main() {

        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(10);
        list.add(8);
        list.add(32);
        list.add(2);

        System.out.println("********* Initial List is ************");
        list.print();
        System.out.println("********* Initial List is ************");

        Integer searchedElement = list.searchAndMoveToHead(18);

        System.out.println("********* Searched Element is ************");
        System.out.println(searchedElement);
        System.out.println("********* Searched Element is ************");


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("********* Initial List is ************");
        list.print();
        System.out.println("********* Initial List is ************");

        Integer searchedElement2 = list.searchAndMoveToHead(8);

        System.out.println("********* Searched Element is ************");
        System.out.println(searchedElement2);
        System.out.println("********* Searched Element is ************");

        System.out.println("********* Changed List is ************");
        list.print();
        System.out.println("********* Changed List is ************");

    }
}
