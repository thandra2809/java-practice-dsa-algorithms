package org.dsa.practice.linkedlist;

public class CircularLink {

    static void main() {

        CustomLinkedList<Integer> firstLinkedList = new CustomLinkedList<>();
        Integer[] firstList = {2, 8, 10, 15, 3, 9, 4, 5, 7};
        Node<Integer> firstListHead = firstLinkedList.createAndReturnCircularAtRandom(firstList,4);


        printCircularAtRandom(firstListHead);

    }


    static void printCircularAtRandom(Node<Integer> head) {
        if (head == null) return;

        // Use fast/slow pointer to find cycle entry point
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        // Step 1: detect cycle exists
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            // plain print if no cycle
            Node<Integer> curr = head;
            while (curr != null) {
                System.out.print(curr.data + " → ");
                curr = curr.next;
            }
            System.out.println("null");
            return;
        }

        // Step 2: find cycle entry node
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        Node<Integer> cycleEntryNode = slow; // ✅ this is where last.next points to

        // Step 3: print until we hit the cycle entry node again
        Node<Integer> curr = head;
        while (curr != cycleEntryNode) {
            System.out.print(curr.data + " → ");
            curr = curr.next;
        }
        System.out.print(curr.data + " → ");  // print the cycle entry node
        System.out.println("(back to " + cycleEntryNode.data + ")");
    }
}
