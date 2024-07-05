# Day 54

## Desafio:

			Implemente um algoritmo em Java para resolver o problema do empacotamento (bin packing problem) utilizando técnicas de programação dinâmica.

**Resultado:**


```java

import java.util.*;

public class Day054 {

    public static void main(String[] args) {
        int binCapacity = 10;
        int[] items = {2, 5, 4, 7, 1, 3, 8};

        int result = binPacking(items, binCapacity);
        System.out.println("Minimum number of bins required: " + result);
    }

    public static int binPacking(int[] items, int binCapacity) {
        int n = items.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;

        for (int i = 0; i < (1 << n); i++) {
            int currentBinLoad = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currentBinLoad += items[j];
                }
            }

            if (currentBinLoad <= binCapacity) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) == 0) {
                        dp[i | (1 << j)] = Math.min(dp[i | (1 << j)], dp[i] + (currentBinLoad + items[j] > binCapacity ? 1 : 0));
                    }
                }
            }
        }

        return dp[(1 << n) - 1];
    }
}
