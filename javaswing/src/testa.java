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

    public HashMap<String, Node> listNode = new HashMap<String,Node>();
    public ArrayList<ArrayList<Edge>> listEdge = new ArrayList<>();

    public ArrayList<String> CityList = new ArrayList<>();

    public testa() {
        initComponents();
        listNode.put("tp.A", new Node("tp.A", 0));
        comboBox1.addItem("tp.A");
        comboBox2.addItem("tp.A");
        cityStart.addItem("tp.A");
        comboBox1.setEnabled(false);
        comboBox2.setEnabled(false);
        cityStart.setEnabled(false);
        viewRs.setEditable(false);
        result.setEditable(false);
    }

    private void addCityAction(ActionEvent e) {
        // TODO add your code here
        String city = cityTf.getText();
        double h_score = Double.parseDouble(hsScore.getText());
        if (!CityList.contains(city) && !city.equals("") && !city.matches("[\\s+]")) {
            CityList.add(city);
            comboBox1.addItem(city);
            comboBox1.setEnabled(true);
            comboBox2.addItem(city);
            cityStart.addItem(city);
            listNode.put(city, new Node(city, h_score));
        }

        cityTf.setText("");
        cityTf.requestFocus();
    }

    private void selectItem(ActionEvent e) {
        // TODO add your code here
        comboBox2.setEnabled(true);
    }

    private void addDistanceAction(ActionEvent e) {
        // TODO add your code here
        String city1 = comboBox1.getSelectedItem().toString();
        String city2 = comboBox2.getSelectedItem().toString();
        if (!city1.equals(city2)) {
            double distance = Double.parseDouble(distanceTf.getText());
            String rs = city1 + "--" + city2 + " : " + distance;
            viewRs.append(rs);
            viewRs.append("\n");
            cityStart.setEnabled(true);
            System.out.println(listNode.get(city1).value);
            System.out.println(listNode.get(city2).value);
            listNode.get(city1).adjacencies.add(new Edge(listNode.get(city2),distance));
            listNode.get(city2).adjacencies.add(new Edge(listNode.get(city1),distance));
        }
    }

    private void showDialog(ActionEvent e) {
        // TODO add your code here
        String city1 = cityStart.getSelectedItem().toString();
        AstarSearchAlgo algo = new AstarSearchAlgo();
        algo.AstarSearch(listNode.get(city1),listNode.get("tp.A"));
        result.append(algo.printPath(listNode.get("tp.A")).toString());
        dialog1.setVisible(true);

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
        dialog1 = new JDialog();
        scrollPane2 = new JScrollPane();
        result = new JTextArea();

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
        scrollPane1.setBounds(385, 30, 575, 525);

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
    private JDialog dialog1;
    private JScrollPane scrollPane2;
    private JTextArea result;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame = new testa();
        frame.setVisible(true);
    }
}
