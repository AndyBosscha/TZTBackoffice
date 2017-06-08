/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

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
public class ForgotPasswordScreen extends JDialog implements ActionListener {

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

    public ForgotPasswordScreen(LoginScreen loginScreen) {
        //Loginscreen gets passed to make it possible to use setVisible on that screen.
        this.loginScreen = loginScreen;
        
        setSize(500, 200);
        setTitle("TZT Backoffice - Wachtwoord vergeten");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 5, 5));

        headerLabel = new JLabel("Wachtwoord vergeten", SwingConstants.CENTER);
        infoLabel = new JLabel("U dient een emailadres op te geven voor het opvragen van uw wachtwoord.", SwingConstants.CENTER);
        //Add panel to contain message
        messagePanel = new JPanel();
        messagePanel.setLayout(new GridLayout(2, 1, 5, 5));
        messagePanel.add(headerLabel);
        messagePanel.add(infoLabel);
        add(messagePanel);

        //Add panel to contain notification
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

        setAlwaysOnTop(true);
        setVisible(true);

    }

    private void cancelButton() {
        //If the cancel button has been pressed
        setVisible(false);
        setModal(false);
        loginScreen.setVisible(true);

    }

    private void sendButton() {
        //If the send button has been pressed
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
