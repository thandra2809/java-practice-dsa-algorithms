package org.dsa.practice.linkedlist;

public class AICustomLinkedListCodeGenerated {

    // ── Node class ───────────────────────────────────────────────
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ── Global head (equivalent to *first=NULL in C) ─────────────
    static Node first = null;

    // ── Create — builds list from array (equivalent to create()) ─
    static void create(int[] A, int n) {
        first = new Node(A[0]);
        Node last = first;

        for (int i = 1; i < A.length; i++) {
            Node t = new Node(A[i]);
            last.next = t;
            last = t;
        }
    }

    // ── Display — prints all elements (equivalent to Display()) ──
    static void display(Node p) {
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    // ── Count — returns size of list ─────────────────────────────
    static int count(Node p) {
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    // ── Insert — inserts at given index (equivalent to Insert()) ─
    static void insert(Node p, int index, int x) {

        // ── Validate index ───────────────────────────────────────
        if (index < 0 || index > count(p)) {
            return;
        }

        Node t = new Node(x);

        // ── Case 1: insert at index 0 (new head) ─────────────────
        if (index == 0) {
            t.next = first;
            first = t;
        }
        // ── Case 2: insert at middle or end ──────────────────────
        else {
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            t.next = p.next;
            p.next = t;
        }
    }

    // ── Main ─────────────────────────────────────────────────────
    public static void main(String[] args) {

        insert(first, 0, 15);  // list: 15
        insert(first, 0, 8);   // list: 8 -> 15
        insert(first, 0, 9);   // list: 9 -> 8 -> 15
        insert(first, 1, 10);  // list: 9 -> 10 -> 8 -> 15

        display(first);
        // Output: 9 10 8 15
    }
}