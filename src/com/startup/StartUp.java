/**
 * TODO: Write JUnit tests for all methods instead of testing it within StartUp class!
 * TODO: Sort all Nodes for its IDs!
 */
package com.startup;

import graphmodel.model.Edge;
import graphmodel.model.Graph;
import graphmodel.model.Node;
import parser.parser.TGFParser;
import writer.writer.TGFWriter;

import java.io.File;


public class StartUp {

    public static void main(String[] args) {
        Graph g1 = new Graph();
        TGFParser.parseTGF_File(new File("TGF_File.txt"), g1);

        for (Node n : g1.getAllNodes().values()) {
            System.out.println("Contains node " + n.getID() + " labeled: " + n.getLabel());
        }
        for (Edge e : g1.getAllEdges().values()) {
            System.out.println(e.getLabel());
        }
    }
}
