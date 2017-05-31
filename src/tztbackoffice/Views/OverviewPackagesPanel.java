/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import tztbackoffice.Models.PackageModel;

/**
 *
 * @author Andy
 */
public class OverviewPackagesPanel extends JPanel implements ActionListener {

    private JPanel topBar;

    private JLabel traceNumberLabel;
    private JLabel signaleringLabel;
    private JLabel koerierIDLabel;
    private JLabel bezorgdLabel;

    private JTextField tracenumberField;
    private JComboBox signaleringComboBox;
    private JTextField koerierIDField;
    private JComboBox bezorgdComboBox;
    private PackageDetailScreen detailScreen = new PackageDetailScreen();

    private JButton filterButton;

    private PackageModel selectedPackage;

    public OverviewPackagesPanel() {
        setSize(1200, 700);
        topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(1200, 50));
        topBar.setLayout(new FlowLayout());
        setLayout(new FlowLayout());

        traceNumberLabel = new JLabel("Tracenummer");
        topBar.add(traceNumberLabel);
        tracenumberField = new JTextField();
        tracenumberField.setPreferredSize(new Dimension(100, 30));
        topBar.add(tracenumberField);

        signaleringLabel = new JLabel("Signalering");
        topBar.add(signaleringLabel);
        String[] comboBoxListSignalering = {"Ja", "Nee"};
        signaleringComboBox = new JComboBox(comboBoxListSignalering);
        signaleringComboBox.setPreferredSize(new Dimension(100, 30));
        topBar.add(signaleringComboBox);

        koerierIDLabel = new JLabel("Koerier ID");
        topBar.add(koerierIDLabel);
        koerierIDField = new JTextField();
        koerierIDField.setPreferredSize(new Dimension(100, 30));
        topBar.add(koerierIDField);

        bezorgdLabel = new JLabel("Bezorgd");
        topBar.add(bezorgdLabel);
        String[] comboBoxListBezorgd = {"Ja", "Nee"};
        bezorgdComboBox = new JComboBox(comboBoxListBezorgd);
        bezorgdComboBox.setPreferredSize(new Dimension(100, 30));
        topBar.add(bezorgdComboBox);

        add(topBar);
        setVisible(true);

        String[] columns = new String[]{
            "Tracenummer", "Koerier ID", "Locatie", "Route", "Signalering", "Bezorgd"};
        Object[][] data = new Object[][]{
            {"1234567890", 4234, "Sexbierum", "Amsterdam - Zwolle", "Nee", "Ja"},
            {"34543535435", 4230, "Sexbierum", "Amsterdam - Zwolle", "Nee", "Ja"},
            {"1234567890", 4230, "Sexbierum", "Amsterdam - Sexbierum", "Nee", "Ja"},
            {"25524234", 4230, "Sexbierum", "Amsterdam - Zwolle", "Ja", "Ja"},
            {"3452524536", 4230, "Sexbierum", "Zwolle - Sexbierum", "Nee", "Ja"},
            {"1234567890", 234213, "Sexbierum", "Zwolle - Amsterdam", "Nee", "Nee"},
            {"1234567890", 4230, "Sexbierum", "Amsterdam - Zwolle", "Nee", "Ja"},
            {"1234567890", 4230, "Sexbierum", "Amsterdam - Zwolle", "Ja", "Nee"},
            {"23652345235", 4230, "Sexbierum", "Sexbierum - Zwolle", "Ja", "Nee"},
            {"1234567890", 543536, "Sexbierum", "Zwolle - Zwolle", "Nee", "Nee"},
            {"6356235235", 4230, "Sexbierum", "Amsterdam - Zwolle", "Nee", "Ja"},
            {"1234567890", 4230, "Sexbierum", "Amsterdam - Sexbierum", "Nee", "Ja"},};
        JTable table = new JTable(data, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setAutoCreateRowSorter(true);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
//                    selectedPackage.setFirstName(table.getValueAt(row, 0).toString());
//                    selectedPackage.setIdUser(Integer.parseInt(table.getValueAt(row, 1).toString()));
//                    selectedPackage.setCity(table.getValueAt(row, 2).toString());
//                    selectedPackage.setDateOfBirth(table.getValueAt(row, 3).toString());
//                    selectedPackage.setStartDate(table.getValueAt(row, 4).toString());
//                    selectedPackage.setAmountOfAcceptedPackages(Integer.parseInt(table.getValueAt(row, 5).toString()));
//                    selectedPackage.setAmountOfDeliveredPackages(Integer.parseInt(table.getValueAt(row, 6).toString()));
//                    selectedPackage.setStatus(table.getValueAt(row, 7).toString());
////                    koerierDetailsScreen.showAndChangeSelectedKoerier(selectedKoerier);
                    detailScreen.showAndChangePackage();
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 500));
        add(scrollPane);
        setPreferredSize(new Dimension(1150, 875));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
