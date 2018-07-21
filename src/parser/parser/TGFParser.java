package parser.parser;

import graphmodel.model.Edge;
import graphmodel.model.Graph;
import graphmodel.model.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TGFParser {

    public static void parseTGF_File(File tgfFile, Graph graph) {

        boolean delimiterReached = false;

        try (BufferedReader br = new BufferedReader(new FileReader(tgfFile))) {
            String line = br.readLine();

            while (line != null) {
                if (line.equals("#")) {
                    delimiterReached = true;
                    line = br.readLine();
                }

                if (!delimiterReached) {
                    parseNodes(line, graph);
                } else {
                    parseEdges(line, graph);
                }
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method parses the TGF-representation of a node into an actually existing node and add this node to the graph.
     * <p>
     * CAVE: This only works, if the node has the correct TGF-format: "NodeID(which must be an Integer) NodeLabel"!
     *
     * @param nodeTGF current line offers a (syntactically correct) description of a node in TGF-format
     * @param graph   the graph, that will be created
     * @throws IllegalArgumentException if nodeTGF doesn´t match the correct pattern as described above
     */
    private static void parseNodes(String nodeTGF, Graph graph) throws IllegalArgumentException {
        String[] nodeAttributes;
        nodeAttributes = nodeTGF.split(" ");
        if (nodeAttributes.length > 2 || !nodeAttributes[0].matches("[0-9]*")) {
            throw new IllegalArgumentException("ERROR: Invalid TGF-File syntax detected!" +
                    "\n Node description needs to match following pattern" +
                    "\n NodeID(must be an Integer) NodeLabel");
        }
        Node coming_Node = new Node(Integer.parseInt(nodeAttributes[0]), nodeAttributes[1]);
        graph.addNode(coming_Node);
    }

    /**
     * This method parses the TGF-representation of an edge (e.g the connection between two nodes) into the graph.
     * <p>
     * CAVE: This only works, if the connection has the correct TGF-format: "NodeID_SourceNode(Integer) NodeID_TargetNode(Integer) EdgeLabel"!
     *
     * @param edgeTGF current line offers a (syntactically correct) description of an edge in TGF-format
     * @param graph   the graph, that will be created
     * @throws IllegalArgumentException if nodeTGF doesn´t match the correct pattern as described above
     */
    private static void parseEdges(String edgeTGF, Graph graph) throws IllegalArgumentException {
        String[] edgeAttributes;
        edgeAttributes = edgeTGF.split(" ", 3);
        if (edgeAttributes.length > 3 || !edgeAttributes[0].matches("[0-9]*") || !edgeAttributes[1].matches("[0-9]*")) {
            throw new IllegalArgumentException("ERROR: Invalid TGF-File syntax detected!" +
                    "\n Connection description needs to match following pattern" +
                    "\n NodeID_SourceNode(Integer) NodeID_TargetNode(Integer) EdgeLabel");
        }
        Node sourceNode = graph.getNodeForID(Integer.parseInt(edgeAttributes[0]));
        Node targetNode = graph.getNodeForID(Integer.parseInt(edgeAttributes[1]));
        graph.connect(sourceNode, targetNode);
    }
}
