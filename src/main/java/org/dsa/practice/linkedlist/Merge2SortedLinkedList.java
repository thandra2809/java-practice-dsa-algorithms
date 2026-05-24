package org.dsa.practice.linkedlist;

public class Merge2SortedLinkedList {
    static void main() {

        CustomLinkedList<Integer> firstLinkedList = new CustomLinkedList<>();
        Integer[] firstList = {2, 8, 10, 15};
        Node<Integer> firstListHead = firstLinkedList.createAndReturn(firstList);


        CustomLinkedList<Integer> secondLinkedList = new CustomLinkedList<>();
        Integer[] secondList = {4, 7, 12, 14};
        Node<Integer> secondListHead = secondLinkedList.createAndReturn(secondList);

        Node<Integer> dummy = new Node<>(0);
        Node<Integer> last = dummy;


        // Merge loop — runs while both lists have nodes
        while (firstListHead != null && secondListHead != null) {
            if (firstListHead.data < secondListHead.data) {
                last.next = firstListHead;
                firstListHead = firstListHead.next;
            } else {
                last.next = secondListHead;
                secondListHead = secondListHead.next;
            }
            last = last.next;
            last.next = null;
        }

        // Attach whichever list still has remaining nodes
        if (firstListHead != null) {
            last.next = firstListHead;
        } else {
            last.next = secondListHead;
        }

        CustomLinkedList<Integer> thirdLinkedList = new CustomLinkedList<>();
        thirdLinkedList.head = dummy.next;
        thirdLinkedList.print();

    }
}
