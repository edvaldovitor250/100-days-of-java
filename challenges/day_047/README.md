# Day 47

## Desafio:

Implemente um algoritmo em Java para encontrar o fecho transitivo de um grafo direcionado.

**Resultado:**


```java

public class Day047 {

    public static void transitiveClosure(int[][] graph) {
        int V = graph.length;
        int[][] reach = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                reach[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    reach[i][j] = (reach[i][j] != 0) || ((reach[i][k] != 0) && (reach[k][j] != 0)) ? 1 : 0;
                }
            }
        }

        printMatrix(reach);
    }

    public static void printMatrix(int[][] matrix) {
        int V = matrix.length;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 0},
            {0, 0, 1, 0},
            {1, 0, 0, 1},
            {0, 0, 0, 0}
        };

        transitiveClosure(graph);
    }
}
