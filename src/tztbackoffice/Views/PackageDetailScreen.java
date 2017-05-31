/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andy
 */
public class PackageDetailScreen extends JDialog implements ActionListener {
    private int windowHeight = 900, windowWidth = 1200, bottomBarHeight = 80;
    private JLabel tracenumberLabel = new JLabel("Tracenummer");
    private JLabel afzenderLabel = new JLabel("Afzender");
    private JLabel afzenderVoornaamLabel = new JLabel("Voornaam");
    private JLabel afzenderAchternaamLabel = new JLabel("Achternaam");
    private JLabel afkomstLabel = new JLabel("Afkomst");
    private JLabel afkomstStraatnaamHuisnrLabel = new JLabel("Straatnaam + huisnr");
    private JLabel afkomstPostcodeLabel = new JLabel("Postcode");
    private JLabel afkomstWoonplaatsLabel = new JLabel("Woonplaats");
    private JLabel geaddresseerdeLabel = new JLabel("Geaddresseerde");
    private JLabel geaddresseerdeVoornaamLabel = new JLabel("Voornaam");
    private JLabel geaddresseerdeAchternaamLabel = new JLabel("Achternaam");
    private JLabel bestemmingLabel = new JLabel("Bestemming");
    private JLabel bestemmingStraatnaamHuisnummerLabel = new JLabel("Straatnaam + huisnr");
    private JLabel bestemmingPostcodeLabel = new JLabel("Postcode");
    private JLabel bestemmingWoonplaatsLabel = new JLabel("Woonplaats");
    private JLabel aanmelddatumLabel = new JLabel("Aanmelddatum");
    private JLabel aanmeldtijdLabel = new JLabel("Aanmeldtijd");
    private JLabel dimensiesLabel = new JLabel("Dimensies");
    private JLabel dimensiesGewichtLabel = new JLabel("Gewicht");
    private JLabel dimensiesHoogteLabel = new JLabel("Hoogte");
    private JLabel dimensiesLengteLabel = new JLabel("Lengte");
    private JLabel dimensiesBreedteLabel = new JLabel("Breedte");
    private JLabel bezorgdLabel = new JLabel("Bezorgd");
    private JLabel bezorgmomentLabel = new JLabel("Bezorgmoment");
    private JLabel signaleringLabel = new JLabel("Signalering");
    private JLabel verzendkostenLabel = new JLabel("Verzendkosten");

    private JTextField tracenummerTextfield = new JTextField();
    private JTextField afzenderVoornaamTextfield = new JTextField();
    private JTextField afzenderAchternaamTextfield = new JTextField();
    private JTextField afkomstStraatnaamTextfield = new JTextField();
    private JTextField afkomstHuisnummerTextfield = new JTextField();
    private JTextField afkomstPostcodeTextfield = new JTextField();
    private JTextField afkomstWoonplaatsTextfield = new JTextField();
    private JTextField geaddresseerdeVoornaamTextfield = new JTextField();
    private JTextField geaddresseerdeAchternaamTextfield = new JTextField();
    private JTextField bestemmingStraatnaamTextfield = new JTextField();
    private JTextField bestemmingHuisnummerTextfield = new JTextField();
    private JTextField bestemmingPostcodeTextfield = new JTextField();
    private JTextField bestemmingWoonplaatsTextfield = new JTextField();
    private JTextField aanmelddatumTextfield = new JTextField();
    private JTextField aanmeldtijdTextfield = new JTextField();
    private JTextField dimensiesGewichtTextfield = new JTextField();
    private JTextField dimensiesHoogteTextfield = new JTextField();
    private JTextField dimensiesLengteTextfield = new JTextField();
    private JTextField dimensiesBreedteTextfield = new JTextField();
    private JTextField bezorgdTextfield = new JTextField();
    private JTextField bezorgmomentTextfield = new JTextField();
    private JTextField signaleringTextfield = new JTextField();
    private JTextField verzendkostenTextfield = new JTextField();

    public PackageDetailScreen() {
        setSize(windowWidth, windowHeight);
        setLayout(new FlowLayout());
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(13,2,30,30));
        leftPanel.setPreferredSize(new Dimension(windowWidth/2-10, windowHeight-bottomBarHeight));
        leftPanel.setBackground(Color.red);
        
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(13,2,30,30));
        rightPanel.setPreferredSize(new Dimension(windowWidth/2-10, windowHeight-bottomBarHeight));
        rightPanel.setBackground(Color.blue);
        
        JPanel bottomBar = new JPanel();
        bottomBar.setLayout(new FlowLayout());
        bottomBar.setPreferredSize(new Dimension(windowWidth, bottomBarHeight));
        bottomBar.setBackground(Color.yellow);
        
        add(leftPanel);
        add(rightPanel);
        add(bottomBar);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    void showAndChangePackage() {
        setVisible(true);

    }

}
