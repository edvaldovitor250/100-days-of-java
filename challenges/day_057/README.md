# Day 57

## Desafio:

Crie um programa Java que implemente o algoritmo de busca em largura (BFS) para encontrar o caminho mais curto entre dois vértices em um grafo não ponderado.

**Resultado:**


```java

import java.util.*;

public class Day057 {

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.adicionarAresta("A", "B");
        grafo.adicionarAresta("A", "C");
        grafo.adicionarAresta("B", "D");
        grafo.adicionarAresta("C", "D");
        grafo.adicionarAresta("C", "E");
        grafo.adicionarAresta("D", "E");

        List<String> caminho = grafo.bfs("A", "E");
        if (caminho != null) {
            System.out.println("Caminho mais curto: " + String.join(" -> ", caminho));
        } else {
            System.out.println("Não existe caminho entre os vértices especificados.");
        }
    }
}

class Grafo {
    private Map<String, List<String>> adjacencia;

    public Grafo() {
        adjacencia = new HashMap<>();
    }

    public void adicionarAresta(String vertice1, String vertice2) {
        adjacencia.computeIfAbsent(vertice1, k -> new ArrayList<>()).add(vertice2);
        adjacencia.computeIfAbsent(vertice2, k -> new ArrayList<>()).add(vertice1);
    }

    public List<String> bfs(String inicio, String fim) {
        Queue<List<String>> fila = new LinkedList<>();
        Set<String> visitados = new HashSet<>();

        fila.add(Collections.singletonList(inicio));
        visitados.add(inicio);

        while (!fila.isEmpty()) {
            List<String> caminho = fila.poll();
            String ultimoVertice = caminho.get(caminho.size() - 1);

            if (ultimoVertice.equals(fim)) {
                return caminho;
            }

            for (String vizinho : adjacencia.getOrDefault(ultimoVertice, Collections.emptyList())) {
                if (!visitados.contains(vizinho)) {
                    visitados.add(vizinho);
                    List<String> novoCaminho = new ArrayList<>(caminho);
                    novoCaminho.add(vizinho);
                    fila.add(novoCaminho);
                }
            }
        }
        return null;
    }
}
