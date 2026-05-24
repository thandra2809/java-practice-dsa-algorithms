package org.dsa.practice.linkedlist;

public class ReverseALinkedList {
    static void main() {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        Integer[] secondList = {1,2,3,4,5,6};
        list.create(secondList);

        list.print();

        list.reverseList();

        list.print();

    }
}
