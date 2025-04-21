/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

class Tenant extends User {

    public Tenant(String username, String password) {
        super(username, password, "Tenant");
    }

    @Override
    public void register() {
        System.out.println("Tenant registered: " + username);
    }
}

