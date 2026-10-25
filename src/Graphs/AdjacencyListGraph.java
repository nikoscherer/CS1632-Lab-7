package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacencyListGraph extends Graph {
    public AdjacencyListGraph() {
        super();
    }

    @Override
    public void addConnection(Node n1, Node n2, double weight) {
        n1.addNeighbor(n2, weight);
        n2.addNeighbor(n1, weight);
    }

    @Override
    public boolean addConnection(String n1name, String n2name, double weight) {
        Node n1 = nodeMap.get(n1name);
        Node n2 = nodeMap.get(n2name);

        // One of these nodes do not exist in the graph
        if (n1 == null || n2 == null) {
            return false;
        }

        addConnection(n1, n2, weight);
        return true;
    }

    public HashMap<Node, Double> getNeighbors(Node node) {
        return node.getNeighbors();
    }
}