/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tztbackoffice.Models.KoerierModel;

/**
 *
 * @author Andy
 */
public class KoerierDetailsScreen extends JDialog implements ActionListener {
    
    private KoerierModel selectedKoerier;
    private JLabel nameLabel = new JLabel("Naam");
    private JLabel additionalNameLabel = new JLabel("Tussenvoegsel");
    private JLabel lastNameLabel = new JLabel("Achternaam");
    private JLabel sexLabel = new JLabel("Geslacht");
    private JLabel dateOfBirthLabel = new JLabel("Geboortedatum");
    private JLabel houseNumberLabel = new JLabel("Huisnummer");
    private JLabel zipCodeLabel = new JLabel("Postcode");
    private JLabel addressLabel = new JLabel("Adres");
    private JLabel cityLabel = new JLabel("Woonplaats");
    private JLabel phoneLabel = new JLabel("Telefoonnummer");
    private JLabel emailLabel = new JLabel("E-mailadres");
    private JLabel bankNumberLabel = new JLabel("Bankrekeningnummer");
    private JLabel photoLabel = new JLabel("Foto");
    private JLabel resumeLabel = new JLabel("Cirucculum Vitae");
    private JLabel idLabel = new JLabel("Kopie identiteitsbewijs");
    private JLabel statusLabel = new JLabel("Status");
    private JLabel koerierNrLabel = new JLabel("Koeriersnummer");
    private int windowHeight = 900, windowWidth = 900, bottomBarHeight = 80;
    
    private JTextField nameField = new JTextField();
    private JTextField additionalNameField = new JTextField();
    private JTextField lastNameField = new JTextField();
    String[] sexBoxList = {"M", "V", "N.v.t."};
    private JComboBox sexBox = new JComboBox(sexBoxList);
    private JTextField dateOfBirthField = new JTextField();
    private JTextField houseNumberField = new JTextField();
    private JTextField zipCodeFIeld = new JTextField();
    private JTextField addressField = new JTextField();
    private JTextField cityField = new JTextField();
    private JTextField phoneNumberField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField bankNumberField = new JTextField();
    private JTextField koerierNrField = new JTextField();
    private JTextField statusField = new JTextField();
    private JPanel photoPanel = new JPanel();
    private JButton resumeButton = new JButton("Openen");
    private JButton idButton = new JButton("Openen");
    
    private JButton acceptButton = new JButton("Goedkeuren");
    private JButton declineButton = new JButton("Afkeuren");
    private JButton editButton = new JButton("Wijzigen");
    private JButton historyButton = new JButton("Inzien opdrachthistorie");
    private JButton blockButton = new JButton("Blokkeren");
    private JButton cancelButton = new JButton("Annuleren");
    
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomBar;
    
    public KoerierDetailsScreen() {
        setLayout(new FlowLayout());
        setSize(windowWidth, windowHeight);
        
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(12, 2, 30, 30));
        
        nameField.setEnabled(false);
        additionalNameField.setEnabled(false);
        lastNameField.setEnabled(false);
        sexBox.setEnabled(false);
        dateOfBirthField.setEnabled(false);
        houseNumberField.setEnabled(false);
        zipCodeFIeld.setEnabled(false);
        addressField.setEnabled(false);
        cityField.setEnabled(false);
        phoneNumberField.setEnabled(false);
        emailField.setEnabled(false);
        bankNumberField.setEnabled(false);
        
        leftPanel.add(nameLabel);
        leftPanel.add(nameField);
        leftPanel.add(additionalNameLabel);
        leftPanel.add(additionalNameField);
        leftPanel.add(lastNameLabel);
        leftPanel.add(lastNameField);
        leftPanel.add(sexLabel);
        leftPanel.add(sexBox);
        leftPanel.add(dateOfBirthLabel);
        leftPanel.add(dateOfBirthField);
        leftPanel.add(houseNumberLabel);
        leftPanel.add(houseNumberField);
        leftPanel.add(zipCodeLabel);
        leftPanel.add(zipCodeFIeld);
        leftPanel.add(addressLabel);
        leftPanel.add(addressField);
        leftPanel.add(cityLabel);
        leftPanel.add(cityField);
        leftPanel.add(phoneLabel);
        leftPanel.add(phoneNumberField);
        leftPanel.add(emailLabel);
        leftPanel.add(emailField);
        leftPanel.add(bankNumberLabel);
        leftPanel.add(bankNumberField);
        
        leftPanel.setPreferredSize(new Dimension(windowWidth / 2 - 10, windowHeight - bottomBarHeight));
        add(leftPanel);
        
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(5, 2, 30, 30));
        
        statusField.setEnabled(false);
        koerierNrField.setEnabled(false);
        
        rightPanel.add(photoLabel);
        rightPanel.add(photoPanel);
        rightPanel.add(resumeLabel);
        rightPanel.add(resumeButton);
        rightPanel.add(idLabel);
        rightPanel.add(idButton);
        rightPanel.add(statusLabel);
        rightPanel.add(statusField);
        rightPanel.add(koerierNrLabel);
        rightPanel.add(koerierNrField);
        
        rightPanel.setPreferredSize(new Dimension(windowWidth / 2 - 10, windowHeight - bottomBarHeight));
        add(rightPanel);
        
        bottomBar = new JPanel();
        bottomBar.setLayout(new FlowLayout());
        
        acceptButton.addActionListener(this);
        declineButton.addActionListener(this);
        editButton.addActionListener(this);
        historyButton.addActionListener(this);
        blockButton.addActionListener(this);
        cancelButton.addActionListener(this);
        
        bottomBar.add(acceptButton);
        bottomBar.add(declineButton);
        bottomBar.add(editButton);
        bottomBar.add(historyButton);
        bottomBar.add(blockButton);
        bottomBar.add(cancelButton);
        bottomBar.setPreferredSize(new Dimension(windowWidth, bottomBarHeight));
        add(bottomBar);
        
        setTitle("TZT Backoffice - Detailoverzicht koerier");
        setResizable(false);
        setLocationRelativeTo(null);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == acceptButton) {
            
        }
        
        if (e.getSource() == declineButton) {
            
        }
        
        if (e.getSource() == editButton) {
            
        }
        if (e.getSource() == historyButton) {
            
        }
        if (e.getSource() == blockButton) {
            
        }
        if (e.getSource() == cancelButton) {
            this.setVisible(false);
        }
        
    }
    
    public void showAndChangeSelectedKoerier(KoerierModel newSelectedKoerier) {
        selectedKoerier = newSelectedKoerier;
        nameField.setText(selectedKoerier.getFirstName());
        additionalNameField.setText((selectedKoerier.getMiddleName()));
        lastNameField.setText(selectedKoerier.getLastName());
        sexBox.setSelectedItem(selectedKoerier.getSex());
        dateOfBirthField.setText(selectedKoerier.getDateOfBirth());
        houseNumberField.setText(selectedKoerier.getHouseNumber());
        zipCodeFIeld.setText(selectedKoerier.getZipCode());
        addressField.setText(selectedKoerier.getStreetName() + " " + selectedKoerier.getHouseNumber());
        cityField.setText(selectedKoerier.getCity());
        phoneNumberField.setText(selectedKoerier.getPhoneNumber());
        emailField.setText(selectedKoerier.getMailAddress());
        bankNumberField.setText(selectedKoerier.getBankNumber());
        statusField.setText(selectedKoerier.getStatus());
        koerierNrField.setText(selectedKoerier.getIdUser() + "");
        
        setVisible(true);
    }
}
