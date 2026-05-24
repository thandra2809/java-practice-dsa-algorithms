package org.dsa.practice.linkedlist;

public class DoublyLinkedList<T> {

    // ── Node ──────────────────────────────────────────────────────────
    static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // ── Fields ────────────────────────────────────────────────────────
    Node<T> head;
    Node<T> tail;

    // ── Create list from array ────────────────────────────────────────
    public Node<T> createFromArray(T[] arr) {
        if (arr == null || arr.length == 0) return null;

        head = new Node<>(arr[0]);
        tail = head;

        for (int i = 1; i < arr.length; i++) {
            Node<T> newNode = new Node<>(arr[i]);

            // Link forward
            tail.next    = newNode;
            // Link backward
            newNode.prev = tail;
            // Advance tail
            tail         = newNode;
        }

        return head;
    }

    // ── Print forward ─────────────────────────────────────────────────
    public void printForward() {
        Node<T> curr = head;
        System.out.print("null <-> ");
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;

            if (curr == head) {
                System.out.print("circular-break-");
                break;
            }

        }
        System.out.println("null");
    }

    // ── Print backward ────────────────────────────────────────────────
    public void printBackward() {
        Node<T> curr = tail;
        System.out.print("null <-> ");
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.prev;

            if (curr == tail) {
                System.out.print("circular-break-");
                break;
            }
        }
        System.out.println("null");
    }

    public void createCircularDoubleLinkedList(Node<T> head,Node<T> tail) {
        if (head == null || tail == null) return;

        // to create circular tails next should point to heads previous
        if (head.prev == null && tail.next == null) {
            tail.next = head;
            head.prev = tail;
        }

    }

    // ── Main ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Integer[] arr = {1, 2, 3, 4, 5};

        dll.createFromArray(arr);

        dll.printForward();   // null <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
        dll.printBackward();  // null <-> 5 <-> 4 <-> 3 <-> 2 <-> 1 <-> null

        dll.createCircularDoubleLinkedList(dll.head,dll.tail);
        dll.printForward();
    }
}