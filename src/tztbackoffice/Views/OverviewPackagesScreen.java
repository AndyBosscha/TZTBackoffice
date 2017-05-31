/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andy
 */
public class OverviewPackagesScreen extends JFrame implements ActionListener {

    private JPanel topBar;

    private JLabel traceNumberLabel;
    private JLabel signaleringLabel;
    private JLabel koerierIDLabel;
    private JLabel bezorgdLabel;

    private JTextField tracenumberField;
    private JTextField signaleringField;
    private JTextField koerierIDField;
    private JComboBox bezorgdComboBox;

    private JButton filterButton;

    public OverviewPackagesScreen() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
