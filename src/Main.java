import java.util.*;

public class Main {
    static class Graph {

        private final Set<Node> nodes = new HashSet<>();

        public void addNode(Node nodeA) {
            nodes.add(nodeA);
        }
    }

    static public class Node {
        private String name;

        private List<Node> shortestPath = new LinkedList<>();

        private Integer distance = Integer.MAX_VALUE;

        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }


        public Node(String name) {
            this.name = name;
        }
    }


    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

        Comparator<Node> cmp = new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.distance - o2.distance;
            }
        };

        PriorityQueue<Node> q = new PriorityQueue<>(cmp);


        source.distance = 0;

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        q.add(source);

        while (q.size() != 0) {
            Node currentNode = q.remove();
            for (Map.Entry<Node, Integer> adjacencyPair:
                    currentNode.adjacentNodes.entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    q.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set <Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.distance;
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void CalculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.distance;
        if (sourceDistance + edgeWeigh < evaluationNode.distance) {
            evaluationNode.distance = sourceDistance + edgeWeigh;
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.shortestPath);
            shortestPath.add(sourceNode);
            evaluationNode.shortestPath = shortestPath;
        }
    }

    public static void main(String[] args) {

        Graph G = new Graph();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        //Node D = new Node("D");

        A.adjacentNodes.put(B, 5);
        B.adjacentNodes.put(C, 7);
        G.nodes.add(A);
        G.nodes.add(B);

        System.out.println(calculateShortestPathFromSource(G, A));


    }
}