package org.dsa.graphs.practice;

import org.dsa.graphs.practice.nodes.Node;

import java.util.*;

public class AllPossiblePathLC797 {
    static void main() {

        // CASE-1 Input: graph = [[1,2],[3],[3],[]]      Output: [[0,1,3],[0,2,3]]
        // List<List<Integer>> allPathCase1 = allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});

        System.out.println(" ");
        System.out.println("##########################################");
        System.out.println(" ");

        // CASE-2 Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]    Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

        List<List<Integer>> allPathCase2 = allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});
    }


    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPossiblePathList = new ArrayList<>();

        Node startNode = buildSingleDirectionalGraphFromAdjacencyList(graph);
        printGraph(startNode);

        int destination = graph.length - 1;

        // start DFS from node 0
        List<Integer> path = new ArrayList<>();
        path.add(startNode.val);
        dfs(startNode, destination, path, allPossiblePathList);

        System.out.println("All paths: " + allPossiblePathList);
        return allPossiblePathList;
    }

    private static void dfs(Node current, int destination,
                            List<Integer> path, List<List<Integer>> result) {

        // reached destination — save path
        if (current.val == destination) {
            result.add(new ArrayList<>(path));
            return;
        }

        // explore each neighbor
        for (Node neighbor : current.neighbors) {
            path.add(neighbor.val);
            dfs(neighbor, destination, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }

//    static Node buildSingleDirectionalGraph(int[][] edges) {
//        Map<Integer, Node> map = new HashMap<>();
//        Node startNode = null;
//        int i = 0;
//        for (int[] edge : edges) {
//            int a = edge[0], b = edge[1];
//            if (i == 0) {
//                startNode = new Node(a);
//            }
//            map.putIfAbsent(a, new Node(a));
//            map.putIfAbsent(b, new Node(b));
//
//            // directed: only a → b
//            map.get(a).neighbors.add(map.get(b));
//            i++;
//        }
//        return startNode;
//    }

    static Node buildSingleDirectionalGraphFromAdjacencyList(int[][] graph) {
        Map<Integer, Node> map = new HashMap<>();

        // create all nodes first
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new Node(i));
        }

        // wire directed edges: node i → each neighbor in graph[i]
        for (int i = 0; i < graph.length; i++) {
            for (int neighbor : graph[i]) {
                map.get(i).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(0); // node 0 is always the source
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
