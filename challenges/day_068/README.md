# Day 68

## Desafio:

	Implemente um algoritmo em Java para encontrar o fecho transitivo reduzido de um grafo direcionado.
    
**Resultado:**


```java


public class Day068 {

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}
        };

        Day068 day068 = new Day068();
        int[][] transitiveClosure = day068.warshallAlgorithm(graph);
        int[][] reducedClosure = day068.reduceTransitiveClosure(transitiveClosure);

        System.out.println("Fecho Transitivo:");
        day068.printMatrix(transitiveClosure);

        System.out.println("Fecho Transitivo Reduzido:");
        day068.printMatrix(reducedClosure);
    }

    public int[][] warshallAlgorithm(int[][] graph) {
        int n = graph.length;
        int[][] closure = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                closure[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    closure[i][j] = closure[i][j] != 0 || (closure[i][k] != 0 && closure[k][j] != 0) ? 1 : 0;
                }
            }
        }
        return closure;
    }

    public int[][] reduceTransitiveClosure(int[][] closure) {
        int n = closure.length;
        int[][] reducedClosure = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (closure[i][j] == 1) {
                    boolean isRedundant = false;
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j && closure[i][k] == 1 && closure[k][j] == 1) {
                            isRedundant = true;
                            break;
                        }
                    }
                    if (!isRedundant) {
                        reducedClosure[i][j] = 1;
                    }
                }
            }
        }
        return reducedClosure;
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
