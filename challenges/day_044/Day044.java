import java.util.*;

public class Day044 {

    public static void main(String[] args) {
        Node start = new Node("Start");
        Node goal = new Node("Goal");
        Graph graph = new Graph();

        graph.addNode(start);
        graph.addNode(goal);

        graph.addEdge(start, goal, 1); 

        AStar aStar = new AStar(graph);
        List<Node> path = aStar.findPath(start, goal);

        for (Node node : path) {
            System.out.print(node.getName() + " ");
        }
    }

    static class Node {
        private String name;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class Edge {
        private Node from;
        private Node to;
        private double cost;

        public Edge(Node from, Node to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public Node getFrom() {
            return from;
        }

        public Node getTo() {
            return to;
        }

        public double getCost() {
            return cost;
        }
    }

    static class Graph {
        private Map<Node, List<Edge>> adjList = new HashMap<>();

        public void addNode(Node node) {
            adjList.putIfAbsent(node, new ArrayList<>());
        }

        public void addEdge(Node from, Node to, double cost) {
            adjList.get(from).add(new Edge(from, to, cost));
        }

        public List<Edge> getNeighbors(Node node) {
            return adjList.getOrDefault(node, new ArrayList<>());
        }
    }

    static class AStar {
        private Graph graph;

        public AStar(Graph graph) {
            this.graph = graph;
        }

        public List<Node> findPath(Node start, Node goal) {
            PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(node -> fScore.getOrDefault(node, Double.MAX_VALUE)));
            Map<Node, Node> cameFrom = new HashMap<>();
            Map<Node, Double> gScore = new HashMap<>();
            Map<Node, Double> fScore = new HashMap<>();

            gScore.put(start, 0.0);
            fScore.put(start, heuristic(start, goal));
            openSet.add(start);

            while (!openSet.isEmpty()) {
                Node current = openSet.poll();

                if (current.equals(goal)) {
                    return reconstructPath(cameFrom, current);
                }

                for (Edge edge : graph.getNeighbors(current)) {
                    Node neighbor = edge.getTo();
                    double tentativeGScore = gScore.getOrDefault(current, Double.MAX_VALUE) + edge.getCost();

                    if (tentativeGScore < gScore.getOrDefault(neighbor, Double.MAX_VALUE)) {
                        cameFrom.put(neighbor, current);
                        gScore.put(neighbor, tentativeGScore);
                        fScore.put(neighbor, tentativeGScore + heuristic(neighbor, goal));

                        if (!openSet.contains(neighbor)) {
                            openSet.add(neighbor);
                        }
                    }
                }
            }

            return Collections.emptyList();

        private double heuristic(Node a, Node b) {
            return 0;
        }

        private List<Node> reconstructPath(Map<Node, Node> cameFrom, Node current) {
            List<Node> totalPath = new ArrayList<>();
            totalPath.add(current);

            while (cameFrom.containsKey(current)) {
                current = cameFrom.get(current);
                totalPath.add(current);
            }

            Collections.reverse(totalPath);
            return totalPath;
        }
    }
}
