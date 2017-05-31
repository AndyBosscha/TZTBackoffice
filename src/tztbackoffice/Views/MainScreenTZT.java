/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import tztbackoffice.Models.KoerierModel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Andy
 */
public class MainScreenTZT extends JFrame implements ActionListener {

    public MainScreenTZT() {
        setSize(1200, 700);
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = new JPanel();
        panel1.add(new OverviewKoerierPanel());
        tabbedPane.addTab("Koeriers", panel1);
        JComponent panel2 = new JPanel();
        tabbedPane.addTab("Klanten", panel2);

        JComponent panel3 = new JPanel();
        panel3.add(new OverviewPackagesPanel());
        tabbedPane.addTab("Pakketten", panel3);

        add(tabbedPane);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        setTitle("TZT Backoffice");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        
        setVisible(true);
    }

//    private JPanel createKoerierTab(){
//        
//
//    }  
//    
    private JPanel createKlantTab() {
        JPanel klantPanel = new JPanel();

        return klantPanel;
    }

    private JPanel createPakketTab() {
        JPanel pakketPanel = new JPanel();

        return pakketPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
