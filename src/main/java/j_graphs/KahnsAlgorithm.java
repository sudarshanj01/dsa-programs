package j_graphs;

import java.util.*;

public class KahnsAlgorithm {
    // Function to perform topological sort using Kahn's Algorithm
    public static List<Integer> topologicalSort(int vertices, List<List<Integer>> adj) {
        int[] inDegree = new int[vertices]; // Array to store in-degrees of all vertices
        List<Integer> topoSort = new ArrayList<>(); // List to store the topological sort result

        // Calculate in-degrees of all vertices
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Queue to store all vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue all vertices with in-degree 0
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Process vertices from the queue
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort.add(node);

            // For each neighbor, reduce its in-degree by 1
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, add to queue
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If the topological sort contains all vertices, return it
        if (topoSort.size() == vertices) {
            return topoSort;
        } else {
            // If there's a cycle, return an empty list (not a DAG)
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list for the graph
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Call topological sort
        List<Integer> result = topologicalSort(vertices, adj);

        if (result.isEmpty()) {
            System.out.println("The graph has a cycle, topological sort not possible.");
        } else {
            System.out.println("Topological Sort: " + result);
        }
    }
}
