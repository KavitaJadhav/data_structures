//DFS traverse
// recursion - add element in result, traverse each element
//iteration - add element in result, maintain STACK for to be visited items

//BFS traverse
//iteration - add element in result, maintain QUEUE for to be visited items

package graph;

import java.sql.Array;
import java.util.*;

public class GraphTraversal {
    private HashMap<String, List> values = new HashMap();

    private void read() {
        values.forEach((vertex, edges) -> System.out.println(vertex + " : " + edges));
    }

    private void removeVertex(String vertex) {
        values.keySet().forEach(_vertex -> removeEdge(_vertex, vertex));
        values.remove(vertex);
    }

    private void removeEdge(String vertex1, String vertex2) {
        values.get(vertex1).remove(vertex2);
        values.get(vertex2).remove(vertex1);
    }

    private void addEdge(String vertex1, String vertex2) {
        values.get(vertex1).add(vertex2);
        values.get(vertex2).add(vertex1);
    }

    private void addVertex(String vertex) {
        values.putIfAbsent(vertex, new ArrayList());
    }

    private void bfsIterative() {
        String firstVertex = getFirstVertex();
        List visited = new ArrayList<>();
        List result = new ArrayList();

        visited.add(firstVertex);

        while (!visited.isEmpty()) {
            String vertex = (String) visited.remove(0);

            if (result.indexOf(vertex) == -1)
                result.add(vertex);

            Collections.sort(values.get(vertex));

            values.get(vertex).forEach(edgeVertex -> {
                if (result.indexOf(edgeVertex) == -1) visited.add(edgeVertex);
            });
        }
        System.out.println("BFS visit iterative: " + result);
    }

    private void dfsIterative() {
        Stack visited = new Stack();
        List result = new ArrayList();
        String firstVertex = getFirstVertex();

        visited.push(firstVertex);

        while (!visited.isEmpty()) {
            String vertex = (String) visited.pop();
            if (result.indexOf(vertex) == -1)
                result.add(vertex);

            Collections.sort(values.get(vertex));

            values.get(vertex).forEach(edgeVertex -> {
                if (result.indexOf(edgeVertex) == -1) visited.push(edgeVertex);
            });
        }
        System.out.println("DFS visit iterative: " + result);

    }

    private void dfsRecursive() {
        List visited = new ArrayList();
        String firstVertex = getFirstVertex();

        visited.add(firstVertex);
        dfsVisit(firstVertex, visited);
        System.out.println("DFS visit recursive: " + visited);
    }

    private String getFirstVertex() {
        return (String) values.keySet().toArray()[0];
    }

    private void dfsVisit(String vertex, List visited) {
        if (visited.indexOf(vertex) == -1)
            visited.add(vertex);

        Collections.sort(values.get(vertex));

        values.get(vertex).forEach(edgeVertex -> {
            if (visited.indexOf(edgeVertex) == -1) dfsVisit((String) edgeVertex, visited);
        });
    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");

        graph.read();
        graph.dfsRecursive();
        graph.dfsIterative();
        graph.bfsIterative();
    }
}
