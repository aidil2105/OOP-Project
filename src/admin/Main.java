/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();

        // Show Login Page
        LoginPage loginPage = new LoginPage(userManagement);
        loginPage.showLoginPage();
    }
}

