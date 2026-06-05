package org.dsa.graphs.practice;

import org.dsa.graphs.practice.nodes.Node;

import java.util.*;

public class BreadthFirstSearchOfGraph {
    static void main() {

        Node node1 = buildGraph();
        printGraph(node1);

        List<Integer> bfsOrder = doBreadthFirstSearch(node1);

        System.out.println(bfsOrder);
    }

    private static List<Integer> doBreadthFirstSearch(Node startNode) {
        List<Integer> result = new ArrayList<>();
        if (startNode == null) return result;

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(startNode);
        visited.add(startNode.val);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.val);
            for (Node neighbor : node.neighbors) {
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }


    static Node buildGraph() {
        //           1
        //         / | \
        //        2  3  4
        //       /|     |\
        //      5  6    7  8
        //     /|  |    |
        //    9 10 11   12
        //          |
        //          13

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);

        // Level 1 → Level 2
        addEdge(node1, node2);
        addEdge(node1, node3);
        addEdge(node1, node4);

        // Level 2 → Level 3
        addEdge(node2, node5);
        addEdge(node2, node6);
        addEdge(node4, node7);
        addEdge(node4, node8);

        // Level 3 → Level 4
        addEdge(node5, node9);
        addEdge(node5, node10);
        addEdge(node6, node11);
        addEdge(node7, node12);

        // Level 4 → Level 5
        addEdge(node11, node13);

        // Cross edges (makes it a graph not just a tree)
        addEdge(node3, node6);
        addEdge(node8, node12);
        addEdge(node9, node13);
        addEdge(node10, node11);
        return node1;
    }

    static void addEdge(Node a, Node b) {
        a.neighbors.add(b);
        b.neighbors.add(a);
    }

    static void printGraph(Node start) {

        Set<Integer> seen = new HashSet<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(start);
        seen.add(start.val);
        System.out.println("Graph:");

        while (!q.isEmpty()) {
            Node curr = q.poll();
            List<Integer> nbVals = new ArrayList<>();
            for (Node nb : curr.neighbors) {
                nbVals.add(nb.val);
                if (!seen.contains(nb.val)) {
                    seen.add(nb.val);
                    q.offer(nb);
                }
            }
            System.out.println("  " + curr.val + " --> " + nbVals);
        }
    }
}
