package j_graphs;

import java.util.*;

class DijkstraAlgo {
    private Map<Integer, List<Edge>> adjacencyList;

    // Constructor to initialize the graph
    public DijkstraAlgo() {
        adjacencyList = new HashMap<>();
    }

    // Edge class to represent a weighted edge between two vertices
    class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Add an edge between two vertices
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight)); // For undirected graph
    }


    public void dijkstra(int source) {

        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));

        // Initialize distances: set all to infinity, except the source which is 0
        for (int vertex : adjacencyList.keySet()) {
            dist.put(vertex, Integer.MAX_VALUE);
        }
        dist.put(source, 0);

        // Start from the source node (vertex, distance) pair
        pq.offer(new int[]{source, 0});

        // Process the graph
        while (!pq.isEmpty()) {
            // Get the vertex with the smallest known distance
            int[] current = pq.poll();
            int currentVertex = current[0];
            int currentDistance = current[1];

            // Iterate over the neighbors of the current vertex
            for (Edge edge : adjacencyList.get(currentVertex)) {
                int neighbor = edge.destination;
                int weight = edge.weight;

                // Calculate the new distance from the source to the neighbor
                int newDist = currentDistance + weight;

                // If the new distance is shorter, update it and push the neighbor to the queue
                if (newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    pq.offer(new int[]{neighbor, newDist});
                }
            }
        }

        // Print the shortest distances from the source
        for (Map.Entry<Integer, Integer> entry : dist.entrySet()) {
            System.out.println("Distance from " + source + " to " + entry.getKey() + " is " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        DijkstraAlgo graph = new DijkstraAlgo();

        // Adding edges with weights (undirected graph)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);

        // Run Dijkstra's Algorithm from the source vertex 0
        graph.dijkstra(0);
    }
}
