package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacencyListGraph {
    private List<Node> nodes;
    private HashMap<String, Node> nodeMap;

    public AdjacencyListGraph() {
        nodes = new ArrayList<>();
        nodeMap = new HashMap<>();
    }

    public void addConnection(Node n1, Node n2, int weight) {
        n1.addNeighbor(n2, weight);
        n2.addNeighbor(n1, weight);
    }

    public boolean addConnection(String n1name, String n2name, int weight) {
        Node n1 = nodeMap.get(n1name);
        Node n2 = nodeMap.get(n2name);

        // One of these nodes do not exist in the graph
        if (n1 == null || n2 == null) {
            return false;
        }

        addConnection(n1, n2, weight);
        return true;
    }

    public void addNode(Node n) {
        nodes.add(n);
        nodeMap.put(n.getName(), n);
    }

    public boolean contains(Node node) {
        return nodes.contains(node);
    }

    public Node getNode(String nodeName) {
        return nodeMap.get(nodeName);
    }

    public boolean contains(String nodeName) {
        return nodeMap.containsKey(nodeName);
    }
}