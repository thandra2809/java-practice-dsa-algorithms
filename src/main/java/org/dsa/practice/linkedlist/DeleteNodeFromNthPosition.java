package org.dsa.practice.linkedlist;

public class DeleteNodeFromNthPosition {
    static void main() {
        CustomLinkedList<Integer> list = new CustomLinkedList<Integer>();
        list.add(1);
        // list.add(2);




        list.deleteNthNodeFromLast(1);

        list.print();
    }
}
