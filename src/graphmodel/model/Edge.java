package graphmodel.model;

public class Edge {


    /**
     * This class represents an edge of the graph, connecting two nodes (dircted/undirected)
     */

    private Node sourceNode;
    private Node targetNode;
    private int ID;
    private String label;


    public Edge(Node sourceNode, Node targetNode) {
        this.sourceNode = sourceNode;
        this.targetNode = targetNode;
    }

    public Edge(Node sourceNode, Node targetNode, int ID, String label) {
        this.sourceNode = sourceNode;
        this.targetNode = targetNode;
        this.ID = ID;
        this.label = label;
    }

    //-----------------GETTERS---------------------

    public Node getSourceNode() {
        return sourceNode;
    }

    public Node getTargetNode() {
        return targetNode;
    }

    public int getID() {
        return ID;
    }

    public String getLabel() {
        return label;
    }

    //-----------------SETTERS---------------------

    public void setSourceNode(Node sourceNode) {
        this.sourceNode = sourceNode;
    }

    public void setTargetNode(Node targetNode) {
        this.targetNode = targetNode;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

