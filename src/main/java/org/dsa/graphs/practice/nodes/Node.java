package org.dsa.graphs.practice.nodes;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        List<Integer> nbVals = new ArrayList<>();
        for (Node nb : neighbors) nbVals.add(nb.val);
        return "Node(" + val + ") --> " + nbVals;
    }


    static void addEdge(Node a, Node b) {
        a.neighbors.add(b);
        b.neighbors.add(a);
    }
}