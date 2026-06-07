package org.dsa.graphs.practice;

import org.dsa.graphs.practice.nodes.Node;

import java.util.*;

public class FindIfPathExistsInGraphLC1971 {
    static void main() {

        // CASE-1 n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
        boolean case1PathExists = validPath(3,new int[][]{{0,1},{1,2},{2,0}},0,2);

        System.out.println("Path to destinations exists:  "+ case1PathExists);

        // CASE-2 n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5

        boolean case2PathExists = validPath(6,new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}},0,5);
        System.out.println("Path to destinations exists:  "+ case2PathExists);

    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        // Build a graph
        Map<Integer,Node> graph =  buildBiDirectionalGraph(edges);
        Node startNode = graph.get(source);
        Node endNode = graph.get(destination);

        // edge case — source is destination
        if (source == destination) return true;

        // edge case — disconnected graph, node doesn't exist
        if (startNode == null || endNode == null) return false;

        //Search the graph now
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Node> visitedNodes = new HashSet<>();
        queue.offer(startNode);
        visited.add(startNode.val);
        visitedNodes.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

//            if (current.val == endNode.val) {
//                return true;
//            }

            if (current.equals(endNode)) {
                return true;
            }

            for (Node neighbour : current.neighbors) {
                if (!visitedNodes.contains(neighbour)) {
                    queue.offer(neighbour);
                    visitedNodes.add(neighbour);
                }
            }


        }

        return false;
    }

    static Map<Integer, Node> buildBiDirectionalGraph(int[][] edges) {
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
}
