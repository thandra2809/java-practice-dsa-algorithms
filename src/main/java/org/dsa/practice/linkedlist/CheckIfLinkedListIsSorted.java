package org.dsa.practice.linkedlist;

public class CheckIfLinkedListIsSorted {

    static void main() {

        CustomLinkedList<Integer> list = new CustomLinkedList<>();
//        Integer[] firstList = {1,2,3,4,5};
//        list.create(firstList);
//
//        list.print();
//
//        boolean isFirstListSorted = list.isSorted();
//
//        System.out.println("First list sorted is " + isFirstListSorted);


        Integer[] secondList = {1,2,6,4,5};
        list.create(secondList);

        list.print();

        boolean isSecondListSorted = list.isSorted();

        System.out.println("First list sorted is " + isSecondListSorted);

    }
}
