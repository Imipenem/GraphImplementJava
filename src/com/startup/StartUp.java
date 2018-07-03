/**
 * TODO: Write JUnit tests for all methods instead of testing it within StartUp class!
 */
package com.startup;

import graphmodel.model.Graph;
import graphmodel.model.Node;
import writer.writer.TGFWriter;


public class StartUp {

    public static void main(String[] args) {

        Node n1 = new Node(3, "XMR");
        Node n2 = new Node(2, "goes");
        Node n3 = new Node(1, "down");

        Graph g1 = new Graph();
        g1.addNode(n1, n2, n3);
        g1.connect(n1, n2);
        g1.connect(n2, n3);
        g1.connect(n3, n1);

        Graph g2 = new Graph();
        g2.addNode(n1, n2);
        g2.connect(n2,n1);


        TGFWriter.writeGraphToFile(g1,g2);
    }
}
