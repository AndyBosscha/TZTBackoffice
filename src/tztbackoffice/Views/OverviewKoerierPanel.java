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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.JTextField;
import tztbackoffice.APIConnector;
import tztbackoffice.Models.KoerierModel;

/**
 *
 * @author Andy
 */
public class OverviewKoerierPanel extends JPanel implements ActionListener {
    private APIConnector con = new APIConnector();
    private JPanel topBar;
    private JLabel nameLabel;
    private JLabel medewerkerNrLabel;
    private JLabel woonplaatsLabel;
    private JLabel statusLabel;
    private JTextField nameTextfield;
    private JTextField medewerkerNrTextfield;
    private JTextField woonplaatsTextfield;
    private JComboBox statusCombobox;
    private KoerierModel selectedKoerier;
    private KoerierDetailsScreen koerierDetailsScreen;
    private JButton filterButton = new JButton("Filter");

    public OverviewKoerierPanel() {
        setLayout(new FlowLayout());
        selectedKoerier = new KoerierModel();
        koerierDetailsScreen = new KoerierDetailsScreen();
        topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(1200, 50));
        topBar.setLayout(new FlowLayout());

        nameLabel = new JLabel("Naam");
        topBar.add(nameLabel);
        nameTextfield = new JTextField();
        nameTextfield.setPreferredSize(new Dimension(100, 30));
        topBar.add(nameTextfield);

        medewerkerNrLabel = new JLabel("Medewerkernr");
        topBar.add(medewerkerNrLabel);
        medewerkerNrTextfield = new JTextField();
        medewerkerNrTextfield.setPreferredSize(new Dimension(100, 30));
        topBar.add(medewerkerNrTextfield);

        woonplaatsLabel = new JLabel("Woonplaats");
        topBar.add(woonplaatsLabel);
        woonplaatsTextfield = new JTextField();
        woonplaatsTextfield.setPreferredSize(new Dimension(100, 30));
        topBar.add(woonplaatsTextfield);

        statusLabel = new JLabel("Status");
        topBar.add(statusLabel);
        String[] comboBoxList = {"", "Nieuw", "Actief", "Inactief"};
        statusCombobox = new JComboBox(comboBoxList);
        statusCombobox.setPreferredSize(new Dimension(100, 30));

        topBar.add(statusCombobox);
        topBar.add(filterButton);
        add(topBar);

        String[] columns = {
            "Naam", "Medewerkernr", "Woonplaats", "Geboortedatum", "Datum in dienst", "Aantal opdrachten aangenomen", "Aantal pakketten bezorgd", "Status"
        };


        
        ArrayList<KoerierModel> allCouriers = con.getAllCouriers();
        
        DefaultTableModel model = new DefaultTableModel(); 
        JTable table = new JTable(model) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for(int i = 0; i < columns.length; i++){
            model.addColumn(columns[i]);
        }
        
        for (KoerierModel koerier : allCouriers) {
            model.addRow(                
                    new Object[]{
                        koerier.getFirstName(),
                        koerier.getIdUser(), 
                        koerier.getCity(), 
                        koerier.getDateOfBirth(), 
                        koerier.getStartDate(),
                        koerier.getAmountOfAcceptedPackages(), 
                        koerier.getAmountOfDeliveredPackages(),
                        koerier.getStatus()
                    }
            );
        }
        
        table.setAutoCreateRowSorter(true);

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    //Make an object from the data in the selected row, then pass it to the details screen.
                    //Not best practice! 
                    selectedKoerier.setFirstName(table.getValueAt(row, 0).toString());
                    selectedKoerier.setIdUser(Integer.parseInt(table.getValueAt(row, 1).toString()));
                    selectedKoerier.setCity(table.getValueAt(row, 2).toString());
                    selectedKoerier.setDateOfBirth(table.getValueAt(row, 3).toString());
                    selectedKoerier.setStartDate(table.getValueAt(row, 4).toString());
                    selectedKoerier.setAmountOfAcceptedPackages(Integer.parseInt(table.getValueAt(row, 5).toString()));
                    selectedKoerier.setAmountOfDeliveredPackages(Integer.parseInt(table.getValueAt(row, 6).toString()));
                    selectedKoerier.setStatus(table.getValueAt(row, 7).toString());
                    koerierDetailsScreen.showAndChangeSelectedKoerier(selectedKoerier);
                    //koerierDetailsScreen.showAndChangeSelectedKoerier(con.getCourierDetails(table.getValueAt(row, 1).toString()));
                    //The commented code above does not work, because the API does not work correctly.
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
