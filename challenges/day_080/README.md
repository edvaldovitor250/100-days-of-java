# Day 80

## Desafio:

	Implemente um algoritmo em Java para resolver o problema do corte de estoque (cutting stock problem), minimizando o desperdício de material.

**Resultado:**


```java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day080 {

    public static class StockCutter {
        private int stockLength;
        private List<Integer> pieces;

        public StockCutter(int stockLength, List<Integer> pieces) {
            this.stockLength = stockLength;
            this.pieces = pieces;
        }

        public int minimizeWaste() {
            Collections.sort(pieces, Collections.reverseOrder());
            List<Integer> remainingLengths = new ArrayList<>();
            for (int piece : pieces) {
                boolean placed = false;
                for (int i = 0; i < remainingLengths.size(); i++) {
                    if (remainingLengths.get(i) >= piece) {
                        remainingLengths.set(i, remainingLengths.get(i) - piece);
                        placed = true;
                        break;
                    }
                }
                if (!placed) {
                    remainingLengths.add(stockLength - piece);
                }
            }
            return remainingLengths.size();
        }

        public static void main(String[] args) {
            List<Integer> pieces = new ArrayList<>();
            pieces.add(5);
            pieces.add(10);
            pieces.add(15);
            pieces.add(22);
            pieces.add(8);

            int stockLength = 24;

            StockCutter stockCutter = new StockCutter(stockLength, pieces);
            int barsUsed = stockCutter.minimizeWaste();
            System.out.println("Number of bars used: " + barsUsed);
        }
    }
}
