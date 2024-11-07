package j_graphs;

import java.util.*;


public class UndirectedGraph {

    class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private Map<Integer, List<Edge>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight));
    }

    public boolean isCyclic() {
        Set<Integer> visited = new HashSet<>();

        //// Start DFS from each unvisited vertex
        for (int vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                // If a cycle is detected from any vertex, return true
                if (isCyclicUtil(vertex, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicUtil(int current, Set<Integer> visited, int parent) {
        visited.add(current);

        for (Edge edge : adjacencyList.get(current)) {
            int neighbor = edge.destination;

            if (!visited.contains(neighbor)) {
                if (isCyclicUtil(neighbor, visited, current)) {
                    return true;  // Cycle detected in the DFS tree
                }
            } else if (neighbor != parent) {
                return true;  // Cycle detected
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 5);

        System.out.println(graph.isCyclic());
    }
}