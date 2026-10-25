package Graphs;

import java.util.HashMap;

public class Node {
    private String name;

    private HashMap<Node, Double> neighbors;

    public Node(String name) {
        this.name = name;
        neighbors = new HashMap<Node, Double>();
    }

    /**
     * Add neighbor to the node with a weight
     * @param n the neighbor node
     * @param weight the cost to traverse to the neighbor node
     */
    public void addNeighbor(Node n, Double weight) {
        neighbors.put(n, weight);
    }

    /**
     * Add neighbor to the node
     * @param n the neighbor node
     */
    public void addNeighbor(Node n) {
        neighbors.put(n, 0.0);
    }

    public String getName() {
        return name;
    }

    public HashMap<Node, Double> getNeighbors() {
        return neighbors;
    }
}
