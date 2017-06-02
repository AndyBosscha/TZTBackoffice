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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andy
 */
public class PackageDetailScreen extends JDialog implements ActionListener {

    private int windowHeight = 600, windowWidth = 1150, bottomBarHeight = 80;
    private JLabel tracenumberLabel = new JLabel("Tracenummer");
    private JLabel emptyLabel1 = new JLabel("         ");
    private JLabel emptyLabel2 = new JLabel("         ");
    private JLabel emptyLabel3 = new JLabel("         ");
    private JLabel emptyLabel4 = new JLabel("         ");
    private JLabel afzenderLabel = new JLabel("Afzender");
    private JLabel afzenderVoornaamLabel = new JLabel("Voornaam Afzender");
    private JLabel afzenderAchternaamLabel = new JLabel("Achternaam Afzender");
    private JLabel afkomstLabel = new JLabel("Afkomst");
    private JLabel afkomstStraatnaamLabel = new JLabel("Straatnaam");
    private JLabel afkomstHuisnummerLabel = new JLabel("Huisnummer");
    private JLabel afkomstPostcodeLabel = new JLabel("Postcode");
    private JLabel afkomstWoonplaatsLabel = new JLabel("Woonplaats");
    private JLabel geaddresseerdeLabel = new JLabel("Geaddresseerde");
    private JLabel geaddresseerdeVoornaamLabel = new JLabel("Voornaam Geaddresseerde");
    private JLabel geaddresseerdeAchternaamLabel = new JLabel("Achternaam Geaddresseerde");
    private JLabel bestemmingLabel = new JLabel("Bestemming");
    private JLabel bestemmingStraatnaamLabel = new JLabel("Straatnaam");
    private JLabel bestemmingHuisnummerLabel = new JLabel("Huisnummer");
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

    private JButton annulerenButton = new JButton("Annuleren");
    private JButton wijzigenButton = new JButton("Wijzigen");
    private JButton opslaanButton = new JButton("Opslaan");

    public PackageDetailScreen() {
        setSize(windowWidth, windowHeight);
        setLayout(new FlowLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(8, 2, 30, 30));
        leftPanel.setPreferredSize(new Dimension(windowWidth / 3 - 10, windowHeight - bottomBarHeight));

        tracenummerTextfield.setEnabled(false);
        tracenummerTextfield.setEnabled(false);
        afzenderVoornaamTextfield.setEnabled(false);
        afzenderAchternaamTextfield.setEnabled(false);
        afkomstStraatnaamTextfield.setEnabled(false);
        afkomstHuisnummerTextfield.setEnabled(false);
        afkomstPostcodeTextfield.setEnabled(false);
        afkomstWoonplaatsTextfield.setEnabled(false);
        geaddresseerdeVoornaamTextfield.setEnabled(false);
        geaddresseerdeAchternaamTextfield.setEnabled(false);
        bestemmingStraatnaamTextfield.setEnabled(false);
        bestemmingHuisnummerTextfield.setEnabled(false);
        bestemmingPostcodeTextfield.setEnabled(false);
        bestemmingWoonplaatsTextfield.setEnabled(false);
        aanmelddatumTextfield.setEnabled(false);
        aanmeldtijdTextfield.setEnabled(false);
        dimensiesGewichtTextfield.setEnabled(false);
        dimensiesHoogteTextfield.setEnabled(false);
        dimensiesLengteTextfield.setEnabled(false);
        dimensiesBreedteTextfield.setEnabled(false);
        bezorgdTextfield.setEnabled(false);
        bezorgmomentTextfield.setEnabled(false);
        signaleringTextfield.setEnabled(false);
        verzendkostenTextfield.setEnabled(false);

        leftPanel.add(tracenumberLabel);
        leftPanel.add(tracenummerTextfield);
        leftPanel.add(afzenderLabel);
        leftPanel.add(emptyLabel1);
        leftPanel.add(afzenderVoornaamLabel);
        leftPanel.add(afzenderVoornaamTextfield);
        leftPanel.add(afzenderAchternaamLabel);
        leftPanel.add(afzenderAchternaamTextfield);
        leftPanel.add(afkomstStraatnaamLabel);
        leftPanel.add(afkomstStraatnaamTextfield);
        leftPanel.add(afkomstHuisnummerLabel);
        leftPanel.add(afkomstHuisnummerTextfield);
        leftPanel.add(afkomstPostcodeLabel);
        leftPanel.add(afkomstPostcodeTextfield);
        leftPanel.add(afkomstWoonplaatsLabel);
        leftPanel.add(afkomstWoonplaatsTextfield);

        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(8, 2, 30, 30));
        midPanel.setPreferredSize(new Dimension(windowWidth / 3 - 10, windowHeight - bottomBarHeight));

        midPanel.add(emptyLabel3);
        midPanel.add(emptyLabel4);
        midPanel.add(geaddresseerdeLabel);
        midPanel.add(emptyLabel2);
        midPanel.add(geaddresseerdeVoornaamLabel);
        midPanel.add(geaddresseerdeVoornaamTextfield);
        midPanel.add(geaddresseerdeAchternaamLabel);
        midPanel.add(geaddresseerdeAchternaamTextfield);
        midPanel.add(bestemmingStraatnaamLabel);
        midPanel.add(bestemmingStraatnaamTextfield);
        midPanel.add(bestemmingHuisnummerLabel);
        midPanel.add(bestemmingHuisnummerTextfield);
        midPanel.add(bestemmingPostcodeLabel);
        midPanel.add(bestemmingPostcodeTextfield);
        midPanel.add(bestemmingWoonplaatsLabel);
        midPanel.add(bestemmingWoonplaatsTextfield);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(10, 2, 30, 15));
        rightPanel.setPreferredSize(new Dimension(windowWidth / 3 - 10, windowHeight - bottomBarHeight));

        rightPanel.add(aanmelddatumLabel);
        rightPanel.add(aanmelddatumTextfield);
        rightPanel.add(aanmeldtijdLabel);
        rightPanel.add(aanmeldtijdTextfield);
        rightPanel.add(dimensiesGewichtLabel);
        rightPanel.add(dimensiesGewichtTextfield);
        rightPanel.add(dimensiesLengteLabel);
        rightPanel.add(dimensiesLengteTextfield);
        rightPanel.add(dimensiesBreedteLabel);
        rightPanel.add(dimensiesBreedteTextfield);
        rightPanel.add(dimensiesHoogteLabel);
        rightPanel.add(dimensiesHoogteTextfield);
        rightPanel.add(bezorgdLabel);
        rightPanel.add(bezorgdTextfield);
        rightPanel.add(bezorgmomentLabel);
        rightPanel.add(bezorgmomentTextfield);
        rightPanel.add(signaleringLabel);
        rightPanel.add(signaleringTextfield);
        rightPanel.add(verzendkostenLabel);
        rightPanel.add(verzendkostenTextfield);

        JPanel bottomBar = new JPanel();
        bottomBar.setLayout(new FlowLayout());
        bottomBar.setPreferredSize(new Dimension(windowWidth, bottomBarHeight));

        bottomBar.add(annulerenButton);
        bottomBar.add(wijzigenButton);
        bottomBar.add(opslaanButton);

        add(leftPanel);
        add(midPanel);
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
