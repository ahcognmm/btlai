import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;

import java.awt.*;

public class Jung {

    UndirectedSparseGraph<String, String> g;

    public Jung() {
        g = new UndirectedSparseGraph<>();
    }

    public void addVertex(String s) {
        g.addVertex(s);
    }

    public void addEdge(String label, String v1, String v2) {
        g.addEdge(label, v1, v2);
    }


    public VisualizationImageServer<String, String> getImage(boolean edge) {
        VisualizationImageServer<String, String> vv = new VisualizationImageServer<>(new CircleLayout<>(g),
                new Dimension(600, 400));

        vv.getRenderContext().setVertexLabelTransformer(s -> s);
        if (edge)
            vv.getRenderContext().setEdgeLabelTransformer(s -> s);

        return vv;
//        JFrame frame = new JFrame("My Graph");
//        frame.setLocationRelativeTo(null);
//        frame.getContentPane().add(vv);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
    }
}
