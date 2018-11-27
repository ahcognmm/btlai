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
public class testa extends JFrame {

    private testjung g = new testjung();
    private testjung graphRs = new testjung();
    public HashMap<String, Node> listNode = new HashMap<String, Node>();
    public ArrayList<ArrayList<Edge>> listEdge = new ArrayList<>();

    public ArrayList<String> CityList = new ArrayList<>();

    public testa() {
        initComponents();
        listNode.put("Bucharest", new Node("Bucharest", 0));
        g.addVertex("Bucharest");
        comboBox1.addItem("Bucharest");
        comboBox2.addItem("Bucharest");
        cityStart.addItem("Bucharest");
        comboBox1.setEnabled(false);
        comboBox2.setEnabled(false);
        cityStart.setEnabled(false);
        viewRs.setEditable(false);
        viewRs2.setEditable(false);
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
            viewRs2.append(city + "-->tp.A::" + h_score + "\n");
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
            viewRs.append(rs);
            viewRs.append("\n");
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

        String city1 = cityStart.getSelectedItem().toString();
        AstarSearchAlgo algo = new AstarSearchAlgo();
        algo.AstarSearch(listNode.get(city1), listNode.get("tp.A"));

        ArrayList<Node> arr = (ArrayList<Node>) algo.printPath(listNode.get("tp.A"));
        for (int i = 0; i < arr.size(); i++) {
            graphRs.addVertex(arr.get(i).value);
            if (i >= 1) {
                graphRs.addEdge("edge" + i, arr.get(i).value, arr.get(i - 1).value);
            }
        }
        double cost = 0;
//        for (Node i : algo.printPath(listNode.get("tp.A"))) {
//            for (Edge ee : i.adjacencies) {
//                if (i.parent.equals(ee.target.value)) {
//                    cost += ee.cost;
//                }
//            }
//        }

        JFrame frame = new JFrame("Cost::" + cost);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(graphRs.getImage());
        frame.pack();
        frame.setVisible(true);

    }

    private void showgraph(ActionEvent e) {
        // TODO add your code here
        JFrame frame = new JFrame("My Graph");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(g.getImage());
        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ngoc ha
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
        scrollPane1 = new JScrollPane();
        viewRs = new JTextArea();
        label5 = new JLabel();
        cityStart = new JComboBox();
        startAstar = new JButton();
        label7 = new JLabel();
        hsScore = new JTextField();
        viewRs2 = new JTextArea();
        button5 = new JButton();
        dialog1 = new JDialog();
        scrollPane2 = new JScrollPane();
        result = new JTextArea();
        dialog2 = new JDialog();
        scrollPane3 = new JScrollPane();
        information = new JTextArea();
        this2 = new JFrame();
        label6 = new JLabel();
        cityTf2 = new JTextField();
        button3 = new JButton();
        label8 = new JLabel();
        comboBox3 = new JComboBox();
        label9 = new JLabel();
        comboBox4 = new JComboBox();
        label10 = new JLabel();
        distanceTf2 = new JTextField();
        button4 = new JButton();
        scrollPane4 = new JScrollPane();
        viewRs3 = new JTextArea();
        label11 = new JLabel();
        cityStart2 = new JComboBox();
        startAstar2 = new JButton();
        label12 = new JLabel();
        hsScore2 = new JTextField();
        viewRs4 = new JTextArea();

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

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(viewRs);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(385, 35, 290, 525);

        //---- label5 ----
        label5.setText(" Thanh pho 1");
        contentPane.add(label5);
        label5.setBounds(1020, 105, 220, 40);

        //---- cityStart ----
        cityStart.addActionListener(e -> selectItem(e));
        contentPane.add(cityStart);
        cityStart.setBounds(1020, 160, 280, 40);

        //---- startAstar ----
        startAstar.setText("OK");
        startAstar.addActionListener(e -> showDialog(e));
        contentPane.add(startAstar);
        startAstar.setBounds(1020, 250, 120, startAstar.getPreferredSize().height);

        //---- label7 ----
        label7.setText("Khang cach chim bay v\u1edbi tp A");
        contentPane.add(label7);
        label7.setBounds(40, 89, 220, 40);
        contentPane.add(hsScore);
        hsScore.setBounds(40, 129, 250, 45);
        contentPane.add(viewRs2);
        viewRs2.setBounds(685, 35, 288, 523);

        //---- button5 ----
        button5.setText("show graph");
        button5.addActionListener(e -> showgraph(e));
        contentPane.add(button5);
        button5.setBounds(195, 560, 120, 30);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
                for (int i = 0; i < dialog1ContentPane.getComponentCount(); i++) {
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
                for (int i = 0; i < dialog2ContentPane.getComponentCount(); i++) {
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

        //======== this2 ========
        {
            this2.setTitle("A START DEMO");
            Container this2ContentPane = this2.getContentPane();
            this2ContentPane.setLayout(null);

            //---- label6 ----
            label6.setText("Thanh Pho");
            this2ContentPane.add(label6);
            label6.setBounds(40, 4, 220, 40);
            this2ContentPane.add(cityTf2);
            cityTf2.setBounds(40, 44, 250, 45);

            //---- button3 ----
            button3.setText("OK");
            button3.addActionListener(e -> addCityAction(e));
            this2ContentPane.add(button3);
            button3.setBounds(40, 180, 120, 30);

            //---- label8 ----
            label8.setText(" Thanh pho 1");
            this2ContentPane.add(label8);
            label8.setBounds(35, 223, 220, 40);

            //---- comboBox3 ----
            comboBox3.addActionListener(e -> selectItem(e));
            this2ContentPane.add(comboBox3);
            comboBox3.setBounds(35, 280, 280, 40);

            //---- label9 ----
            label9.setText(" Thanh pho 2");
            this2ContentPane.add(label9);
            label9.setBounds(35, 340, 220, 40);
            this2ContentPane.add(comboBox4);
            comboBox4.setBounds(35, 395, 280, 40);

            //---- label10 ----
            label10.setText("Khoang cach ");
            this2ContentPane.add(label10);
            label10.setBounds(35, 445, 220, 40);
            this2ContentPane.add(distanceTf2);
            distanceTf2.setBounds(35, 490, 250, 45);

            //---- button4 ----
            button4.setText("OK");
            button4.addActionListener(e -> addDistanceAction(e));
            this2ContentPane.add(button4);
            button4.setBounds(40, 560, 120, 30);

            //======== scrollPane4 ========
            {
                scrollPane4.setViewportView(viewRs3);
            }
            this2ContentPane.add(scrollPane4);
            scrollPane4.setBounds(385, 35, 290, 525);

            //---- label11 ----
            label11.setText(" Thanh pho 1");
            this2ContentPane.add(label11);
            label11.setBounds(1020, 105, 220, 40);

            //---- cityStart2 ----
            cityStart2.addActionListener(e -> selectItem(e));
            this2ContentPane.add(cityStart2);
            cityStart2.setBounds(1020, 160, 280, 40);

            //---- startAstar2 ----
            startAstar2.setText("OK");
            startAstar2.addActionListener(e -> showDialog(e));
            this2ContentPane.add(startAstar2);
            startAstar2.setBounds(1020, 250, 120, startAstar2.getPreferredSize().height);

            //---- label12 ----
            label12.setText("Khang cach chim bay v\u1edbi tp A");
            this2ContentPane.add(label12);
            label12.setBounds(40, 89, 220, 40);
            this2ContentPane.add(hsScore2);
            hsScore2.setBounds(40, 129, 250, 45);
            this2ContentPane.add(viewRs4);
            viewRs4.setBounds(685, 35, 288, 523);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < this2ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = this2ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = this2ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                this2ContentPane.setMinimumSize(preferredSize);
                this2ContentPane.setPreferredSize(preferredSize);
            }
            this2.pack();
            this2.setLocationRelativeTo(this2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ngoc ha
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
    private JScrollPane scrollPane1;
    private JTextArea viewRs;
    private JLabel label5;
    private JComboBox cityStart;
    private JButton startAstar;
    private JLabel label7;
    private JTextField hsScore;
    private JTextArea viewRs2;
    private JButton button5;
    private JDialog dialog1;
    private JScrollPane scrollPane2;
    private JTextArea result;
    private JDialog dialog2;
    private JScrollPane scrollPane3;
    private JTextArea information;
    private JFrame this2;
    private JLabel label6;
    private JTextField cityTf2;
    private JButton button3;
    private JLabel label8;
    private JComboBox comboBox3;
    private JLabel label9;
    private JComboBox comboBox4;
    private JLabel label10;
    private JTextField distanceTf2;
    private JButton button4;
    private JScrollPane scrollPane4;
    private JTextArea viewRs3;
    private JLabel label11;
    private JComboBox cityStart2;
    private JButton startAstar2;
    private JLabel label12;
    private JTextField hsScore2;
    private JTextArea viewRs4;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame = new testa();
        frame.setVisible(true);
    }
}
