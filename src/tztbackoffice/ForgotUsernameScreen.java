/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Andy
 */
public class ForgotUsernameScreen extends JDialog implements ActionListener {

    private JPanel messagePanel;
    private JPanel notificationPanel;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JLabel headerLabel;
    private JLabel notificationLabel;
    private JLabel infoLabel;
    private JTextField emailTextField;
    private JButton cancelButton;
    private JButton sendButton;
    private LoginScreen loginScreen;

    public ForgotUsernameScreen(LoginScreen loginScreen) {

        this.loginScreen = loginScreen;
        setSize(500, 200);
        setTitle("TZT Backoffice - Gebruikersnaam vergeten");
        setResizable(false);
        setLocationRelativeTo(null);
//        setModal(true);
        setLayout(new GridLayout(4, 1, 5, 5));

        headerLabel = new JLabel("Gebruikersnaam vergeten", SwingConstants.CENTER);
        infoLabel = new JLabel("U dient een emailadres op te geven voor het opvragen van uw gebruikersnaam.", SwingConstants.CENTER);
//        infoLabel = new JLabel("<html>U dient een e-mailadres op te geven <br />voor het opvragen van uw gebruikersnaam</html>", SwingConstants.CENTER);
        messagePanel = new JPanel();
        messagePanel.setLayout(new GridLayout(2, 1, 5, 5));
        messagePanel.add(headerLabel);
        messagePanel.add(infoLabel);
        add(messagePanel);

        notificationLabel = new JLabel();
        notificationPanel = new JPanel();
        notificationPanel.setLayout(new GridLayout(1, 1, 5, 5));
        notificationPanel.add(notificationLabel);
        add(notificationPanel);

        emailTextField = new JTextField();
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 1, 5, 5));
        inputPanel.add(emailTextField);
        add(inputPanel);

        cancelButton = new JButton("Annuleren");
        cancelButton.addActionListener(this);
        sendButton = new JButton("Verzenden");
        sendButton.addActionListener(this);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(cancelButton);
        buttonPanel.add(sendButton);
        add(buttonPanel);

//        setLayout(new GridLayout(1, 2, 5, 5));
        setAlwaysOnTop(true);
        setVisible(true);

    }

    private void cancelButton() {
        setVisible(false);
        setModal(false);
        loginScreen.setVisible(true);

    }

    private void sendButton() {
        setVisible(false);
        setModal(false);
        loginScreen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            cancelButton();
        }
        if (e.getSource() == sendButton) {
            sendButton();
        }
    }
}
