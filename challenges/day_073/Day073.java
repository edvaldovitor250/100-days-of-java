import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day073 {

    static class Graph {
        private final int V;
        private final List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

        void fillOrder(int v, boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;
            for (int n : adj.get(v)) {
                if (!visited[n]) {
                    fillOrder(n, visited, stack);
                }
            }
            stack.push(v);
        }

        void DFSUtil(int v, boolean[] visited, List<Integer> component) {
            visited[v] = true;
            component.add(v);
            for (int n : adj.get(v)) {
                if (!visited[n]) {
                    DFSUtil(n, visited, component);
                }
            }
        }

        Graph getTranspose() {
            Graph g = new Graph(V);
            for (int v = 0; v < V; v++) {
                for (int n : adj.get(v)) {
                    g.adj.get(n).add(v);
                }
            }
            return g;
        }

        void printSCCs() {
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    fillOrder(i, visited, stack);
                }
            }
            Graph gr = getTranspose();
            visited = new boolean[V];
            while (!stack.isEmpty()) {
                int v = stack.pop();
                if (!visited[v]) {
                    List<Integer> component = new ArrayList<>();
                    gr.DFSUtil(v, visited, component);
                    System.out.println("Componente fortemente conexo: " + component);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Os componentes fortemente conexos do grafo são:");
        g.printSCCs();
    }
}
