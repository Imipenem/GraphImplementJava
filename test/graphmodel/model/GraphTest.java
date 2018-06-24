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
}