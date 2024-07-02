# Day 51

## Desafio:

	Implemente um algoritmo em Java para encontrar a árvore de abrangência mínima de um grafo usando o algoritmo de Prim.

**Resultado:**


```java
import java.util.*;

public class Day051 {

    public static void main(String[] args) {
        int vertices = 5;
        Day050 prim = new Day050(vertices);

        prim.addEdge(0, 1, 2);
        prim.addEdge(0, 3, 6);
        prim.addEdge(1, 2, 3);
        prim.addEdge(1, 3, 8);
        prim.addEdge(1, 4, 5);
        prim.addEdge(2, 4, 7);
        prim.addEdge(3, 4, 9);
        prim.primMST();
    }

    static class Edge {
        int source, destination, weight;
        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    int vertices;
    LinkedList<Edge>[] adjacencyList;

    public Day050(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        Edge reverseEdge = new Edge(destination, source, weight); 
        adjacencyList[source].add(edge);
        adjacencyList[destination].add(reverseEdge);
    }

    public void primMST() {
        boolean[] inMST = new boolean[vertices];
        Edge[] edgeTo = new Edge[vertices];
        int[] key = new int[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.weight));

        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        pq.add(new Edge(-1, 0, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int vertex = edge.destination;

            if (inMST[vertex]) continue;

            inMST[vertex] = true;

            if (edge.source != -1) {
                edgeTo[vertex] = edge;
            }

            for (Edge adjacentEdge : adjacencyList[vertex]) {
                int adjVertex = adjacentEdge.destination;

                if (!inMST[adjVertex] && adjacentEdge.weight < key[adjVertex]) {
                    key[adjVertex] = adjacentEdge.weight;
                    pq.add(new Edge(vertex, adjVertex, adjacentEdge.weight));
                    edgeTo[adjVertex] = adjacentEdge;
                }
            }
        }

        printMST(edgeTo);
    }

    public void printMST(Edge[] edgeTo) {
        System.out.println("Arestas na Árvore de Abrangência Mínima:");
        for (int i = 1; i < vertices; i++) {
            if (edgeTo[i] != null) {
                System.out.println("Origem: " + edgeTo[i].source + " - Destino: " + edgeTo[i].destination + " com peso: " + edgeTo[i].weight);
            }
        }
    }
}
