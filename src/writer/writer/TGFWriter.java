package writer.writer;

import graphmodel.model.Graph;
import graphmodel.model.Node;
import graphmodel.model.Edge;

import java.io.*;

public class TGFWriter {

    public static void writeGraphToFile(Graph... graphs) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("TGF_File.txt", true), "utf-8"))) {

            for (Graph graph : graphs) {

                for (Node n : graph.getAllNodes().values()) {
                    writer.write(n.getID() + " " + n.getLabel());
                    ((BufferedWriter) writer).newLine();
                }
                writer.write("#");
                ((BufferedWriter) writer).newLine();

                for (Edge e : graph.getAllEdges().values()) {
                    writer.write(e.getSourceNode().getID() + " " + e.getTargetNode().getID() + " " + e.getLabel());
                    ((BufferedWriter) writer).newLine();
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
