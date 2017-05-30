/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Andy
 */
public class MainScreenTZT extends JFrame implements ActionListener {

    private JPanel mainScreen;
    private JLabel nameLabel;
    private JLabel medewerkerNrLabel;
    private JLabel woonplaatsLabel;
    private JLabel statusLabel;
    private JTextField nameTextfield;
    private JTextField medewerkerNrTextfield;
    private JTextField woonplaatsTextfield;
    private JComboBox statusCombobox;

    public MainScreenTZT() {
        setSize(1200, 700);
        setTitle("TZT Backoffice");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainScreen = new JPanel();
        add(mainScreen);
        mainScreen.setLayout(new GridLayout(8, 1, 5, 5));
        nameLabel = new JLabel();
        mainScreen.add(nameLabel);
        medewerkerNrLabel = new JLabel();
        mainScreen.add(medewerkerNrLabel);
        woonplaatsLabel = new JLabel();
        mainScreen.add(woonplaatsLabel);
        statusLabel = new JLabel();
        mainScreen.add(statusLabel);
        nameTextfield = new JTextField();
        mainScreen.add(nameTextfield);
        medewerkerNrTextfield = new JTextField();
        mainScreen.add(medewerkerNrTextfield);
        woonplaatsTextfield = new JTextField();
        mainScreen.add(woonplaatsTextfield);
        statusCombobox = new JComboBox();
        mainScreen.add(statusCombobox);

//        String[] columns = new String[]{
//            "Id", "Name", "Hourly Rate", "Part Time"
//        };
//        Object[][] data = new Object[][]{
//            {1, "John", 40.0, false},
//            {2, "Rambo", 70.0, false},
//            {3, "Zorro", 60.0, true},};
//        JTable table = new JTable(data, columns);
//        this.add(new JScrollPane(table));
//
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
