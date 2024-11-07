package j_graphs;

import java.util.*;

// A class representing a weighted graph
public class WeightedGraph {
    // Adjacency list where each vertex points to a list of pairs (neighbor, weight)
    private Map<String, List<Pair<String, Integer>>> adjList;

    // Constructor to initialize the adjacency list
    public WeightedGraph() {
        adjList = new HashMap<>();
    }

    // Class to represent a pair (neighbor, weight)
    private static class Pair<U, V> {
        public U neighbor;  // Neighbor vertex
        public V weight; // Edge weight

        public Pair(U neighbor, V weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    // Add a vertex to the graph
    public void addVertex(String vertex) {
        // If the vertex doesn't exist, add it with an empty adjacency list
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge between two vertices with a weight (for directed or undirected graph)
    public void addEdge(String vertex1, String vertex2, int weight, boolean directed) {
        // Add vertex2 with weight to vertex1's adjacency list
        adjList.get(vertex1).add(new Pair<>(vertex2, weight));

        // If the graph is undirected, add the reverse edge (vertex2 to vertex1)
        if (!directed) {
            adjList.get(vertex2).add(new Pair<>(vertex1, weight));
        }
    }

    // Print the graph (for debugging purposes)
    public void printGraph() {
        for (String vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            for (Pair<String, Integer> neighbor : adjList.get(vertex)) {
                System.out.print("(" + neighbor.neighbor + ", " + neighbor.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        // Add edges (undirected graph with weights)
        graph.addEdge("A", "B", 5, false);
        graph.addEdge("A", "C", 3, false);
        graph.addEdge("B", "C", 7, false);

        // Print the graph
        graph.printGraph();
    }
}
