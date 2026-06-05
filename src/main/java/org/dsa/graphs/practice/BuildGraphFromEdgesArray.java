package org.dsa.graphs.practice;

import java.util.*;
import org.dsa.graphs.practice.nodes.*;

public class BuildGraphFromEdgesArray {

    static void main() {
        int[][] edges = {{1,2},{1,3},{2,4},{2,5},{3,5}};

        Map<Integer, Node> graph = buildGraph(edges);

        printGraph(graph.get(1));
    }

    static Map<Integer, Node> buildGraph(int[][] edges) {
        Map<Integer, Node> map = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];

            // Create node if it doesn't exist yet
            map.putIfAbsent(a, new Node(a));
            map.putIfAbsent(b, new Node(b));

            // Add undirected edge
            map.get(a).neighbors.add(map.get(b));
            map.get(b).neighbors.add(map.get(a));
        }
        return map;
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
                if (!seen.contains(nb.val)) { seen.add(nb.val); q.offer(nb); }
            }
            System.out.println("  " + curr.val + " --> " + nbVals);
        }
    }
}
