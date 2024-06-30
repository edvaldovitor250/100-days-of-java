# Day 49

## Desafio:

Crie um programa Java que implemente o algoritmo de detecção de ciclos em um grafo direcionado.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Day049 {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        if (graph.hasCycle()) {
            System.out.println("O grafo tem um ciclo.");
        } else {
            System.out.println("O grafo não tem um ciclo.");
        }
    }
}

class Graph {
    private final int vertices;
    private final List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (dfs(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        recStack[v] = true;

        List<Integer> children = adjList.get(v);
        for (Integer c : children) {
            if (dfs(c, visited, recStack)) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }
}
