package com.startup;

import graphmodel.model.Graph;
import graphmodel.model.Node;

public class StartUp {

    public static void main(String[] args) {

        Node n1 = new Node(3, "XMR");
        Node n2 = new Node(2, "goes");
        Node n3 = new Node(1, "down");

        Graph g1 = new Graph();
        g1.addNode(n1, n2, n3);

        n1.setUserData("Frankfurt");
        n2.setUserData("Hamburg");
        n3.setUserData("München");

        g1.connect(n1, n2);


        System.out.println(n1.toString());
        System.out.println();
        System.out.println(n2.toString());
        System.out.println();
        System.out.println(n3.toString());
        System.out.println(g1.hasConnection(n1, n2));
        System.out.println(g1.hasConnection(n2, n1));
    }

}
