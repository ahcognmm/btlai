import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
/*
 * Created by JFormDesigner on Sat Nov 10 21:38:07 ICT 2018
 */


/**
 * @author unknown
 */
public class App extends JFrame {

    private Jung g = new Jung();
    private Jung graphRs = new Jung();
    public HashMap<String, Node> listNode = new HashMap<String, Node>();
    public ArrayList<ArrayList<Edge>> listEdge = new ArrayList<>();

    public ArrayList<String> CityList = new ArrayList<>();

    public App() {
        initComponents();
        listNode.put("Bucharest", new Node("Bucharest", 0));
        g.addVertex("Bucharest");
        comboBox1.addItem("Bucharest");
        comboBox2.addItem("Bucharest");
        cityStart.addItem("Bucharest");
        comboBox1.setEnabled(false);
        comboBox2.setEnabled(false);
        cityStart.setEnabled(false);
        result.setEditable(false);
    }

    private void addCityAction(ActionEvent e) {
        // TODO add your code here
        String city = cityTf.getText();
        double h_score = Double.parseDouble(hsScore.getText());
        if (!CityList.contains(city) && !city.equals("") && !city.matches("[\\s+]")) {
            CityList.add(city);
            g.addVertex(city);
            comboBox1.addItem(city);
            comboBox1.setEnabled(true);
            comboBox2.addItem(city);
            cityStart.addItem(city);
            listNode.put(city, new Node(city, h_score));
        }
        cityTf.setText("");
        hsScore.setText("");
        cityTf.requestFocus();
    }

    private void selectItem(ActionEvent e) {
        // TODO add your code here
        comboBox2.setEnabled(true);
    }

    private void addDistanceAction(ActionEvent e) {
        System.out.println(listNode.values().toString());
        // TODO add your code here
        String city1 = comboBox1.getSelectedItem().toString();
        String city2 = comboBox2.getSelectedItem().toString();
        if (!city1.equals(city2)) {
            double distance = Double.parseDouble(distanceTf.getText());
            String rs = city1 + "--" + city2 + " : " + distance;
//            if(distance >= listNode.)
            cityStart.setEnabled(true);
            System.out.println(listNode.get(city1).value);
            System.out.println(listNode.get(city2).value);
            listNode.get(city1).adjacencies.add(new Edge(listNode.get(city2), distance));
            listNode.get(city2).adjacencies.add(new Edge(listNode.get(city1), distance));
            g.addEdge(String.valueOf(distance), city1, city2);
            listNode.get(city1).adjacencies.forEach(i -> {
                System.out.println(i.toString());
            });
        }
    }

    private void showDialog(ActionEvent e) {
        // TODO add your code here

        HashMap<String, Node> listNode1 = this.listNode;

        String city1 = cityStart.getSelectedItem().toString();
        AstarSearchAlgo algo = new AstarSearchAlgo();
        algo.AstarSearch(listNode1.get(city1), listNode1.get("Bucharest"));

        ArrayList<Node> arr = (ArrayList<Node>) algo.printPath(listNode1.get("Bucharest"));
        for (int i = 0; i < arr.size(); i++) {
            graphRs.addVertex(arr.get(i).value);
            if (i >= 1) {
                graphRs.addEdge("edge" + i, arr.get(i).value, arr.get(i - 1).value);
            }
        }
//        double cost = 0;
//        for (Node i : algo.printPath(listNode.get("Bucharest"))) {
//            for (Edge ee : i.adjacencies) {
//                if (i.parent.equals(ee.target.value)) {
//                    cost += ee.cost;
//                }
//            }
//        }

        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(graphRs.getImage(false));
        frame.pack();
        frame.setVisible(true);

    }

    private void showgraph(ActionEvent e) {
        // TODO add your code here
        JFrame frame = new JFrame("My Graph");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(g.getImage(true));
        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ahcogn
        label1 = new JLabel();
        cityTf = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        label3 = new JLabel();
        comboBox2 = new JComboBox();
        label4 = new JLabel();
        distanceTf = new JTextField();
        button2 = new JButton();
        label5 = new JLabel();
        cityStart = new JComboBox();
        startAstar = new JButton();
        label7 = new JLabel();
        hsScore = new JTextField();
        button5 = new JButton();
        dialog1 = new JDialog();
        scrollPane2 = new JScrollPane();
        result = new JTextArea();
        dialog2 = new JDialog();
        scrollPane3 = new JScrollPane();
        information = new JTextArea();

        //======== this ========
        setTitle("A START DEMO");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Thanh Pho");
        contentPane.add(label1);
        label1.setBounds(40, 4, 220, 40);
        contentPane.add(cityTf);
        cityTf.setBounds(40, 44, 250, 45);

        //---- button1 ----
        button1.setText("OK");
        button1.addActionListener(e -> addCityAction(e));
        contentPane.add(button1);
        button1.setBounds(40, 180, 120, 30);

        //---- label2 ----
        label2.setText(" Thanh pho 1");
        contentPane.add(label2);
        label2.setBounds(35, 223, 220, 40);

        //---- comboBox1 ----
        comboBox1.addActionListener(e -> selectItem(e));
        contentPane.add(comboBox1);
        comboBox1.setBounds(35, 280, 280, 40);

        //---- label3 ----
        label3.setText(" Thanh pho 2");
        contentPane.add(label3);
        label3.setBounds(35, 340, 220, 40);
        contentPane.add(comboBox2);
        comboBox2.setBounds(35, 395, 280, 40);

        //---- label4 ----
        label4.setText("Khoang cach ");
        contentPane.add(label4);
        label4.setBounds(35, 445, 220, 40);
        contentPane.add(distanceTf);
        distanceTf.setBounds(35, 490, 250, 45);

        //---- button2 ----
        button2.setText("OK");
        button2.addActionListener(e -> addDistanceAction(e));
        contentPane.add(button2);
        button2.setBounds(40, 560, 120, 30);

        //---- label5 ----
        label5.setText("Thanh pho xuat phat");
        contentPane.add(label5);
        label5.setBounds(425, 100, 220, 40);

        //---- cityStart ----
        cityStart.addActionListener(e -> selectItem(e));
        contentPane.add(cityStart);
        cityStart.setBounds(425, 155, 280, 40);

        //---- startAstar ----
        startAstar.setText("OK");
        startAstar.addActionListener(e -> showDialog(e));
        contentPane.add(startAstar);
        startAstar.setBounds(425, 245, 120, startAstar.getPreferredSize().height);

        //---- label7 ----
        label7.setText("Khoang cach chim bay v\u1edbi Bucharest");
        contentPane.add(label7);
        label7.setBounds(40, 89, 250, 40);
        contentPane.add(hsScore);
        hsScore.setBounds(40, 129, 250, 45);

        //---- button5 ----
        button5.setText("show graph");
        button5.addActionListener(e -> showgraph(e));
        contentPane.add(button5);
        button5.setBounds(195, 560, 120, 30);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());

        //======== dialog1 ========
        {
            dialog1.setTitle("KET QUA TIM DUONG");
            Container dialog1ContentPane = dialog1.getContentPane();
            dialog1ContentPane.setLayout(null);

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(result);
            }
            dialog1ContentPane.add(scrollPane2);
            scrollPane2.setBounds(15, 15, 445, 175);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialog1ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = dialog1ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialog1ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialog1ContentPane.setMinimumSize(preferredSize);
                dialog1ContentPane.setPreferredSize(preferredSize);
            }
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            dialog2.setTitle("Th\u00f4ng b\u00e1o");
            Container dialog2ContentPane = dialog2.getContentPane();
            dialog2ContentPane.setLayout(null);

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(information);
            }
            dialog2ContentPane.add(scrollPane3);
            scrollPane3.setBounds(10, 10, 275, 125);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialog2ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = dialog2ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialog2ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialog2ContentPane.setMinimumSize(preferredSize);
                dialog2ContentPane.setPreferredSize(preferredSize);
            }
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ahcogn
    private JLabel label1;
    private JTextField cityTf;
    private JButton button1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JLabel label3;
    private JComboBox comboBox2;
    private JLabel label4;
    private JTextField distanceTf;
    private JButton button2;
    private JLabel label5;
    private JComboBox cityStart;
    private JButton startAstar;
    private JLabel label7;
    private JTextField hsScore;
    private JButton button5;
    private JDialog dialog1;
    private JScrollPane scrollPane2;
    private JTextArea result;
    private JDialog dialog2;
    private JScrollPane scrollPane3;
    private JTextArea information;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame = new App();
        frame.setVisible(true);
    }
}
