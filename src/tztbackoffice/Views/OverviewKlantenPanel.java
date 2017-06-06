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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tztbackoffice.APIConnector;
import tztbackoffice.Models.KlantModel;

/**
 *
 * @author Andy
 */
public class OverviewKlantenPanel extends JPanel implements ActionListener {

    private KlantModel selectedKlant;
    private KlantDetailsScreen detailScreen = new KlantDetailsScreen();
    private JTextField searchField;
    private JButton searchButton;
    private int panelWidth = 1200;
    APIConnector con = new APIConnector();
    
    public OverviewKlantenPanel() {
        
        selectedKlant = new KlantModel();
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(150,30));
        searchButton = new JButton("Zoeken");
        searchButton.addActionListener(this);
        setLayout(new FlowLayout());
        JPanel topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topBar.setPreferredSize(new Dimension(panelWidth, 50));
        topBar.add(searchField);
        topBar.add(searchButton);
        add(topBar);
        
        ArrayList<KlantModel> allCustomers = con.getAllCustomers();

        String[] columns = {
            "Naam", "Adres", "Woonplaats", "Postcode", "Huisnummer", "Actief"
        };
        
        DefaultTableModel model = new DefaultTableModel(); 
        JTable table = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for(int i = 0; i < columns.length; i++){
            model.addColumn(columns[i]);
        }
        
        for(KlantModel klant : allCustomers){
            model.addRow(new Object[]{
                klant.getName(),
                klant.getStreet(),
                klant.getCity(),
                klant.getZipCode(),
                klant.getHouseNumber(),
                klant.getActive()
            });
        }
        
        
        table.setAutoCreateRowSorter(true);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    selectedKlant.setName(table.getValueAt(row, 0).toString());
                    selectedKlant.setStreet(table.getValueAt(row, 1).toString());
                    selectedKlant.setCity(table.getValueAt(row, 2).toString());
                    selectedKlant.setZipCode(table.getValueAt(row, 3).toString());
                    selectedKlant.setHouseNumber(table.getValueAt(row, 4).toString());
                    selectedKlant.setActive(table.getValueAt(row, 5).toString());
                    detailScreen.showAndUpdateKlant(selectedKlant);
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(panelWidth - 200, 500));
        add(scrollPane);
        setPreferredSize(new Dimension(panelWidth, 1200));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}