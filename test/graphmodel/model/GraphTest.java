package graphmodel.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void addNode() {
        Graph testGraph = new Graph();
        Node testNode1 = new Node(10, "Ich bin Test Node 1");
        testGraph.addNode(testNode1);

        assertTrue(testGraph.getAllNodes().containsValue(testNode1));
    }

    @Test
    void addMoreThanOneNode() {
        Graph testGraph = new Graph();
        Node testNode1 = new Node(10, "Ich bin Test Node 1");
        Node testNode2 = new Node(100, "Ich bin Test Node 2");
        Node testNode3 = new Node(1000, "Ich bin Test Node 3");
        Node testNode4 = new Node(10000, "Ich bin Test Node 4");
        Map<String, Node> expected = new HashMap<>();
        expected.put("Ich bin Test Node 1", testNode1);
        expected.put("Ich bin Test Node 2", testNode2);
        expected.put("Ich bin Test Node 3", testNode3);
        expected.put("Ich bin Test Node 4", testNode4);

        testGraph.addNode(testNode1, testNode2, testNode3, testNode4);
        assertThat(testGraph.getAllNodes(), is(expected));

    }

    @Test
    void alreadyAddedNodeWillNotBeAdded() {
        Graph testGraph = new Graph();
        Node testNode1 = new Node(10, "Ich bin Test Node 1");
        testGraph.addNode(testNode1);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> testGraph.addNode(testNode1));
        assertEquals("Attempted to add an already existing node!", exception.getMessage());
    }

    @Test
    void connect() {
        Graph testGraph = new Graph();
        Node testNode1 = new Node(10, "Ich bin Test Node 1");
        Node testNode2 = new Node(100, "Ich bin Test Node 2");

        assertEquals(0, testNode1.getOutgoingEdges().size());
        assertEquals(0, testNode2.getIncomingEdges().size());

        testGraph.connect(testNode1, testNode2);

        assertTrue(testGraph.getAllEdges().containsKey("Connecting node " + testNode1.getID() + " and its target Node " + testNode2.getID()));
        assertThat(testGraph.getAllEdges().size(), is(1));
        assertEquals(1, testNode1.getOutgoingEdges().size());
        assertEquals(1, testNode2.getIncomingEdges().size());
    }

    @Test
    void severalNodesGetConnectedCorrectly() {
        Graph testGraph = new Graph();
        Node testNode1 = new Node(10, "Ich bin Test Node 1");
        Node testNode2 = new Node(100, "Ich bin Test Node 2");
        Node testNode3 = new Node(1000, "Ich bin Test Node 3");
        Node testNode4 = new Node(10000, "Ich bin Test Node 4");

        assertEquals(0, testNode1.getOutgoingEdges().size());
        assertEquals(0, testNode2.getIncomingEdges().size());
        assertEquals(0, testNode3.getOutgoingEdges().size());
        assertEquals(0, testNode4.getIncomingEdges().size());

        testGraph.connect(testNode1, testNode2);
        testGraph.connect(testNode1, testNode4);
        testGraph.connect(testNode3, testNode2);
        testGraph.connect(testNode3, testNode4);

        assertTrue(testGraph.getAllEdges().containsKey("Connecting node " + testNode1.getID() + " and its target Node " + testNode2.getID()));
        assertTrue(testGraph.getAllEdges().containsKey("Connecting node " + testNode1.getID() + " and its target Node " + testNode4.getID()));
        assertTrue(testGraph.getAllEdges().containsKey("Connecting node " + testNode3.getID() + " and its target Node " + testNode2.getID()));
        assertTrue(testGraph.getAllEdges().containsKey("Connecting node " + testNode3.getID() + " and its target Node " + testNode4.getID()));
        assertThat(testGraph.getAllEdges().size(), is(4));
        assertEquals(2, testNode1.getOutgoingEdges().size());
        assertEquals(2, testNode2.getIncomingEdges().size());
        assertEquals(2, testNode3.getOutgoingEdges().size());
        assertEquals(2, testNode4.getIncomingEdges().size());
    }
}