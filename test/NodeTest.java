import Graphs.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void testANeighbor_Weighted() {
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");

        n1.addNeighbor(n2, 5.0);
        n2.addNeighbor(n1, 5.0);

        assertEquals(5, n1.getNeighbors().get(n2));
        assertEquals(5, n2.getNeighbors().get(n1));

        n1.addNeighbor(n3);
        n3.addNeighbor(n1);

        assertTrue(n1.getNeighbors().containsKey(n3));
        assertTrue(n3.getNeighbors().containsKey(n1));
    }

    @Test
    void testANeighbor_Unweighted() {
        Node n1 = new Node("B");
        Node n2 = new Node("C");

        n1.addNeighbor(n2);
        n2.addNeighbor(n1);

        assertTrue(n1.getNeighbors().containsKey(n2));
        assertTrue(n2.getNeighbors().containsKey(n1));
    }

    @Test
    void getName() {
        Node n1 = new Node("A");
        assertEquals("A", n1.getName());
    }
}