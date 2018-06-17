package graphModel;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the graph as a graphModel.model.
 * It´s responsible for performing actions on the graph, affecting its components.
 */

public class Graph {

    Map<String, Node> m_allNodes;
    Map<String, Edge> m_allEdges;


    public Graph(Map<String, Node> m_allNodes, Map<String, Edge> m_allEdges) {
        this.m_allNodes = m_allNodes;
        this.m_allEdges = m_allEdges;
    }

    public Graph() {
        m_allEdges = new HashMap<>();
        m_allNodes = new HashMap<>();
    }


    /**
     * This method adds 0 to n Nodes to the graph, so that the graph is aware of the nodes
     *
     * @param nodes the amount of n nodes to be added
     */
    public void addNode(Node... nodes) {
        for (Node n : nodes) {
            if (m_allNodes.containsValue(n)) {
                throw new IllegalArgumentException("Attempted to add an already existing node!");
            }
            m_allNodes.put(n.getLabel(), n);
        }
    }

    /**
     * This method connects two nodes with an edge
     *
     * @param source the source Node
     * @param target the target Node
     */

    public void connect (Node source, Node target) {
        Edge edge = new Edge(source,target);
        edge.setLabel("Connecting node "+source.getID()+" and its target Node "+target.getID());
        m_allEdges.put(edge.getLabel(),edge);
        source.getOutgoingEdges().add(edge);
        target.getIncomingEdges().add(edge);
    }

    /**
     *
     * Checks if two nodes are connected
     *
     * @param source Source Node
     * @param target Target Node
     * @return if the nodes are already connected
     *
     * TODO: Requires clever method for other direction!
     */

    public boolean hasConnection(Node source,Node target) {
        for (Edge e: source.getOutgoingEdges()) {
            if((e.getTargetNode().equals(target))){
                return true;
            }
        }
        return false;
    }


    public Map<String, Node> getM_allNodes() {
        return m_allNodes;
    }

    public Map<String, Edge> getM_allEdges() {
        return m_allEdges;
    }


    public void setM_allNodes(Map<String, Node> m_allNodes) {
        this.m_allNodes = m_allNodes;
    }

    public void setM_allEdges(Map<String, Edge> m_allEdges) {
        this.m_allEdges = m_allEdges;
    }
}
