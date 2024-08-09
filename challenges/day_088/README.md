# Day 88

## Desafio:

	Implemente um algoritmo em Java para calcular o número mínimo de trocas necessárias para ordenar um array usando o algoritmo de bubble sort.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Day088 {

    public static int bubbleSortWithSwapCount(int[] array) {
        int n = array.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapCount++;
                }
            }
        }

        return swapCount;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        int swaps = bubbleSortWithSwapCount(array);
        System.out.println("Número mínimo de trocas: " + swaps);
    }
}

