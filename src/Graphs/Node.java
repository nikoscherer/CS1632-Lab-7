package Graphs;

import java.util.HashMap;

public class Node {
    private String name;

    private HashMap<Node, Integer> neighbors;

    public Node(String name) {
        this.name = name;
        neighbors = new HashMap<Node, Integer>();
    }

    /**
     * Add neighbor to the node with a weight
     * @param n the neighbor node
     * @param weight the cost to traverse to the neighbor node
     */
    public void addNeighbor(Node n, int weight) {
        neighbors.put(n, weight);
    }

    /**
     * Add neighbor to the node
     * @param n the neighbor node
     */
    public void addNeighbor(Node n) {
        neighbors.put(n, 0);
    }

    public String getName() {
        return name;
    }

    public HashMap<Node, Integer> getNeighbors() {
        return neighbors;
    }
}
