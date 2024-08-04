# Day 84

## Desafio:

	Implemente um algoritmo em Java para calcular a árvore de Steiner mínima em um grafo não direcionado.
            
**Resultado:**


```java

import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int V;
    List<Edge> edges;

    Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    List<Edge> steinerTree(List<Integer> terminals) {
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> result = new ArrayList<>();
        for (Edge edge : edges) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if (x != y) {
                result.add(edge);
                union(parent, rank, x, y);
            }
        }

        Map<Integer, Set<Integer>> components = new HashMap<>();
        for (int terminal : terminals) {
            int root = find(parent, terminal);
            components.computeIfAbsent(root, k -> new HashSet<>()).add(terminal);
        }

        List<Edge> steinerEdges = new ArrayList<>();
        for (Edge edge : result) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);

            if (x != y && (components.containsKey(x) || components.containsKey(y))) {
                steinerEdges.add(edge);
                union(parent, rank, x, y);
                components.computeIfAbsent(find(parent, x), k -> new HashSet<>()).addAll(components.getOrDefault(x, new HashSet<>()));
                components.computeIfAbsent(find(parent, y), k -> new HashSet<>()).addAll(components.getOrDefault(y, new HashSet<>()));
            }
        }

        return steinerEdges;
    }
}

public class Day084 {
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 9);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 15);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 8);
        graph.addEdge(4, 6, 9);
        graph.addEdge(5, 6, 11);

        List<Integer> terminals = Arrays.asList(0, 2, 4, 6);

        List<Edge> steinerTree = graph.steinerTree(terminals);

        System.out.println("Steiner Tree Edges:");
        for (Edge edge : steinerTree) {
            System.out.println("src: " + edge.src + ", dest: " + edge.dest + ", weight: " + edge.weight);
        }
    }
}
