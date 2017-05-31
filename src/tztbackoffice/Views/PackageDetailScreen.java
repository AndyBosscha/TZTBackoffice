/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Andy
 */
public class PackageDetailScreen extends JDialog implements ActionListener {

    private JLabel tracenumberLabel;
    private JLabel afzenderLabel;
    private JLabel afzenderVoornaamLabel;
    private JLabel afzenderAchternaamLabel;
    private JLabel afkomstLabel;
    private JLabel afkomstStraatnaamHuisnrLabel;
    private JLabel afkomstPostcodeLabel;
    private JLabel afkomstWoonplaatsLabel;
    private JLabel geaddresseerdeLabel;
    private JLabel geaddresseerdeVoornaamLabel;
    private JLabel geaddresseerdeAchternaamLabel;
    private JLabel bestemmingLabel;
    private JLabel bestemmingStraatnaamHuisnummerLabel;
    private JLabel bestemmingPostcodeLabel;
    private JLabel bestemmingWoonplaatsLabel;
    private JLabel aanmelddatumLabel;
    private JLabel aanmeldtijdLabel;
    private JLabel dimensiesLabel;
    private JLabel dimensiesGewichtLabel;
    private JLabel dimensiesHoogteLabel;
    private JLabel dimensiesLengteLabel;
    private JLabel dimensiesBreedteLabel;
    private JLabel bezorgdLabel;
    private JLabel bezorgmomentLabel;
    private JLabel signaleringLabel;
    private JLabel verzendkostenLabel;

    private JTextField tracenummerTextfield;
    private JTextField afzenderVoornaamTextfield;
    private JTextField afzenderAchternaamTextfield;
    private JTextField afkomstStraatnaamTextfield;
    private JTextField afkomstHuisnummerTextfield;
    private JTextField afkomstPostcodeTextfield;
    private JTextField afkomstWoonplaatsTextfield;
    private JTextField geaddresseerdeVoornaamTextfield;
    private JTextField geaddresseerdeAchternaamTextfield;

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
