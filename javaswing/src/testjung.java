import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;

import javax.swing.*;
import java.awt.*;

public class testjung {

    UndirectedSparseGraph<String, String> g;

    public testjung() {
        g = new UndirectedSparseGraph<>();
    }

    public void addVertex(String s) {
        g.addVertex(s);
    }

    public void addEdge(String label, String v1, String v2) {
        g.addEdge(label, v1, v2);
    }


    public VisualizationImageServer<String, String> getImage() {
        VisualizationImageServer<String, String> vv = new VisualizationImageServer<>(new CircleLayout<>(g),
                new Dimension(600, 400));

        vv.getRenderContext().setVertexLabelTransformer(s -> s);
        vv.getRenderContext().setEdgeLabelTransformer(s -> s);

        return vv;
//        JFrame frame = new JFrame("My Graph");
//        frame.setLocationRelativeTo(null);
//        frame.getContentPane().add(vv);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
    }

    public static void main(String[] args) {
        testjung g = new testjung();
        g.addVertex("0");
        g.addVertex("1");
        g.addVertex("2");
        g.addVertex("3");
        g.addVertex("4");
        g.addVertex("5");
        g.addVertex("6");

        g.addEdge("Edge0", "0", "1");
        g.addEdge("Edge1", "0", "2");
        g.addEdge("Edge3", "2", "1");
        g.addEdge("Edge8", "2", "3");
        g.addEdge("Edge4", "3", "4");
        g.addEdge("Edge5", "3", "5");
        g.addEdge("Edge6", "3", "6");
        g.addEdge("Edge7", "4", "6");

    }
}
