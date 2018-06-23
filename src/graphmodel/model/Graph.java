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
     * @throws IllegalArgumentException If one of the nodes already exists in the graphs map
     */
    public void addNode(Node... nodes) throws IllegalArgumentException {
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
     * @throws IllegalArgumentException If the method would create self loops (that is connecting a node to itsself)
     * @throws IllegalArgumentException If the two nodes are already connected
     */

    public void connect(Node source, Node target) throws IllegalArgumentException {

        if (!hasConnection(source, target) && !source.equals(target)) {
            Edge edge = new Edge(source, target);
            edge.setLabel("Connecting node " + source.getID() + " and its target Node " + target.getID());
            allEdges.put(edge.getLabel(), edge);
            source.getOutgoingEdges().add(edge);
            target.getIncomingEdges().add(edge);
        } else if (source.equals(target)) {
            throw new IllegalArgumentException("Connection failed: No self loops allowed!");
        } else {
            throw new IllegalArgumentException("Connection failed: Cannot connect two nodes that are already connected");
        }
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

    /**
     * This method disconnects two nodes, provided that there is an existing connection
     *
     * @param source Source Node
     * @param target Target Node
     * @throws IllegalArgumentException If there is no exisitng connection
     */

    public void disconnectUndirected(Node source, Node target) throws IllegalArgumentException {
        if (hasConnection(source, target)) {

            for (Edge e : getM_allEdges().values()) {

                if (e.getSourceNode().equals(source) && e.getTargetNode().equals(target) || e.getSourceNode().equals(target) && e.getTargetNode().equals(source)) {
                    getM_allEdges().values().remove(e);
                }
            }
        } else {
            throw new IllegalArgumentException("No disconnection needed: Nodes are not connected!");
        }
    }

    public Node getNodeForID(int id) {
        for (Node n : getM_allNodes().values()) {
            if (n.getID() == id) {
                return n;
            }
        }
        return null;
    }

    public Edge getEdgeForNodes(Node source, Node target) {
        for (Edge e : getM_allEdges().values()) {
            if (e.getSourceNode().equals(source) && e.getTargetNode().equals(target) || e.getSourceNode().equals(target) && e.getTargetNode().equals(source)) {
                return e;
            }
        }
        return null;
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
