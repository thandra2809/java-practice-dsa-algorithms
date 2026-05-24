package org.dsa.practice.linkedlist;

public class DeleteDuplicatesFromLinkedList {

    static void main() {

        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        Integer[] secondList = {1,2,2,3,4,5,5,6,6,6};
        list.create(secondList);

        list.print();

        boolean isSecondListSorted = list.isSorted();

        System.out.println("First list sorted is " + isSecondListSorted);

        list.deleteDuplicates();


        list.print();

    }
}
