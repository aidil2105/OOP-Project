/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

class Landlord extends User {

    public Landlord(String username, String password) {
        super(username, password, "Landlord");
    }

    @Override
    public void register() {
        System.out.println("Landlord registered: " + username);
    }
}

