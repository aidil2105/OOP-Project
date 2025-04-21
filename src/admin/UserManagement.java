/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import java.util.*;
import java.io.*;

class UserManagement {
    private List<User> users;
    private final String fileName = "users.txt"; // File to store user data

    public UserManagement() {
        users = new ArrayList<>();
        loadUsersFromFile(); // Load users from file when the application starts
    }

    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 4) { // username, password, role, and some other data
                    String username = userDetails[0];
                    String password = userDetails[1];
                    String role = userDetails[2];
                    User user;
                    if (role.equals("Tenant")) {
                        user = new Tenant(username, password);
                    } else if (role.equals("Landlord")) {
                        user = new Landlord(username, password);
                    } else {
                        user = new Admin(username, password);
                    }
                    users.add(user);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users from file: " + e.getMessage());
        }
    }

    private void saveUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(user.username + "," + user.password + "," + user.getRole());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user to file: " + e.getMessage());
        }
    }

    public void registerUser(User user) {
        users.add(user);
        saveUserToFile(user); // Save the user to the file
        user.register(); // Optional: Additional registration logic
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.login(username, password)) {
                return true;
            }
        }
        return false;
    }
}

