package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Graph {
    protected List<Node> nodes;
    protected HashMap<String, Node> nodeMap;

    public Graph() {
        nodes = new ArrayList<>();
        nodeMap = new HashMap<>();
    }

    public abstract void addConnection(Node n1, Node n2, double weight);

    public abstract boolean addConnection(String n1name, String n2name,
                                   double weight);

    public abstract HashMap<Node, Double> getNeighbors(Node node);

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