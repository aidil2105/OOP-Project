/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage {
    private UserManagement userManagement;

    public LoginPage(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    public void showLoginPage() {
        // Create a JFrame to hold the components
        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);  // Center the window on the screen
        frame.setLayout(new BorderLayout(10, 10));

        // Panel for login form components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // GridLayout with padding
        panel.setBackground(new Color(255, 255, 255)); // White background

        // Username and Password labels and fields
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JPasswordField passwordField = new JPasswordField(15);

        // Dropdown for selecting Tenant, Landlord, or Admin
        JLabel roleLabel = new JLabel("Select Role:");
        String[] roles = { "Tenant", "Landlord", "Admin" };
        JComboBox<String> roleDropdown = new JComboBox<>(roles);

        // Login and Register buttons
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 122, 255)); // Blue button
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(0, 122, 255)); // Blue button
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Action listener for Login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String role = (String) roleDropdown.getSelectedItem(); // Get selected role

            if (role != null && (role.equals("Tenant") || role.equals("Landlord") || role.equals("Admin"))) {
                if (userManagement.loginUser(username, password)) {
                    JOptionPane.showMessageDialog(frame, role + " Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select Tenant, Landlord, or Admin.");
            }
        });

        // Action listener for Register button
        registerButton.addActionListener(e -> {
            frame.dispose(); // Close the login window
            RegistrationPage registrationPage = new RegistrationPage(userManagement);
            registrationPage.showRegistrationPage(); // Open registration page
        });

        // Add components to panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(roleLabel);
        panel.add(roleDropdown);
        panel.add(new JLabel(""));

        // Add buttons to panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        // Add everything to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}

