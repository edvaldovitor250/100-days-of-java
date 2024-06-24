# Day 42

## Desafio:

		Crie um programa Java que implemente o algoritmo de Kruskal para encontrar a árvore geradora mínima de um grafo ponderado.

**Resultado:**


```java

import java.util.*;

public class Day042 {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class Graph {
        int V, E;
        Edge[] edges;

        public Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
        }

        public void addEdge(int index, int src, int dest, int weight) {
            edges[index] = new Edge(src, dest, weight);
        }

        public int find(int[] parent, int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent, parent[i]);
        }

        public void union(int[] parent, int[] rank, int x, int y) {
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

        public void kruskalMST() {
            Edge[] result = new Edge[V];
            int e = 0;
            int i = 0;

            Arrays.sort(edges);

            int[] parent = new int[V];
            int[] rank = new int[V];

            for (int v = 0; v < V; v++) {
                parent[v] = v;
                rank[v] = 0;
            }

            while (e < V - 1) {
                Edge nextEdge = edges[i++];

                int x = find(parent, nextEdge.src);
                int y = find(parent, nextEdge.dest);

                if (x != y) {
                    result[e++] = nextEdge;
                    union(parent, rank, x, y);
                }
            }

            System.out.println("Arestas da Árvore Geradora Mínima:");
            for (i = 0; i < e; i++) {
                System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        Graph graph = new Graph(V, E);

        graph.addEdge(0, 0, 1, 10);
        graph.addEdge(1, 0, 2, 6);
        graph.addEdge(2, 0, 3, 5);
        graph.addEdge(3, 1, 3, 15);
        graph.addEdge(4, 2, 3, 4);

        graph.kruskalMST();
    }
}
