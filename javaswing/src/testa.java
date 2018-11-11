import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/*
 * Created by JFormDesigner on Sat Nov 10 21:38:07 ICT 2018
 */


/**
 * @author unknown
 */
public class testa extends JFrame {

    public ArrayList<String> CityList = new ArrayList<>();

    public testa() {
        initComponents();
        comboBox1.setEnabled(false);
        comboBox2.setEnabled(false);
        cityStart.setEnabled(false);
        cityFinish.setEnabled(false);
        viewRs.setEditable(false);
        result.setEditable(false);
    }

    private void addCityAction(ActionEvent e) {
        // TODO add your code here
        String city = cityTf.getText();
        if (!CityList.contains(city) && !city.equals("") && !city.matches("[\\s+]")) {
            CityList.add(city);
            comboBox1.addItem(city);
            comboBox1.setEnabled(true);
            comboBox2.addItem(city);
            cityStart.addItem(city);
            cityFinish.addItem(city);
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
            String distance = distanceTf.getText();
            String rs = city1 + "--" + city2 + " : " + distance;
            viewRs.append(rs);
            viewRs.append("\n");
            cityStart.setEnabled(true);
            cityFinish.setEnabled(true);
        }
    }

    private void showDialog(ActionEvent e) {
        // TODO add your code here
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
        label6 = new JLabel();
        cityFinish = new JComboBox();
        startAstar = new JButton();
        label7 = new JLabel();
        cityTf2 = new JTextField();
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

        //---- label6 ----
        label6.setText(" Thanh pho 2");
        contentPane.add(label6);
        label6.setBounds(1020, 230, 220, 40);
        contentPane.add(cityFinish);
        cityFinish.setBounds(1020, 285, 280, 40);

        //---- startAstar ----
        startAstar.setText("OK");
        startAstar.addActionListener(e -> showDialog(e));
        contentPane.add(startAstar);
        startAstar.setBounds(1025, 370, 120, startAstar.getPreferredSize().height);
        contentPane.add(label7);
        label7.setBounds(40, 89, 220, 40);
        contentPane.add(cityTf2);
        cityTf2.setBounds(40, 129, 250, 45);

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
    private JLabel label6;
    private JComboBox cityFinish;
    private JButton startAstar;
    private JLabel label7;
    private JTextField cityTf2;
    private JDialog dialog1;
    private JScrollPane scrollPane2;
    private JTextArea result;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame = new testa();
        frame.setVisible(true);
    }
}
