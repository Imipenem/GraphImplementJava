package graphmodel.model;

import java.util.ArrayList;

/**
 * This class represents a single Node of a Graph:
 * <p>
 * The Node is identified by an ID/ a label and can hold a value of any type (Object).
 * Furthermore the Node itsself keeps track of its current Edges and its state.
 */

enum STATUS {
    NOT_VISITED("Not yet visited"), VISITED("Already visited"), VISITING("Currently visiting");

    private final String statusDescription;

    STATUS(String value) {
        statusDescription = value;
    }

    public String getStatusDescription() {
        return statusDescription;
    }
}

public class Node {

    private int ID;
    private int weight;
    private String label;
    private Object UserData;
    private STATUS status;
    private ArrayList<Edge> IncomingEdges;
    private ArrayList<Edge> OutgoingEdges;

    public Node(int ID, int weight, String label, Object userData) {
        this.ID = ID;
        this.weight = weight;
        this.label = label;
        UserData = userData;
        status = STATUS.NOT_VISITED;
        IncomingEdges = new ArrayList<>();
        OutgoingEdges = new ArrayList<>();
    }

    public Node(int ID, int weight, String label) {
        this.ID = ID;
        this.weight = weight;
        this.label = label;
        status = STATUS.NOT_VISITED;
        UserData = new Object();
        IncomingEdges = new ArrayList<>();
        OutgoingEdges = new ArrayList<>();
    }

    public Node(int ID, String label) {
        this.ID = ID;
        this.label = label;
        status = STATUS.NOT_VISITED;
        UserData = new Object();
        IncomingEdges = new ArrayList<>();
        OutgoingEdges = new ArrayList<>();
    }

    //GETTERS --------------------------------------------

    public STATUS getStatus() {

        return status;
    }

    public int getID() {
        return ID;
    }

    public int getWeight() {
        return weight;
    }

    public String getLabel() {
        return label;
    }

    public Object getUserData() {
        return UserData;
    }

    public ArrayList<Edge> getIncomingEdges() {
        return IncomingEdges;
    }

    public ArrayList<Edge> getOutgoingEdges() {
        return OutgoingEdges;
    }

    //SETTERS -------------------------------------------

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setUserData(Object userData) {
        UserData = userData;
    }

    public void setIncomingEdges(ArrayList<Edge> incomingEdges) {
        IncomingEdges = incomingEdges;
    }

    public void setOutgoingEdges(ArrayList<Edge> outgoingEdges) {
        OutgoingEdges = outgoingEdges;
    }


    /**
     * @Override
     * Represents the textual contents of a node
     */

    public String toString() {
        return "NodeID: " + ID + "\n" +
                "NodeLabel: " + label + "\n" +
                "Current Status: " + status.getStatusDescription() + "\n" +
                "UserData: " + UserData.toString() + "\n" +
                "Node Weight: " + weight;
    }
}
