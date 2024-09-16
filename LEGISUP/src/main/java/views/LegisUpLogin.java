package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LegisUpLogin extends JFrame {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LegisUpLogin() {
        setTitle("LEGIS UP - LOGIN");
        setSize(1024, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the background color to light blue
        getContentPane().setBackground(new Color(224, 242, 241));

        // Create a panel for the login form
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setBounds(312, 210, 400, 300);

        // Title
        JLabel titleLabel = new JLabel("LEGIS UP - LOGIN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(85, 20, 250, 30);
        loginPanel.add(titleLabel);

        // User field
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(50, 80, 300, 20);
        loginPanel.add(userLabel);

        userField = new JTextField();
        userField.setBounds(50, 100, 300, 30);
        loginPanel.add(userField);

        // Password field
        JLabel passwordLabel = new JLabel("Senha");
        passwordLabel.setBounds(50, 140, 300, 20);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 160, 300, 30);
        loginPanel.add(passwordField);

        // Login button
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 220, 300, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());
                // Here you would typically validate the login credentials
                // and perform the necessary actions to log in to the system
                JOptionPane.showMessageDialog(LegisUpLogin.this, 
                    "Login attempt with username: " + username);
            }
        });
        loginPanel.add(loginButton);

        // Add the login panel to the frame
        setLayout(null);
        add(loginPanel);
    }
}