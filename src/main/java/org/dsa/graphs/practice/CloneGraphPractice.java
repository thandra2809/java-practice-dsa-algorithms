package org.dsa.graphs.practice;

import java.util.*;

import org.dsa.graphs.practice.nodes.Node;

public class CloneGraphPractice {
    static Map<Node, Node> visitedMap = new HashMap<>();

    static void main() {
/*
        // First build the graph from adjacent list  [[2,4],[1,3],[2,4],[1,3]]
        int[][] edges = new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Map<Integer, Node> map = buildGraph(edges);

        Node test = map.getOrDefault(1, null);
        System.out.println(test.val);
        System.out.println(test.neighbors);

        Node clonedDFS = cloneGraphDFS(test);
        System.out.println(clonedDFS.val);
        System.out.println(clonedDFS.neighbors);
*/


        int[][] edgesBFS = {{1, 2}, {2, 3}, {3, 4}, {4, 1}};
        Map<Integer, Node> mapBFS = buildGraph(edgesBFS);

        Node testBFS = mapBFS.getOrDefault(1, null);
        Node clonedBFS = cloneGraphBFS(testBFS);
        printGraph(clonedBFS);


    }

    private static Node cloneGraphBFS(Node node) {

        if (node == null) {
            return null;
        }


        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        Map<Node, Node> visitedMap = new HashMap<>();
        Node clone = new Node(node.val);
        visitedMap.put(node, clone);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (Node neighbor : currentNode.neighbors) {
                if (!visitedMap.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    visitedMap.put(neighbor, new Node(neighbor.val));
                }

                Node cloneNode = visitedMap.get(currentNode);
                cloneNode.neighbors.add(visitedMap.get(neighbor));
            }
        }
        return clone;
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
                if (!seen.contains(nb.val)) {
                    seen.add(nb.val);
                    q.offer(nb);
                }
            }
            System.out.println("  " + curr.val + " --> " + nbVals);
        }
    }

    static Node cloneGraphDFS(Node node) {


        if (node == null) {
            return null;
        }

        if (visitedMap.containsKey(node)) {
            return visitedMap.get(node);
        }

        Node clone = new Node(node.val);
        visitedMap.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraphDFS(neighbor));
        }

        return clone;

    }
}
