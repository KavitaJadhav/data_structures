package graph;

import java.util.*;

public class WeightedGraph {
    private HashMap<String, List> values = new HashMap();

    private void read() {
        values.forEach((vertex, edges) -> System.out.println(vertex + " : " + edges));
    }

    private void addEdge(String vertex1, String vertex2, int weight) {
        values.get(vertex1).add(new Edge(vertex2, weight));
        values.get(vertex2).add(new Edge(vertex1, weight));
    }

    private void addVertex(String vertex) {
        values.putIfAbsent(vertex, new ArrayList());
    }

    private void shortestDistance(String startVertex, String endVertex) {
        List visited = new ArrayList();
        HashMap<String, String> previousNodes = new HashMap();
        HashMap<String, Integer> distances = new HashMap();
        Queue distanceQueue = new PriorityQueue();

        for (String _vertex : values.keySet()) {
            distances.put(_vertex, (int) Double.POSITIVE_INFINITY);
            previousNodes.put(_vertex, null);
        }

        previousNodes.put(startVertex, null);
        distanceQueue.add(new Distance(startVertex, 0));

        findDistance(visited, previousNodes, distances, distanceQueue);

        distances.forEach((vertex, value) -> System.out.println(vertex + " : " + value));
    }

    private void findDistance(List visited, HashMap<String, String> previousNodes, HashMap<String, Integer> distances, Queue distanceQueue) {

        while (!distanceQueue.isEmpty()) {
            String vertex = ((Distance) distanceQueue.remove()).vertex;

            if (visited.indexOf(vertex) == -1) visited.add(vertex);

            values.get(vertex).forEach(edgeVertex -> {
                Edge edge = (Edge) edgeVertex;

                if (visited.indexOf(edge.vertex) == -1) {
                    previousNodes.put(edge.vertex, vertex);

                    int oldDistance = distances.get(edge.vertex);

                    //newDistance = Todo: Use weight attribute to get previous distance instead of calculating + edge weight
                    int newDistance = getDistance(previousNodes, edge.vertex, "A");

                    if (newDistance < oldDistance) {
                        distances.put(edge.vertex, newDistance);
                        distanceQueue.add(new Distance(edge.vertex, newDistance));
                    }
                }
            });
            findDistance(visited, previousNodes, distances, distanceQueue);
        }
    }

    private int getDistance(HashMap<String, String> previousNodes, String fromVertex, String toVertex) {
        int distance = 0;

        String previous = null;

        while (previous != toVertex) {
            previous = previousNodes.get(fromVertex);

            distance += getWeight(fromVertex, previous);
            fromVertex = previous;
        }
        return distance;
    }

    private int getWeight(String from, String to) {
        Edge edge = null;
        List edges = values.get(from);

        for (int i = 0; i < edges.size(); i++) {
            edge = (Edge) edges.get(i);
            if (edge.vertex == to) break;
        }
        return edge.weight;
    }


    private class Edge {
        public String vertex;
        public int weight;

        public Edge(String vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public String toString() {
            return "{ Vertex: " + vertex + " weight: " + weight + " }";
        }
    }

    private class Distance implements Comparable<Distance> {
        public String vertex;
        public int distance;

        public Distance(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int compareTo(Distance b) {
            if (this.distance > b.distance) {
                return 1;
            } else if (this.distance < b.distance) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "F", 4);
        graph.addEdge("B", "E", 3);
        graph.addEdge("D", "F", 1);
        graph.addEdge("D", "E", 3);
        graph.addEdge("E", "F", 1);

        graph.read();
        graph.shortestDistance("A", "E");
    }
}
