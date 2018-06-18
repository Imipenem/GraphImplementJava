package graphmodel.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the graph as a graphmodel.model.
 * It´s responsible for performing actions on the graph, affecting its components.
 */

public class Graph {

    private Map<String, Node> allNodes;
    private Map<String, Edge> allEdges;


    public Graph(Map<String, Node> allNodes, Map<String, Edge> allEdges) {
        this.allNodes = allNodes;
        this.allEdges = allEdges;
    }

    public Graph() {
        allEdges = new HashMap<>();
        allNodes = new HashMap<>();
    }


    /**
     * This method adds 0 to n Nodes to the graph, so that the graph is aware of the nodes
     *
     * @param nodes the amount of n nodes to be added
     */
    public void addNode(Node... nodes) {
        for (Node n : nodes) {
            if (allNodes.containsValue(n)) {
                throw new IllegalArgumentException("Attempted to add an already existing node!");
            }
            allNodes.put(n.getLabel(), n);
        }
    }

    /**
     * This method connects two nodes with an edge
     *
     * @param source the source Node
     * @param target the target Node
     */

    public void connect(Node source, Node target) {
        Edge edge = new Edge(source, target);
        edge.setLabel("Connecting node " + source.getID() + " and its target Node " + target.getID());
        allEdges.put(edge.getLabel(), edge);
        source.getOutgoingEdges().add(edge);
        target.getIncomingEdges().add(edge);
    }

    /**
     * Checks if two nodes are connected
     *
     * @param source Source Node
     * @param target Target Node
     * @return if the nodes are already connected
     */

    public boolean hasConnection(Node source, Node target) {

        for (Edge e : allEdges.values()) {

            if (e.getSourceNode().equals(source) && e.getTargetNode().equals(target)) {
                return true;
            } else if (e.getSourceNode().equals(target) && e.getTargetNode().equals(source)) {
                return true;
            }
        }
        return false;
    }


    public Map<String, Node> getM_allNodes() {
        return allNodes;
    }

    public Map<String, Edge> getM_allEdges() {
        return allEdges;
    }


    public void setM_allNodes(Map<String, Node> m_allNodes) {
        this.allNodes = m_allNodes;
    }

    public void setM_allEdges(Map<String, Edge> m_allEdges) {
        this.allEdges = m_allEdges;
    }
}
