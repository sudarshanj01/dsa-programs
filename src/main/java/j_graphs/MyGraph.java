package j_graphs;

import java.util.*;

public class MyGraph {
    private Map<String, List<String>> adjList;

    // Constructor to initialize the adjacency list.
    public MyGraph() {
        adjList = new HashMap<>();
    }

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        // Add edges (undirected graph)
        graph.addEdge("A", "B", false);
        graph.addEdge("A", "E", false);
        graph.addEdge("B", "C", false);
        graph.addEdge("B", "D", false);
        graph.addEdge("C", "D", false);
        graph.addEdge("D", "E", false);

        // Display the graph
        graph.display();

        // Perform BFS starting from vertex A
        System.out.println("\nBFS traversal starting from vertex A:");
        graph.bfs("A");

        // Perform DFS starting from vertex A
        System.out.println("\nDFS traversal starting from vertex A:");
        graph.dfs("A");

    }

    // Add a vertex to the graph
    public void addVertex(String vertex) {
        // If the vertex doesn't exist, add it with an empty adjacency list.
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge between two vertices (for undirected graph)
    public void addEdge(String vertex1, String vertex2, boolean directed) {
        // Add vertex2 to vertex1's adjacency list
        adjList.get(vertex1).add(vertex2);

        // If the graph is undirected, add the reverse edge
        if (!directed) {
            adjList.get(vertex2).add(vertex1);
        }
    }

    // Display the graph
    public void display() {
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (String neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // BFS algorithm to traverse the graph
    public void bfs(String startVertex) {
        // Create a set to track visited vertices
        // (we use Set instead of array because String vertices are not index-based)
        Set<String> visited = new HashSet<>();

        // Create a queue for BFS
        Queue<String> queue = new LinkedList<>();

        // Mark the start vertex as visited and enqueue it
        visited.add(startVertex);
        queue.add(startVertex);

        // Continue until the queue is empty
        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            String vertex = queue.poll();
            System.out.print(vertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If a neighbor hasn't been visited, mark it and enqueue it
            for (String neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // DFS algorithm to traverse the graph
    public void dfs(String startVertex) {
        // Create a set to track visited vertices
        Set<String> visited = new HashSet<>();

        // Call the recursive DFS helper function
        dfsRecursive(startVertex, visited);
        System.out.println();
    }

    // Helper function for DFS traversal using recursion
    private void dfsRecursive(String vertex, Set<String> visited) {
        // Mark the current vertex as visited and print it
        visited.add(vertex);
        System.out.print(vertex + " ");

        // Recursively visit all unvisited neighbors
        for (String neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }
}


