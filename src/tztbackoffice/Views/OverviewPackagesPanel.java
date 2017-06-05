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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tztbackoffice.Models.PackageModel;
import tztbackoffice.APIConnector;

/**
 *
 * @author Andy
 */
public class OverviewPackagesPanel extends JPanel implements ActionListener {

    private JPanel topBar;
    private APIConnector con = new APIConnector();

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
        con.getAllPackages();
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
        String[] comboBoxListSignalering = {"", "Ja", "Nee"};
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
        String[] comboBoxListBezorgd = {"", "Ja", "Nee"};
        bezorgdComboBox = new JComboBox(comboBoxListBezorgd);
        bezorgdComboBox.setPreferredSize(new Dimension(100, 30));
        topBar.add(bezorgdComboBox);

        filterButton = new JButton("Filter");
        topBar.add(filterButton);

        add(topBar);

        DefaultTableModel model = new DefaultTableModel();
        String[] columns = new String[]{"Tracenummer", "Koerier ID", "Locatie", "Route", "Signalering", "Bezorgd"};
        JTable table = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ArrayList<PackageModel> allPackages = con.getAllPackages();
        table.setAutoCreateRowSorter(true);
        
        for (int i = 0; i < columns.length; i++) {
            model.addColumn(columns[i]);
        }
        
        for (PackageModel pckg : allPackages) {
            model.addRow(                
                    new Object[]{
                        pckg.getIdPackage(),
                        pckg.getIdCustomer(),
                        "N/A",
                        "N/A",
                        "N/A",
                        pckg.getIsDelivered()
                    }
            );
        }

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    detailScreen.showAndChangePackage(con.getPackageDetails(table.getValueAt(row, 0).toString()));
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 500));
        add(scrollPane);
        setPreferredSize(new Dimension(1150, 875));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String isDelivered(Date deliveryDate) {
        System.out.println(deliveryDate);
        if(deliveryDate.toString().equals("0000-00-00")){
            return "Nee";
        } else {
            return "Ja";
        }
    }

}
