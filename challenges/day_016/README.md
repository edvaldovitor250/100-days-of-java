# Day 16

## Desafio:

Escreva um programa Java que realize a multiplicação de matrizes.

**Resultado:**

```java

public class Day016 {

    public static void main(String[] args) {
        Day016 day = new Day016();
        day.multiplicacaoMatriz(2);

    }

    public static void multiplicacaoMatriz(int multiplicar) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] resultado = new int[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resultado[i][j] = matriz[i][j] * multiplicar;
            }
        }

        System.out.println("Matriz resultante após multiplicação:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
}
}