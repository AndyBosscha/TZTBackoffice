/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Views;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import tztbackoffice.Controllers.LoginController;

/**
 *
 * @author Andy
 */
public class LoginScreen extends JFrame implements ActionListener {

    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JLabel notificationLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private JButton forgotPasswordButton;
    private JButton forgotUsernameButton;
    private JPanel loginPanel;
    private JPanel buttonPanel;
    private JPanel errorPanel;
    private JPanel loginFormContainer;
    private LoginController loginController;
    private ForgotUsernameScreen fus;
    private ForgotPasswordScreen fps;

    public LoginScreen() {
        setSize(600, 200);
        setLayout(new GridLayout(1,1,30,30));
        setTitle("TZT Backoffice - Inloggen");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        errorPanel = new JPanel();
        loginPanel = new JPanel();
        loginFormContainer = new JPanel();
        buttonPanel = new JPanel();
        loginFormContainer.setSize(new Dimension(400, 200));
        usernameLabel = new JLabel("Gebruikersnaam");
        usernameTextField = new JTextField();
        usernameTextField.addActionListener(this);
        passwordLabel = new JLabel("Wachtwoord");
        passwordTextField = new JPasswordField(12);
        notificationLabel = new JLabel();
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        forgotPasswordButton = new JButton("Wachtwoord vergeten");
        forgotPasswordButton.addActionListener(this);
        forgotUsernameButton = new JButton("Gebruikersnaam vergeten");
        forgotUsernameButton.addActionListener(this);

        fus = new ForgotUsernameScreen(this);
        fus.setVisible(false);
        fus.setModal(false);

        fps = new ForgotPasswordScreen(this);
        fps.setVisible(false);
        fps.setModal(false);

        loginPanel.setLayout(new GridLayout(2, 2, 5, 5));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
        loginFormContainer.add(loginPanel);
        add(loginFormContainer);

        errorPanel.setLayout(new GridLayout(2, 1, 5, 5));
        errorPanel.add(notificationLabel);
        loginFormContainer.add(errorPanel);

        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(loginButton);
        buttonPanel.add(forgotPasswordButton);
        buttonPanel.add(forgotUsernameButton);
        loginFormContainer.add(buttonPanel);
        setPreferredSize(new Dimension(400, 200));
        setVisible(true);
    }

    private void login() {
        System.out.println(String.valueOf(passwordTextField.getPassword()));
        if(LoginController.checkLoginCredentials(usernameTextField.getText(), String.valueOf(passwordTextField.getPassword()))){
            MainScreenTZT mst = new MainScreenTZT();
            this.setVisible(false);
        } else {
            notificationLabel.setText("Logingegevens incorrect. Probeer het nogmaals.");
            repaint();
        }
        
    }

    private void openForgotUsernameScreen() {
        fus.setVisible(true);
        fus.setModal(true);
        this.setVisible(false);
    }

    private void setNotificationLabelText() {

    }

    private void openForgotPasswordScreen() {
        fps.setVisible(true);
        fps.setModal(true);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            login();
        }

        if (e.getSource() == forgotPasswordButton) {
            openForgotPasswordScreen();
        }

        if (e.getSource() == forgotUsernameButton) {
            openForgotUsernameScreen();

        }
    }

}
