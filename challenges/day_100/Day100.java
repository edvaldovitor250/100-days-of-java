import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day100 {

    static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static Set<Integer> vertexCoverApproximation(int numVertices, List<Edge> edges) {
        Set<Integer> vertexCover = new HashSet<>();
        Set<Edge> edgeSet = new HashSet<>(edges);

        while (!edgeSet.isEmpty()) {
            Edge edge = edgeSet.iterator().next();

            vertexCover.add(edge.u);
            vertexCover.add(edge.v);

            edgeSet.removeIf(e -> e.u == edge.u || e.v == edge.v || e.u == edge.v || e.v == edge.u);
        }

        return vertexCover;
    }

    public static void main(String[] args) {
        int numVertices = 6;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1));
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(3, 4));
        edges.add(new Edge(4, 5));
        edges.add(new Edge(0, 3));
        edges.add(new Edge(1, 4));

        Set<Integer> vertexCover = vertexCoverApproximation(numVertices, edges);

        System.out.println("Cobertura mínima de vértices: " + vertexCover);
    }
}
