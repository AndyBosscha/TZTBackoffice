/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
    private JPanel topBar;
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
        topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(this.getWidth(), 50));
        topBar.setLayout(new FlowLayout());
        //mainScreen.setLayout(new GridLayout(1, 8, 5, 5));
        nameLabel = new JLabel("Naam");
        nameLabel.setPreferredSize(new Dimension(100, 40));
        topBar.add(nameLabel);
        nameTextfield = new JTextField();
        topBar.add(nameTextfield);
                
        medewerkerNrLabel = new JLabel("Medewerkernr");
        topBar.add(medewerkerNrLabel);
        medewerkerNrTextfield = new JTextField();
        topBar.add(medewerkerNrTextfield);
        
        woonplaatsLabel = new JLabel("Woonplaats");
        topBar.add(woonplaatsLabel);
        woonplaatsTextfield = new JTextField();
        topBar.add(woonplaatsTextfield);
        
        statusLabel = new JLabel("Status");
        topBar.add(statusLabel);
        statusCombobox = new JComboBox();
        topBar.add(statusCombobox);
        
        
        
        add(topBar);
        
//        
//        String[] columns = new String[]{
//            "Id", "Name", "Hourly Rate", "Part Time"
//        };
//        Object[][] data = new Object[][]{
//            {1, "John", 40.0, false},
//            {2, "Rambo", 70.0, false},
//            {3, "Zorro", 60.0, true},};
//        JTable table = new JTable(data, columns);
//        mainScreen.add(new JScrollPane(table));
//
//        add(mainScreen);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
