package org.dsa.practice.linkedlist;

public class CustomLinkedList<T> {
    Node<T> head;
    Node<T> last;
    int size;

    public CustomLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;

        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            last = newNode;
        }
        size++;
    }

    void create(T[] A) {
        head = new Node<T>(A[0]);
        Node<T> last = head;

        for (int i = 1; i < A.length; i++) {
            Node<T> t = new Node<>(A[i]);
            last.next = t;
            last = t;
        }
    }

    Node<T> createAndReturn(T[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        head = new Node<T>(A[0]);
        Node<T> last = head;

        for (int i = 1; i < A.length; i++) {
            Node<T> t = new Node<>(A[i]);
            last.next = t;
            last = t;
        }

        return head;
    }

    public void print() {
        Node<T> current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print("[" + current.data + "] -> ");
            current = current.next;
        }
        System.out.print("NULL");
        System.out.println("");
    }


    public void printHelper(Node<T> head) {
        if (head.next != null) {
            System.out.print("[" + head.data + "] -> ");
            printHelper(head.next);
        }
        if (head.next == null) {
            System.out.print("NULL");
        }
    }

    public void printRecursive() {
        System.out.print("HEAD -> ");
        printHelper(head);
        System.out.println();
    }

    public int totalCountOfElements() {
        return size;
    }

    public int sumOfAllElements() {
        int sum = 0;
        Node<T> current = head;
        while (current != null) {
            sum = sum + (int) current.data;
            current = current.next;
        }
        return sum;
    }

    public int getTheLargestElement() {
        int largestElement = Integer.MIN_VALUE;
        Node<T> current = head;

        if (current == null) return largestElement;

        while (current != null) {
            if ((int) current.data > largestElement) {
                largestElement = (int) current.data;
            }
            current = current.next;
        }
        return largestElement;
    }

    public T search(T i) {
        Node<T> current = head;

        while (current != null) {
            if (current.data == i) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public T searchAndMoveToHead(T i) {
        Node<T> p = head;
        Node<T> q = null;

        while (p != null) {
            if (p.data == i) {
                q.next = p.next;
                p.next = head;
                head = p;
                return p.data;
            }
            q = p;
            p = p.next;
        }
        return null;
    }

    public void addAtFirst(T item) {
        Node<T> newNode = new Node<>(item);

        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtIndex(Integer index, T item) {

        // ── Validate index ───────────────────────────────────────────
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> newNode = new Node<>(item);

        // ── Case 1: insert at index 0 (new head) ─────────────────────
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        // ── Case 2: insert at last index (append to end) ─────────────
        if (index == size) {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            size++;
            return;
        }

        // ── Case 3: insert in the middle ─────────────────────────────
        Node<T> p = head;
        Node<T> q = null;
        int counter = 0;

        while (p != null) {
            if (counter == index) {
                q.next = newNode;
                newNode.next = p;
                size++;
                return;
            }
            counter++;
            q = p;
            p = p.next;
        }
    }

    public boolean isSorted() {
        Node<T> p = head;
        int MIN_VALUE = Integer.MIN_VALUE;
        while (p != null) {
            if ((int) p.data < MIN_VALUE) {
                return false;
            }
            MIN_VALUE = (int) p.data;
            p = p.next;
        }
        return true;
    }

    public void deleteDuplicates() {
        Node<T> p = head;
        Node<T> q = head.next;

        while (q != null) {

            if (p.data != q.data) {
                p = q;
                q = q.next;
            } else {
                p.next = q.next;
                q = null;
                q = p.next;
            }

        }

    }

    public void deleteFromPosition(int position) {
        int sizeOfTheList = 0;
        Node<T> pointer = head;
        while (pointer != null) {
            sizeOfTheList++;
            pointer = pointer.next;
        }

        System.out.println("The Size of the List is:: " + sizeOfTheList);

        if (position > sizeOfTheList) {
            throw new IndexOutOfBoundsException("Index: " + position + ", Size: " + sizeOfTheList);
        }

        // move the pointer back to head
        pointer = head;
        if (position == 0) {
            head = pointer.next;
            pointer = null;
        }

        // move the pointer back to head
        pointer = head;
        Node<T> previousPointer = head;
        int index = 0;
        while (pointer != null) {

            if (index == position + 1) {
                previousPointer.next = pointer.next;
                pointer = null;
                break;
                // return head;
            }
            previousPointer = pointer;
            pointer = pointer.next;
            index++;
        }

    }


    public void deleteNthNodeFromLast(int position) {
        int sizeOfTheList = 0;
        Node<T> pointer = head;
        while (pointer != null) {
            sizeOfTheList++;
            pointer = pointer.next;
        }

        System.out.println("The Size of the List is:: " + sizeOfTheList);

        if (position > sizeOfTheList) {
            throw new IndexOutOfBoundsException("Index: " + position + ", Size: " + sizeOfTheList);
        }

        // move the pointer back to head
        pointer = head;
        if (sizeOfTheList - position == 0) {
            head = pointer.next;
            pointer = null;
        }

        // move the pointer back to head
        pointer = head;
        Node<T> previousPointer = head;
        int index = 0;
        while (pointer != null) {

            if (sizeOfTheList - position == index) {
                previousPointer.next = pointer.next;
                pointer.next = null;
                break;
                // return head;
            }
            previousPointer = pointer;
            pointer = pointer.next;
            index++;
        }
    }

    public void reverseList() {
        Node<T> p = head;
        Node<T> q = null;
        Node<T> r = null;

        while (p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        head = q;


    }

    public void reverseListWithRecursion(Node<T> q, Node<T> p) {
        if (p != null) {
            reverseListWithRecursion(p, p.next);
            p.next = q;
        } else {
            head = q;
        }

    }


    Node<T> createAndReturnCircularAtRandom(T[] A, int circularIndex) {
        if (A == null || A.length == 0) {
            return null;
        }

        // Validate index
        if (circularIndex < 0 || circularIndex >= A.length) {
            throw new IllegalArgumentException("circularIndex " + circularIndex + " out of bounds for length " + A.length);
        }

        head = new Node<T>(A[0]);
        Node<T> last = head;
        Node<T> circularNode = (circularIndex == 0) ? head : null; // track the target node

        for (int i = 1; i < A.length; i++) {
            Node<T> t = new Node<>(A[i]);
            last.next = t;
            last = t;

            // ✅ Capture the node at circularIndex as we build
            if (i == circularIndex) {
                circularNode = t;
            }
        }

        // Point last node to the captured node
        last.next = circularNode;

        return head;
    }
}

