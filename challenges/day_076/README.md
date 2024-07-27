# Day 76

## Desafio:

Implemente um algoritmo em Java para calcular o pagerank de páginas da web em um grafo representando a rede de links.

**Resultado:**


```java
import java.util.*;

public class Day076 {
    
    private static final double DAMPING_FACTOR = 0.85;
    private static final double CONVERGENCE_THRESHOLD = 0.0001;
    private static final int MAX_ITERATIONS = 100;

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("C"));
        graph.put("C", Arrays.asList("A"));
        
        Map<String, Double> pageRanks = calculatePageRank(graph);
        
        for (Map.Entry<String, Double> entry : pageRanks.entrySet()) {
            System.out.println("Page " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static Map<String, Double> calculatePageRank(Map<String, List<String>> graph) {
        Map<String, Double> pageRanks = new HashMap<>();
        Map<String, Double> newPageRanks = new HashMap<>();
        int numPages = graph.size();
        double initialRank = 1.0 / numPages;
        
        for (String page : graph.keySet()) {
            pageRanks.put(page, initialRank);
        }
        
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            double diff = 0;
            for (String page : graph.keySet()) {
                double newRank = (1 - DAMPING_FACTOR) / numPages;
                for (String otherPage : graph.keySet()) {
                    if (graph.get(otherPage).contains(page)) {
                        newRank += DAMPING_FACTOR * (pageRanks.get(otherPage) / graph.get(otherPage).size());
                    }
                }
                newPageRanks.put(page, newRank);
                diff += Math.abs(newRank - pageRanks.get(page));
            }
            pageRanks.putAll(newPageRanks);
            if (diff < CONVERGENCE_THRESHOLD) {
                break;
            }
        }
        return pageRanks;
    }
}
