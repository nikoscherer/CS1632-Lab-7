package Graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListGraphTest {

    @Test
    void addConnection() {
        AdjacencyListGraph graph = new AdjacencyListGraph();

        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);

        assertTrue(graph.contains(n1));

        assertTrue(graph.contains("B"));

        assertTrue(graph.contains(n3));
        assertTrue(graph.contains("C"));
    }
}