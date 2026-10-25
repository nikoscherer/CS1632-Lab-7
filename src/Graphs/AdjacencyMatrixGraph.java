package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyMatrixGraph extends Graph {
    private HashMap<Node, Integer> nodeIndex;
    private ArrayList<ArrayList<Double>> adjacencyMatrix;

    public AdjacencyMatrixGraph() {
        super();
        nodeIndex = new HashMap<>();
        adjacencyMatrix = new ArrayList<>();
    }

    @Override
    public void addNode(Node n) {
        super.addNode(n);
        int index = nodes.size() - 1;
        nodeIndex.put(n, index);

        // Expand existing rows for the new column
        for (ArrayList<Double> row : adjacencyMatrix) {
            row.add(0.0);
        }

        // Add a new row for the new node
        ArrayList<Double> newRow = new ArrayList<>();
        for (int i = 0; i <= index; i++) {
            newRow.add(0.0);
        }
        adjacencyMatrix.add(newRow);
    }

    @Override
    public void addConnection(Node n1, Node n2, double weight) {
        int i1 = nodeIndex.get(n1);
        int i2 = nodeIndex.get(n2);

        // Bi-directional setting
        adjacencyMatrix.get(i1).set(i2, weight);
        adjacencyMatrix.get(i2).set(i1, weight);
    }

    @Override
    public boolean addConnection(String n1name, String n2name, double weight) {
        Node n1 = getNode(n1name);
        Node n2 = getNode(n2name);

        if (n1 == null || n2 == null) {
            return false;
        }

        addConnection(n1, n2, weight);
        return true;
    }

    @Override
    public HashMap<Node, Double> getNeighbors(Node node) {
        HashMap<Node, Double> neighbors = new HashMap<>();
        Integer index = nodeIndex.get(node);
        if (index == null) {
            return neighbors;
        }

        ArrayList<Double> row = adjacencyMatrix.get(index);
        for (int i = 0; i < row.size(); i++) {
            double weight = row.get(i);
            if (weight > 0.0) {
                Node neighborNode = nodes.get(i);
                neighbors.put(neighborNode, weight);
            }
        }
        return neighbors;
    }
}