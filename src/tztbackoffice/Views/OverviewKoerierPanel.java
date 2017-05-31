/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import tztbackoffice.Models.KoerierModel;

/**
 *
 * @author Andy
 */
public class OverviewKoerierPanel extends JPanel {
    
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
    
    public OverviewKoerierPanel(){
        selectedKoerier = new KoerierModel();
        koerierDetailsScreen = new KoerierDetailsScreen();
        topBar = new JPanel();
        topBar.setPreferredSize(new Dimension(this.getWidth(), 50));
        topBar.setLayout(new FlowLayout());
        setLayout(new FlowLayout());
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
        String[] comboBoxList = {"Nieuw", "Actief", "Inactief"};
        statusCombobox = new JComboBox(comboBoxList);
        statusCombobox.setPreferredSize(new Dimension(100, 30));

        topBar.add(statusCombobox);
        topBar.add(filterButton);
        add(topBar);

        String[] columns = new String[]{
            "Naam", "Medewerkernr", "Woonplaats", "Geboortedatum", "Datum in dienst", "Aantal opdrachten aangenomen", "Aantal pakketten bezorgd", "Status"
        };
        Object[][] data = new Object[][]{
            {"John", 4230, "Sexbierum", "12/11/1977", "12/03/2015", 532, 54, "Actief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 33, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 533, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 43, 444, "Nieuw"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Actief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 66664, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Nieuw"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Actief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Nieuw"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Actief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 4342, 444, "Inactief"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Nieuw"},
            {"Rambo", 7220, "Rochel", "02/03/1953", "01/08/2011", 782, 444, "Inactief"}
        };
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
                    selectedKoerier.setFirstName(table.getValueAt(row, 0).toString());
                    selectedKoerier.setIdUser(Integer.parseInt(table.getValueAt(row, 1).toString()));
                    selectedKoerier.setCity(table.getValueAt(row, 2).toString());
                    selectedKoerier.setDateOfBirth(table.getValueAt(row, 3).toString());
                    selectedKoerier.setStartDate(table.getValueAt(row, 4).toString());
                    selectedKoerier.setAmountOfAcceptedPackages(Integer.parseInt(table.getValueAt(row, 5).toString()));
                    selectedKoerier.setAmountOfDeliveredPackages(Integer.parseInt(table.getValueAt(row, 6).toString()));
                    selectedKoerier.setStatus(table.getValueAt(row, 7).toString());
                    koerierDetailsScreen.showAndChangeSelectedKoerier(selectedKoerier);
                }
            }
        });
        table.setPreferredSize(new Dimension(1000,1000));
        add(table);
        setPreferredSize(new Dimension(1150, 875));
    }
}
