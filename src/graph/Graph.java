package graph;

import java.util.*;

public class Graph {
    private HashMap<String, List> values = new HashMap();

    private void read() {
        values.forEach((city, edges) -> System.out.println(city + " : " + edges));
    }

    private void removeVertex(String vertex) {
        values.keySet().forEach(city -> removeEdge(city, vertex));
        values.remove(vertex);
    }

    private void removeEdge(String city1, String city2) {
        values.get(city1).remove(city2);
        values.get(city2).remove(city1);
    }

    private void addEdge(String city1, String city2) {
        values.get(city1).add(city2);
        values.get(city2).add(city1);
    }

    private void addVertex(String city) {
        values.putIfAbsent(city, new ArrayList());
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Tokyo");
        graph.addVertex("Delhi");
        graph.addVertex("Chicago");
        graph.addVertex("Warsaw");

        graph.addEdge("Chicago", "Delhi");
        graph.addEdge("Chicago", "Warsaw");

        graph.read();

        graph.removeEdge("Delhi", "Chicago");
        graph.removeVertex("Chicago");

        graph.read();
    }
}
